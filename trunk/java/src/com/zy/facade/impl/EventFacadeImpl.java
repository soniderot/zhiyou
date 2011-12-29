package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventcategory;
import com.zy.common.model.ZyEventmember;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRecommplace;
import com.zy.common.model.ZyRequest;
import com.zy.domain.event.service.EventService;
import com.zy.domain.message.service.RequestService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.sns.service.SNSService;
import com.zy.facade.EventFacade;
import com.zy.facade.vo.EventVO;

public class EventFacadeImpl implements EventFacade{
	private EventService eventService;
	private ProfileService profileService;
	private SNSService snsService;
	private RequestService requestService;
	
	public SNSService getSnsService() {
		return snsService;
	}

	public void setSnsService(SNSService snsService) {
		this.snsService = snsService;
	}

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

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
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
	
	public void updateEvent(ZyEvent event){
		eventService.updateEvent(event);
	}
	
	public List<EventVO> getEvents(int userId,String userIds,int pageNo,int pageSize){
		List<EventVO> list = eventService.getEvents(userIds,pageNo,pageSize);
		for(int i=0;i<list.size();i++){
			list.get(i).setProfile(profileService.findProfileById(list.get(i).getMember().getUserid()));
			List<ZyProfile> profiles = this.getEventMembers(list.get(i).getEvent().getId());
			list.get(i).setMembers(profiles);
			for(int m=0;m<profiles.size();m++){
				if(profiles.get(m).getUserid()==userId){
					list.get(i).setJoined(true);
					break;
				}
			}
		}
		return list;
	}
	
	public void removeMember(int userId,int eventId){
		eventService.removeMember(userId, eventId);
	}
	
	public List<ZyEventcategory> getEventCategorys(){
		return eventService.getEventCategorys();
	}
	
	public List<ZyRecommplace> getRecommPlaces(int districtid,int subcategoryid){
		return eventService.getRecommPlaces(districtid, subcategoryid);
	}
	
	public List<EventVO> getEventFriends(int userId, int eventId) {
		List<ZyProfile> friendList = snsService.getAllFriends(userId, (short)1);
		List<ZyProfile> eventMembers = getRequestSentTo(eventId);
		List<EventVO> eventFriends = new ArrayList<EventVO>();
		for(int i = 0; i < friendList.size(); i++) {
			ZyProfile profile = friendList.get(i);
			EventVO eventVo = new EventVO();
			eventVo.setProfile(profile);
			if (eventMembers.contains(profile)) {
				eventVo.setJoined(true);
			} else {
				eventVo.setJoined(false);
			}
			eventFriends.add(eventVo);
		}
		return eventFriends;
	}
	
	public List<ZyProfile> getRequestSentTo(int eventId){
		List<ZyRequest> members = requestService.getRequests(eventId);
		List<ZyProfile> profiles = new ArrayList<ZyProfile>();
		for(int i=0;i<members.size();i++){
			ZyProfile profile = profileService.findProfileById(members.get(i).getReceiverid());
			profiles.add(profile);
		}
		return profiles;
	}

}
