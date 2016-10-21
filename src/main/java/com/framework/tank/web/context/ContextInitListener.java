package com.framework.tank.web.context;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.Log4jWebConfigurer;

public class ContextInitListener extends ContextLoaderListener
{
	
	public ContextInitListener()
	{
		super();
	}
	
	public ContextInitListener(WebApplicationContext context)
	{
		super(context);
	}
	
	public void contextInitialized(ServletContextEvent event)
	{
		Log4jWebConfigurer.initLogging(event.getServletContext());
		super.contextInitialized(event);
	}
	
	public void contextDestroyed(ServletContextEvent event)
	{
		Log4jWebConfigurer.shutdownLogging(event.getServletContext());
		super.contextDestroyed(event);
	}
}
