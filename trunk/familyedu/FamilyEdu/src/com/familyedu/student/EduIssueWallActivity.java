package com.familyedu.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.IssueWall_Adapter;

/**
 * 
 * @author Administrator
 * 学生端-问题墙
 * Adapter:IssueWall_Adapter
 */
public class EduIssueWallActivity extends ActivityBase implements OnClickListener, OnItemClickListener{
    
	private Button refresh; // 刷新
	private ListView issueWallList; // 问题墙列表
	private IssueWall_Adapter adapter;
	
	private EditText edit;
	private Button query; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_issuewall);
        
        initView();
    }

	private void initView() {

		adapter = new IssueWall_Adapter(this);
		
		refresh = (Button) findViewById(R.id.refresh); // 刷新
		issueWallList = (ListView) findViewById(R.id.issueWallList);
		issueWallList.setOnItemClickListener(this);
		issueWallList.setAdapter(adapter);
		
		edit = (EditText) findViewById(R.id.edit);
		query = (Button) findViewById(R.id.query); // 检索
		query.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.query){
			
			startActivity(new Intent(this, EduIssueWall_queryConActivity.class));
		}
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		
		Log.i("sk", "当前点击的位置是：" + position);
		Intent intent = new Intent();
		intent.putExtra("IssueState", 2);
		intent.setClass(this, EduIssueConYActvity.class);
		startActivity(intent);
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