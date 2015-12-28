package com.familyedu.net;

import android.util.Log;

import com.familyedu.model.AskAQuestion;
import com.familyedu.tools.LogHandler;

public class JsonBean {

	private JsonRequest req = new JsonRequest();
	private String url =  "http://211.101.29.244:8899/jjxt/";   //"http://jjxt.demo.com.cn/jjxt/";//"http://211.101.29.244:8899/jjxt/";
	private static final String TAG = "sk";
	
	public Object userLogin(String username, String password) {
		String res = req.httpGet(url + "loginss?username=" + username + "&password=" + password);
		Log.d("userLogin", res + "");
		Object obj = JsonParse.parseUserLogin(res);
		return obj;
	}

	/**
	 * 学生注册
	 */
	public Object studentRegister(String username, String head, String email, String password, String repeatpassword) {
		String res = req.httpGet(url + "regST?username=" + username + "&head=" + head + "&email=" + email + "&password=" + password + "&repeatpassword=" + repeatpassword);
		Log.d("studentRegister", res + "");
		Object obj = JsonParse.parseStudentRegister(res);
		return obj;
	}
	
	/**
	 * 老师注册
	 */
	public Object teacherRegister(String username, String head, String email, String password, String repeatpassword, int subject, int grade) {
		String res = req.httpGet(url + "regTC?username=" + username + "&head=" + head + "&email=" + email + "&password=" + password + "&repeatpassword=" + repeatpassword + "&subject=" + subject + "&grade=" + grade);
		Log.d("teacherRegister", res + "");
		Object obj = JsonParse.parseTeacherRegister(res);
		return obj;
	}

