package com.zy.domain.message.bean;

import java.util.Date;

import com.zy.Constants;
import com.zy.common.model.ZyProfile;

public class NotificationBean {
	
	private Integer id;
	private String isread;
	private Date createtime;
	private String content;
	
	private ZyProfile profile;
	
	public ZyProfile getProfile() {
		return profile;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getOutContent(){
		return content.replace("<a href=\"", "<a href=\""+Constants.DOMAINNAME);
	}

	
	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public Date getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public long getDays(){
		return (new Date().getTime() - createtime.getTime()) / (3600000 * 24);
	}
}
