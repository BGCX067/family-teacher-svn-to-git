package com.familyedu.student.adapter;

import com.familyedu.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 
 * @author Administrator
 * 首页问题列表Adapter:EduMyInformActivity
 */
public class MyInfrom_Adapter extends BaseAdapter {

	Context context;
	private ViewHolder holder;
	public static final String[] issueT = {"issue1", "issue2", "issue3", "issue4", "issue5", 
		                                   "issue6", "issue7", "issue8", "issue9", "issue10"};
	
	public MyInfrom_Adapter(Context context) {
		
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
			convertView = LayoutInflater.from(context).inflate(R.layout.student_adapter_myinform, null);
			holder.ititle = (TextView) convertView.findViewById(R.id.ititle); // 通知标题
			holder.time = (TextView) convertView.findViewById(R.id.time); // 时间
			holder.issuestate = (TextView) convertView.findViewById(R.id.issuestate); // 状态
			holder.iCon = (TextView) convertView.findViewById(R.id.iCon); // 内容
			
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.ititle.setText(issueT[position]);
		return convertView;
	}
   
	class ViewHolder{
		
		TextView ititle, time, issuestate, iCon;
	}
}