package com.zy.common.model;

import java.util.Date;

/**
 * ZyNotificationtype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyNotificationtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short eventkey;
	private String subject;
	private String content;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyNotificationtype() {
	}

	/** full constructor */
	public ZyNotificationtype(Short eventkey, String subject, String content,
			Date createtime) {
		this.eventkey = eventkey;
		this.subject = subject;
		this.content = content;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getEventkey() {
		return this.eventkey;
	}

	public void setEventkey(Short eventkey) {
		this.eventkey = eventkey;
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

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}