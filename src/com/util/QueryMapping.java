package com.util;

import java.util.HashMap;

public class QueryMapping {
	public static HashMap<String,String> getQueryMap(String queryStr) {
		HashMap<String,String> map = new HashMap<String, String>();
		String[] arr =  queryStr.split("&");
		for(String i : arr) {
			String[] kv = i.split("=");
			map.put(kv[0], kv[1]);
		}
		return map;	
	}
}
