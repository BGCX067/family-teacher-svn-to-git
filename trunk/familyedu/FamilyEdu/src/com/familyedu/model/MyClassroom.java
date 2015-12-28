package com.familyedu.model;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl
 * 我的教室
 */
public class MyClassroom {

	public String headurl;			//头像url
	public int issuenum;     //问题数
	public int studentnum;        // 我的老师
	public int collect;           //我的收藏
	public int myinfrorm;         //我的通知
	public int gold;            // 赚取的金币

	public ArrayList<ReplyRecordInfo> replyList = new ArrayList<ReplyRecordInfo>();
	
	public MyClassroom parser(JSONObject json) {
		try {
			headurl = json.getString("headurl");
			issuenum = json.getIntValue("issuenum");
			studentnum = json.getIntValue("studentnum");
			collect = json.getIntValue("collect");
			myinfrorm = json.getIntValue("myinfrorm");
			gold = json.getIntValue("gold");
			
			JSONArray replyArray = json.getJSONArray("replylist");
			for (Object object : replyArray) {
				replyArray.add(new ReplyRecordInfo().parser((JSONObject) object));
			}
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
