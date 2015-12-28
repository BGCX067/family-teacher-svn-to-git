package com.familyedu.teacher;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.Consumption_Adapter;

/**
 * 
 * @author Administrator
 * 老师消费记录
 * Adapter:Consumption_Adapter
 */
public class EduConsumptionTeacherActivity extends ActivityBase implements OnClickListener{

	private ListView consumptionList;
	private Button back;
	private Consumption_Adapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_myconsumption);
		
		initView();
	}
	
	private void initView() {

		adapter = new Consumption_Adapter(this);
		
		back = (Button) findViewById(R.id.back); 
		back.setOnClickListener(this);
		
		consumptionList = (ListView) findViewById(R.id.consumptionList); // 消费记录
		consumptionList.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

		if(v.getId() == R.id.back){
			
			this.finish();
		}
		
	}

}
