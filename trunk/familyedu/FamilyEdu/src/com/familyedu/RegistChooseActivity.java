package com.familyedu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 选择注册方式
 * 教师注册？学生注册
 * @author jiangxiaoliang
 *
 */
public class RegistChooseActivity extends ActivityBase implements OnClickListener{

	public static void actionRegisterChoose(Context ctx) {
		Intent sIntent = new Intent(ctx, RegistChooseActivity.class);
		ctx.startActivity(sIntent);
	}
	
	
	Button btnTeacherReg;  //教师注册按钮
	Button btnStudentReg;  //学生注册按钮
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist_choose);
		
		btnStudentReg = (Button)findViewById(R.id.btnStudentReg);  //学生注册
		btnStudentReg.setOnClickListener(this);
		
		btnTeacherReg = (Button)findViewById(R.id.btnTeacherReg);  //教师注册
		btnTeacherReg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnTeacherReg:  //跳转到教师注册
			startActivity(new Intent(RegistChooseActivity.this, TeacherRegistActivity.class));
			break;
		case R.id.btnStudentReg:	//跳转到学生注册
			startActivity(new Intent(RegistChooseActivity.this, StudentRegistActivity.class));
			break;
		}
	}
}
