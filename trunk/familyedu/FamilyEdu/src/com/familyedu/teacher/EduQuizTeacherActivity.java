package com.familyedu.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.EduCompositionActivity;
import com.familyedu.student.adapter.Consumption_Adapter;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 账户
 */
public class EduQuizTeacherActivity extends ActivityBase implements OnClickListener{
   
	private Button refresh, txBtn; // 刷新，提现
	private TextView goldNum, issueNum;
	private Consumption_Adapter adapter;
	private ListView consumptionList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_myaccount);
        
        initView();
    }
    
    
	private void initView() {
		
		adapter = new Consumption_Adapter(this);
		
		refresh = (Button) findViewById(R.id.refresh); // 刷新
		refresh.setOnClickListener(this);
		txBtn = (Button) findViewById(R.id.txBtn); // 提现
		txBtn.setOnClickListener(this);
		
		consumptionList = (ListView) findViewById(R.id.consumptionList);
		consumptionList.setAdapter(adapter);
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
		case R.id.refresh: // 刷新
			
			Utilities.showToast(EduQuizTeacherActivity.this, "刷新");
			break;
		case R.id.txBtn: // 提现
			
			startActivity(new Intent(this, EduTiXianActivity.class));
			break;
		
		default:
			break;
		}
		
	}
}