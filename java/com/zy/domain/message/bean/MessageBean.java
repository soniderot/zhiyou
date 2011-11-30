package com.zy.domain.message.bean;

import java.util.List;

import com.zy.common.model.ZyMessage;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.HtmlUtil;

public class MessageBean {
	private ZyProfile profile;
	private ZyMessage message;
	
	public ZyProfile getProfile() {
		return profile;
	}
	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}
	public ZyMessage getMessage() {
		return message;
	}
	public void setMessage(ZyMessage message) {
		this.message = message;
	}
	
}

