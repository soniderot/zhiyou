package com.zy.common.model;

import java.util.Date;

/**
 * ZyQuestion entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String summary;
	private Date createtime;
	private Short type;

	// Constructors

	/** default constructor */
	public ZyQuestion() {
	}

	/** minimal constructor */
	public ZyQuestion(String summary) {
		this.summary = summary;
	}

	/** full constructor */
	public ZyQuestion(String summary, Date createtime, Short type) {
		this.summary = summary;
		this.createtime = createtime;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

}