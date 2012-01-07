package com.zy.common.model;

/**
 * ZyAnsweroption entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyAnsweroption implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer questionid;
	private String summary;

	// Constructors

	/** default constructor */
	public ZyAnsweroption() {
	}

	/** full constructor */
	public ZyAnsweroption(Integer questionid, String summary) {
		this.questionid = questionid;
		this.summary = summary;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}