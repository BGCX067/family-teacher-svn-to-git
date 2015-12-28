package com.familyedu.teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.tools.LinkURL;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 教师端-解答问题
 */
public class EduAnswerIssueActivity extends ActivityBase implements OnClickListener{

	private Button refresh;
	private EditText edit;
	private View camera; // 添加照片
	private View voice; // 添加声音
	private Button submit; // 提交
	
	// 添加图片
	private PopupWindow addPicWindow;
	private Button source_camera, source_sdcard;
	
	// 判断SD卡
	private boolean issdCard;
	private static String SDCardRoot; // 目录的路径
	private static String StrheadUrl; // 用户头像路径
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_answer_issue);
        
        initView();
        
    }

	private void initView() {
		
		refresh = (Button) findViewById(R.id.refresh); // 刷新
		refresh.setOnClickListener(this);
		
		edit = (EditText) findViewById(R.id.edit); // 编辑框
		camera = (View)findViewById(R.id.camera); // 添加照片
		camera.setOnClickListener(this);
		voice = (View)findViewById(R.id.voice); // 添加声音
		voice.setOnClickListener(this);
		
		submit = (Button) findViewById(R.id.submit); // 提交
		submit.setOnClickListener(this);
		
	      //获取外存储设备目录，建立FamilyEdu目录
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){ // 有SD卡
        	
        	issdCard = true;
        	SDCardRoot = Environment.getExternalStorageDirectory() + "/FamilyEdu/";
        
        }else{	// 无SD卡
        	issdCard = false;
        }
		
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.refresh: // 刷新
			
			Utilities.showToast(this, "刷新");
			break;
		case R.id.submit:// 提交
			
			// StrheadUrl 图片URL
			if(StrheadUrl == null){
				
				StrheadUrl = "";
			}else{
				
				Log.i("sk", "图片地址是=========>" + StrheadUrl);
			}
			Utilities.showToast(this, "提交");
			break;
		case R.id.camera: // 添加图片
			
			AddPicWindow();
			addPicWindow.showAtLocation(findViewById(R.id.parent_view), Gravity.CENTER, 0, 0);
			break;
		case R.id.voice:// 添加声音
			
			Utilities.showToast(this, "添加声音");
			break;
		case R.id.source_camera: // 从相机设置照片
			
			if(addPicWindow.isShowing()){
				addPicWindow.dismiss();
			}
			
			if(issdCard == true){
				
				Intent intentCamera = new Intent("android.media.action.IMAGE_CAPTURE"); // 调用系统默认的相机
				startActivityForResult(intentCamera,1);
			}else{
				
				Utilities.showToast(this, "无SD卡");
			}
			break;
		case R.id.source_sdcard: // 从媒体库设置照片
			
			if(addPicWindow.isShowing()){
				addPicWindow.dismiss();
			}
			
			if(issdCard == true){
				
			    Intent mIntent= new Intent(Intent.ACTION_GET_CONTENT); // 从媒体库获得图片 android默认的路径
			    mIntent.addCategory(Intent.CATEGORY_OPENABLE);
			    mIntent.setType("image/*");
			    startActivityForResult(mIntent,3);
			}else{
				
				Utilities.showToast(this, "无SD卡");
			}
			break;
		default:
			break;
		}
	}
	
	private void AddPicWindow() {
		
		if(addPicWindow == null){
			View remindView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.teacher_editinformation_sethead, null);
			
			addPicWindow = new PopupWindow(findViewById(R.id.parent_view), 300, LayoutParams.WRAP_CONTENT);
			addPicWindow.setContentView(remindView);
			
			source_camera = (Button) remindView.findViewById(R.id.source_camera); // 从相机设置照片
			source_camera.setOnClickListener(this);
			source_sdcard = (Button) remindView.findViewById(R.id.source_sdcard); // 从从媒体库设置照片
			source_sdcard.setOnClickListener(this);
			
			addPicWindow.setFocusable(true);
			addPicWindow.setTouchable(true);
			addPicWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		if(addPicWindow.isShowing()){
			addPicWindow.dismiss();
		}
	}
	
	// 处理设置头像的结果
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1 && resultCode == Activity.RESULT_OK) { // 从相机中返回的照片

			Bitmap bm = (Bitmap) data.getExtras().get("data"); // 返回一个Bitmap图片
			
			picToPicUrl(bm, "从相机"); // 复制图片到项目文件夹下
			
		}

		if (requestCode == 3 && resultCode == Activity.RESULT_OK) { // 从相簿中返回的照片

			try {
				Uri photoUri = data.getData(); // 从媒体库去图取返回的是一个Uri
				ContentResolver resolver = EduAnswerIssueActivity.this.getContentResolver();
				Bitmap bm = BitmapFactory.decodeStream(resolver.openInputStream(photoUri));
				
				picToPicUrl(bm, "从媒体库"); // 复制图片到项目文件夹下
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 复制图片到项目文件夹下
	 */
	public static void picToPicUrl(Bitmap bm, String str) {
		
	    byte[] b =  Utilities.bitmap2Bytes(bm);
	    
	    File dir = new File(SDCardRoot); 
	    if(!dir.exists()){  
	    	
	    	dir.mkdirs();  
 	   } 
	    String time = Utilities.GetNowDateTime();
	    File bitmapFile = new File(SDCardRoot + time + ".png"); // 根据时间命名复制过来的图片
	    if(!bitmapFile.exists()){
                	  	                    		   
 		   try{  
 			   bitmapFile.createNewFile();  
 		   }  
 		   catch (IOException e){  
 			   e.printStackTrace();  
 		   }  
 	   } 
	    OutputStream output = null;
 		try {
 			output = new FileOutputStream(bitmapFile);
 			output.write(b, 0, b.length);
 			output.flush();
 		}catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} finally {
 			try {
 				output.close();
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 		}
 		StrheadUrl = bitmapFile.getPath();
	     Log.i("sk", str + "复制过来的图片地址是========>" + StrheadUrl);
	}	
	
}