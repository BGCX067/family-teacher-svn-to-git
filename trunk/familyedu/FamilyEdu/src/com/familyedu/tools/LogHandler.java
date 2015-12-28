package com.familyedu.tools;

import android.util.Log;

public class LogHandler {
	static boolean flag = true;
	
	
	public static void LogPrint(String tag,String content)
	{
		if(flag == true)
		{
			Log.e(tag, content); 	
		}
	}		
}
