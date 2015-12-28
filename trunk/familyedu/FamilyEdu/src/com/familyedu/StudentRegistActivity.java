package com.familyedu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.familyedu.tools.Utilities;

/**
 * 学生注册
 * @author jiangxiaoliang
 *
 */
public class StudentRegistActivity extends ActivityBase implements OnClickListener{

	Button btnBack, btnRegist;  //返回，注册按钮
	LinearLayout llGoTecReg;   //跳转到教师注册页面
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist_student);
		init();
	}
	
	/**
	 * 控件初始化
	 */
	private void init() {
		btnBack = (Button)findViewById(R.id.btnBack);	//返回按钮
		btnBack.setOnClickListener(this);
		
		btnRegist= (Button)findViewById(R.id.btnRegist);	//注册按钮
		btnRegist.setOnClickListener(this);
		
		llGoTecReg = (LinearLayout)findViewById(R.id.llGoTeacherReg);
		llGoTecReg.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnBack:	//返回按钮
			this.finish();
			break;
		case R.id.btnRegist:	//注册阿牛
			Utilities.showToast(this, "注册信息已经提交！");
			break;
		case R.id.llGoTeacherReg:	//跳转到教师注册页面
			startActivity(new Intent(this, TeacherRegistActivity.class));
			this.finish();
		default:
			break;
		}
	}
}
