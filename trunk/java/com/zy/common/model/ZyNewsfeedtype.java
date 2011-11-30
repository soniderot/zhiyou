package com.zy.common.model;

import java.util.Date;

/**
 * ZyNewsfeedtype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyNewsfeedtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String handle;
	private String message;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyNewsfeedtype() {
	}

	/** minimal constructor */
	public ZyNewsfeedtype(String handle, String message) {
		this.handle = handle;
		this.message = message;
	}

	/** full constructor */
	public ZyNewsfeedtype(String handle, String message, Date createtime) {
		this.handle = handle;
		this.message = message;
		this.createtime = createtime;
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

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}