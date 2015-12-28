package com.familyedu.teacher;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.familyedu.ActivityBase;
import com.familyedu.R;

/**
 * 
 * @author Administrator
 * 充值
 */
public class EduTiXianActivity extends ActivityBase{

	private Button back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_tixian);
		
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				
				EduTiXianActivity.this.finish();
			}
		});
	}

}
