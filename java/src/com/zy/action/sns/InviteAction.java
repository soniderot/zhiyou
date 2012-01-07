package com.zy.action.sns;

import com.opensymphony.xwork2.ActionSupport;

public class InviteAction extends ActionSupport{
	private String[] emails;
	private String[] names;
	
 	public String[] getEmails() {
		return emails;
	}

	public String[] getNames() {
		return names;
	}

	public void setEmails(String[] emails) {
		this.emails = emails;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String execute() {
		if (emails != null) {
			for (int i = 0; i < emails.length; i ++)
				if (!"".equals(emails[i])) {
					System.out.println("name:" + names[i] + " emails:" + emails[i]);
				}
		}
		return "invite.success";
	}
}
