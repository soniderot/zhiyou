package com.zy.common.model;

/**
 * ZyCity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyCity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer countryid;
	private Integer regionid;
	private String cityname;
	private String citypinyin;
	private Integer sortorder;

	// Constructors

	/** default constructor */
	public ZyCity() {
	}

	/** full constructor */
	public ZyCity(Integer countryid, Integer regionid, String cityname,
			String citypinyin,
			Integer sortorder) {
		this.countryid = countryid;
		this.regionid = regionid;
		this.cityname = cityname;
		this.citypinyin = citypinyin;
		this.sortorder = sortorder;
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

	public Integer getRegionid() {
		return this.regionid;
	}

	public void setRegionid(Integer regionid) {
		this.regionid = regionid;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Integer getSortorder() {
		return this.sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

	public String getCitypinyin() {
		return citypinyin;
	}

	public void setCitypinyin(String citypinyin) {
		this.citypinyin = citypinyin;
	}

}