package com.familyedu.teacher;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.familyedu.R;
import com.familyedu.tools.Utilities;

/**
 * MainTab页，教师端登录底部Tab，修改相应图片即可
 * 
 * @author xiezhangsuo
 * 
 */
public class MainTabTecActivity extends TabActivity implements OnCheckedChangeListener {
	// RadioButton 首页，账户，问题强，我的教室，更多
	private RadioButton rbHomePage, rbAccount, rbQuestions, rbMyClassRoom, rbMore;

	private Intent homePageIntent, accountIntent, questionsIntent, classRoomIntent, moreIntent;
	private TabHost localTabHost;
	private long exitTime = 0; // 退出时间

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.maintab4teacher);

		initView();
		setupIntent();
	}

	private void initView() {
		localTabHost = this.getTabHost();

		homePageIntent = new Intent(this, EduMainTeacherActivity.class); // 主页
		accountIntent = new Intent(this, EduQuizTeacherActivity.class); // 账户
		questionsIntent = new Intent(this, EduIssueWallTeacherActivity.class);// 问题强
		classRoomIntent = new Intent(this, EduMyClassRoomActivity.class);// 我的教室
		moreIntent = new Intent(this, EduMoreTeacherActivity.class); // 更多

		rbHomePage = (RadioButton) findViewById(R.id.rbHomePage); // 首页
		rbHomePage.setOnCheckedChangeListener(this);
		rbAccount = (RadioButton) findViewById(R.id.rbAccount); // 账户
		rbAccount.setOnCheckedChangeListener(this);
		rbQuestions = (RadioButton) findViewById(R.id.rbQuestions); // 问题强
		rbQuestions.setOnCheckedChangeListener(this);
		rbMyClassRoom = (RadioButton) findViewById(R.id.rbMyClassRoom);// 我的教室
		rbMyClassRoom.setOnCheckedChangeListener(this);
		rbMore = (RadioButton) findViewById(R.id.rbMore); // 更多
		rbMore.setOnCheckedChangeListener(this);

	}

	/**
	 * Tab-Intent
	 */
	private void setupIntent() {
		localTabHost.addTab(buildTabSpec("homepage_tab", R.string.hello, R.drawable.icon_dsbg_out, homePageIntent)); // 首页
		localTabHost.addTab(buildTabSpec("account_tab", R.string.hello, R.drawable.icon_jryp_out, accountIntent)); // 账户
		localTabHost.addTab(buildTabSpec("questions_tab", R.string.hello, R.drawable.icon_sszn_out, questionsIntent)); // 问题强
		localTabHost.addTab(buildTabSpec("classroom_tab", R.string.hello, R.drawable.icon_jmyg_out, classRoomIntent)); // 我的教室
		localTabHost.addTab(buildTabSpec("more_tab", R.string.hello, R.drawable.icon_mxk_out, moreIntent));// 更多

		// 设置默认选中第一个位置
		// localTabHost.setCurrentTab(0);
	}

	/**
	 * 选项卡细节
	 */
	private TabHost.TabSpec buildTabSpec(String tag, int resLable, int resIcon, Intent content) {
		return this.localTabHost.newTabSpec(tag).setIndicator(getString(resLable), getResources().getDrawable(resIcon))
				.setContent(content);
	}

	/**
	 * tab切换动作
	 * 
	 * @param buttonView
	 * @param isChecked
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		if (isChecked) {
			switch (buttonView.getId()) {
			case R.id.rbHomePage:
				this.localTabHost.setCurrentTabByTag("homepage_tab");
				break;
			case R.id.rbAccount:
				this.localTabHost.setCurrentTabByTag("account_tab");
				break;
			case R.id.rbQuestions:
				this.localTabHost.setCurrentTabByTag("questions_tab");
				break;
			case R.id.rbMyClassRoom:
				this.localTabHost.setCurrentTabByTag("classroom_tab");
				break;
			case R.id.rbMore:
				this.localTabHost.setCurrentTabByTag("more_tab");
				break;
			}
		}
	}

	// 屏蔽回退键
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		// 第一次按下时
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				exitTime = System.currentTimeMillis();
				Utilities.showToast(MainTabTecActivity.this, "再按一次退出程序！");
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
