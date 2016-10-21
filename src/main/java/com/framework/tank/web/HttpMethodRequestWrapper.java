package com.framework.tank.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;



public class HttpMethodRequestWrapper extends HttpServletRequestWrapper
{
	  private String method;

	public HttpMethodRequestWrapper(HttpServletRequest request, String method)
	{
		super(request);
		this.method = method;
	}

	
	public String getMethod()
	{
		return method;
	}
	  
}
