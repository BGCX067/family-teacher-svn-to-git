package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl
 * 学生收藏
 */
public class StudentCollectInfo {
	public int aid;// 问题ID
	public String atime;	   // 发问时间
	public String state; // 1已解决, 2待解决, 3已退回, 4未发布-????
	public String con;    // 文字描述

	
	public StudentCollectInfo parser(JSONObject json) {
		try {
			aid = json.getIntValue("aid");
			atime = json.getString("atime");
			state = json.getString("state");
			con = json.getString("con");
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
