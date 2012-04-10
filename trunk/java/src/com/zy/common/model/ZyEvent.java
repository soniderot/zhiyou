package com.zy.common.model;

import java.util.Date;

import com.zy.common.util.ImageUtil;

/**
 * ZyEvent entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyEvent implements java.io.Serializable {

	// Fields

	private Integer id;
	private String eventname;
	private Date begintime;
	private Date endtime;
	private String address;
	private Integer cityid;
	private Date createtime;
	private Integer createuserid;
	private Date updatetime;
	private String detail;
	private String logo;
	private Integer districtid;
	private Integer subcategoryid;
	private String biglogo;
	private Integer type;
	
	private int photosCnt;
	private int commentsCnt;
	
	private String eventLogo;
	
	private Integer privacy; //0 all 1 friends 2 members 
	
	
	// Constructors


	public String getEventLogo() {
		return eventLogo;
	}

	public void setEventLogo(String eventLogo) {
		String smallFileName = eventLogo.replace(".jpg","-small.jpg");
		int[] result = ImageUtil.resetsize(eventLogo,smallFileName,320,320);
		this.logo = smallFileName;
		this.biglogo = eventLogo;
	}

	public int getPhotosCnt() {
		return photosCnt;
	}

	public void setPhotosCnt(int photosCnt) {
		this.photosCnt = photosCnt;
	}

	public int getCommentsCnt() {
		return commentsCnt;
	}

	public void setCommentsCnt(int commentsCnt) {
		this.commentsCnt = commentsCnt;
	}

	/** default constructor */
	public ZyEvent() {
	}

	/** minimal constructor */
	public ZyEvent(String eventname, Date begintime, Date endtime,
			String address, Integer cityid, Integer createuserid) {
		this.eventname = eventname;
		this.begintime = begintime;
		this.endtime = endtime;
		this.address = address;
		this.cityid = cityid;
		this.createuserid = createuserid;
	}

	/** full constructor */
	public ZyEvent(String eventname, Date begintime, Date endtime,
			String address, Integer cityid, Date createtime,
			Integer createuserid, Date updatetime, String detail, String logo,
			Integer districtid, Integer subcategoryid, String biglogo,
			Integer type) {
		this.eventname = eventname;
		this.begintime = begintime;
		this.endtime = endtime;
		this.address = address;
		this.cityid = cityid;
		this.createtime = createtime;
		this.createuserid = createuserid;
		this.updatetime = updatetime;
		this.detail = detail;
		this.logo = logo;
		this.districtid = districtid;
		this.subcategoryid = subcategoryid;
		this.biglogo = biglogo;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventname() {
		return this.eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCityid() {
		return this.cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateuserid() {
		return this.createuserid;
	}

	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getDistrictid() {
		return this.districtid;
	}

	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}

	public Integer getSubcategoryid() {
		return this.subcategoryid;
	}

	public void setSubcategoryid(Integer subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getBiglogo() {
		return this.biglogo;
	}

	public void setBiglogo(String biglogo) {
		this.biglogo = biglogo;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Integer privacy) {
		this.privacy = privacy;
	}

}