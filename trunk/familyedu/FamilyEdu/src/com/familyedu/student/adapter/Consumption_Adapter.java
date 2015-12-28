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
 * 消费记录Adapter:EduConsumptionActivity-学生端
 *               EduQuizTeacherActivity-教师端 
 */
public class Consumption_Adapter extends BaseAdapter {

	Context context;
	private ViewHolder holder;
	public static final String[] issueT = {"21", "32", "32", "45", "46", 
		                                   "47", "48", "49", "51", "63"};
	
	public Consumption_Adapter(Context context) {
		
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
			convertView = LayoutInflater.from(context).inflate(R.layout.student_adapter_consumption, null);
			holder.time = (TextView) convertView.findViewById(R.id.time); // 时间
			holder.action = (TextView) convertView.findViewById(R.id.action); // 行为
			holder.goldchange = (TextView) convertView.findViewById(R.id.goldchange); // 金币变化
			holder.balance = (TextView) convertView.findViewById(R.id.balance); // 余额
			
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.balance.setText(issueT[position]);
		return convertView;
	}
   
	class ViewHolder{
		
		TextView time, action, goldchange, balance; // 时间， 行为， 金币变化， 金币总数
	}
}