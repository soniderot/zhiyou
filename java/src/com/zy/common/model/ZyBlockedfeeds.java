package com.zy.common.model;

import java.util.Date;

/**
 * ZyOption entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyBlockedfeeds implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userid;
	private Integer feedid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyBlockedfeeds() {
	}

	/** full constructor */
	public ZyBlockedfeeds(Integer userid, Integer feedid) {
		this.userid = userid;
		this.feedid = feedid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public Integer getFeedid() {
		return feedid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setFeedid(Integer feedid) {
		this.feedid = feedid;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


}