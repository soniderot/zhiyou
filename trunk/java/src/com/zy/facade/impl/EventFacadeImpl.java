package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventmember;
import com.zy.common.model.ZyProfile;
import com.zy.domain.event.service.EventService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.facade.EventFacade;

public class EventFacadeImpl implements EventFacade{
	private EventService eventService;
	private ProfileService profileService;
	
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void createEvent(ZyEvent event){
		eventService.createEvent(event);
	}
	
	public void sendEventInvites(ZyEvent event,List<Integer> profileIds){
		eventService.sendInvites(event.getCreateuserid(), event.getId(),profileIds);
	}
	
	public List<ZyProfile> getEventMembers(int eventId){
		List<ZyProfile> profiles = new ArrayList<ZyProfile>();
		List<ZyEventmember> members = eventService.getEventMembers(eventId);
		for(int i=0;i<members.size();i++){
			ZyProfile profile = profileService.findProfileById(members.get(i).getUserid());
			profiles.add(profile);
		}
		return profiles;
	}
	
	public void addMember(int userId,int eventId){
		eventService.addMember(userId, eventId);
	}
	public ZyEvent getEvent(int eventId){
		return eventService.getEvent(eventId);
	}
}
