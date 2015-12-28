package com.familyedu.model;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author JiangXiaoLiang 首页回答列表
 */
public class HomePageAnswerListInfo {
	public int index; // 列表分页起始页
	public int num; // 列表分页一页最多显示条数
	public String username; // 用户名

	// pageBean
	public int allRow;// 列表总行数
	public int currentPage;// 当前页码

	private ArrayList<TeacherAnswerPageBean> answerInfoList = new ArrayList<TeacherAnswerPageBean>();

	public void addAnswer(TeacherAnswerPageBean issue) {
		answerInfoList.add(issue);
	}

	public ArrayList<TeacherAnswerPageBean> getAnswers() {
		return answerInfoList;
	}
	
	
	public HomePageAnswerListInfo parser(String res) {
		try {
			JSONObject jsonObject = JSON.parseObject(res);
			JSONObject jsonAnswerInfo = jsonObject.getJSONObject("pageBean");
			allRow = jsonAnswerInfo.getIntValue("allRow");
			currentPage = jsonAnswerInfo.getIntValue("currentPage");
			
			//answerList
			JSONArray answerArray = jsonAnswerInfo.getJSONArray("list");
			for (Object object : answerArray) {
				addAnswer(new TeacherAnswerPageBean().parser((JSONObject) object));
			}
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
