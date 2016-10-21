package com.tank.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 测试入口
 * 描述: 
 * 版权: Copyright (c) 2016
 * 版本: 1.0
 * 创建日期: 2016年10月21日
 * 创建时间: 下午5:04:21
 */
@Controller
public class HomeController {


	@RequestMapping(value = "/", method = GET)
	@ResponseBody
	public String index() {
		
		return "The web server is ok!";
	}


}
