package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl
 * 我的教师 通知消息
 */
public class MyTeacherNotificationInfo {
	public int id;			//通知ID
	public String title;     // 通知标题
	public String CTime;     //时间
	public String content;    // 通知正文
	public String state;          // 通知状态 1已读,2未读

	
	public MyTeacherNotificationInfo parser(JSONObject json) {
		try {
			id = json.getIntValue("id");
			title = json.getString("title");
			CTime = json.getString("CTime");
			content = json.getString("content");
			state = json.getString("state");
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
