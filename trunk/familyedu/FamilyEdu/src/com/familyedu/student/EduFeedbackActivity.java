package com.familyedu.student;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.tools.Utilities;
/**
 * 
 * @author Administrator
 * 意见反馈
 * 
 */
public class EduFeedbackActivity extends ActivityBase implements OnClickListener{
    
	private Button back, submit;
	private EditText edit;
	private String sCon;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_feedback);
        
        initView();
    }
    
    
	private void initView() {
		
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(this);
		
		submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(this);
		
		edit = (EditText) findViewById(R.id.edit);
	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.back:
			
			this.finish();
			break;
		case R.id.submit:
			
			sCon = edit.getText().toString();
			Utilities.showToast(this, "提交的信息是" + sCon);
			break;

		default:
			break;
		}
	}



}