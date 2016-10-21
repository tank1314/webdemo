package com.framework.tank.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.framework.tank.constant.Constant;
import com.framework.tank.web.StaticHttpServletResponseWrapper;

public class ActionUtil
{
	
	/**
	 * 获得Request对象
	 * @return
	 */
	public static HttpServletRequest getRequest()
	{
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return sra == null ? null : sra.getRequest();
	}
	
	/**
	 * 获得Response对象
	 * @return
	 */
	public static HttpServletResponse getResponse()
	{
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return sra == null ? null : sra.getResponse();
	}
	
	/**
	 * 获取IP地址
	 * @return
	 * 2016年10月21日 上午11:41:03
	 */
	public static String getIpAddr()
	{
		HttpServletRequest request = getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		
		if (ip == null)
		{
			return null;
		}
		return ip.split(",")[0];
	}
	
	/**
	 * 将站点URL存入ServletContext中
	 */
	public static void addContextPath()
	{
		addContextPath(getRequest());
	}
	
	/**
	 * 将站点URL存入ServletContext中
	 */
	public static void addContextPath(HttpServletRequest request)
	{
		StringBuffer buf = new StringBuffer("");
		buf.append(request.getScheme()).append("://").append(request.getServerName());
		int port = request.getServerPort();
		if (port != 80)
		{
			buf.append(":").append(request.getServerPort());
		}
		buf.append(request.getContextPath());
		request.getServletContext().setAttribute(Constant.CONTEXT_PATH_KEY, buf.toString());
	}
	
	/**
	 * 获取站点URL
	 * @return
	 */
	public static String getContextPath()
	{
		return getContextPath(getRequest());
	}
	
	/**
	 * 获取站点URL
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request)
	{
		return (String) request.getServletContext().getAttribute(Constant.CONTEXT_PATH_KEY);
	}
	
	/**
	 * 将静态资源地址存入ServletContext中
	 */
	public static void addStaticPath()
	{
		addStaticPath(getRequest());
	}
	
	/**
	 * 将静态资源地址存入ServletContext中
	 */
	public static void addStaticPath(HttpServletRequest request)
	{
		request.getServletContext().setAttribute(Constant.STATIC_PATH_KEY, Constant.STATIC_PATH);
	}
	
	/**
	 * 获取静态资源地址
	 * @return
	 */
	public static String getStaticPath()
	{
		return getStaticPath(getRequest());
	}
	
	/**
	 * 获取静态资源地址
	 * @return
	 */
	public static String getStaticPath(HttpServletRequest request)
	{
		return (String) request.getServletContext().getAttribute(Constant.STATIC_PATH_KEY);
	}
	
	/**
	 * 从Request中获得所有请求的参数
	 * @return
	 */
	public static Map<String, String> getRequestParamsMap()
	{
		Map<String, String[]> params = getRequest().getParameterMap();
		Map<String, String> map = new HashMap<String, String>();
		if (params == null || params.isEmpty())
		{
			return map;
		}
		Iterator<String> keyItr = params.keySet().iterator();
		while (keyItr.hasNext())
		{
			String key = keyItr.next();
			String value = params.get(key)[0];
			
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * 从Request中获得数据流
	 * @return
	 */
	public static String getRequestInput()
	{
		InputStream is = null;
		BufferedReader br = null;
		try
		{
			is = getRequest().getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			StringBuffer buffer = new StringBuffer("");
			String line = "";
			while ((line = br.readLine()) != null)
			{
				buffer.append(line);
			}
			return buffer.toString();
		}
		catch (Exception e)
		{
			return null;
		}
		finally
		{
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 输出响应数据给客户端
	 * @param str
	 */
	public static void printStr(Object str)
	{
		HttpServletResponse response = getResponse();
		if (response instanceof StaticHttpServletResponseWrapper)
		{
			StaticHttpServletResponseWrapper nmwResponse = ((StaticHttpServletResponseWrapper) response);
			nmwResponse.setCharResult(str == null ? null : str.toString());
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			out.print(str);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (out != null)
			{
				out.close();
			}
		}
	}
	
}
