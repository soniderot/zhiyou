package com.zy.common.model;

import java.util.Date;

/**
 * ZyRequesttype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyRequesttype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short eventkey;
	private String template;
	private Date createtime;
	private String template2;

	// Constructors

	/** default constructor */
	public ZyRequesttype() {
	}

	/** minimal constructor */
	public ZyRequesttype(Short eventkey) {
		this.eventkey = eventkey;
	}

	/** full constructor */
	public ZyRequesttype(Short eventkey, String template, Date createtime,
			String template2) {
		this.eventkey = eventkey;
		this.template = template;
		this.createtime = createtime;
		this.template2 = template2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getEventkey() {
		return this.eventkey;
	}

	public void setEventkey(Short eventkey) {
		this.eventkey = eventkey;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getTemplate2() {
		return this.template2;
	}

	public void setTemplate2(String template2) {
		this.template2 = template2;
	}

}