package com.zy.common.model;

import java.util.Date;

/**
 * ZyFollow entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyFollow implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer followid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyFollow() {
	}

	/** minimal constructor */
	public ZyFollow(Integer userid, Integer followid) {
		this.userid = userid;
		this.followid = followid;
	}

	/** full constructor */
	public ZyFollow(Integer userid, Integer followid, Date createtime) {
		this.userid = userid;
		this.followid = followid;
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

	public Integer getFollowid() {
		return this.followid;
	}

	public void setFollowid(Integer followid) {
		this.followid = followid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}