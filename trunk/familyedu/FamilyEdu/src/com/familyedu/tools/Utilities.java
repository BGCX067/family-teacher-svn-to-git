package com.familyedu.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class Utilities {

	public static void showToast(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}

	public static Dialog exitDialog(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("退出程序");
		builder.setMessage("确定要退出程序吗");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				exitApp();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				dialog.cancel();
			}
		});
		return builder.show();
	}

	public static void exitApp(Context ctx) {
		ActivityManager mActivityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
		mActivityManager.restartPackage(ctx.getPackageName());
	}

	public static void exitApp() {
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	public static Bitmap getCircleBitmap(Bitmap sourceBitmap) {
		int targetWidth = sourceBitmap.getWidth() > sourceBitmap.getHeight() ? sourceBitmap.getWidth() : sourceBitmap.getHeight();
		Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetWidth, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(targetBitmap);
		Path path = new Path();
		path.addCircle(((float) targetWidth - 1) / 2, ((float) targetWidth - 1) / 2, (Math.min(((float) targetWidth), ((float) targetWidth)) / 2), Path.Direction.CCW);
		canvas.clipPath(path);
		canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(), sourceBitmap.getHeight()), new Rect(0, 0, targetWidth, targetWidth), null);
		return targetBitmap;
	}

	public static String toMd5(byte[] bytes) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(bytes);
			return toHexString(algorithm.digest(), "");
		} catch (NoSuchAlgorithmException e) {
			Log.v("util", "toMd5():" + e);
			throw new RuntimeException(e);
		}
	}

	private static String toHexString(byte[] bytes, String separator) {
		StringBuilder hexString = new StringBuilder();
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xFF & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex).append(separator);
		}
		return hexString.toString();
	}
	
	
	/**
	 * Bitmap转换为byte[]
	 * @param bm
	 * @return
	 */
	public static  byte[] bitmap2Bytes(Bitmap bm){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
		return baos.toByteArray();  
	}
	
	/**
	 * 获取时间
	 * @return
	 */
	public static String GetNowDateTime()
	{
		Calendar c = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy_MM_dd_HH_mm_ss"); 
		return sdf.format(c.getTime());
	}    
    
}
