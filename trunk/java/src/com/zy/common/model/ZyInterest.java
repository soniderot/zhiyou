package com.zy.common.model;

import java.util.Date;

/**
 * ZySchool entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyInterest implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tag;
	private Integer userid;
	private Integer flag;
	private Integer hot;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyInterest() {
	}

	/** minimal constructor */
	public ZyInterest(String tag) {
		this.tag = tag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getTag() {
		return tag;
	}

	public Integer getUserid() {
		return userid;
	}

	public Integer getHot() {
		return hot;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


}