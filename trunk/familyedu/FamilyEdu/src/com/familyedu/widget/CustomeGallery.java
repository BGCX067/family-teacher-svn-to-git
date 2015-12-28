package com.familyedu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

public class CustomeGallery extends Gallery {

	public CustomeGallery(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	public CustomeGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public CustomeGallery(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 移动到前一张
	 */
	public void move2Previous(){
		onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, null);
	}
	
	/**
	 * 移动到下一张
	 */
	public void move2Next(){
		onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
	}
	
	
	



}
