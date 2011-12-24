package com.zy.common.model;

import java.util.Date;

/**
 * ZyAlbum entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyAlbum implements java.io.Serializable {

	// Fields

	private Integer id;
	private String albumname;
	private Date createtime;
	
	private int userid;
	private String logo;
	
	private int photosCnt;

	
	
	// Constructors

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getPhotosCnt() {
		return photosCnt;
	}

	public void setPhotosCnt(int photosCnt) {
		this.photosCnt = photosCnt;
	}

	/** default constructor */
	public ZyAlbum() {
	}

	/** full constructor */
	public ZyAlbum(String albumname, Date createtime) {
		this.albumname = albumname;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlbumname() {
		return this.albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}