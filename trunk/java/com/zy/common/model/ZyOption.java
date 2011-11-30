package com.zy.common.model;

/**
 * ZyOption entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyOption implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer optionid;
	private String handle;
	private String content;

	// Constructors

	/** default constructor */
	public ZyOption() {
	}

	/** full constructor */
	public ZyOption(Integer optionid, String handle, String content) {
		this.optionid = optionid;
		this.handle = handle;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOptionid() {
		return this.optionid;
	}

	public void setOptionid(Integer optionid) {
		this.optionid = optionid;
	}

	public String getHandle() {
		return this.handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}