/**
 * 
 */
package com.zy.common.util;

import java.util.Map;

/**
 * @author Steele
 * @version V 1.0, Dec 3, 2009
 */
public class MailThread extends Thread {
	private String from;
	private String senderName;
	private String to;
	private String subject;
	private String templateName;
	private Map root;
	private String message;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Map getRoot() {
		return root;
	}

	public void setRoot(Map root) {
		this.root = root;
	}

	public void run() {
		if(message == null || "".equals(message)){
			MailUtil.sendFormatEmail(from, senderName, to, subject, templateName, root);
		} else {
			MailUtil.sendNoTemplateEmail(from, senderName, to, subject, message);
		}
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
