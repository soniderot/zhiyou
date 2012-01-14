package com.zy.facade.vo;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventmember;
import com.zy.common.model.ZyProfile;

public class EventVO {
	private ZyEvent event;
	private ZyEventmember member;
	private ZyProfile profile;
	
	private List<ZyProfile> members;
	private boolean joined;
	
	private boolean expired;
	
	
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public boolean isJoined() {
		return joined;
	}
	public void setJoined(boolean joined) {
		this.joined = joined;
	}
	public List<ZyProfile> getMembers() {
		return members;
	}
	public void setMembers(List<ZyProfile> members) {
		this.members = members;
	}
	public ZyEvent getEvent() {
		return event;
	}
	public void setEvent(ZyEvent event) {
		this.event = event;
	}
	public ZyEventmember getMember() {
		return member;
	}
	public void setMember(ZyEventmember member) {
		this.member = member;
	}
	public ZyProfile getProfile() {
		return profile;
	}
	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}
}
