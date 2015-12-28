package com.familyedu.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.familyedu.ActivityBase;
import com.familyedu.FamilyEduActivity;
import com.familyedu.R;
import com.familyedu.student.EduChongzhiActivity;
import com.familyedu.student.EduConsumptionActivity;
import com.familyedu.student.EduFavoriteActivity;
import com.familyedu.student.EduMyInformActivity;
import com.familyedu.student.EduMyTeachersActivity;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 我的教室
 */
public class EduMyClassRoomActivity extends ActivityBase implements OnClickListener{

	private ImageView uhead; // 用户头像
	private TextView nickname; // 用户名
	
	/*** 问题数 ***/
	private View issueview; // 我的回答
	private TextView issueNum; // 回答数

	/*** 我的老师 ***/
	private View teacherview; // 我的学生
	private TextView sNum; // 学生数	
	
	/*** 我的收藏 ***/
	private View collectview; // 收藏View
	private TextView collectNum; // 收藏数	
	
	/*** 我的通知 ***/
	private View informview; // 问题View
	private TextView informNum; // 通知数
	
	/*** 编辑个人资料 ***/
	private Button compileview; // 编辑个人资料
	
	private View surplusgold; // 赚取金币数
	private Button chongzhiview; // 去提现
	private EditText cyear, dyear; // 开始年月日， 到结束年月日
	private Button search;// 查询
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_myeducation);
        
        initView();
        
    }

	private void initView() {
		
		uhead = (ImageView) findViewById(R.id.uhead); // 用户头像
		nickname = (TextView) findViewById(R.id.nickname); // 用户昵称
		
		/*** 问题数 ***/
		issueview = (View)findViewById(R.id.issueview); // 我的回答
		issueview.setOnClickListener(this);
		issueNum = (TextView) findViewById(R.id.issueNum); // 回答数
		
		/*** 我的老师 ***/
		teacherview = (View)findViewById(R.id.teacherview); // 学生View
		teacherview.setOnClickListener(this);
		sNum = (TextView) findViewById(R.id.sNum); // 学生数
		
		/*** 我的收藏 ***/
		collectview = (View)findViewById(R.id.collectview); // 收藏View
		collectview.setOnClickListener(this);
		collectNum = (TextView) findViewById(R.id.collectNum); // 收藏数
		
		/*** 我的通知 ***/
		informview = (View)findViewById(R.id.informview); // 通知View
		informview.setOnClickListener(this);
		informNum = (TextView) findViewById(R.id.informNum); // 通知数
		
		compileview = (Button)findViewById(R.id.compileview); // 编辑个人资料View
		compileview.setOnClickListener(this);
		
		surplusgold = (View) findViewById(R.id.surplusgold); // 我的金币
		surplusgold.setOnClickListener(this);
		chongzhiview = (Button)findViewById(R.id.chongzhiview); // 提现View
		chongzhiview.setOnClickListener(this);
		
		cyear = (EditText) findViewById(R.id.cyear); // 开始-年
		dyear = (EditText) findViewById(R.id.dyear); // 结束-年
		
		search = (Button) findViewById(R.id.search);
		search.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.issueview: // 我的回答
			
			// 我的回答问题页面还没做
			break;
		case R.id.teacherview: // 学生View
			
			intent.setClass(this,EduMyStudentActivity.class);
			startActivity(intent);
			break;
		case R.id.collectview: // 收藏View
			
			intent.setClass(this, EduFavoriteActivity.class);
			startActivity(intent);
			break;
		case R.id.informview: // 通知View
			
			intent.setClass(this, EduMyInformActivity.class);
			startActivity(intent);
			break;
		case R.id.compileview: // 编辑个人资料View
			
			intent.setClass(this, EduEditInFormation.class);
			startActivity(intent);
			break;
		case R.id.surplusgold: // 赚取金币
			
			intent.setClass(this, EduConsumptionTeacherActivity.class);
			startActivity(intent);
			break;
		case R.id.chongzhiview: // 提现
			
			intent.setClass(this, EduTiXianActivity.class);
			startActivity(intent);
			break;
		case R.id.search: // 查询
			
			intent.setClass(this, EduConsumptionActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		
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
}