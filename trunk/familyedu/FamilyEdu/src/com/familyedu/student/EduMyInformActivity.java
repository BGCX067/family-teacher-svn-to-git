package com.familyedu.student;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.MyInfrom_Adapter;

/**
 * 
 * @author Administrator
 * 我的通知
 * Adapter:MyInfrom_Adapter
 */
public class EduMyInformActivity extends ActivityBase implements OnClickListener{

	private ListView informList;
	private Button back;
	private MyInfrom_Adapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_myinform);
		
		initView();
	}
	
	private void initView() {

		adapter = new MyInfrom_Adapter(this);
		
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(this);
		informList = (ListView) findViewById(R.id.informList);
		informList.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

		if(v.getId() == R.id.back){
		
			this.finish();
		}
	}
	
	

}
