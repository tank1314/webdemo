package com.framework.tank.web;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


@SuppressWarnings("unused")
public class StaticHttpServletResponseWrapper extends HttpServletResponseWrapper
{
	private String charResult;

	public StaticHttpServletResponseWrapper(HttpServletResponse response){
		super(response) ;
	}
	
	public String getCharResult()
	{
		return charResult;
	}
	
	public void setCharResult(String charResult)
	{
		this.charResult = charResult;
	}
	
	
}
