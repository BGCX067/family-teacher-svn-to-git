package com.familyedu.net;

import android.content.Context;
import android.os.Handler;

import com.familyedu.model.AskAQuestion;

public class DataService {

	public static final int MSG_GET_VERSION = 1;
	public static final int MSG_LOGIN = 2;
	public static final int MSG_REGISTER = 3;
	public static final int MSG_GET_MAIN_ISSUE_LIST = 4;
	public static final int MSG_GET_ANSWERED_ISSUE = 5;
	public static final int MSG_COMMIT_ASSESS = 6;
	public static final int MSG_ASK = 7;
	public static final int MSG_PAY_RECORD = 8;

	/**
	 * 用户登录
	 * @param username -用户昵称
	 * @param password  -登录密码
	 */
	public void login(final Context context, final Handler handler, final int msgid, final String username,
			final String password) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.userLogin(username, password);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 学生首页问题列表
	 * @param uid  -用户id
	 * @param type -用户类型 1-老师；2-学生
	 * @param index  -起始位置，从0开始，-1表示全部
	 * @param num  -查询条数
	 */
	public void getMainIssueList(final Context context, final Handler handler, final int msgid, final String username,
			final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.mainIssueList(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 老师首页回答列表
	 * @param username
	 * @param index 列表分页起始页
	 * @param num 列表分页一页最多显示条数
	 */
	public void getMainAnswerList(final Context context, final Handler handler, final int msgid, final String username,
			final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.mainAnswerList(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}

	/**
	 * 作文提交
	 * @param username
	 * @param content  内容
	 * @param grade  年级
	 * @param stylex  作文类型
	 * @param title 作文标题
	 */
	public void addCompositionInfo(final Context ctx, final Handler handler, final int msgid, final String username,
			final String content, final int grade, final String stylex, final String title) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.addCompositionInfo(username, content, grade, stylex, title);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 问题墙列表
	 * @param index
	 * @param num
	 */
	public void getQuestionListWall(final Context context, final Handler handler, final int msgid, final String username, final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.getQuestionListWall(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 问题墙搜索
	 * @param index
	 * @param num
	 * @param keywords 问题关键字
	 */
	public void serachQuestionListWall(final Context context, final Handler handler, final int msgid, final int index, final int num, final String keywords) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.serachQuestionListWall(index, num, keywords);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 修改学生个人信息
	 * @param username
	 * @param grade 年纪
	 * @param head
	 * @param email
	 * @param password
	 * @param repeatpassword
	 * @param phone
	 * @param gender 性别：1男，2女
	 * @param birthday
	 */
	public void updateStudent(final Context ctx, final Handler handler, final int msgid, final String username,
			final int grade, final String head, final String email, final String password, final String repeatpassword,
			final String phone, final int gender, final long birthday) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.updateStudent(username, grade, head, email, password,
						repeatpassword, phone, gender, birthday);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 教师查看问题
	 * @param aid 问题编号
	 */
	public void teacherLookQuestionInfo(final Context context, final Handler handler, final int msgid, final int aid) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.teacherLookQuestionInfo(aid);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 老师是否可以认领问题
	 * @param aid 问题id
	 */
	public void isQuestionClaim(final Context ctx, final Handler handler, final int msgid, final int aid) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.isQuestionClaim(aid);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 教师放弃问题
	 * @param aid 问题编号
	 */
	public void isQuestionAccept(final Context ctx, final Handler handler, final int msgid, final int aid) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.isQuestionAccept(aid);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 教师“我的回答”
	 * @param username
	 * @param index
	 * @param num
	 */
	public void teacherAnswerList(final Context ctx, final Handler handler, final int msgid, final String username, final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.teacherAnswerList(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 学生注册
	 * @param username
	 * @param head
	 * @param email
	 * @param password
	 * @param repeatpassword
	 */
	public void studentRegister(final Context context, final Handler handler, final int msgid, final String username, final String head, final String email, final String password, final String repeatpassword) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.studentRegister(username, head, email, password, repeatpassword);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 老师注册
	 * @param username
	 * @param head
	 * @param email
	 * @param password
	 * @param repeatpassword
	 * @param subject 学科编号
	 * @param grade 年纪编号
	 */
	public void teacherRegister(final Context context, final Handler handler, final int msgid, final String username, final String head, final String email, final String password, final String repeatpassword, final int subject, final int grade) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.teacherRegister(username, head, email, password, repeatpassword, subject, grade);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 问题提交
	 * @param username
	 * @param content 问题内容
	 * @param grade 年纪编号
	 * @param subject 学科编号
	 * @param title 问题标题
	 */
	public void addQuesionInfo(final Context ctx, final Handler handler, final int msgid, final String username, final String content, final int grade, final int subject, final String title) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.addQuesionInfo(username, content, grade, subject, title);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 学生查看问题内容
	 * @param questionId 问题ID
	 */
	public void studentLookQuestion(final Context ctx, final Handler handler, final int msgid, final int questionId) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.studentLookQuestion(questionId);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 教师回答问题
	 * @param questionId 问题ID
	 * @param username
	 * @param answerContent 教师回答内容
	 */
	public void teacherAnswerQuestion(final Context ctx, final Handler handler, final int msgid, final int questionId, final String username, final String answerContent) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.teacherAnswerQuestion(questionId, username, answerContent);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 我的家教
	 * @param username
	 */
	public void myHomeTeacher(final Context ctx, final Handler handler, final int msgid, final String username) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.myHomeTeacher(username);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 我的家教-我的老师
	 * @param username
	 * @param index 从第几条开始查询，分页获取频道数据
	 * @param num 频道数量，-1表示获取全部
	 */
	public void getMyTeacherList(final Context ctx, final Handler handler, final int msgid, final String username, final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.getMyTeacherList(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 我的收藏
	 * @param uid
	 * @param index 从第几条开始查询，分页获取频道数据
	 * @param num 频道数量，-1表示获取全部
	 */ 
	public void myCollect(final Context ctx, final Handler handler, final int msgid, final String username, final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.myCollect(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 我的家教-我的收藏—删除选中
	 * @param username
	 * @param collectid 我的收藏ID
	 */
	public void deleteStudentCollect(final Context ctx, final Handler handler, final int msgid, final String username, final int collectid) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.deleteStudentCollect(username, collectid);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 我的家教-我的通知
	 * @param username
	 * @param index 从第几条开始查询，分页获取频道数据
	 * @param num 频道数量，-1表示获取全部
	 */
	public void getMyTeacherNotification(final Context ctx, final Handler handler, final int msgid, final String username, final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.getMyTeacherNotification(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 我的家教-我的消费
	 * @param username
	 * @param index 从第几条开始查询，分页获取频道数据
	 * @param num 频道数量，-1表示获取全部
	 */
	public void getMyConsumption(final Context ctx, final Handler handler, final int msgid, final String username, final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.getMyConsumption(username, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 我的教室
	 * @param username
	 * @param index 从第几条开始查询，分页获取频道数据
	 * @param num 频道数量，-1表示获取全部
	 * @param begTime 开始时间
	 * @param endTime 结束时间
	 */
	public void getMyClassroom(final Context ctx, final Handler handler, final int msgid, final String username, final int index, final int num, final String begTime, final String endTime) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.getMyClassroom(username, index, num, begTime, endTime);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	
	
	
	/**
	 * 提交评价 满意ro不满意
	 * @param aid 问题iid
	 * @param type 提交的类型1-满意， 2-不满意
	 */
	public void commitAssess(final Context context, final Handler handler, final int msgid, final int aid,
			final int type) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.getAttentionType(aid, type);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}

	/**
	 * 修改老师个人信息
	 */
	public void updateTeacher(final Context ctx, final Handler handler, final int msgid, final String username,
			final int grade, final int subject, final String head, final String email, final String password, final String repeatpassword,
			final String phone, final int gender, final long birthday) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.updateTeacher(username, grade, subject, head, email, password,
						repeatpassword, phone, gender, birthday);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
	/**
	 * 老师 账户
	 */
	public void getTeacherAccount(final Context ctx, final Handler handler, final int msgid, final String uid, final int index, final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				MessageManager mm = new MessageManager(handler, msgid);
				JsonBean bean = new JsonBean();
				ResultObject ro = (ResultObject) bean.getTeacherAccount(uid, index, num);
				mm.sendHandlerMessage(ro);
			}
		}).start();
	}
	
}
