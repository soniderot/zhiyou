package com.zy.common.model;

import java.util.Date;

/**
 * ZyIndexlog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyIndexlog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String filename;
	private Integer recordcount;
	private Integer indextimemillis;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyIndexlog() {
	}

	/** minimal constructor */
	public ZyIndexlog(String filename) {
		this.filename = filename;
	}

	/** full constructor */
	public ZyIndexlog(String filename, Integer recordcount,
			Integer indextimemillis, Date createtime) {
		this.filename = filename;
		this.recordcount = recordcount;
		this.indextimemillis = indextimemillis;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getRecordcount() {
		return this.recordcount;
	}

	public void setRecordcount(Integer recordcount) {
		this.recordcount = recordcount;
	}

	public Integer getIndextimemillis() {
		return this.indextimemillis;
	}

	public void setIndextimemillis(Integer indextimemillis) {
		this.indextimemillis = indextimemillis;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}