package com.zy.common.model;

public class ZyFriendDetail {
	private ZyFriend friend;
	private ZyProfile profile;
	private ZyFriendgroup group;
	public ZyFriend getFriend() {
		return friend;
	}
	public void setFriend(ZyFriend friend) {
		this.friend = friend;
	}
	public ZyProfile getProfile() {
		return profile;
	}
	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}
	public ZyFriendgroup getGroup() {
		return group;
	}
	public void setGroup(ZyFriendgroup group) {
		this.group = group;
	}
}
