package com.zy.facade.vo;

import java.util.List;

import com.zy.common.model.ZyProfile;

public class ProfileVO {
	private ZyProfile profile;
	private List<ZyProfile> muFriends;
	
	private boolean requestOutFlag;
	
	private boolean requestInFlag;
	
	private boolean friendFlag;
	
	
	public boolean isFriendFlag() {
		return friendFlag;
	}
	public void setFriendFlag(boolean friendFlag) {
		this.friendFlag = friendFlag;
	}
	public boolean isRequestOutFlag() {
		return requestOutFlag;
	}
	public void setRequestOutFlag(boolean requestOutFlag) {
		this.requestOutFlag = requestOutFlag;
	}
	public boolean isRequestInFlag() {
		return requestInFlag;
	}
	public void setRequestInFlag(boolean requestInFlag) {
		this.requestInFlag = requestInFlag;
	}
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
