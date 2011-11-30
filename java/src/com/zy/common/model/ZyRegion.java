package com.zy.common.model;

/**
 * ZyRegion entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyRegion implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer countryid;
	private String regionname;

	// Constructors

	/** default constructor */
	public ZyRegion() {
	}

	/** full constructor */
	public ZyRegion(Integer countryid, String regionname) {
		this.countryid = countryid;
		this.regionname = regionname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCountryid() {
		return this.countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getRegionname() {
		return this.regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

}