package com.zy.facade.vo;

import java.util.List;

import com.zy.common.model.ZyProfile;

public class ProfileVO {
	private ZyProfile profile;
	private List<ZyProfile> muFriends;
	public ZyProfile getProfile() {
		return profile;
	}
	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}
	public List<ZyProfile> getMuFriends() {
		return muFriends;
	}
	public void setMuFriends(List<ZyProfile> muFriends) {
		this.muFriends = muFriends;
	}
}
