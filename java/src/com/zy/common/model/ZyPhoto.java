package com.zy.common.model;

import java.util.Date;

import com.zy.common.util.ImageUtil;

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
	private String deleted;
	
	private String bigfilename;
	
	private Integer width;
	
	private Integer height;
	
	private Integer eventid;
	
	
	// Constructors
	

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

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
	public void setPhotoFilename(String filename) {
		this.bigfilename = filename;
		
		String smallFileName = filename.replace(".jpg","-small.jpg");
		int[] result = ImageUtil.resetsize(filename,smallFileName,320,320);
		this.filename = smallFileName;
		this.width = result[0];
		this.height = result[1];
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

	public String getBigfilename() {
		return bigfilename;
	}

	public void setBigfilename(String bigfilename) {
		this.bigfilename = bigfilename;
	}

	public Integer getEventid() {
		return eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

}