package com.zy.common.model;

import java.util.Date;

/**
 * ZyMatchquestioncategory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyMatchquestioncategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String categoryname;
	private Integer type;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyMatchquestioncategory() {
	}

	/** full constructor */
	public ZyMatchquestioncategory(String categoryname, Integer type,
			Date createtime) {
		this.categoryname = categoryname;
		this.type = type;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}