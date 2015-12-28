package com.familyedu.teacher.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.familyedu.R;
import com.familyedu.model.IssueInfo;
import com.familyedu.model.QuestionInfo;
import com.familyedu.model.TeacherAnswerPageBean;
import com.familyedu.model.TeacherHomePageIssue;
import com.familyedu.tools.LogHandler;
import com.familyedu.widget.ArrayListAdapter;

/**
 * 
 * @author Administrator
 * 教师端首页:EduMainTeacherActivity
 */
public class t_MainList_Adapter extends ArrayListAdapter<TeacherAnswerPageBean> {

	Context context;
	private ViewHolder holder;
	//public static final String[] issueT = {"issue1", "issue2", "issue3", "issue4", "issue5", 
	//	                                   "issue6", "issue7", "issue8", "issue9", "issue10"};
	
	public t_MainList_Adapter(Context context) {
		super(context);
		this.context = context;
	}
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		QuestionInfo homePageIssue = mList.get(position).mQuestionInfo;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.teacher_adapter_mainlist, null);
			holder.issueTitle = (TextView) convertView.findViewById(R.id.issueTitle); // 问题标题
			holder.issuestate = (TextView) convertView.findViewById(R.id.issuestate); // 问题状态
			holder.issuecon = (TextView) convertView.findViewById(R.id.issuecon); // 问题内容
			
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.issueTitle.setText(homePageIssue.questionSubject);  //问题标题
		holder.issuestate.setText(getQuestionState(homePageIssue.questionStatus));  //问题状态
		holder.issuecon.setText(homePageIssue.questionContent);	//问题内容
		return convertView;
	}
   
	class ViewHolder{
		
		ImageView uhead;
		TextView issueTitle, issuestate, issuecon;
	}
	
	protected String getQuestionState(int i) {
		String strState = "";
		switch (i) {
		case 1:
			strState = "等待解决";
			break;
		case 2:
			strState = "已经解答";
			break;
		case 3:
			strState = "已经评价";
			break;
		case 4:
			strState = "已经分配";
			break;
		case 5:
			strState = "已经接收";
			break;
		case 6:
			strState = "开始解答";
			break;
		case 7:
			strState = "金币不足，请充值";
			break;
		default:
			break;
		}
		return strState;
	}
}