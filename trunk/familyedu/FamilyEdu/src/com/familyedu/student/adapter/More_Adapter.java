package com.familyedu.student.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.familyedu.R;

/**
 * 
 * @author Administrator
 * 更多Adapter:EduMoreActivity
 */
public class More_Adapter extends BaseAdapter {

	Context context;
	private ViewHolder holder;
	public static final String[] issueT = {"账号绑定", "手机通讯录匹配", "流量统计", "系统更新", "意见反馈"};
	
	public More_Adapter(Context context) {
		
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
			convertView = LayoutInflater.from(context).inflate(R.layout.student_adapter_more, null);
			holder.cItem = (TextView) convertView.findViewById(R.id.cItem); 
			
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.cItem.setText(issueT[position]);
		// 按钮监听事件没写完，可以参考电视报1期的代码
		return convertView;
	}
   
	class ViewHolder{
		
		TextView cItem;
	}
}