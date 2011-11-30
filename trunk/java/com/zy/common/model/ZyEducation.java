package com.zy.common.model;

import java.util.Date;

/**
 * ZyEducation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyEducation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer schoolid;
	private Integer userid;
	private String major;
	private Integer degreeid;
	private Integer startyear;
	private Integer startmonth;
	private Integer endyear;
	private Integer endmonth;
	private Date createtime;
	private Date modifytime;
	
	private String schoolname;
	private String degreename;
	
	

	// Constructors

	public String getDegreename() {
		return degreename;
	}

	public void setDegreename(String degreename) {
		this.degreename = degreename;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	/** default constructor */
	public ZyEducation() {
	}

	/** minimal constructor */
	public ZyEducation(Integer schoolid, Integer userid, String major,
			Integer degreeid, Integer startyear, Integer startmonth,
			Integer endyear, Integer endmonth) {
		this.schoolid = schoolid;
		this.userid = userid;
		this.major = major;
		this.degreeid = degreeid;
		this.startyear = startyear;
		this.startmonth = startmonth;
		this.endyear = endyear;
		this.endmonth = endmonth;
	}

	/** full constructor */
	public ZyEducation(Integer schoolid, Integer userid, String major,
			Integer degreeid, Integer startyear, Integer startmonth,
			Integer endyear, Integer endmonth, Date createtime, Date modifytime) {
		this.schoolid = schoolid;
		this.userid = userid;
		this.major = major;
		this.degreeid = degreeid;
		this.startyear = startyear;
		this.startmonth = startmonth;
		this.endyear = endyear;
		this.endmonth = endmonth;
		this.createtime = createtime;
		this.modifytime = modifytime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSchoolid() {
		return this.schoolid;
	}

	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getDegreeid() {
		return this.degreeid;
	}

	public void setDegreeid(Integer degreeid) {
		this.degreeid = degreeid;
	}

	public Integer getStartyear() {
		return this.startyear;
	}

	public void setStartyear(Integer startyear) {
		this.startyear = startyear;
	}

	public Integer getStartmonth() {
		return this.startmonth;
	}

	public void setStartmonth(Integer startmonth) {
		this.startmonth = startmonth;
	}

	public Integer getEndyear() {
		return this.endyear;
	}

	public void setEndyear(Integer endyear) {
		this.endyear = endyear;
	}

	public Integer getEndmonth() {
		return this.endmonth;
	}

	public void setEndmonth(Integer endmonth) {
		this.endmonth = endmonth;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

}