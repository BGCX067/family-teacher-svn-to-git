package com.familyedu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.familyedu.net.DataService;
import com.familyedu.widget.CustomeGallery;
import com.familyedu.widget.CustomeGalleryAdapter;

/**
 * 引导页
 * 
 * @author Administrator
 * 
 */
public class GuideActivity extends Activity {

	private CustomeGallery gallery;
	public static GuideActivity actiivty;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.guidepage);

		actiivty = this;
		initView();
		
		execProtocal();
	}

	private void initView() {

		gallery = (CustomeGallery) findViewById(R.id.gallery);
		gallery.setAdapter(new CustomeGalleryAdapter(this));
	}

	
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			
		};
	};
	
	private void execProtocal() {
//		login();//登录	yes
//		studentReg();//学生注册	yes
//		teacherReg();//老师注册	yes
//		getMainIssueList();//学生首页问题列表	yes
//		getMainAnswerList();//老师首页回答列表  yes
//		addCompositionInfo();//作文提交
//		getQuestionListWall();//问题墙列表	yes
//		serachQuestionListWall();//问题墙搜索	yes
//		updateStudent();//修改学生个人信息	yes
//		teacherLookQuestionInfo();//教师查看问题	yes
//		isQuestionClaim();//老师是否可以认领问题	yes
//		isQuestionAccept();//教师放弃问题  yes
//		teacherAnswerList();//教师“我的回答”	yes
//		addQuesionInfo();//问题提交
//		studentLookQuestion();//学生查看问题内容	yes
//		teacherAnswerQuestion();//教师回答问题
//		myHomeTeacher();//我的家教  yes
//		getMyTeacherList();//我的家教-我的老师  yes
		myCollect();//我的收藏
//		deleteStudentCollect();//我的家教-我的收藏—删除选中
//		getMyTeacherNotification();//我的家教-我的通知	yes
//		getMyConsumption();//我的家教-我的消费	yes
//		getMyClassroom();//我的教室
	}

	private void login() {
		new DataService().login(this, mHandler, 0, "xs1", "111111");
//		new DataService().login(this, mHandler, 0, "tc1", "111111");
	}

	private void studentReg() {
		new DataService().studentRegister(this, mHandler, 0, "student1", "www.baidu.com", "799583678@qq.com", "aaaaaa", "aaaaaa");
	}

	private void teacherReg() {
		new DataService().teacherRegister(this, mHandler, 0, "jiangxl110", "www.baidu.com", "799583678@qq.com", "aaaaaa", "aaaaaa", 0, 0);
	}

	private void getMainIssueList() {
		new DataService().getMainIssueList(this, mHandler, 0, "xs1", 0, 10);
	}

	private void getMainAnswerList() {
		new DataService().getMainAnswerList(this, mHandler, 0, "tc1", 0, 10);
	}

	private void addCompositionInfo() {
		new DataService().addCompositionInfo(this, mHandler, 0, "xs1", "haha", 1, "aaa", "title");
	}

	private void getQuestionListWall() {
		new DataService().getQuestionListWall(this, mHandler, 0, "xs1", 0, 10);
	}

	private void serachQuestionListWall() {
		new DataService().serachQuestionListWall(this, mHandler, 0, 0, 10, "a");
	}

	private void updateStudent() {
		new DataService().updateStudent(this, mHandler, 0, "xs1", 0, "www.head.com", "799583678@qq.com", "111111", "111111",
				"13888888888", 1, System.currentTimeMillis());
	}

	private void teacherLookQuestionInfo() {
		new DataService().teacherLookQuestionInfo(this, mHandler, 0, 36);
	}

	private void isQuestionClaim() {
		new DataService().isQuestionClaim(this, mHandler, 0, 36);
	}

	private void isQuestionAccept() {
		new DataService().isQuestionAccept(this, mHandler, 0, 36);
	}

	private void teacherAnswerList() {
		new DataService().teacherAnswerList(this, mHandler, 0, "tc1", 0, 10);
	}

	private void addQuesionInfo() {
		new DataService().addQuesionInfo(this, mHandler, 0, "xs1", "addQuesionInfo", 1, 1, "addQuesionInfo");
	}

	private void studentLookQuestion() {
		new DataService().studentLookQuestion(this, mHandler, 0, 34);
	}

	private void teacherAnswerQuestion() {
		new DataService().teacherAnswerQuestion(this, mHandler, 0, 36, "tc1", "teacherAnswerQuestion");
	}
	
	private void myHomeTeacher() {
		new DataService().myHomeTeacher(this, mHandler, 0, "xs1");
	}
	
	private void getMyTeacherList() {
		new DataService().getMyTeacherList(this, mHandler, 0, "xs1", 0, 10);
	}
	
	private void myCollect() {
		new DataService().myCollect(this, mHandler, 0, "xs1", 0, 10);
	}
	
	private void deleteStudentCollect() {
		new DataService().deleteStudentCollect(this, mHandler, 0, "xs1", 1);
	}
	
	private void getMyTeacherNotification() {
		new DataService().getMyTeacherNotification(this, mHandler, 0, "xs1", 0, 10);
	}
	
	private void getMyConsumption() {
		new DataService().getMyConsumption(this, mHandler, 0, "xs1", 0, 10);
	}
	
	private void getMyClassroom() {
		new DataService().getMyClassroom(this, mHandler, 0, "xs1", 0, 10, "111", System.currentTimeMillis() + "");
	}
}
