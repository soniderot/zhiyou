package com.zy.common.model;

import java.util.Date;

/**
 * ZyEventinvite entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyEventinvite implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer senderid;
	private Integer receiverid;
	private Integer eventid;
	private Short status;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyEventinvite() {
	}

	/** minimal constructor */
	public ZyEventinvite(Integer senderid, Integer receiverid, Integer eventid) {
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.eventid = eventid;
	}

	/** full constructor */
	public ZyEventinvite(Integer senderid, Integer receiverid, Integer eventid,
			Short status, Date createtime) {
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.eventid = eventid;
		this.status = status;
		this.createtime = createtime;
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

	public Integer getEventid() {
		return this.eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}