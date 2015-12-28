package com.familyedu.tools;

import com.familyedu.model.UserInfo;

import android.app.Application;

public class ApplicationData extends Application{

	private UserInfo userInfo;  //保存登录用户的个人信息
	//分页查询条目
	public static int PAGE_NUM = 10;
	/**
	 * 返回用户名
	 * @return the userName
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}
	/**
	 * 设置用户名
	 * @param userName the userName to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
