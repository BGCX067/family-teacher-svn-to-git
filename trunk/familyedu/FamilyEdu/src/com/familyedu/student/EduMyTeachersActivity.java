package com.familyedu.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.MyTeachers_Adapter;

/**
 * 
 * @author Administrator
 * 我的老师
 * Adapter ：MyTeachers_Adapter
 */
public class EduMyTeachersActivity extends ActivityBase implements OnClickListener, OnItemClickListener{

	private Button myback;
	private GridView grid;
	private MyTeachers_Adapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_myteachers);
		
		initView();
	}

	private void initView() {

		adapter = new MyTeachers_Adapter(this);
		
		myback = (Button) findViewById(R.id.myback);
		myback.setOnClickListener(this);
		
		grid = (GridView) findViewById(R.id.grid);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {

		if(v.getId() == R.id.myback){
			
			this.finish();
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		startActivity(new Intent(EduMyTeachersActivity.this, EduMyTeacher_ConListActivity.class));
		
	}
	
}
