package com.familyedu.student;

import java.util.ArrayList;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.model.HomePageIssueListInfo;
import com.familyedu.model.IssueInfo;
import com.familyedu.net.DataService;
import com.familyedu.net.ResultObject;
import com.familyedu.student.adapter.EduMain_Adapter;
import com.familyedu.tools.LinkURL;
import com.familyedu.tools.LogHandler;
import com.familyedu.tools.Utilities;
/**
 * 
 * @author Administrator
 * 学生端-贴身家教首页
 * Adaprer:EduMain_Adapter
 */
public class EduMainActivity extends ActivityBase implements OnItemClickListener{
    
	private Button refresh;
	private ListView issueList;
	private EduMain_Adapter adapter;
	private int startposition = 0; // 数据加载的起始位置
	private int uploadNum = 10; // 加载个数
	private static final int STUDENTISSUELIST = 1;  // 学生问题列表
	private ProgressDialog mProgressDialog;
	private String UserName ; // 用户名
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_mainpage);
        
        initView();
    }
    
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {

			
			switch (msg.what) {
			case STUDENTISSUELIST: // 学生问题列表 
				
				ResultObject res = (ResultObject) msg.obj;
				if(res.result == true){
					HomePageIssueListInfo hli = (HomePageIssueListInfo) res.obj;
					ArrayList<IssueInfo> issuelist = hli.getIssues();
					
					if(issueList.getAdapter() != null){ // 滑动加载-目前没用
						
						
						adapter.setLists(issuelist);
					
					}else{ // 正常加载
						
						adapter.setList(issuelist);
						issueList.setAdapter(adapter);
					}
					startposition = adapter.getCount();
				}else{
					Utilities.showToast(EduMainActivity.this, "网络错误");
				}
				CancelDialog();
					break;
			default:
				break;
			}
			
			super.handleMessage(msg);
		}
	};
    
	private void initView() {
		
		SharedPreferences share = getSharedPreferences(LinkURL.USERINFO, 0);
		UserName = share.getString("username", "");
		LogHandler.LogPrint("sk", "用户名是====>" + UserName);
		adapter = new EduMain_Adapter(this);
		
		refresh = (Button) findViewById(R.id.refresh); // 刷新
		refresh.setOnClickListener(new BtnOnClick());
		issueList = (ListView) findViewById(R.id.issueList); // 问题列表
		issueList.setOnItemClickListener(this);
		issueList.setOnScrollListener(new ScrollListener());
		
		// 接口调用
		getMainIssueList(startposition, uploadNum) ;
	}

	/**
	 * 学生首页列表接口
	 * @param startposition
	 * @param uploadNum
	 */
	private void getMainIssueList(int startposition, int uploadNum) {

		   StartDialog();
		   // 接口
		   new DataService().getMainIssueList(this, handler, STUDENTISSUELIST, UserName,startposition, uploadNum);
	}
	
	// 启动dialog
	private void StartDialog()
	{
		  mProgressDialog = new ProgressDialog(this);
		   mProgressDialog.setTitle("请稍等...");
		   mProgressDialog.setMessage("数据加载中");					
		if(mProgressDialog!=null)
		{
			mProgressDialog.show();
		}
	}
	
	// 取消dialog
	private void CancelDialog()
	{
		if(mProgressDialog!=null)
		{
			mProgressDialog.dismiss();
		}							
	}
	
	class BtnOnClick implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			
			Utilities.showToast(EduMainActivity.this, "刷新");
		}
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		
		EduMain_Adapter eAdapter = (EduMain_Adapter) arg0.getAdapter();
		ArrayList<IssueInfo> al = eAdapter.getList();
		IssueInfo iss = al.get(position);
		
		String strSubject = "[" + iss.subjectName + "]"; // 学科
		String st = iss.questionSubject; // 标题
		String gs = iss.gradeName; // 年级
		String acon = iss.questionContent; // 问题内容
		String atime = iss.questionTime; // 提问时间
		int aid = iss.id; // 问题ID
		int sstate = iss.questionStatus; // 问题状态
		
		Intent intent = new Intent();
		intent.putExtra("strSubject", strSubject); // 学科
		intent.putExtra("st", st); // 问题标题
		intent.putExtra("gs", gs); // 年级
		intent.putExtra("acon", acon); // 问题内容
		intent.putExtra("atime", atime); // 提问时间
		intent.putExtra("aid", aid); // 问题id
		intent.putExtra("IssueState", sstate); // 问题状态
		intent.setClass(this, EduIssueConYActvity.class);
		startActivity(intent);
	}
	
	class ScrollListener implements OnScrollListener{

		boolean isIDLE = false;
		
		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			
			isIDLE = firstVisibleItem + visibleItemCount>=totalItemCount;
		}
		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {

			if(scrollState == OnScrollListener.SCROLL_STATE_IDLE){
				
				if(isIDLE){
					
					getMainIssueList(startposition, uploadNum);
				}
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