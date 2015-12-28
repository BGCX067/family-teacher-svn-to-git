package com.familyedu.model;

import java.util.ArrayList;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author JiangXiaoLiang 首页问题列表
 */
public class HomePageIssueListInfo {
	public int index; // 列表分页起始页
	public int num; // 列表分页一页最多显示条数
	public String username; // 用户名

	// pageBean
	public int allRow;// 列表总行数
	public int currentPage;// 当前页码

	private ArrayList<IssueInfo> issueList = new ArrayList<IssueInfo>();

	public void addIssue(IssueInfo issue) {
		issueList.add(issue);
	}

	public ArrayList<IssueInfo> getIssues() {
		return issueList;
	}
	
	public HomePageIssueListInfo parser(String res) {
		try {
			JSONObject json = JSON.parseObject(res);
			index = (Integer) json.get("index");
			num = (Integer) json.get("num");
			username = (String) json.get("username");
			
			//pageBean
			JSONObject jsonPageBean = (JSONObject) json.get("pageBean");
			allRow = (Integer) jsonPageBean.get("allRow");
			currentPage = (Integer) jsonPageBean.get("currentPage");
			
			//issue list
			JSONArray issueArray = (JSONArray) jsonPageBean.get("list");
			for (Object jsonObject : issueArray) {
				addIssue(new IssueInfo().parser((JSONObject) jsonObject));
			}
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
