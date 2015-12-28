package com.familyedu.model;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl
 * 教室 账号
 */
public class TeacherAccount {
	public String cmonth;  // 本月问题数
	public int balance;  // 提现的差额
	public ArrayList<ReplyRecordInfo> replyList = new ArrayList<ReplyRecordInfo>();
	
	public TeacherAccount parser(JSONObject json) {
		try {
			cmonth = json.getString("cmonth");
			balance = json.getIntValue("balance");
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
