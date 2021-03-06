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
 * 收藏Adapter:EduMyCollectActivity
 */
public class MyCollect_Adapter extends BaseAdapter {

	Context context;
	private ViewHolder holder;
	public static final String[] issueT = {"issue1", "issue2", "issue3", "issue4", "issue5", 
		                                   "issue6", "issue7", "issue8", "issue9", "issue10"};
	
	public MyCollect_Adapter(Context context) {
		
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
			convertView = LayoutInflater.from(context).inflate(R.layout.student_adapter_mycollect, null);
			holder.uhead = (ImageView) convertView.findViewById(R.id.uhead);// 头像
			holder.issueTitle = (TextView) convertView.findViewById(R.id.issueTitle); // 问题标题
			holder.issuestate = (TextView) convertView.findViewById(R.id.issuestate); // 问题状态
			holder.ctime = (TextView) convertView.findViewById(R.id.ctime); // 提问时间
			holder.icon = (TextView) convertView.findViewById(R.id.icon); // 问题内容
			holder.checkBtn = (Button) convertView.findViewById(R.id.checkBtn); // 选中按钮
			
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.issueTitle.setText(issueT[position]);
		// 按钮监听事件没写完，可以参考电视报1期的代码
		return convertView;
	}
   
	class ViewHolder{
		
		ImageView uhead;
		TextView issueTitle, ctime, issuestate, icon;
		Button checkBtn;
	}
	
	class BtnOnClick implements OnClickListener{

		private int position;
		private Button btn;
		
		public BtnOnClick(int position) {
			
			this.position = position;
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	}
}