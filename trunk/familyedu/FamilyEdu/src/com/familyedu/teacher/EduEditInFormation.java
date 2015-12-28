package com.familyedu.teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.familyedu.R;
import com.familyedu.tools.LinkURL;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author SK
 * 教师端-编辑个人资料
 */
public class EduEditInFormation extends Activity implements OnClickListener{

	private static SharedPreferences share;
	
	// Banner
	private Button back;
	
	// 用户资料
	private EditText nickName; // 用户名
	private EditText grade; // 擅长年级
	private EditText subject; // 学科
	private ImageView uhead; // 头像图片
	private TextView head_portrait; // 设置头像
	private EditText email; // 邮箱
	private EditText password01; // 密码
	private EditText password02; // 重复密码
	private EditText phoneNum; // 手机号
	private EditText gender; // 性别
	private EditText shenfenNum; // 身份证
	private TextView state; // 老师资格审核状态-审核通过则该文字隐藏
	
	// 用户资料-String
	String StrnickName;  // 用户名
	String Strgrade; // 擅长年级
	String Strsubject; // 学科
	String Stremail;  // 邮箱
	String Strpassword01; // 密码
	String Strpassword02;  // 重复密码
	String StrphoneNum; // 手机号
	String Strgender; // 性别
	String StrshenfenNum; // 身份证
	static String StrheadUrl; // 用户头像路径
	
	// 注册按钮
	private Button register;
	
	// 设置头像
	private PopupWindow twitterWindow;
	private Button source_camera, source_sdcard;
	
