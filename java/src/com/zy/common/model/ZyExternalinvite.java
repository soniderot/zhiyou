package com.zy.common.model;

/**
 * ZyExternalinvite entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyExternalinvite implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private String receivername;
	private String receiveremail;
	private String title;
	private String body;
	private String createtime;
	private Integer receiverid;
	
	

	// Constructors

	public Integer getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(Integer receiverid) {
		this.receiverid = receiverid;
	}

	/** default constructor */
	public ZyExternalinvite() {
	}

	/** full constructor */
	public ZyExternalinvite(Integer userid, String receivername,
			String receiveremail, String title, String body, String createtime) {
		this.userid = userid;
		this.receivername = receivername;
		this.receiveremail = receiveremail;
		this.title = title;
		this.body = body;
		this.createtime = createtime;
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

	public String getReceivername() {
		return this.receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getReceiveremail() {
		return this.receiveremail;
	}

	public void setReceiveremail(String receiveremail) {
		this.receiveremail = receiveremail;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}