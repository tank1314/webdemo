package com.framework.tank.json.result;

import org.apache.poi.ss.formula.functions.T;


public class ObjResult
{
	private String code;
	private String msg;
	private String dtMsg;
	private T data;
	public ObjResult()
	{}
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code = code;
	}
	
	public String getMsg()
	{
		return msg;
	}
	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	
	public String getDtMsg()
	{
		return dtMsg;
	}
	
	public void setDtMsg(String dtMsg)
	{
		this.dtMsg = dtMsg;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	
}
