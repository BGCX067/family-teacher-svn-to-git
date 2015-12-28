package com.familyedu.student;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.MyCollect_Adapter;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 我的收藏
 * Adapter:MyCollect_Adapter
 */
public class EduMyCollectActivity extends ActivityBase implements OnClickListener{

	private Button back, delete;
	private ListView collectList;
	private MyCollect_Adapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_mycollect);
		
		initView();
	}
	
	private void initView() {

		adapter = new MyCollect_Adapter(this);
		
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(this);
		
		delete = (Button) findViewById(R.id.delete);
		delete.setOnClickListener(this);
		
		collectList = (ListView) findViewById(R.id.collectList);
		collectList.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.back:
			
			this.finish();
			break;
		case R.id.delete:
			
			Utilities.showToast(this, "删除选中项");
			break;

		default:
			break;
		}
	}

}
