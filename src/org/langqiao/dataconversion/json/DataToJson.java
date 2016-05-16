package org.langqiao.dataconversion.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class DataToJson {

	public static String getJsonDataByMap(){
		Map<String, String>  map = new HashMap<String, String>();
		map.put("name", "张三");
		map.put("age", "24");
		String json = JSON.toJSONString(map);
		return json;
	}
	
	public static String getJsonDataByList(){
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("123");
		String json = JSON.toJSONString(list);
		return json;
	}
	
	public static void main(String[] args) {
		String result = getJsonDataByList();
		System.out.println(result);
	}
}
