package com.familyedu;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;

import com.familyedu.teacher.EduIssueWallTeacherActivity;
import com.familyedu.teacher.EduMainTeacherActivity;
import com.familyedu.teacher.EduMoreTeacherActivity;
import com.familyedu.teacher.EduMyClassRoomActivity;
import com.familyedu.teacher.EduQuizTeacherActivity;
import com.familyedu.tools.Utilities;

public class FamilyEduTeacherActivity extends TabActivity implements View.OnClickListener {

	public static void actionFamilyEduActivity(Context ctx) {
		actionFamilyEduActivity(ctx, 0);
	}

	public static void actionFamilyEduActivity(Context ctx, int position) {
		Intent intent = new Intent();
		intent.putExtra("position", position);
		intent.setClass(ctx, FamilyEduTeacherActivity.class);
		ctx.startActivity(intent);
	}

	private TabHost mHost;
	private TabHost localTabHost;
	private Button mainpage, quiz, issuewall, myedu, more;// 首页，账户， 问题墙，

	private int position = 0; // 接收到的位置

	private static final String EDU_MAINPAGE = "tab_main";
	private static final String EDU_QUIZ = "tab_quiz";
	private static final String EDU_ISSUEWALL = "tab_issuewall";
	private static final String EDU_MYEDUCATION = "tab_myeducation";
	private static final String EDU_MORE = "tab_more";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_tab);

		initView();
		setupIntent();
		
		Log.i("sk", "-------->" + getClass().getName());
	}

	private void initView() {
		Intent intent = getIntent();
		position = intent.getIntExtra("position", 0);

		mainpage = (Button) findViewById(R.id.tvgossip);
		mainpage.setOnClickListener(this); // 首页
		quiz = (Button) findViewById(R.id.tvmeanguide);
		quiz.setOnClickListener(this); // 账户
		issuewall = (Button) findViewById(R.id.tvguide);
		issuewall.setOnClickListener(this); // 问题墙
		myedu = (Button) findViewById(R.id.programparade);// 我的教室
		myedu.setOnClickListener(this);
		more = (Button) findViewById(R.id.star); // 更多
		more.setOnClickListener(this);
	}

	private void setupIntent() {
		mHost = getTabHost();

		Intent MainIntent = new Intent(this, EduMainTeacherActivity.class); // 首页
		Intent QuizIntent = new Intent(this, EduQuizTeacherActivity.class); // 账户
		Intent IssueWallIntent = new Intent(this, EduIssueWallTeacherActivity.class);// 问题墙
		Intent MyEducationIntent = new Intent(this, EduMyClassRoomActivity.class);// 我的教室
		Intent MoreIntent = new Intent(this, EduMoreTeacherActivity.class); // 更多

		localTabHost = this.mHost;

		// try {
		// Field idcurrent =
		// localTabHost.getClass().getDeclaredField("mCurrentTab");
		// idcurrent.setAccessible(true);
		// idcurrent.setInt(localTabHost, -2);
		// } catch (Exception e) {
		// Log.i("sk", "Exception==========>>" + e.getMessage());
		// }

		localTabHost.addTab(buildTabSpec(EDU_MAINPAGE, R.string.hello, R.drawable.icon_dsbg_out, MainIntent)); // 首页
		localTabHost.addTab(buildTabSpec(EDU_QUIZ, R.string.hello, R.drawable.icon_jryp_out, QuizIntent)); // 账户
		localTabHost.addTab(buildTabSpec(EDU_ISSUEWALL, R.string.hello, R.drawable.icon_sszn_out, IssueWallIntent)); // 问题墙
		localTabHost.addTab(buildTabSpec(EDU_MYEDUCATION, R.string.hello, R.drawable.icon_jmyg_out, MyEducationIntent)); // 我的家教
		localTabHost.addTab(buildTabSpec(EDU_MORE, R.string.hello, R.drawable.icon_mxk_out, MoreIntent));// 更多

		// try {
		// Field idcurrent =
		// localTabHost.getClass().getDeclaredField("mCurrentTab");
		// idcurrent.setAccessible(true);
		// idcurrent.setInt(localTabHost, 0);
		// } catch (Exception e) {
		// Log.i("sk", "Exception1==========>>" + e.getMessage());
		// }

		setCurrentTab(position);
	}

	// 设置当前Tab页
	private void setCurrentTab(int position) {
		if (position < 0) {
			localTabHost.setCurrentTab(0);
		} else {
			if (position == 0) { // 首页
				mainpage.setBackgroundResource(R.drawable.icon_dsbg_over);
				quiz.setBackgroundResource(R.drawable.icon_jryp_out);
				issuewall.setBackgroundResource(R.drawable.icon_sszn_out);
				myedu.setBackgroundResource(R.drawable.icon_jmyg_out);
				more.setBackgroundResource(R.drawable.icon_mxk_out);
			} else if (position == 1) { // 账户
				mainpage.setBackgroundResource(R.drawable.icon_dsbg_out);
				quiz.setBackgroundResource(R.drawable.icon_jryp_over);
				issuewall.setBackgroundResource(R.drawable.icon_sszn_out);
				myedu.setBackgroundResource(R.drawable.icon_jmyg_out);
				more.setBackgroundResource(R.drawable.icon_mxk_out);
			} else if (position == 2) { // 问题墙
				mainpage.setBackgroundResource(R.drawable.icon_dsbg_out);
				quiz.setBackgroundResource(R.drawable.icon_jryp_out);
				issuewall.setBackgroundResource(R.drawable.icon_sszn_over);
				myedu.setBackgroundResource(R.drawable.icon_jmyg_out);
				more.setBackgroundResource(R.drawable.icon_mxk_out);
			} else if (position == 3) { // 我的教室
				mainpage.setBackgroundResource(R.drawable.icon_dsbg_out);
				quiz.setBackgroundResource(R.drawable.icon_jryp_out);
				issuewall.setBackgroundResource(R.drawable.icon_sszn_out);
				myedu.setBackgroundResource(R.drawable.icon_jmyg_over);
				more.setBackgroundResource(R.drawable.icon_mxk_out);
			} else if (position == 4) { // 更多
				mainpage.setBackgroundResource(R.drawable.icon_dsbg_out);
				quiz.setBackgroundResource(R.drawable.icon_jryp_out);
				issuewall.setBackgroundResource(R.drawable.icon_sszn_out);
				myedu.setBackgroundResource(R.drawable.icon_jmyg_out);
				more.setBackgroundResource(R.drawable.icon_mxk_over);
			}
			// 选择的TabHost
			localTabHost.setCurrentTab(position);
		}
	}

	/**
	 * 选项卡细节
	 */
	private TabHost.TabSpec buildTabSpec(String tag, int resLable, int resIcon, Intent content) {
		return this.mHost.newTabSpec(tag).setIndicator(getString(resLable), getResources().getDrawable(resIcon)).setContent(content);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tvgossip: // 首页
			setCurrentTab(0);
			break;
		case R.id.tvmeanguide: // 账户
			setCurrentTab(1);
			break;
		case R.id.tvguide: // 问题墙
			setCurrentTab(2);
			break;
		case R.id.programparade: // 我的家教
			setCurrentTab(3);
			break;
		case R.id.star: // 更多
			setCurrentTab(4);
			break;
		}
	}

	// 屏蔽回退键
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			Utilities.exitDialog(this).show();
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
}