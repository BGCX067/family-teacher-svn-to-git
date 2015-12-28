package com.familyedu.student.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.familyedu.R;

/**
 * 
 * @author Administrator
 * 问题墙Adapter:EduIssueWallActivity
 */
public class IssueWall_Adapter extends BaseAdapter {

	Context context;
	private ViewHolder holder;
	public static final String[] issueT = {"issue1", "issue2", "issue3", "issue4", "issue5", 
		                                   "issue6", "issue7", "issue8", "issue9", "issue10"};
	
	public IssueWall_Adapter(Context context) {
		
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return issueT.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return issueT[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.student_adapter_issuewall, null);
			holder.nickname = (TextView) convertView.findViewById(R.id.nickname); // 用户名
			holder.issueTitle = (TextView) convertView.findViewById(R.id.issueTitle); // 问题标题
			holder.issueCon = (TextView) convertView.findViewById(R.id.issueCon); // 问题内容
			
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.issueTitle.setText(issueT[position]);
		return convertView;
	}
   
	class ViewHolder{
		
		ImageView uhead;
		TextView nickname, issueTitle, issueCon;
	}
}