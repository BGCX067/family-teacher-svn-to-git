package com.familyedu.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author JiangXiaoLiang 老师回答信息
 */
public class TeacherAnswerPageBean {

	public int aid; // 问题编号
	public String answerContent; // 问题回答内容
	public String answerTime; // 问题回答时间
	public int assessGrade;// 对回答的解说的评价。2好1不好
	public String assessTime;// 学生评价老师答案的时间
	public String difficultyGrade;// 问题难度级别，容易，适中，较难
	public int smsForAnswerTeacher;// 学生采纳答案是否短信提醒老师：1短信提醒，0不短信提醒
	public QuestionInfo mQuestionInfo;
	
	
	public TeacherAnswerPageBean parser(JSONObject jsonAnswerInfo) {
		try {
			aid = jsonAnswerInfo.getIntValue("aid");
			answerContent = jsonAnswerInfo.getString("answerContent");
			answerTime = jsonAnswerInfo.getString("answerTime");
			assessGrade = jsonAnswerInfo.getIntValue("assessGrade");
			assessTime = jsonAnswerInfo.getString("assessTime");
			difficultyGrade = jsonAnswerInfo.getString("difficultyGrade");
			smsForAnswerTeacher = jsonAnswerInfo.getIntValue("smsForAnswerTeacher");
			mQuestionInfo = new QuestionInfo().parser(jsonAnswerInfo.getJSONObject("questionInfo"));
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
