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
 * 我的家教-我的老师Adapter:EduMyTeachersActivity
 * 教师端-EduMyStudentActivity      
 */
public class MyTeachers_Adapter extends BaseAdapter {

	Context context;
	private ViewHolder holder;
	public static final String[] issueT = {"issue1", "issue2", "issue3", "issue4", "issue5", 
		                                   "issue6", "issue7", "issue8", "issue9", "issue10"};
	
	public MyTeachers_Adapter(Context context) {
		
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
			convertView = LayoutInflater.from(context).inflate(R.layout.student_adapter_myteachers, null);
			holder.image = (ImageView) convertView.findViewById(R.id.image); // 头像
			holder.tname = (TextView) convertView.findViewById(R.id.tname); // 名字
			
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.tname.setText(issueT[position]);
		return convertView;
	}
   
	class ViewHolder{
		
		ImageView image;
		TextView tname;
	}
}