package com.zy.common.model;

import java.util.Date;

/**
 * ZyRecommfriend entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyRecommfriend implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer recommenduserid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyRecommfriend() {
	}

	/** full constructor */
	public ZyRecommfriend(Integer userid, Integer recommenduserid,
			Date createtime) {
		this.userid = userid;
		this.recommenduserid = recommenduserid;
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

	public Integer getRecommenduserid() {
		return this.recommenduserid;
	}

	public void setRecommenduserid(Integer recommenduserid) {
		this.recommenduserid = recommenduserid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}