package com.familyedu;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.familyedu.model.UserInfo;
import com.familyedu.net.DataService;
import com.familyedu.net.ResultObject;
import com.familyedu.teacher.MainTabTecActivity;
import com.familyedu.tools.ApplicationData;
import com.familyedu.tools.Utilities;
/**
 * 用户登录
 * @author jiangxiaoliang
 *
 */

public class LoginActivity extends ActivityBase implements OnClickListener{

	LinearLayout llGoRegist; //去注册
	Button btnLogin;  //登录按钮
	private DataService service;
	private static final int LOGIN =1;
	private EditText uname, upw;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        //没有账号？立即注册
        llGoRegist = (LinearLayout)findViewById(R.id.llGoRegist);
        llGoRegist.setOnClickListener(this);
        
        //登录按钮
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        
        service = new DataService();
        
        uname = (EditText) findViewById(R.id.uname);
        uname.setText("tc1");
        upw = (EditText) findViewById(R.id.upw);
        upw.setText("111111");
    }

	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {

			
			switch (msg.what) {
			case LOGIN: // 
				
				ResultObject res = (ResultObject) msg.obj;
				if(res.result == true){
					
					UserInfo user = (UserInfo) res.obj;
					
					//将用户个人信息存储到全局数据Application中
					ApplicationData applicationData = (ApplicationData)LoginActivity.this.getApplication();
					applicationData.setUserInfo(user);
					
					String type = user.roleType;
					if(type.equals("ST")){ // 学生
						
						FamilyEduActivity.actionFamilyEduActivity(LoginActivity.this);
						LoginActivity.this.finish();
					
					}else if(type.equals("TC")){ // 老师
						
						//FamilyEduTeacherActivity.actionFamilyEduActivity(LoginActivity.this);
						LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainTabTecActivity.class));
						LoginActivity.this.finish();
					}
					
				}else{
					Utilities.showToast(LoginActivity.this, "登录失败");
				}
					break;
			default:
				break;
			}
			
			super.handleMessage(msg);
		}
	};
    
    
    @Override
    public void onClick(View v) {
    	switch (v.getId()) {
		case R.id.llGoRegist:  //没有账号，立即注册
			RegistChooseActivity.actionRegisterChoose(LoginActivity.this);  //跳转到注册
			LoginActivity.this.finish();
			break;
		case R.id.btnLogin:  //登录按钮
			
			 String unames = uname.getText().toString();
			 String upws = upw.getText().toString();
			
			ObtainSubjectMsg(unames, upws);
//			 
//			FamilyEduActivity.actionFamilyEduActivity(LoginActivity.this);
//			FamilyEduTeacherActivity.actionFamilyEduActivity(LoginActivity.this);
//			LoginActivity.this.finish();
			//登录
			break;
		default:
			break;
		}
    }
    
	// 获取专题 信息
	private void ObtainSubjectMsg(String username, String password){
		
		CallPortThread ost = new CallPortThread(LoginActivity.this, username,password);
		ost.execute("");
	}
    
	// 调用接口
	class CallPortThread extends AsyncTask<String, Integer, String>{

		Context context;
		String username;
		String password;
		public CallPortThread(Context context, String username, String password) {

			this.context = context;
			this.username = username;
			this.password = password;
		}
		
		@Override
		protected void onPreExecute() {
			
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {

			service.login(context, handler, LOGIN, username, password);
			                  
			return "";
		}
	}
	
}
