package com.zy.common.model;

import java.util.Date;

/**
 * ZyPhoto entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyPhoto implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer albumno;
	private Date createtime;

	private String filename;
	
	private String summary;
	
	// Constructors

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	/** default constructor */
	public ZyPhoto() {
	}

	/** full constructor */
	public ZyPhoto(Integer userid, Integer albumno, Date createtime,String filename,String summary) {
		this.userid = userid;
		this.albumno = albumno;
		this.createtime = createtime;
		this.filename = filename;
		this.summary = summary;
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

	public Integer getAlbumno() {
		return this.albumno;
	}

	public void setAlbumno(Integer albumno) {
		this.albumno = albumno;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}