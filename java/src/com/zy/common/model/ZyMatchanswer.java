package com.zy.common.model;

import java.util.Date;

/**
 * ZyMatchanswer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyMatchanswer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer matchquestionid;
	private Integer userid;
	private Integer optionid;
	private String targetoptionid;
	private Date createtime;
	
	private String[] targetoptions;
	

	// Constructors

	public String[] getTargetoptions() {
		if(targetoptionid!=null&&targetoptionid.trim().length()>0){
			targetoptionid.split(",");
		}
		return targetoptions;
	}

	public void setTargetoptions(String[] targetoptions) {
		this.targetoptions = targetoptions;
	}

	/** default constructor */
	public ZyMatchanswer() {
	}

	/** full constructor */
	public ZyMatchanswer(Integer matchquestionid, Integer userid,
			Integer optionid, String targetoptionid, Date createtime) {
		this.matchquestionid = matchquestionid;
		this.userid = userid;
		this.optionid = optionid;
		this.targetoptionid = targetoptionid;
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

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getOptionid() {
		return this.optionid;
	}

	public void setOptionid(Integer optionid) {
		this.optionid = optionid;
	}

	public String getTargetoptionid() {
		return this.targetoptionid;
	}

	public void setTargetoptionid(String targetoptionid) {
		this.targetoptionid = targetoptionid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}