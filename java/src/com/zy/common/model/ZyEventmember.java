package com.zy.common.model;

import java.util.Date;

/**
 * ZyEventmember entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyEventmember implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer eventid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyEventmember() {
	}

	/** minimal constructor */
	public ZyEventmember(Integer userid, Integer eventid) {
		this.userid = userid;
		this.eventid = eventid;
	}

	/** full constructor */
	public ZyEventmember(Integer userid, Integer eventid, Date createtime) {
		this.userid = userid;
		this.eventid = eventid;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getEventid() {
		return this.eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}