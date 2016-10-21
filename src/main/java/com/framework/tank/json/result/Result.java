package com.framework.tank.json.result;


public class Result
{
	private String code;
	/**
	 * 是否强制弹出对话框
	 */
	private boolean popup;
	private String msg = "";
	private String data = "";

	public Result(){

	}

	
	public String getCode()
	{
		return code;
	}

	
	public void setCode(String code)
	{
		this.code = code;
	}

	
	public boolean isPopup()
	{
		return popup;
	}

	
	public void setPopup(boolean popup)
	{
		this.popup = popup;
	}

	
	public String getMsg()
	{
		return msg;
	}

	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	
	public String getData()
	{
		return data;
	}

	
	public void setData(String data)
	{
		this.data = data;
	}

	public String toJson() {
		StringBuffer buf = new StringBuffer("");
		return buf.append("{")
				.append("\"code\":\"").append(code).append("\"")
				.append(",\"popup\":").append(popup)
				.append(",\"msg\":\"").append(msg).append("\"")
				.append(",\"data\":").append(data).append("}")
				.toString();
	}

	public String toString() {
		StringBuffer buf = new StringBuffer("");
		buf.append("{")
				.append("\"code\":\"").append(code).append("\"")
				.append(",\"popup\":").append(popup)
				.append(",\"msg\":\"").append(msg).append("\"");

		if(data == null || data.equals("")) {
			buf.append(",\"data\":\"\"}");
		} else {
			buf.append(",\"data\":\"").append(data).append("\"}");
		}

		return buf.toString();
	}
	
}
