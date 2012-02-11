package com.zy.common.model;

import java.util.Date;

/**
 * ZyMatchquestionoption entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyMatchquestionoption implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer matchquestionid;
	private String title;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ZyMatchquestionoption() {
	}

	/** full constructor */
	public ZyMatchquestionoption(Integer matchquestionid, String title,
			Date createtime) {
		this.matchquestionid = matchquestionid;
		this.title = title;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatchquestionid() {
		return this.matchquestionid;
	}

	public void setMatchquestionid(Integer matchquestionid) {
		this.matchquestionid = matchquestionid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}