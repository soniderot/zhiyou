package com.zy.common.model;

import java.util.Date;

/**
 * ZyNewsfeedcomment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyNewsfeedcomment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer newsfeedid;
	private Integer userid;
	private String content;
	private Date created;

	// Constructors

	/** default constructor */
	public ZyNewsfeedcomment() {
	}

	/** minimal constructor */
	public ZyNewsfeedcomment(Integer newsfeedid, Integer userid, String content) {
		this.newsfeedid = newsfeedid;
		this.userid = userid;
		this.content = content;
	}

	/** full constructor */
	public ZyNewsfeedcomment(Integer newsfeedid, Integer userid,
			String content, Date created) {
		this.newsfeedid = newsfeedid;
		this.userid = userid;
		this.content = content;
		this.created = created;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNewsfeedid() {
		return this.newsfeedid;
	}

	public void setNewsfeedid(Integer newsfeedid) {
		this.newsfeedid = newsfeedid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}