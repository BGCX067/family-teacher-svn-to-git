package com.familyedu;

import android.app.Application;


public class EduApplication extends Application{

	private String HeadURL;

	public String getHeadURL() {
		return HeadURL;
	}

	public void setHeadURL(String headURL) {
		HeadURL = headURL;
	}
	
	
}
