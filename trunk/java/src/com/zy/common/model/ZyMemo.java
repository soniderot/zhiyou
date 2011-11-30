package com.zy.common.model;

import java.util.Date;

/**
 * ZyMemo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyMemo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer memorid;
	private String content;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyMemo() {
	}

	/** minimal constructor */
	public ZyMemo(Integer userid, Integer memorid, String content) {
		this.userid = userid;
		this.memorid = memorid;
		this.content = content;
	}

	/** full constructor */
	public ZyMemo(Integer userid, Integer memorid, String content,
			Date createtime) {
		this.userid = userid;
		this.memorid = memorid;
		this.content = content;
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

	public Integer getMemorid() {
		return this.memorid;
	}

	public void setMemorid(Integer memorid) {
		this.memorid = memorid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}