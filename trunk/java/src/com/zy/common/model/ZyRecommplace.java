package com.zy.common.model;

import java.util.Date;

/**
 * ZyRecommplace entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyRecommplace implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer cityid;
	private Integer districtid;
	private Integer subcategoryid;
	private String avatar;
	private String summary;
	private Date createtime;
	private String address;
	private String placename;
	private Integer hot;
	
	

	// Constructors

	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	/** default constructor */
	public ZyRecommplace() {
	}

	/** minimal constructor */
	public ZyRecommplace(String placename,Integer cityid, Integer districtid,
			Integer subcategoryid, String avatar,String address) {
		this.placename = placename;
		this.cityid = cityid;
		this.districtid = districtid;
		this.subcategoryid = subcategoryid;
		this.avatar = avatar;
		this.address = address;
	}

	/** full constructor */
	public ZyRecommplace(Integer cityid, Integer districtid,
			Integer subcategoryid, String avatar, String summary,
			Date createtime) {
		this.cityid = cityid;
		this.districtid = districtid;
		this.subcategoryid = subcategoryid;
		this.avatar = avatar;
		this.summary = summary;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCityid() {
		return this.cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
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

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}