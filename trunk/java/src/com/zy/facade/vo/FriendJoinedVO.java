package com.zy.facade.vo;

import com.zy.common.model.ZyProfile;

public class FriendJoinedVO {

	private ZyProfile profile;
	private int groupId;
	private boolean joined;

	public ZyProfile getProfile() {
		return profile;
	}

	public boolean isJoined() {
		return joined;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	

}
