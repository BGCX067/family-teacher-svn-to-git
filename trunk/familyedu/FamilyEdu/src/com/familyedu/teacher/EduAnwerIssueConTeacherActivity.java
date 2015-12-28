package com.familyedu.teacher;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.tools.Utilities;
/**
 * 
 * @author Administrator
 * 教师端-主页问题列表-已回复的问题内容页
 *
 */
public class EduAnwerIssueConTeacherActivity extends ActivityBase implements OnClickListener{
    
	private Button back, refresh;
	
	// 问题
	private ImageView uhead; // 学生头像
	private TextView title; // 问题标题
	private TextView itime; // 提问时间
	private TextView istate; // 问题状态
	private TextView icon; // 问题描述
	
	// 回复
	private int ishuifu; // 1=有回复问题， 2=没有回复的问题
	private ImageView rhead; // 老师头像
	private TextView tName; // 老师名字
	private TextView rtime; // 解答时间
	private TextView rcon; // 回复内容
	private ImageView rpic; // 回复图片
	private Button rplay; // 播放mp3
	private View replyview; // 回复问题的view
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_issueanwerpage_);
        
        initView();
    }
    
    
	private void initView() {
		
		Intent intent = getIntent();
		ishuifu = intent.getIntExtra("value", -1);
		
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(this);
		refresh = (Button) findViewById(R.id.refresh);
		refresh.setOnClickListener(this);
		
		// 问题
		uhead = (ImageView) findViewById(R.id.uhead); // 学生头像
		title = (TextView) findViewById(R.id.title); // 问题标题
		itime = (TextView) findViewById(R.id.itime); // 提问时间
		istate = (TextView) findViewById(R.id.istate); // 问题状态
		icon = (TextView) findViewById(R.id.icon); // 问题描述
		
		// 回复
		replyview = (View) findViewById(R.id.replyview); // 回复View
		
		if(ishuifu == 1){
			replyview.setVisibility(View.VISIBLE);
		}else{
			
			replyview.setVisibility(View.GONE);
		}
		
		rhead = (ImageView) findViewById(R.id.rhead); // 老师头像
		tName = (TextView) findViewById(R.id.tName); // 老师名字
		rtime = (TextView) findViewById(R.id.rtime); // 解答时间
		rcon = (TextView) findViewById(R.id.rcon); // 回复内容
		rpic = (ImageView) findViewById(R.id.rpic); // 回复图片
		rplay = (Button) findViewById(R.id.rplay); // 播放mp3
		rplay.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.back: // 返回
			
			this.finish();
			break;
		case R.id.refresh: // 刷新
			
			Utilities.showToast(this, "刷新");
			break;
		case R.id.rplay: // 播放MP3
			
			Utilities.showToast(this, "播放MP3");
			break;
		default:
			break;
		}
	}
	
	/**
	 * 确定放弃问题
	 */
	
}