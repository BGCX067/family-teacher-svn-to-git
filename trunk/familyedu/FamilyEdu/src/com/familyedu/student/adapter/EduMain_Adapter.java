package com.familyedu.student.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.familyedu.R;
import com.familyedu.model.IssueInfo;
import com.familyedu.widget.ArrayListAdapter;

/**
 * 
 * @author Administrator
 * 首页问题列表Adapter:EduMainActivity
 */
public class EduMain_Adapter extends ArrayListAdapter<IssueInfo>  {
// public class EduMain_Adapter extends BaseAdapter {
	Context context;
	
	public EduMain_Adapter(Context context) {
		
		super(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		HolderView holder;
		if(convertView == null){
			holder = new HolderView();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.student_adapter_mainlist, null);
			holder.issuetitle = (TextView) convertView.findViewById(R.id.issuetitle); // 问题标题
			holder.issuetime = (TextView) convertView.findViewById(R.id.issuetime); //提问时间
			holder.issuestate = (TextView) convertView.findViewById(R.id.issuestate); // 问题状态
			holder.grade_subject = (TextView) convertView.findViewById(R.id.grade_subject); // 年级+学科
			holder.issuecon = (TextView) convertView.findViewById(R.id.issuecon); // 问题内容
			
			convertView.setTag(holder);
		}else{
			
			holder = (HolderView) convertView.getTag();
		}
		
		IssueInfo ii = (IssueInfo) getItem(position);
		
		if(ii!=null){
			
			holder.issuetitle.setText("[" + ii.subjectName + "]" + ii.questionSubject);
			holder.grade_subject.setText(ii.gradeName + "[" + ii.subjectName + "]");
			holder.issuecon.setText(ii.questionContent);
			holder.issuetime.setText(ii.questionTime);
			holder.issuestate.setText("问题状态时" + ii.questionStatus);
		}
		
		return convertView;
	}
   
	class HolderView{
		
		TextView issuetitle, issuetime, issuestate, grade_subject, issuecon;
	}
}