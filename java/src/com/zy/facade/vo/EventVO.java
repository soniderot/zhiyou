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
	
	//private int commentsCnt;
	//private int photosCnt;
	private ZyProfile createUser;
	private List<ZyProfile> friends;
	
	private boolean newDateFlag;
	
	public boolean isNewDateFlag() {
		return newDateFlag;
	}
	public void setNewDateFlag(boolean newDateFlag) {
		this.newDateFlag = newDateFlag;
	}
	public List<ZyProfile> getFriends() {
		return friends;
	}
	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
	}
	public ZyProfile getCreateUser() {
		return createUser;
	}
	public void setCreateUser(ZyProfile createUser) {
		this.createUser = createUser;
	}
	/*
	public int getCommentsCnt() {
		return commentsCnt;
	}
	public void setCommentsCnt(int commentsCnt) {
		this.commentsCnt = commentsCnt;
	}
	public int getPhotosCnt() {
		return photosCnt;
	}
	public void setPhotosCnt(int photosCnt) {
		this.photosCnt = photosCnt;
	}*/
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
