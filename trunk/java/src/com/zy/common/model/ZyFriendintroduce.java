package com.zy.common.model;

import java.util.Date;

/**
 * ZyFriendintroduce entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyFriendintroduce implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer introducerid;
	private Integer targetid;
	private String message;
	private Short status;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyFriendintroduce() {
	}

	/** minimal constructor */
	public ZyFriendintroduce(Integer userid, Integer introducerid,
			Integer targetid, Short status) {
		this.userid = userid;
		this.introducerid = introducerid;
		this.targetid = targetid;
		this.status = status;
	}

	/** full constructor */
	public ZyFriendintroduce(Integer userid, Integer introducerid,
			Integer targetid, String message, Short status, Date createtime) {
		this.userid = userid;
		this.introducerid = introducerid;
		this.targetid = targetid;
		this.message = message;
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

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getIntroducerid() {
		return this.introducerid;
	}

	public void setIntroducerid(Integer introducerid) {
		this.introducerid = introducerid;
	}

	public Integer getTargetid() {
		return this.targetid;
	}

	public void setTargetid(Integer targetid) {
		this.targetid = targetid;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
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