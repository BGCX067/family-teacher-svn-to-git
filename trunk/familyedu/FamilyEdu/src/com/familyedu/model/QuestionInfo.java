package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl
 * 问题信息
 */
public class QuestionInfo {

	// questionInfo
	public int answerCount;// 问题总回答次数
	public String answerTimeForQuestionInfo;// 问题回答时间
	public String assignFlag;// 用来表示分配的方案，0代表未分配，1代表分配给普通老师，2代表分配给专职老师，3代表分配给业务员，4代表分配给所有能回答问题的人员
	public String assignTime;// 问题分配时间

	// gradeInfor
	public String gradeGroup;// 年纪分配
	public int gradeId;// 年纪编号
	public String gradeName;// 年纪名称

	public int id;// 问题ID
	public String questionContent;// 问题内容
	public int questionLevel;// 问题级别：1为精选问题，0未非精选问题
	public int questionStatus;// 用户提交的问题的状态，1，等待解决（学生提出的问题，但还没有教师给予解答的状态。）；2.
								// 已经解答（学员提出的问题，教师已经给予解答的状态。）；3.
								// 已经评价（学员对教师提出的问题，已经给予了“满意”评价的状态。）；4.
								// 已经分配（客服对问题已经进行归类，分配到教师接收池中的状态）；5.
								// 已经接收（已经有某位教师接收了问题的状态）；6.
								// 开始解答（教师接收了问题后，对问题开始解决的状态）7（如果没有金币的状态，应该提示用户充值）
	public String questionSubject;// 问题标题
	public String questionTime;// 提问时间
	public int questionType;// 问题类型:1网页端问题，2手机端问题
	public int smsForAnswerStudent;// 老师回答问题后是否短信提醒：1短信提醒，0不短信提醒

	// subjectInfor
	public int subjectId;// 学科编号
	public String subjectName;// 学科名称
	
	public QuestionInfo parser(JSONObject jsonQuestionInfo) {
		try {
			// questionInfo
			id = jsonQuestionInfo.getIntValue("id");
			questionContent = jsonQuestionInfo.getString("questionContent");
			questionLevel = jsonQuestionInfo.getIntValue("questionLevel");
			questionStatus = jsonQuestionInfo.getIntValue("questionStatus");
			questionSubject = jsonQuestionInfo.getString("questionSubject");
			questionTime = jsonQuestionInfo.getString("questionTime");
			questionType = jsonQuestionInfo.getIntValue("questionType");
			smsForAnswerStudent = jsonQuestionInfo.getIntValue("smsForAnswerStudent");
			
			// gradeInfor
			JSONObject jsonGradeInfor = jsonQuestionInfo.getJSONObject("gradeInfor");
			gradeGroup = jsonGradeInfor.getString("gradeGroup");
			gradeId = jsonGradeInfor.getIntValue("gradeId");
			gradeName = jsonGradeInfor.getString("gradeName");
			
			// subjectInfor
			JSONObject jsonSubjectInfor = jsonQuestionInfo.getJSONObject("subjectInfor"); 
			subjectId = jsonSubjectInfor.getIntValue("subjectId");
			subjectName = jsonSubjectInfor.getString("subjectName");
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
