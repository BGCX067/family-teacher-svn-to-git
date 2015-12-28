package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

public class MyTeacherListItemInfo {
	public String turl;       //老师头像url??
	public String tname;  // 老师名字

	
	public MyTeacherListItemInfo parser(JSONObject json) {
		try {
			turl = json.getString("turl");
			tname = json.getString("tname");
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