	/**
	 * 学生首页问题列表
	 */
	public Object mainIssueList(String username, int index, int num) {
		String res = req.httpGet(url + "studentQusList?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("mainIssueList", res + "");
		Object obj = JsonParse.parseMainIssueList(res);
		return obj;
	}
	
	/**
	 * 老师首页回答列表
	 */
	public Object mainAnswerList(String username, int index, int num) {
		String res = req.httpGet(url + "teacherQusList?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("mainAnswerList", res + "");
		Object obj = JsonParse.parseMainAnswerList(res);
		return obj;
	}

	/**
	 * 问题墙
	 */
	public Object getQuestionListWall(String username, int index, int num) {
		String res = req.httpGet(url + "QusListWall?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("getQuestionListWall", res + "");
		Object obj = JsonParse.parseQuestionListWall(res);
		return obj;
	}
	
	/**
	 * 问题墙搜索
	 */
	public Object serachQuestionListWall(int index, int num, String keywords) {
		String res = req.httpGet(url + "QusListWall?index=" + index + "&num=" + num + "&keywords=" + keywords);
		Log.d("serachQuestionListWall", res + "");
		Object obj = JsonParse.parseQuestionListWall(res);
		return obj;
	}
	
	/**
	 * 教师查看问题
	 */
	public Object teacherLookQuestionInfo(int aid) {
		String res = req.httpGet(url + "tcLookQusInfo?aid=" + aid);
		Log.d("teacherLookQuestionInfo", res + "");
		Object obj = JsonParse.parseTeacherLookQuestionInfo(res);
		return obj;
	}
	
	public Object getAttentionType(int hid, int type) {
		String res = req.httpGet(url + "xxxxxxx?" + "hid=" + hid + "&type=" + type);
		Log.d("getAttentionType", res + "");
		Object obj = JsonParse.parseAttentionType(res);
		return obj;
	}

	/**
	 * 作文提交
	 */
	public Object addCompositionInfo(String username, String content, int grade, String stylex, String title) {
		String res = req.httpGet(url + "addCompositionInfo?username=" + username + "&con=" + content + "&grade=" + grade
				+ "&stylex=" + stylex + "&title=" + title);
		Log.d("addCompositionInfo", res + "");
		Object obj = JsonParse.parseAddCompositionInfo(res);
		return obj;
	}

	/**
	 * 更新学生信息
	 */
	public Object updateStudent(String username, int grade, String head, String email, String password,
			String repeatpassword, String phone, int gender, long birthday) {
		String res = req.httpGet(url + "updateStudent?username=" + username + "&grade=" + grade + "&head=" + head
				+ "&email=" + email + "&password=" + password + "&repeatpassword=" + repeatpassword + "&phone=" + phone
				+ "&gender=" + gender + "&birthday=" + birthday);
		Log.d("updateStudent", res + "");
		Object obj = JsonParse.parseUpdateStudent(res);
		return obj;
	}
	
	/**
	 * 更新老师信息
	 */
	public Object updateTeacher(String username, int grade, int subject, String head, String email, String password,
			String repeatpassword, String phone, int gender, long birthday) {
		String res = req.httpGet(url + "updateTeacher?username=" + username + "&grade=" + grade + "&subject=" + subject + "&head=" + head
				+ "&email=" + email + "&password=" + password + "&repeatpassword=" + repeatpassword + "&phone=" + phone
				+ "&gender=" + gender + "&birthday" + birthday);
		Log.d("updateTeacher", res + "");
		Object obj = JsonParse.parseUpdateTeacher(res);
		return obj;
	}
	
	/**
	 * 老师是否可以认领问题
	 */
	public Object isQuestionClaim(int aid) {
		String res = req.httpGet(url + "isQusClaim?aid=" + aid);
		Log.d("isQuestionClaim", res + "");
		Object obj = JsonParse.parseIsQuestionClaim(res);
		return obj;
	}
	
	/**
	 * 教师放弃问题
	 */
	public Object isQuestionAccept(int aid) {
		String res = req.httpGet(url + "isQusAccept?aid=" + aid);
		Log.d("isQuestionAccept", res + "");
		Object obj = JsonParse.parseIsQuestionAccept(res);
		return obj;
	}
	
	/**
	 * 教师“我的回答”
	 */
	public Object teacherAnswerList(String username, int index, int num) {
		String res = req.httpGet(url + "tcAnswerList?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("teacherAnswerList", res + "");
		Object obj = JsonParse.parseTeacherAnswerList(res);
		return obj;
	}
	
	/**
	 * 问题提交
	 */
	public Object addQuesionInfo(String username, String content, int grade, int subject, String title) {
		String res = req.httpGet(url + "addQuesionInfo?username=" + username + "&con=" + content + "&grade=" + grade + "&subject=" + subject + "&title=" + title);
		Log.d("addQuesionInfo", res + "");
		Object obj = JsonParse.parseAddQuesionInfo(res);
		return obj;
	}
	
	/**
	 * 我的收藏
	 */
	public Object myCollect(String username, int index, int num) {
		String res = req.httpGet(url + "myCollect?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("teacherCollect", res + "");
		Object obj = JsonParse.parseMyCollect(res);
		return obj;
	}
	
	/**
	 * 我的家教-我的收藏—删除选中
	 */
	public Object deleteStudentCollect(String username, int collectid) {
		String res = req.httpGet(url + "delMyCollect?username=" + username + "&collectid=" + collectid);
		Log.d("deleteStudentCollect", res + "");
		Object obj = JsonParse.parseDeleteStudentCollect(res);
		return obj;
	}
	
	/**
	 * 教师回答问题
	 */
	public Object teacherAnswerQuestion(int questionId, String username, String answerContent) {
		String res = req.httpGet(url + "tcAnswerQuestion?questionId=" + questionId + "&username=" + username + "&answerContent=" + answerContent);
		Log.d("teacherAnswerQuestion", res + "");
		Object obj = JsonParse.parserTeacherAnswerQuestion(res);
		return obj;
	}
	
	/**
	 * 学生查看问题内容
	 */
	public Object studentLookQuestion(int questionId) {
		String res = req.httpGet(url + "lookWSQuestion?questionId=" + questionId);
		Log.d("studentLookQuestion", res + "");
		Object obj = JsonParse.parserStudentLookQuestion(res);
		return obj;
	}
	
	/**
	 * 我的家教
	 */
	public Object myHomeTeacher(String username) {
		String res = req.httpGet(url + "myHomeTeacher?username=" + username);
		Log.d("myHomeTeacher", res + "");
		Object obj = JsonParse.parserMyHomeTeacher(res);
		return obj;
	}
	
	/**
	 * 我的家教-我的老师
	 */
	public Object getMyTeacherList(String username, int index, int num) {
		String res = req.httpGet(url + "myTeachers?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("getMyTeacherList", res + "");
		Object obj = JsonParse.parserMyTeacherList(res);
		return obj;
	}
	
	/**
	 * 我的家教-我的通知
	 */
	public Object getMyTeacherNotification(String username, int index, int num) {
		String res = req.httpGet(url + "myNotice?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("getMyTeacherNotification", res + "");
		Object obj = JsonParse.parserMyTeacherNotification(res);
		return obj;
	}
	
	/**
	 * 我的教室
	 */
	public Object getMyClassroom(String username, int index, int num, String begTime, String endTime) {
		String res = req.httpGet(url + "myClassroom?username=" + username + "&index=" + index + "&num=" + num + "&begTime=" + begTime + "&endTime=" + endTime);
		Log.d("getMyClassroom", res + "");
		Object obj = JsonParse.parserMyClassroom(res);
		return obj;
	}
	
	/**
	 * 老师 账户
	 */
	public Object getTeacherAccount(String uid, int index, int num) {
		String res = req.httpGet(url + "xxx?uid=" + uid + "&index=" + index + "&num=" + num);
		Log.d("getTeacherAccount", res + "");
		Object obj = JsonParse.parserTeacherAccount(res);
		return obj;
	}
	
	/**
	 * 我的家教-我的消费
	 */
	public Object getMyConsumption(String username, int index, int num) {
		String res = req.httpGet(url + "myConsume?username=" + username + "&index=" + index + "&num=" + num);
		Log.d("getMyConsumption", res + "");
		Object obj = JsonParse.parserMyConsumption(res);
		return obj;
	}
	
}
