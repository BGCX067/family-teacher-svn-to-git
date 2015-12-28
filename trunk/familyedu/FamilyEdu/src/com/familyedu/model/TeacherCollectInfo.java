package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl 老师 收藏
 */
public class TeacherCollectInfo {

	public int questionId; // 问题ID
	public String ctime; // 发问时间
	public int status; // 用户提交的问题的状态，1，等待解决（学生提出的问题，但还没有教师给予解答的状态。）；2.
						// 已经解答（学员提出的问题，教师已经给予解答的状态。）；3.
						// 已经评价（学员对教师提出的问题，已经给予了“满意”评价的状态。）；4.
						// 已经分配（客服对问题已经进行归类，分配到教师接收池中的状态）；5.
						// 已经接收（已经有某位教师接收了问题的状态）；6.
						// 开始解答（教师接收了问题后，对问题开始解决的状态）7（如果没有金币的状态，应该提示用户充值）
	public String qcontent; // 文字内容
	public String qtitle; // 问题标题

	public TeacherCollectInfo parser(JSONObject jsonTeacherCollectInfo) {
		try {
			questionId = jsonTeacherCollectInfo.getIntValue("questionId");
			ctime = jsonTeacherCollectInfo.getString("ctime");
			status = jsonTeacherCollectInfo.getIntValue("status");
			qcontent = jsonTeacherCollectInfo.getString("qcontent");
			qtitle = jsonTeacherCollectInfo.getString("qtitle");
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
