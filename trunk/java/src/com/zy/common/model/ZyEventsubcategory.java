package com.zy.common.model;

/**
 * ZyEventsubcategory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyEventsubcategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer categoryid;
	private String name;

	// Constructors

	/** default constructor */
	public ZyEventsubcategory() {
	}

	/** full constructor */
	public ZyEventsubcategory(Integer categoryid, String name) {
		this.categoryid = categoryid;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}