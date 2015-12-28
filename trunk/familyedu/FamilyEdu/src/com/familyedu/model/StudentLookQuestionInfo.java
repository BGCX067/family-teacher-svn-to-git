package com.familyedu.model;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jxl
 * 学生查看问题内容
 */
public class StudentLookQuestionInfo {

	public int aid;
	public String answerContent;
	public String answerInfo;
	public ArrayList<AnswerInfoListItem> answerInfoList = new ArrayList<StudentLookQuestionInfo.AnswerInfoListItem>();
	
	public StudentLookQuestionInfo parser(JSONObject json) {
		try {
			aid = json.getIntValue("aid");
			answerContent = json.getString("answerContent");
			answerInfo = json.getString("answerInfo");

			JSONArray jsonArray = json.getJSONArray("answerInfoList");
			for (Object object : jsonArray) {
				answerInfoList.add(new AnswerInfoListItem().parser((JSONObject) object));
			}
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public class AnswerInfoListItem {
		public int aid; //回答内容ID
		public String answerContent;//问题回答内容
		public String answerTime;//问题回答时间
		public String assessDescription; //问题备注
		public String assessGrade;// "问题答案是否被接受 1：为学生没有接受回答 2：为学生接受回答
		public String assessTime;//学生评价老师答案的时间
		public String difficultyGrade;//容易

		public QuestionInfo questionInfo;
		
		public AnswerInfoListItem parser(JSONObject json) {
			try {
				aid = json.getIntValue("aid");
				answerContent = json.getString("answerContent");
				assessDescription = json.getString("assessDescription");
				assessGrade = json.getString("assessGrade");
				answerTime = json.getString("answerTime");
				difficultyGrade = json.getString("difficultyGrade");
				questionInfo = new QuestionInfo().parser(json.getJSONObject("questionInfo"));
				return this;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
