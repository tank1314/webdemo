package com.framework.tank.json;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * JsonUtil封装
 * 描述: 
 * 版权: Copyright (c) 2016
 * 版本: 1.0
 * 创建日期: 2016年10月21日
 * 创建时间: 下午3:25:34
 */
public class JsonUtil
{
	@SuppressWarnings("unchecked")
	public static<T> T toBean(String jsonStr, Class<?> clz){
		return (T)JSON.parseObject(jsonStr, clz);
	}

	@SuppressWarnings("unchecked")
	public static<T> List<T> toBeanList(String jsonStr, Class<?> clz){
		return (List<T>)JSON.parseArray(jsonStr, clz);

	}

	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static String toJson(List<?> list) {
		if(list == null || list.size() <= 0) {
			return "[]";
		}

		return JSON.toJSONString(list);
	}

	public static boolean isJson(String jsonStr) {
		try {
			JSON.parseObject(jsonStr);
			return true;
		} catch (Exception e) {
			try {
				JSON.parseArray(jsonStr);
				return true;
			} catch (Exception e1) {
				return false;
			}
		}
	}

	public static<K, V, T> T mapToObject(Map<K, V> map, Class<T> clz) {
		return toBean(toJson(map), clz);
	}

	public static<K, V, T> Map<K, V> objectToMap(T t) {
		return toBean(toJson(t), Map.class);
	}
}
