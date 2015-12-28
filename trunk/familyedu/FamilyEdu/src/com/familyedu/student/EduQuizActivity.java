package com.familyedu.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 提问
 */
public class EduQuizActivity extends ActivityBase implements OnClickListener{
   
	private Button back, go_composition; // 返回， 写作文
	private Button grade, subject;  // 年级， 学科
	private EditText iTitle, iCon; // 问题标题， 问题内容
	private Button addPic, addrecord; // 添加图片， 录音
	private ImageView picflag, recordflag; // 添加图片标识，添加录音标识  
	private Button save, submit; // 保存问题， 提交问题
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_quiz);
        
        initView();
    }
    
    
	private void initView() {
		
		back = (Button) findViewById(R.id.back); // 返回
		back.setOnClickListener(this);
		go_composition = (Button) findViewById(R.id.go_composition); // 写作文
		go_composition.setOnClickListener(this);
		grade = (Button) findViewById(R.id.grade); // 年级
		grade.setOnClickListener(this);
		subject = (Button) findViewById(R.id.subject); // 学科
		subject.setOnClickListener(this);
		
		iTitle = (EditText) findViewById(R.id.iTitle); // 问题标题
		iCon = (EditText) findViewById(R.id.iCon); // 问题内容
		
		addPic = (Button) findViewById(R.id.addPic); // 添加图片
		addPic.setOnClickListener(this);
		addrecord = (Button) findViewById(R.id.addrecord); // 添加录音
		addrecord.setOnClickListener(this);
		
		picflag = (ImageView) findViewById(R.id.picflag); // 添加图片标识
		recordflag = (ImageView) findViewById(R.id.recordflag); // 添加录音标识
		
		save = (Button) findViewById(R.id.save); // 保存问题
		save.setOnClickListener(this);
		submit = (Button) findViewById(R.id.submit); // 提交问题
		submit.setOnClickListener(this);
	}


	// 捕捉回退键，是否真的退出该程序
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			return false;
		}else{
			return super.onKeyDown(keyCode, event);
		}
	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.back: // 返回
			
			this.finish();
			break;
		case R.id.go_composition: // 写作文
			
			startActivity(new Intent(this,EduCompositionActivity.class ));
			break;
		case R.id.grade: // 年级
			
			Utilities.showToast(this, "年级");
			break;
		case R.id.subject: // 学科
			
			Utilities.showToast(this, "学科");
			break;
		case R.id.addPic: // 添加图片
			
			Utilities.showToast(this, "添加图片");
			break;
		case R.id.addrecord: // 添加录音
			
			Utilities.showToast(this, "添加录音");
			break;
		case R.id.save: // 保存问题
			
			Utilities.showToast(this, "保存问题");
			break;
		case R.id.submit: // 提交问题
			
			Utilities.showToast(this, "提交问题");
			break;
		default:
			break;
		}
		
	}
}