package com.zy.common.model;

import java.util.Date;

/**
 * ZyFriendgroup entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyFriendgroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private String groupname;
	private Short status;
	private Date createtime;
	
	private String selected = "";
	

	// Constructors

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	/** default constructor */
	public ZyFriendgroup() {
	}

	/** minimal constructor */
	public ZyFriendgroup(Integer userid, String groupname, Date createtime) {
		this.userid = userid;
		this.groupname = groupname;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


}