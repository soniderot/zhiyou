package com.zy.common.model;

import java.util.Date;

import com.zy.common.util.HtmlUtil;

/**
 * ZyMessage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyMessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer parentid;
	private Integer senderid;
	private Integer receiverid;
	private String subject;
	private String body;
	private String isread;
	private String deletedbysender;
	private String deletedbyreceiver;
	private Date createtime;
	
	private String parentids;
	

	// Constructors

	public String getParentids() {
		return parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids;
	}

	/** default constructor */
	public ZyMessage() {
	}

	/** minimal constructor */
	public ZyMessage(Integer parentid, Integer senderid, Integer receiverid,
			String subject) {
		this.parentid = parentid;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.subject = subject;
	}

	/** full constructor */
	public ZyMessage(Integer parentid, Integer senderid, Integer receiverid,
			String subject, String body, String isread, String deletedbysender,
			String deletedbyreceiver, Date createtime) {
		this.parentid = parentid;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.subject = subject;
		this.body = body;
		this.isread = isread;
		this.deletedbysender = deletedbysender;
		this.deletedbyreceiver = deletedbyreceiver;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getSenderid() {
		return this.senderid;
	}

	public void setSenderid(Integer senderid) {
		this.senderid = senderid;
	}

	public Integer getReceiverid() {
		return this.receiverid;
	}

	public void setReceiverid(Integer receiverid) {
		this.receiverid = receiverid;
	}
	
	public String getFormattedSubject() {
		return HtmlUtil.getFormattedContent(subject);
	}
	
	public String getFormattedBody() {
		return HtmlUtil.getFormattedContent(body);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getIsread() {
		return this.isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public String getDeletedbysender() {
		return this.deletedbysender;
	}

	public void setDeletedbysender(String deletedbysender) {
		this.deletedbysender = deletedbysender;
	}

	public String getDeletedbyreceiver() {
		return this.deletedbyreceiver;
	}

	public void setDeletedbyreceiver(String deletedbyreceiver) {
		this.deletedbyreceiver = deletedbyreceiver;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}