package com.familyedu.model;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl 我的消费
 */
public class MyConsumptionInfo {

	public ArrayList<MyConsumptionRecordInfo> consumptionRecordList = new ArrayList<MyConsumptionInfo.MyConsumptionRecordInfo>();

	public MyConsumptionInfo parser(JSONObject json) {
		try {
			JSONArray consumptionArray = json.getJSONArray("currentmonth");
			for (Object object : consumptionArray) {
				consumptionRecordList.add(new MyConsumptionRecordInfo().parser((JSONObject) object));
			}
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	class MyConsumptionRecordInfo {
		public String payTime; // 时间
		public int payType; // (1,"充值"),(2,"问题答案查看"),
							// (3,"作文评语查看"),(4,"提问"),(5,"发表作文"),(6,"题库问题答案查看"),(7,"回答问题的奖励"),(8,"批过作文的奖励"),(9,"提现金币数");
		public int coin; // 消耗金币数
		public int currentCoinSurplus; // 消耗后的金币总额

		public MyConsumptionRecordInfo parser(JSONObject json) {
			try {
				payTime = json.getString("payTime");
				payType = json.getIntValue("payType");
				coin = json.getIntValue("coin");
				currentCoinSurplus = json.getIntValue("currentCoinSurplus");
				return this;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
