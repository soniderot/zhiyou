package com.zy.common.model;

import java.util.Date;
import java.util.List;

/**
 * ZyMatchquestion entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyMatchquestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer categoryid;
	private String title;
	private Date createtime;
	
	private List<ZyMatchquestionoption> options;
	
	private ZyMatchanswer answer;
	

	// Constructors

	public List<ZyMatchquestionoption> getOptions() {
		return options;
	}

	public void setOptions(List<ZyMatchquestionoption> options) {
		this.options = options;
	}

	/** default constructor */
	public ZyMatchquestion() {
	}

	/** full constructor */
	public ZyMatchquestion(Integer categoryid, String title, Date createtime) {
		this.categoryid = categoryid;
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

	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
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

	public ZyMatchanswer getAnswer() {
		return answer;
	}

	public void setAnswer(ZyMatchanswer answer) {
		this.answer = answer;
	}
}