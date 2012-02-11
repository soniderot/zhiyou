package com.zy.common.model;

import java.util.Date;

/**
 * ZyRequest entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyRequest implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer senderid;
	private Integer receiverid;
	private Integer status;
	private String isdeleted;
	private Short eventkey;
	private String content;
	private Date createtime;
	private Integer referenceid;
	private String parameters;
	private String content2;
	
	private String message;
	
	private String matchflag;
	
	

	// Constructors

	public String getMatchflag() {
		return matchflag;
	}

	public void setMatchflag(String matchflag) {
		this.matchflag = matchflag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/** default constructor */
	public ZyRequest() {
	}

	/** minimal constructor */
	public ZyRequest(Integer senderid, Integer receiverid, Short eventkey,
			String content) {
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.eventkey = eventkey;
		this.content = content;
	}

	/** full constructor */
	public ZyRequest(Integer senderid, Integer receiverid, Integer status,
			String isdeleted, Short eventkey, String content, Date createtime,
			Integer referenceid, String parameters, String content2) {
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.status = status;
		this.isdeleted = isdeleted;
		this.eventkey = eventkey;
		this.content = content;
		this.createtime = createtime;
		this.referenceid = referenceid;
		this.parameters = parameters;
		this.content2 = content2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Short getEventkey() {
		return this.eventkey;
	}

	public void setEventkey(Short eventkey) {
		this.eventkey = eventkey;
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

	public Integer getReferenceid() {
		return this.referenceid;
	}

	public void setReferenceid(Integer referenceid) {
		this.referenceid = referenceid;
	}

	public String getParameters() {
		return this.parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getContent2() {
		return this.content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

}