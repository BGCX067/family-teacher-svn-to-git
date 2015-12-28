package com.familyedu.student;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.familyedu.ActivityBase;
import com.familyedu.R;
import com.familyedu.student.adapter.IssueWall_QueryCon_Adapter;
import com.familyedu.tools.Utilities;

/**
 * 
 * @author Administrator
 * 学生端、教师端-问题墙-检索内容页
 * 
 * Adapter:IssueWall_QueryCon_Adapter
 */
public class EduIssueWall_queryConActivity extends ActivityBase implements OnClickListener, OnItemClickListener{
    
	private EditText edit;
	private Button query;
	private ListView issueList;
	private IssueWall_QueryCon_Adapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_issuewall_querycon);
        
        initView();
    }

	private void initView() {
		
		adapter = new IssueWall_QueryCon_Adapter(this);

		edit = (EditText) findViewById(R.id.edit);
		query = (Button) findViewById(R.id.query);
		query.setOnClickListener(this);
		issueList = (ListView) findViewById(R.id.issueList);
		issueList.setAdapter(adapter);
		/*确定有内容页后，再把下面的代码打开
		issueList.setOnItemClickListener(this);*/
	}

	
	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.query){
			
			Utilities.showToast(this, "检索");
		}
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		
		// issueState 1=有回复， 2=无回复 
		// 确定是否有内容页后在打开下面的代码
		/*Log.i("sk", "当前点击的位置是：" + position);
		Intent intent = new Intent();
		intent.putExtra("IssueState", 2);
		intent.setClass(this, EduIssueConYActvity.class);
		startActivity(intent);*/
	}
    
}