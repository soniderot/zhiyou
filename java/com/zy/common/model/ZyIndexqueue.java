package com.zy.common.model;

/**
 * ZyIndexqueue entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyIndexqueue implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;

	// Constructors

	/** default constructor */
	public ZyIndexqueue() {
	}

	/** full constructor */
	public ZyIndexqueue(Integer userid) {
		this.userid = userid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}