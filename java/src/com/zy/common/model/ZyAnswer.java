package com.zy.common.model;

import java.util.Date;

/**
 * ZyAnswer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyAnswer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer questionid;
	private String answer;
	private Integer optionanswer;
	private Integer userid;
	private Date createtime;

	// Constructors

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/** default constructor */
	public ZyAnswer() {
	}

	/** full constructor */
	public ZyAnswer(Integer questionid, String answer, Integer optionanswer) {
		this.questionid = questionid;
		this.answer = answer;
		this.optionanswer = optionanswer;
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

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getOptionanswer() {
		return this.optionanswer;
	}

	public void setOptionanswer(Integer optionanswer) {
		this.optionanswer = optionanswer;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}