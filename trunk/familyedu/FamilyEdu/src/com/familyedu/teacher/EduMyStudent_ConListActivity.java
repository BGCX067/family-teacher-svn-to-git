package com.familyedu.teacher;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.IssueWall_Adapter;

/**
 * 
 * @author Administrator
 * 我的教室-我的学生-问题列表页
 * Adapter:IssueWall_Adapter
 */
public class EduMyStudent_ConListActivity extends ActivityBase{
    
	private Button refresh; // 刷新
	private ListView issueWallList; // 问题墙列表
	private IssueWall_Adapter adapter;
	private TextView userName; // 用户名
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_mystuednt_conlist);
        
        initView();
    }

	private void initView() {

		adapter = new IssueWall_Adapter(this);
		
		userName = (TextView) findViewById(R.id.userName); // 用户名
		
		refresh = (Button) findViewById(R.id.refresh); // 刷新
		refresh.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				EduMyStudent_ConListActivity.this.finish();
			}
			
		});
		issueWallList = (ListView) findViewById(R.id.issueWallList);
		issueWallList.setAdapter(adapter);
		
	}

	
    
    
}