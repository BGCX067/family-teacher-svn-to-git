package com.familyedu.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.familyedu.ActivityBase;
import com.familyedu.FamilyEduActivity;
import com.familyedu.R;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 我的作文
 */
public class EduCompositionActivity extends ActivityBase implements OnClickListener{
   
	private Button back, go_quiz; // 返回， 去提问
	private Button grade, subject; // 年级， 学科
	private EditText iTitle, iCon; // 作文标题， 作文内容
	private Button addPic; // 上传图片
	private ImageView picflag; // 上传图片标识
	private Button submit; // 提交
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_composition);
        
        initView();
    }

	private void initView() {
		
		back = (Button) findViewById(R.id.back); // 回退键
		back.setOnClickListener(this);
		go_quiz = (Button) findViewById(R.id.go_quiz); // 去提问
		go_quiz.setOnClickListener(this);
		grade = (Button) findViewById(R.id.grade); // 年级
		grade.setOnClickListener(this);
		subject = (Button) findViewById(R.id.subject); // 学科
		subject.setOnClickListener(this);
		
		iTitle = (EditText) findViewById(R.id.iTitle); // 作文标题
		iCon = (EditText) findViewById(R.id.iCon); // 作文内容
		
		addPic = (Button) findViewById(R.id.addPic); // 上传图片
		addPic.setOnClickListener(this);
		picflag = (ImageView) findViewById(R.id.picflag); // 上传图片标识
		
		submit = (Button) findViewById(R.id.submit); // 提交
		submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.back: // 回退
			
			this.finish();
			break;
		case R.id.go_quiz: // 去提问
			
			Intent intent = new Intent();
			intent.putExtra("position",1);
			intent.setClass(this, FamilyEduActivity.class);
			startActivity(intent);
			this.finish();
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
		case R.id.submit: // 提交
			
			Utilities.showToast(this, "提交");
			break;

		default:
			break;
		}
		
	}
    
    
}