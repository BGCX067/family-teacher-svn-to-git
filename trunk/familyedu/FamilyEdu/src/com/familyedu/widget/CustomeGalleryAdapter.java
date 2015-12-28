package com.familyedu.widget;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.familyedu.GuideActivity;
import com.familyedu.LoginActivity;
import com.familyedu.R;

/**
 * 
 * @author Administrator
 * 引导页 GuideActivity
 */
public class CustomeGalleryAdapter extends BaseAdapter{

	Context context;
	
	public CustomeGalleryAdapter(Context context) {

		this.context = context;
	}
	
	public static final int[] picPos = {R.drawable.guide_a, R.drawable.guide_b, R.drawable.guide_c,
										R.drawable.guide_d};
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return picPos.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return picPos[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		if(convertView == null){
			holder = new ViewHolder();
			
			convertView = LayoutInflater.from(context).inflate(R.layout.guidepage_adapter, null);
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			holder.btn = (Button) convertView.findViewById(R.id.btn);
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(position == 3){
			
			holder.btn.setVisibility(View.VISIBLE);
		}else{
			
			holder.btn.setVisibility(View.GONE);
		}
		
		holder.image.setImageResource(picPos[position]);
		holder.btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent();
				intent.setClass(context, LoginActivity.class);
				context.startActivity(intent);
				GuideActivity.actiivty.finish();
			}
			
		});
		
		return convertView;
	}

	class ViewHolder{
		
		ImageView image;
		Button btn;
	}
	
}
