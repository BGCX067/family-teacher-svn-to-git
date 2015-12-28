package com.familyedu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.familyedu.tools.Utilities;

/**
 * 教师注册
 * @author jiangxiaoliang
 *
 */
public class TeacherRegistActivity extends ActivityBase implements OnClickListener{

	Button btnBack, btnRegist;
	LinearLayout llGoStudentReg;  //跳转到学生注册页面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist_teacher);
		
		init();
	}
	
	private void init() {
		btnBack = (Button)findViewById(R.id.btnBack);  //返回按钮
		btnBack.setOnClickListener(this);
		
		btnRegist = (Button)findViewById(R.id.btnRegist);  //初始化注册按钮
		btnRegist.setOnClickListener(this);
		
		llGoStudentReg = (LinearLayout)findViewById(R.id.llGoStudentReg);  //初始化跳转到学生注册布局
		llGoStudentReg.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnBack:
			this.finish();
			break;
		case R.id.btnRegist:
			Utilities.showToast(this, "注册信息已提交！");
			break;
		case R.id.llGoStudentReg:
			startActivity(new Intent(this, StudentRegistActivity.class));
			this.finish();
		default:
			break;
		}
	}
}
