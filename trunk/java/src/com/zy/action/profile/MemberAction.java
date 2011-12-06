package com.zy.action.profile;

import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport{
	private int newrequestcnt = 1;
	private int newnotificationcnt =1;
	private int newmessagecnt = 1;
	public int getNewrequestcnt() {
		return newrequestcnt;
	}
	public void setNewrequestcnt(int newrequestcnt) {
		this.newrequestcnt = newrequestcnt;
	}
	public int getNewnotificationcnt() {
		return newnotificationcnt;
	}
	public void setNewnotificationcnt(int newnotificationcnt) {
		this.newnotificationcnt = newnotificationcnt;
	}
	public int getNewmessagecnt() {
		return newmessagecnt;
	}
	public void setNewmessagecnt(int newmessagecnt) {
		this.newmessagecnt = newmessagecnt;
	}
	public String execute(){
		return "member.header";
	}
}
