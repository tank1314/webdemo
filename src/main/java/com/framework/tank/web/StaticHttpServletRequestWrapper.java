package com.framework.tank.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class StaticHttpServletRequestWrapper extends HttpServletRequestWrapper
{
	private String uuid;
    private String utype;
    private String accessLogId;
	public StaticHttpServletRequestWrapper(HttpServletRequest request)
	{
		super(request);
	}
	
	public String getUuid()
	{
		return uuid;
	}
	
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	
	public String getUtype()
	{
		return utype;
	}
	
	public void setUtype(String utype)
	{
		this.utype = utype;
	}
	
	public String getAccessLogId()
	{
		return accessLogId;
	}
	
	public void setAccessLogId(String accessLogId)
	{
		this.accessLogId = accessLogId;
	}
    
    
}