	// 判断SD卡
	private boolean issdCard;
	private static String SDCardRoot; // 目录的路径
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.teacher_editinformation);
		
		initView();
	}

	private void initView() {

		share = getSharedPreferences(LinkURL.FAMILY, 0);
		
		back = (Button) findViewById(R.id.back); //  返回
		back.setOnClickListener(this);
		register = (Button) findViewById(R.id.register); //  注册
		register.setOnClickListener(this);
		
		// 用户资料
		nickName = (EditText) findViewById(R.id.nickName); // 用户名
		grade = (EditText) findViewById(R.id.grade); // 擅长年级
		subject = (EditText) findViewById(R.id.subject); // 学科
		uhead = (ImageView) findViewById(R.id.uhead); // 头像图片
		head_portrait = (TextView) findViewById(R.id.head_portrait); // 设置头像
		head_portrait.setOnClickListener(this);
		email = (EditText) findViewById(R.id.email); // 邮箱
		password01 = (EditText) findViewById(R.id.password01); // 密码
		password02 = (EditText) findViewById(R.id.password02); // 重复密码
		phoneNum = (EditText) findViewById(R.id.phoneNum); // 手机号
		gender = (EditText) findViewById(R.id.gender); // 性别
		shenfenNum = (EditText) findViewById(R.id.shenfenNum); // 身份证
		state = (TextView) findViewById(R.id.state); // 老师资格审核状态-审核通过则该文字隐藏
	
		
	      //获取外存储设备目录，建立FamilyEdu目录
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){ // 有SD卡
        	
        	issdCard = true;
        	SDCardRoot = Environment.getExternalStorageDirectory() + "/FamilyEdu/";
        
        }else{	// 无SD卡
        	issdCard = false;
        }
	}
	
	
	/**
	 * 设置头像来源的方式相机、SD卡
	 */
	private void TwitterWindow() {
		
		
		if(twitterWindow == null){
			View remindView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.teacher_editinformation_sethead, null);
			
			twitterWindow = new PopupWindow(findViewById(R.id.parent_view), 300, LayoutParams.WRAP_CONTENT);
			twitterWindow.setContentView(remindView);
			
			source_camera = (Button) remindView.findViewById(R.id.source_camera); // 从相机设置照片
			source_camera.setOnClickListener(this);
			source_sdcard = (Button) remindView.findViewById(R.id.source_sdcard); // 从从媒体库设置照片
			source_sdcard.setOnClickListener(this);
			
			twitterWindow.setFocusable(true);
			twitterWindow.setTouchable(true);
			twitterWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		if(twitterWindow.isShowing()){
			twitterWindow.dismiss();
		}
	}	

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.back:
			
			this.finish();
			break;
		case R.id.head_portrait: // 选择设置头像的来源
			
			TwitterWindow();
			twitterWindow.showAtLocation(findViewById(R.id.parent_view), Gravity.CENTER, 0, 0);
			break;
		case R.id.register:
			
			// 用户资料
			StrnickName = nickName.getText().toString();  // 用户名
			Strgrade = grade.getText().toString(); // 擅长年级
			Strsubject = subject.getText().toString(); // 学科
			Stremail = email.getText().toString();  // 邮箱
			Strpassword01 = password01.getText().toString(); // 密码
			Strpassword02 = password02.getText().toString();  // 重复密码
			StrphoneNum = phoneNum.getText().toString(); // 手机号
			Strgender = gender.getText().toString(); // 性别
			StrshenfenNum = shenfenNum.getText().toString(); // 身份证
			
			if(StrheadUrl==null){ // 如果头像路径等于null的话设置为“”
				
				StrheadUrl = "";
			}
			break;
		case R.id.source_camera: // 从相机设置照片
			
			if(twitterWindow.isShowing()){
				twitterWindow.dismiss();
			}
			
			if(issdCard == true){
				
				Intent intentCamera = new Intent("android.media.action.IMAGE_CAPTURE"); // 调用系统默认的相机
				startActivityForResult(intentCamera,1);
			}else{
				
				Utilities.showToast(this, "无SD卡");
			}
			break;
		case R.id.source_sdcard: // 从媒体库设置照片
			
			if(twitterWindow.isShowing()){
				twitterWindow.dismiss();
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

	// 处理设置头像的结果
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1 && resultCode == Activity.RESULT_OK) { // 从相机中返回的照片

			Bitmap bm = (Bitmap) data.getExtras().get("data"); // 返回一个Bitmap图片
			uhead.setImageBitmap(bm);
			picToPicUrl(bm, "从相机"); // 复制图片到项目文件夹下
			
			// 从相机中获取图片地址
			/* SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     String filename = timeStampFormat.format(new Date());
		     ContentValues values = new ContentValues();
		     values.put(Media.TITLE, filename);
		     Uri photoUri = getContentResolver().insert(
                     MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
		     getRealPathFromURI(photoUri, getContentResolver());*/ 
		}

		if (requestCode == 3 && resultCode == Activity.RESULT_OK) { // 从相簿中返回的照片

			try {
				Uri photoUri = data.getData(); // 从媒体库去图取返回的是一个Uri
				ContentResolver resolver = EduEditInFormation.this.getContentResolver();
				Bitmap bm = BitmapFactory.decodeStream(resolver.openInputStream(photoUri));
				uhead.setImageBitmap(bm);
				picToPicUrl(bm, "从媒体库"); // 复制图片到项目文件夹下
				
				// 获取媒体库图片路径
				/*String mediaurl = getRealPathFromURl(this, photoUri);*/
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}	
	
	/**
	 * 从相机中获取图片地址
	 */
	public static void getRealPathFromURI(Uri uri, ContentResolver resolver) {
		
		// 获取相机图片的地址
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = resolver.query(uri, proj, null, null, null);
        int column_index = cursor
                        .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String str = cursor.getString(column_index);
        cursor.close();
        Log.i("sk", "通过相机获得的图片地址是========>" + str);
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
 		share.edit().putString(LinkURL.PICURL, StrheadUrl).commit();
	     Log.i("sk", str + "复制过来的图片地址是========>" + share.getString(LinkURL.PICURL, ""));
	}
	
	
	/**
	 * 将URI转成字符串-图片地址
	 * @param act
	 * @param contentUri
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getRealPathFromURl(Activity act, Uri contentUri){
		
		String[] proj = {MediaStore.Images.Media.DATA};
		Cursor cursor = act.managedQuery(contentUri, proj, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		
		return cursor.getString(column_index);
	}
	
}
