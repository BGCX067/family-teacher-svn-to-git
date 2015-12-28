package com.familyedu.teacher;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.FlagToString;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.model.HomePageAnswerListInfo;
import com.familyedu.model.HomePageIssueListInfo;
import com.familyedu.model.IssueInfo;
import com.familyedu.model.TeacherAnswerPageBean;
import com.familyedu.model.TeacherHomePageIssue;
import com.familyedu.net.DataService;
import com.familyedu.net.ResultObject;
import com.familyedu.teacher.adapter.t_MainList_Adapter;
import com.familyedu.tools.ApplicationData;
import com.familyedu.tools.LogHandler;
import com.familyedu.tools.Utilities;
/**
 * 
 * @author Administrator
 * 贴身家教首页
 * Adaprer:t_MainList_Adapter
 */
@SuppressLint("ParserError")
public class EduMainTeacherActivity extends ActivityBase implements OnClickListener,OnItemClickListener{
    
	private Button shaixuan, refresh;
	private ListView MainList;
	private t_MainList_Adapter adapter;
	DataService dataService ;  //网络请求数据接口
	
	private int PAGE_INDEX = 0;  //分页索引
	protected static final  int MSGID = 1;    //消息id，请求教师回答问题列表
	
	private ProgressDialog mProgressDialog;
	private boolean flagFinish = false;   //是否加载完成的标识
	Handler handler = new Handler() {

		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case MSGID:
				ResultObject res = (ResultObject) msg.obj;
				if (res.result == true) {
					HomePageAnswerListInfo homePageIssueList = (HomePageAnswerListInfo)res.obj;
					ArrayList<TeacherAnswerPageBean> answerList = homePageIssueList.getAnswers();
					LogHandler.LogPrint("lb", "共有" + answerList.size() + "条数据");
					if (answerList.size() > 0) {
						if(MainList.getAdapter() != null){ // 非初次加载
							
							
							adapter.setLists(answerList);
						
						}else{ // 首次加载
							
							adapter.setList(answerList);
							MainList.setAdapter(adapter);
						}
						++PAGE_INDEX;
					} else {
						Utilities.showToast(EduMainTeacherActivity.this, "加载完成");
						flagFinish = true;
					}
					
				}else {
					Utilities.showToast(EduMainTeacherActivity.this, msg.obj.toString());
				}
				CancelDialog();
				break;

			default:
				break;
			}
			super.handleMessage(msg);
		}
		
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_mainpage);
        
        initView();
        
        dataService = new DataService();
        //请求网络数据
        new QueryTask(this).execute("");
    }
    
    
	private void initView() {
		
		adapter = new t_MainList_Adapter(this);
		
		shaixuan = (Button) findViewById(R.id.shaixuan);
		shaixuan.setOnClickListener(this);
		refresh = (Button) findViewById(R.id.refresh);
		refresh.setOnClickListener(this);
		
		MainList = (ListView) findViewById(R.id.MainList);
		MainList.setOnScrollListener(new MyScrollListener());
		MainList.setOnItemClickListener(this);
	}

	// 启动dialog
	private void StartDialog()
	{
		 					
		if(mProgressDialog ==null)
		{
			 mProgressDialog = new ProgressDialog(this);
			   mProgressDialog.setTitle("请稍等...");
			   mProgressDialog.setMessage("数据加载中");
			
		}
		mProgressDialog.show();
	}
	
	// 取消dialog
	private void CancelDialog()
	{
		if(mProgressDialog!=null)
		{
			mProgressDialog.dismiss();
		}							
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		
		Intent intent = new Intent();
		
		if(position == 0){
			// value 1=有回复问题， 2=没有回复的g问题
			intent.putExtra("value", 1);
			intent.setClass(this, EduAnwerIssueConTeacherActivity.class); // 有回复的问题
			startActivity(intent);
		}else{
			
			intent.setClass(this, EduIssueConTeacherActivity.class); // 未回复的问题
			startActivity(intent);
		}
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.shaixuan:
			
			Utilities.showToast(EduMainTeacherActivity.this, "筛选");
			break;
		case R.id.refresh:
			
			Utilities.showToast(EduMainTeacherActivity.this, "刷新");
			break;

		default:
			break;
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
		
		// 异步请求接口
		class QueryTask extends AsyncTask<String, Integer, String>{

			Context context;
			public QueryTask(Context context) {

				this.context = context;
			}
			
			@Override
			protected void onPreExecute() {
				
				super.onPreExecute();
				StartDialog();  //出现进度条
			}

			@Override
			protected String doInBackground(String... params) {
				LogHandler.LogPrint("lb", "正在加载第" + PAGE_INDEX + "页数据");
				dataService.getMainAnswerList(context, handler, MSGID, ((ApplicationData)EduMainTeacherActivity.this.getApplicationContext()).getUserInfo().username, PAGE_INDEX, ApplicationData.PAGE_NUM);
				                  
				return "";
			}
		}
		
		class MyScrollListener implements OnScrollListener{
			
			private int visibleLastIndex = 0; 
			
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				
				visibleLastIndex = firstVisibleItem + visibleItemCount -1;
			}
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

				/**
				 * 当停止滚动，滚动到最后一条，并且数据没有完全加载完成时，加载数据
				 */
				if (scrollState == OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == view.getAdapter().getCount()-1 && !flagFinish) {
					new QueryTask(EduMainTeacherActivity.this).execute("");
				}
			
		}
		}
}