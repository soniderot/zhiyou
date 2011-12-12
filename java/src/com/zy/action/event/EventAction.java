package com.zy.action.event;

import java.util.List;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.facade.SNSFacade;

public class EventAction {
	private SNSFacade snsFacade;
	
	private List<ZyProfile> friends;

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}
	public List<ZyProfile> getFriends() {
		return friends;
	}

	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
	}
	
	public String getEvents(){
		System.out.println("--------------into-------------activitys");
		return "member.events";
	}
	
	public String createOrUpdate() {
		friends = snsFacade.getAllFriends(1, 0, (short)1);
		return "member.cteateOrUpdateEvent";
	}

}
