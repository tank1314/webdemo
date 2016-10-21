package com.framework.tank.web.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.framework.tank.util.ActionUtil;
import com.framework.tank.web.HttpMethodRequestWrapper;
import com.framework.tank.web.StaticHttpServletRequestWrapper;
import com.framework.tank.web.StaticHttpServletResponseWrapper;


public class HttpFilter extends OncePerRequestFilter
{
	public static final String DEFAULT_METHOD_PARAM = "_method";
	public static final String DEFAULT_ENCODING = "utf-8";
	
	private String methodParam = DEFAULT_METHOD_PARAM;
	private String encoding = DEFAULT_ENCODING;
	
	public void setMethodParam(String methodParam)
	{
		Assert.hasText(methodParam, "'methodParam' must not be empty");
		this.methodParam = methodParam;
	}
	
	public void setEncoding(String encoding)
	{
		Assert.hasText(encoding, "'encoding' must not be empty");
		this.encoding = encoding;
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
	{
		request = new StaticHttpServletRequestWrapper(request) ;
		response = new StaticHttpServletResponseWrapper(response) ;
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		//将站点域名和静态资源地址信息存入到context中
		ActionUtil.addContextPath(request);
		ActionUtil.addStaticPath(request);
		
		/**
		 * 浏览器不支持put,delete等method,由该filter将/service?_method=delete转换为标准的http delete方法
		 **/
		String paramValue = request.getParameter(methodParam);
		if ("POST".equalsIgnoreCase(request.getMethod()) && StringUtils.hasLength(paramValue)) {
			String method = paramValue.toUpperCase(Locale.ENGLISH);
			filterChain.doFilter(new HttpMethodRequestWrapper(request, method), response);
		} else {
			filterChain.doFilter(request, response);
		}
	}
	
}
