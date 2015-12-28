package com.familyedu.student;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.model.StudentLookQuestionInfo;
import com.familyedu.model.StudentLookQuestionInfo.AnswerInfoListItem;
import com.familyedu.net.DataService;
import com.familyedu.net.ResultObject;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 问题内容页-已回复
 */
public class EduIssueConYActvity extends ActivityBase implements OnClickListener{

	private Button back, refresh;// 回退，刷新
	private Button top, trample, click; // 顶， 踩， 收藏
	private int iscollect = 0; // 0 未收藏  1已收藏
	private View replyview; // 问题回复view
	/*** 问题部分 ***/
	private ImageView uhead;// 头像
	private TextView issuetitle, itime, istate, icon; // 问题标题,回复时间,问题状态,文字描述
	private ImageView ipic; // 问题图片
	private Button iplay; // 播放录音按钮
	private int iplayFlag = 1; // 问题播放录音按钮标识
	
	/*** 回复部分 ***/
	private ImageView rhead; // 老师头像
	private TextView rtitle, rtime, rcon; // 回复标题,回复时间，回复文字描述
	private ImageView rpic; // 回复图片
	private Button rplay; // 播放回复录音
	private int rplayFlag = 1; // 回复播放录音按钮标识
	
	private int issueState; // 1=有回复， 2=无回复
	private int aid; // 问题ID
	private String strSubject; // 学科
	private String st; // 标题
	private String gs; // 年级
	private String acon; // 问题内容
	private String atime; // 提问时间
	
	private static final int ISSUECON = 1;
	private ProgressDialog mProgressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.student_issuecony);
		
		initView();
	}

	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {

			
			switch (msg.what) {
			case ISSUECON: // 学生问题内容 
				
				ResultObject res = (ResultObject) msg.obj;
				if(res.result == true){
					
					ArrayList<AnswerInfoListItem> array = (ArrayList<AnswerInfoListItem>) res.obj;
					AnswerInfoListItem ail = array.get(0);
					if(ail!=null){
						
						rtime.setText(ail.answerTime); // 回复时间
						rcon.setText(ail.answerContent);; // 回复文字描述
					}
					
				}else{
					Utilities.showToast(EduIssueConYActvity.this, "网络错误");
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

		
		Intent intent = getIntent();
		issueState = intent.getIntExtra("IssueState", -1); // 3或者4的时候显示回答view，其他不显示
		aid = intent.getIntExtra("aid", -1); // 问题ID
		strSubject = intent.getStringExtra("strSubject"); // 学科
		st = intent.getStringExtra("st"); // 标题
		gs = intent.getStringExtra("gs"); // 年级
		acon = intent.getStringExtra("acon"); // 问题内容
		atime = intent.getStringExtra("atime"); // 提问时间
		
		replyview = (View) findViewById(R.id.replyview); // 回复View
		back = (Button) findViewById(R.id.back); // 回退
		back.setOnClickListener(this);
		refresh = (Button) findViewById(R.id.refresh); // 刷新
		refresh.setOnClickListener(this);
		top = (Button) findViewById(R.id.top); // 顶
		top.setOnClickListener(this);
		trample = (Button) findViewById(R.id.trample); // 踩
		trample.setOnClickListener(this);
		click = (Button) findViewById(R.id.click); // 收藏
		click.setOnClickListener(this);
		
		/****** 问题部分 ******/
		uhead = (ImageView) findViewById(R.id.uhead); // 头像
		issuetitle = (TextView) findViewById(R.id.issuetitle); // 问题标题
		issuetitle.setText(strSubject + st);
		itime = (TextView) findViewById(R.id.itime); // 提问时间
		itime.setText(atime);
		istate = (TextView) findViewById(R.id.istate); // 问题状态
		istate.setText(issueState + "");
		icon = (TextView) findViewById(R.id.icon); // 文字描述
		icon.setText(acon);
		ipic = (ImageView) findViewById(R.id.ipic); // 问题图片
		iplay = (Button) findViewById(R.id.iplay); // 播放问题录音
		iplay.setText("播放");
		iplay.setOnClickListener(this);
		
		/****** 回复部分 ******/
		rhead = (ImageView) findViewById(R.id.rhead); // 老师头像
		rtitle = (TextView) findViewById(R.id.rtitle); // 回复标题
		rtime = (TextView) findViewById(R.id.rtime); // 回复时间
		rcon = (TextView) findViewById(R.id.rcon); // 回复文字描述
		rpic = (ImageView) findViewById(R.id.rpic); // 回复图片
		rplay = (Button) findViewById(R.id.rplay); // 播放回复录音 
		rplay.setText("播放");
		rplay.setOnClickListener(this);
		
		// 1=有回复， 2=无回复
		if(issueState == 3 || issueState == 4){
			
			replyview.setVisibility(View.VISIBLE);
			top.setVisibility(View.VISIBLE);
			trample.setVisibility(View.VISIBLE);
		}else{
			
			replyview.setVisibility(View.GONE);
			top.setVisibility(View.GONE);
			trample.setVisibility(View.GONE);
		}
		
		// 接口	
		studentLookQuestion(aid) ;
	}

	/**
	 * 获取问题回复信息
	 * @param aid
	 */
	private void studentLookQuestion(int aid) {
		
		StartDialog();
		
		new DataService().studentLookQuestion(this, handler, ISSUECON, aid);
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
	
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.back: // 回退
			
			this.finish();
			break;
		case R.id.refresh:// 刷新
			
			Utilities.showToast(this, "刷新");
			break;
		case R.id.top: // 顶
			
			Utilities.showToast(this, "顶");
			break;
		case R.id.trample: // 踩
			
			Utilities.showToast(this, "踩");
			break;
		case R.id.click: // 收藏
			
			if(iscollect!=1){
				iscollect = 1;
				click.setText("已收藏");
			}else{
				iscollect = 0;
				click.setText("未收藏");
				
			}
			break;
		case R.id.iplay:
			
			if(iplayFlag == 1){
				
				iplayFlag = 2;
				iplay.setText("播放中");
			}else{
				
				iplayFlag = 1;
				iplay.setText("播放");
			}
			break;
		case R.id.rplay:
			
			if(rplayFlag == 1){
				
				rplayFlag = 2;
				rplay.setText("播放中");
			}else{
				
				rplayFlag = 1;
				rplay.setText("播放");
			}
			break;
		default:
			break;
		}
		
	}
}
