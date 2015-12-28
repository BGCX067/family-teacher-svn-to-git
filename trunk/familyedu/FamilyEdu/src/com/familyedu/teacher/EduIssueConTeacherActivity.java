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
 * 教师端-主页问题列表-问题内容页
 *
 */
public class EduIssueConTeacherActivity extends ActivityBase implements OnClickListener{
    
	private Button back, refresh;
	private ImageView uhead;
	private TextView title; // 问题标题
	private TextView itime; // 时间
	private TextView istate; // 问题状态
	private TextView icon; // 问题描述
	private Gallery ipic; // 问题图片
	private Button iplay; // 播放mp3
	private TextView surplustime; // 剩余时间
	private Button answer; // 解答题目
	private Button click; // 放弃
	
	private PopupWindow fqWindow;
	private Button confirm, cancel; // 确定， 取消
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_issuecon);
        
        initView();
    }
    
    
	private void initView() {
		
		back = (Button) findViewById(R.id.back); // 返回
		back.setOnClickListener(this);
		refresh = (Button) findViewById(R.id.refresh); // 刷新
		refresh.setOnClickListener(this);
		uhead = (ImageView) findViewById(R.id.uhead); // 头像
		title = (TextView) findViewById(R.id.title); // 问题标题
		itime = (TextView) findViewById(R.id.itime); // 时间
		istate = (TextView) findViewById(R.id.istate); // 问题状态
		icon = (TextView) findViewById(R.id.icon); // 问题描述
		ipic = (Gallery) findViewById(R.id.ipic); // 问题图片
		iplay = (Button) findViewById(R.id.iplay); // 播放mp3
		iplay.setOnClickListener(this);
		surplustime = (TextView) findViewById(R.id.surplustime); // 剩余时间
		answer = (Button) findViewById(R.id.answer); // 解答题目
		answer.setOnClickListener(this);
		click = (Button) findViewById(R.id.click); // 可点击
		click.setOnClickListener(this);
		
		
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
		case R.id.iplay: // 播放MP3
			
			Utilities.showToast(this, "播放MP3");
			break;
		case R.id.answer: // 解答题目
			
			startActivity(new Intent(this, EduAnswerIssueActivity.class));
			break;
		case R.id.click: // 放弃问题
			
			FQIssue();
			fqWindow.showAtLocation(findViewById(R.id.parent_view), Gravity.CENTER, 0, 0);
			break;
			// confirm, cancel
		case R.id.confirm: // 确定放弃问题
			
			if(fqWindow.isShowing()){
				fqWindow.dismiss();
			}
			Utilities.showToast(this, "确定放弃问题");
			break;
		case R.id.cancel: // 取消放弃问题
			
			if(fqWindow.isShowing()){
				fqWindow.dismiss();
			}
			Utilities.showToast(this, "取消放弃问题");
			break;			
		default:
			break;
		}
	}
	
	/**
	 * 确定放弃问题
	 */
	private void FQIssue() {
		
		if(fqWindow == null){
			View qxView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.teacher_fgnqi_issuecon_win, null);
			
			fqWindow = new PopupWindow(findViewById(R.id.parent_view), 300, LayoutParams.WRAP_CONTENT);
			fqWindow.setContentView(qxView);
			
			confirm = (Button) qxView.findViewById(R.id.confirm); // 确定
			confirm.setOnClickListener(this);
			cancel = (Button) qxView.findViewById(R.id.cancel); // 取消
			cancel.setOnClickListener(this);
			
			fqWindow.setFocusable(true);
			fqWindow.setTouchable(true);
			fqWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		if(fqWindow.isShowing()){
			fqWindow.dismiss();
		}

	}
	
}