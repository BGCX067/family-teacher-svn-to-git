package com.familyedu.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.familyedu.ActivityBase;
import com.familyedu.R;

/**
 * 
 * @author Administrator
 * 教师端-问题墙-内容页
 * 
 */
public class EduIssueWallConTeacherActivity extends ActivityBase implements OnClickListener{
    
	private Button back, refresh;
	private TextView banner_title; // 问题标题
	private int isreply; // 1=已回复， 2=未回复
	
	// 问题
	private ImageView uhead; // 学生头像
	private TextView tname; // 学生名字
	private TextView itime; // 提问时间
	private TextView istate; // 问题状态
	private TextView title; // 问题标题
	private TextView icon; //  问题内容
	private Gallery ipic; // 问题图片
	private Button iplay; // 播放Mp3
	
	// 回复
	private View replyView; // 回复View
	private ImageView rhead; // 老师头像
	private TextView tName; // 老师名字
	private TextView rtime; // 解答时间
	private TextView rcon; //  回复内容
	private ImageView rpic; // 回复图片
	private Button rplay; // 播放回复Mp3
	
	private View bottomview; // 顶或者踩的view
	private ImageView dORc; // 顶或者踩的图标
	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_issuewallcon);
        
        initView();
    }

	private void initView() {

		Intent intent = getIntent();
		isreply = intent.getIntExtra("isreply", -1); // 1=已回复， 2=未回复
		
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(this);
		refresh = (Button) findViewById(R.id.refresh); 
		refresh.setOnClickListener(this);
		banner_title = (TextView) findViewById(R.id.banner_title); // 问题标题
		
		
		// 问题
		uhead = (ImageView) findViewById(R.id.uhead); // 学生头像
		tname = (TextView) findViewById(R.id.tname); // 学生名字
		itime = (TextView) findViewById(R.id.itime); // 提问时间
		istate = (TextView) findViewById(R.id.istate); // 问题状态
		title = (TextView) findViewById(R.id.title); // 问题标题
		icon = (TextView) findViewById(R.id.icon); //  问题内容
		ipic = (Gallery) findViewById(R.id.ipic); // 问题图片
		iplay = (Button) findViewById(R.id.iplay); // 播放Mp3
		
		// 回复
		replyView = (View) findViewById(R.id.replyView); // 回复View
		rhead = (ImageView) findViewById(R.id.rhead); // 老师头像
		tName = (TextView) findViewById(R.id.tName); // 老师名字
		rtime = (TextView) findViewById(R.id.rtime); // 解答时间
		rcon = (TextView) findViewById(R.id.rcon); //  回复内容
		rpic = (ImageView) findViewById(R.id.rpic); // 回复图片
		rplay = (Button) findViewById(R.id.rplay); // 播放回复Mp3
		
		bottomview = (View) findViewById(R.id.bottomview); // 顶或者踩的view
		dORc = (ImageView) findViewById(R.id.dORc); // 顶或者踩的图标
		
		// 1=已回复， 2=未回复
		if(isreply == 1){ // 已回复
			
			replyView.setVisibility(View.VISIBLE);
			bottomview.setVisibility(View.VISIBLE);
		
		}else{ // 未回复
			
			replyView.setVisibility(View.GONE);
			bottomview.setVisibility(View.GONE);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}