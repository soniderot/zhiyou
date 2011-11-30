package com.zy.common.model;

import java.util.Date;

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

	// Constructors

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
			Integer createuserid, Date updatetime) {
		this.eventname = eventname;
		this.begintime = begintime;
		this.endtime = endtime;
		this.address = address;
		this.cityid = cityid;
		this.createtime = createtime;
		this.createuserid = createuserid;
		this.updatetime = updatetime;
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

}