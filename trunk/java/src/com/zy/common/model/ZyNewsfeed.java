package com.zy.common.model;

import java.util.Date;

/**
 * ZyNewsfeed entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyNewsfeed implements java.io.Serializable {

	// Fields

	private Integer id;
	private String handle;
	private Integer userid;
	private String title;
	private String body;
	private Integer comments;
	private Date created;
	private Integer feedfrom;
	private Integer referenceid;
	private String shareReason;
	private Integer atuserid;
	private String atread;

	// Constructors

	public String getAtread() {
		return atread;
	}

	public void setAtread(String atread) {
		this.atread = atread;
	}

	public Integer getAtuserid() {
		return atuserid;
	}

	public void setAtuserid(Integer atuserid) {
		this.atuserid = atuserid;
	}

	/** default constructor */
	public ZyNewsfeed() {
	}

	/** minimal constructor */
	public ZyNewsfeed(String handle, Integer userid) {
		this.handle = handle;
		this.userid = userid;
	}

	/** full constructor */
	public ZyNewsfeed(String handle, Integer userid, String title, String body,
			Integer comments, Date created, Integer feedfrom,
			Integer referenceid) {
		this.handle = handle;
		this.userid = userid;
		this.title = title;
		this.body = body;
		this.comments = comments;
		this.created = created;
		this.feedfrom = feedfrom;
		this.referenceid = referenceid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHandle() {
		return this.handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getComments() {
		return this.comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getFeedfrom() {
		return this.feedfrom;
	}

	public void setFeedfrom(Integer feedfrom) {
		this.feedfrom = feedfrom;
	}

	public Integer getReferenceid() {
		return this.referenceid;
	}

	public void setReferenceid(Integer referenceid) {
		this.referenceid = referenceid;
	}

	public String getShareReason() {
		return shareReason;
	}

	public void setShareReason(String shareReason) {
		this.shareReason = shareReason;
	}

}
