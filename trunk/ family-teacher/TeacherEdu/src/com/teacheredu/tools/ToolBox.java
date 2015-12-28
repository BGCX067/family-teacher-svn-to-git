package com.teacheredu.tools;
import android.content.Context;
import android.widget.Toast;

public class ToolBox {

	
	public static void showToast(Context context,String str) {
			Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}
	
		
}
