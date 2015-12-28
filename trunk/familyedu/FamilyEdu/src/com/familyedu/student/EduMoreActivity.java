package com.familyedu.student;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.More_Adapter;
import com.familyedu.student.adapter.More_twitter_Adapter;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 更多
 *  Activity-Adapter:More_Adapter
 *  账号绑定Adapter:More_twitter_Adapter
 */
public class EduMoreActivity extends ActivityBase {
    
	private Button back;
	private ListView moreList, twitterList;
	private More_Adapter adapter;
	private More_twitter_Adapter twitter_adapter;
	private PopupWindow twitterWindow;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_more);
        
        initView();
    }
    
    
	private void initView() {
		
		adapter = new More_Adapter(this);
		
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				
				EduMoreActivity.this.finish();
			}
			
		});
		
		moreList = (ListView) findViewById(R.id.moreList);
		moreList.setAdapter(adapter);
		moreList.setOnItemClickListener(new OnItemListener());
	}


	/**
	 * twitter
	 */
	private void TwitterWindow() {
		
		twitter_adapter = new More_twitter_Adapter(this); 
		
		if(twitterWindow == null){
			View remindView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.student_more_twitter, null);
			
			twitterWindow = new PopupWindow(findViewById(R.id.parent_view), 300, LayoutParams.WRAP_CONTENT);
			twitterWindow.setContentView(remindView);
			twitterList = (ListView)remindView. findViewById(R.id.twitterList);
			twitterList.setAdapter(twitter_adapter);
			twitterList.setOnItemClickListener(new OnItemClickListener(){

				@SuppressWarnings("unused")
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
				
					More_twitter_Adapter adapter = (More_twitter_Adapter) parent.getAdapter();
					String scon = (String) adapter.getItem(position);
					Utilities.showToast(EduMoreActivity.this, scon);
					
				}
				
			});
			twitterWindow.setFocusable(true);
			twitterWindow.setTouchable(true);
			twitterWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		if(twitterWindow.isShowing()){
			twitterWindow.dismiss();
		}
	}
	
	
	
	class OnItemListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			
			switch (position) {
			case 0:
				
				TwitterWindow();
				twitterWindow.showAtLocation(findViewById(R.id.parent_view), Gravity.CENTER, 0, 0);
				break;
			case 1:
				
				Utilities.showToast(EduMoreActivity.this, "手机通讯录匹配");
				break;
			case 2:
				
				Utilities.showToast(EduMoreActivity.this, "流量统计");
				break;
			case 3:
				
				Utilities.showToast(EduMoreActivity.this, "系统更新");
				break;
			case 4:
				
				startActivity(new Intent(EduMoreActivity.this, EduFeedbackActivity.class));
				break;

			default:
				break;
			}
			
		}
		
	}
	
	// 捕捉回退键，是否真的退出该程序
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			return false;
		}else{
			return super.onKeyDown(keyCode, event);
		}
	}
}