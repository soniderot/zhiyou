package com.zy.common.model;

import java.util.Date;

/**
 * ZyFriend entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyFriend implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer friendid;
	private Integer groupid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyFriend() {
	}

	/** minimal constructor */
	public ZyFriend(Integer userid, Integer friendid, Integer groupid) {
		this.userid = userid;
		this.friendid = friendid;
		this.groupid = groupid;
	}

	/** full constructor */
	public ZyFriend(Integer userid, Integer friendid, Integer groupid,
			Date createtime) {
		this.userid = userid;
		this.friendid = friendid;
		this.groupid = groupid;
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

	public Integer getFriendid() {
		return this.friendid;
	}

	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}

	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}