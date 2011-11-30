package com.zy.common.model;

import java.util.Date;

/**
 * ZyNotification entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyNotification implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer receiverid;
	private Short eventkey;
	private String content;
	private String isread;
	private String isdeleted;
	private String parameters;
	private Date createtime;
	private Date updatetime;

	// Constructors

	/** default constructor */
	public ZyNotification() {
	}

	/** minimal constructor */
	public ZyNotification(Short eventkey, String content, String isread,
			String isdeleted, String parameters, Date createtime,
			Date updatetime) {
		this.eventkey = eventkey;
		this.content = content;
		this.isread = isread;
		this.isdeleted = isdeleted;
		this.parameters = parameters;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	/** full constructor */
	public ZyNotification(Integer receiverid, Short eventkey, String content,
			String isread, String isdeleted, String parameters,
			Date createtime, Date updatetime) {
		this.receiverid = receiverid;
		this.eventkey = eventkey;
		this.content = content;
		this.isread = isread;
		this.isdeleted = isdeleted;
		this.parameters = parameters;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReceiverid() {
		return this.receiverid;
	}

	public void setReceiverid(Integer receiverid) {
		this.receiverid = receiverid;
	}

	public Short getEventkey() {
		return this.eventkey;
	}

	public void setEventkey(Short eventkey) {
		this.eventkey = eventkey;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsread() {
		return this.isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getParameters() {
		return this.parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}