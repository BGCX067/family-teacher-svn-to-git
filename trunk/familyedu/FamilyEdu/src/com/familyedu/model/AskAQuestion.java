package com.familyedu.model;
/*
 * 提问
 * 
 */
public class AskAQuestion {
	
	private int uid;		       //用户ID
	private String issuetitle;     // 问题标题
	private String issuedetail;    // 问题内容
	private String grade;          // 年级
	private String subject;        // 学科
	private String issuepica;      // 第1张图片
	private String issuepicb;      // 第2张图片
	private String issuepicc;      // 第3张图片
	private String issuerecord;    // MP3路径
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getIssuetitle() {
		return issuetitle;
	}
	public void setIssuetitle(String issuetitle) {
		this.issuetitle = issuetitle;
	}
	public String getIssuedetail() {
		return issuedetail;
	}
	public void setIssuedetail(String issuedetail) {
		this.issuedetail = issuedetail;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIssuepica() {
		return issuepica;
	}
	public void setIssuepica(String issuepica) {
		this.issuepica = issuepica;
	}
	public String getIssuepicb() {
		return issuepicb;
	}
	public void setIssuepicb(String issuepicb) {
		this.issuepicb = issuepicb;
	}
	public String getIssuepicc() {
		return issuepicc;
	}
	public void setIssuepicc(String issuepicc) {
		this.issuepicc = issuepicc;
	}
	public String getIssuerecord() {
		return issuerecord;
	}
	public void setIssuerecord(String issuerecord) {
		this.issuerecord = issuerecord;
	}


	
	
}
