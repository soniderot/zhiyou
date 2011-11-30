package com.zy.common.model;

/**
 * ZyDistrict entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyDistrict implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer cityid;
	private String districtname;

	// Constructors

	/** default constructor */
	public ZyDistrict() {
	}

	/** full constructor */
	public ZyDistrict(Integer cityid, String districtname) {
		this.cityid = cityid;
		this.districtname = districtname;
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

	public String getDistrictname() {
		return this.districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

}