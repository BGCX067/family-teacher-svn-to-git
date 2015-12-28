package com.familyedu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

public class ActivityBase extends Activity implements Handler.Callback {

	protected Handler mHandler = new Handler(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	@Override
	public boolean handleMessage(Message msg) {
		return false;
	}
	
	

}
