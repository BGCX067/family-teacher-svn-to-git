package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl 回答记录条目信息
 */
public class ReplyRecordInfo {

	public String payTime; // 回答问题的时间
	public int payType; // 用户行为(1,"充值"),(2,"问题答案查看"),
						// (3,"作文评语查看"),(4,"提问"),(5,"发表作文"),(6,"题库问题答案查看"),(7,"回答问题的奖励"),(8,"批过作文的奖励"),(9,"提现金币数");
	public int coin; // 金币变化
	public int currentCoinSurplus; // 金币总额

	public ReplyRecordInfo parser(JSONObject json) {
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
