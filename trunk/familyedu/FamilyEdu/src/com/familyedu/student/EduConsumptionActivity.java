package com.familyedu.student;

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
 * 我的消费记录
 * Adapter:Consumption_Adapter
 */
public class EduConsumptionActivity extends ActivityBase implements OnClickListener{

	private ListView consumptionList;
	private Button back;
	private TextView goldNum, issueNum;// 金币数， 问题数
	private Consumption_Adapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_myconsumption);
		
		initView();
	}
	
	private void initView() {

		adapter = new Consumption_Adapter(this);
		
		back = (Button) findViewById(R.id.back); 
		back.setOnClickListener(this);
		
		goldNum = (TextView) findViewById(R.id.goldNum); // 金币数
		issueNum = (TextView) findViewById(R.id.issueNum); // 本月问题数
		
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
