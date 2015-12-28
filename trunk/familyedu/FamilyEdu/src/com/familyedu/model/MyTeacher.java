package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl
 * 我的教师
 */
public class MyTeacher {

	public String headurl;		    //头像url
	public int issuenum;       //问题数
	public int myteacher;         // 我的老师
	public int collect;           //我的收藏
	public int inform;            //我的通知

	
	public MyTeacher parser(JSONObject json) {
		try {
			headurl = json.getString("headurl");
			issuenum = json.getIntValue("issuenum");
			myteacher = json.getIntValue("myteacher");
			collect = json.getIntValue("collect");
			inform = json.getIntValue("inform");
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
