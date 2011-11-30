package com.zy.common.model;

import java.util.Date;

/**
 * ZyMailqueue entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyMailqueue implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sendername;
	private Integer userid;
	private String receivername;
	private String sender;
	private String receiver;
	private String subject;
	private String content;
	private Short status;
	private String template;
	private Date createtime;
	private Date sendtime;
	private String sendby;

	// Constructors

	/** default constructor */
	public ZyMailqueue() {
	}

	/** full constructor */
	public ZyMailqueue(String sendername, Integer userid, String receivername,
			String sender, String receiver, String subject, String content,
			Short status, String template, Date createtime, Date sendtime,
			String sendby) {
		this.sendername = sendername;
		this.userid = userid;
		this.receivername = receivername;
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.content = content;
		this.status = status;
		this.template = template;
		this.createtime = createtime;
		this.sendtime = sendtime;
		this.sendby = sendby;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSendername() {
		return this.sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getReceivername() {
		return this.receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getSendby() {
		return this.sendby;
	}

	public void setSendby(String sendby) {
		this.sendby = sendby;
	}

}