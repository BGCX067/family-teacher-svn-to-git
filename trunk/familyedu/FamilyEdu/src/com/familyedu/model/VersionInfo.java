package com.familyedu.model;

/**
 * 系统版本信息
 *
 */
public class VersionInfo {
	
	private String number;	//版本号
	private String url;		//下载地址
	private String info;	//版本信息(更新内容)
	private Boolean auto;	//自动更新
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}

	public void setAuto(Boolean auto) {
		this.auto = auto;
	}

	public Boolean getAuto() {
		return auto;
	}
}
