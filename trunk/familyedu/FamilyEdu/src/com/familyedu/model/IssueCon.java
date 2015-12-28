package com.familyedu.model;

public class IssueCon {
	
	// 该问题是否提交过的判断
	private boolean issueyon; // true表示提交过满意或者不满意，false表示从未提交过满意或不满意
	
	// 学生
	private int aid; // 问题ID
	private int issuestate; // 问题状态 1已解决, 2待解决, 3已退回, 4未发布
	private String userhead; // 用户头像url
	private String issuetitle; // 问题标题
	private String textdescription; // 问题的文字描述
	private String issuepic; // 问题图片
	private String issuerecord; // mp3地址
	private String releasetime; // 提问时间
	
	// 老师
	private String tpic; // 老师头像url
	private String answertext; // 文字描述
	private String answerpic; // 回答图片url
	private String answerrecord; // 问题mp3
	private String answertime; // 回复时间
	
	
	
	
	public boolean isIssueyon() {
		return issueyon;
	}
	public void setIssueyon(boolean issueyon) {
		this.issueyon = issueyon;
	}
	public String getAnswertime() {
		return answertime;
	}
	public void setAnswertime(String answertime) {
		this.answertime = answertime;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getIssuestate() {
		return issuestate;
	}
	public void setIssuestate(int issuestate) {
		this.issuestate = issuestate;
	}
	public String getUserhead() {
		return userhead;
	}
	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}
	public String getIssuetitle() {
		return issuetitle;
	}
	public void setIssuetitle(String issuetitle) {
		this.issuetitle = issuetitle;
	}
	public String getTextdescription() {
		return textdescription;
	}
	public void setTextdescription(String textdescription) {
		this.textdescription = textdescription;
	}
	public String getIssuepic() {
		return issuepic;
	}
	public void setIssuepic(String issuepic) {
		this.issuepic = issuepic;
	}
	public String getIssuerecord() {
		return issuerecord;
	}
	public void setIssuerecord(String issuerecord) {
		this.issuerecord = issuerecord;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public String getTpic() {
		return tpic;
	}
	public void setTpic(String tpic) {
		this.tpic = tpic;
	}
	public String getAnswertext() {
		return answertext;
	}
	public void setAnswertext(String answertext) {
		this.answertext = answertext;
	}
	public String getAnswerpic() {
		return answerpic;
	}
	public void setAnswerpic(String answerpic) {
		this.answerpic = answerpic;
	}
	public String getAnswerrecord() {
		return answerrecord;
	}
	public void setAnswerrecord(String answerrecord) {
		this.answerrecord = answerrecord;
	}
	
	
}
