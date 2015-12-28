package com.familyedu.model;

public class UserInfo {
	
	public String birthday;//出生年月
	public String createTime;//注册时间
	public String emailAddress;		//邮箱地址
	public int emailAddressStatus;//邮箱是否认证0为未认证、1为已认证
	public String headImg;//头像地址
	public String nickname;	//昵称
	public String password;	//密码
	public int usertype;	// 用户类型ST为学生用户、TC为教师用户
	public int status ;//0,为已删除 1,为已激活，并且可以正常登陆网站，使用网站提供的服务2,,为账户已冻结
	public String username;//用户名
	public String roleType; // 用户类型ST为学生用户、TC为教师用户
	
	
}
