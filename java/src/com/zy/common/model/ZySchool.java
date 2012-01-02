package com.zy.common.model;

import java.util.Date;

/**
 * ZySchool entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZySchool implements java.io.Serializable {

	// Fields

	private Integer id;
	private String schoolname;
	private String schoolpinyin;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZySchool() {
	}

	/** minimal constructor */
	public ZySchool(String schoolname) {
		this.schoolname = schoolname;
	}

	/** full constructor */
	public ZySchool(String schoolname, Date createtime) {
		this.schoolname = schoolname;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchoolname() {
		return this.schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getSchoolpinyin() {
		return schoolpinyin;
	}

	public void setSchoolpinyin(String schoolpinyin) {
		this.schoolpinyin = schoolpinyin;
	}

}