package com.zy.facade.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventcategory;
import com.zy.common.model.ZyEventmember;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRecommplace;
import com.zy.common.model.ZyRequest;
import com.zy.domain.event.service.EventService;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.domain.message.service.RequestService;
import com.zy.domain.photo.service.PhotoService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.sns.service.SNSService;
import com.zy.facade.EventFacade;
import com.zy.facade.FeedFacade;
import com.zy.facade.vo.EventVO;

public class EventFacadeImpl implements EventFacade{
	private EventService eventService;
	private ProfileService profileService;
	private SNSService snsService;
	private RequestService requestService;
	private PhotoService photoService;
	private FeedFacade feedFacade;
	
	
	
	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

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
		int photosCnt = photoService.getPhotosCntByEventId(eventId);
		ZyEvent event = eventService.getEvent(eventId);
		event.setPhotosCnt(photosCnt);
		List<FeedBean> feeds = feedFacade.getEventNewsFeed(""+eventId,1,Integer.MAX_VALUE);
		event.setCommentsCnt(feeds.size());
		return event;
	}
	
	public void updateEvent(ZyEvent event){
		eventService.updateEvent(event);
	}
	
	public List<EventVO> getFriendsEvents(int userId,int pageNo,int pageSize){
		String str = "";
		List<Integer> friendIds = snsService.getAllFriendsByDegree(userId,(short)1);
		for(int i=0;i<friendIds.size();i++){
			if(i!=friendIds.size()-1){
				str = str+friendIds.get(i)+",";
			}else{
				str = str+friendIds.get(i);
			}
		}
		System.out.println("--------------into---friends----------activitys---["+str+"]");
		
		
		List<ZyEvent> events = eventService.getDistinctEvents(str, pageNo, pageSize);
		List<EventVO> results = new ArrayList<EventVO>();
		for(int i=0;i<events.size();i++){
			EventVO vo = new EventVO();
			vo.setEvent(events.get(i));
			int photosCnt = photoService.getPhotosCntByEventId(events.get(i).getId());
			List<FeedBean> feeds = feedFacade.getEventNewsFeed(""+events.get(i).getId(),1,Integer.MAX_VALUE);
			events.get(i).setPhotosCnt(photosCnt);
			events.get(i).setCommentsCnt(feeds.size());
			vo.setProfile(profileService.findProfileById(events.get(i).getCreateuserid()));
			List<ZyProfile> profiles = this.getEventMembers(events.get(i).getId());
			vo.setMembers(profiles);
			List<ZyProfile> friends = new ArrayList<ZyProfile>();
			for(int j=0;j<profiles.size();j++){
				if(friendIds.contains(profiles.get(j).getUserid())){
					friends.add(profiles.get(j));
				}
			}
			vo.setFriends(friends);
			results.add(vo);
		}
		return results;
	}
	
	public List<EventVO> getEvents(int userId,String userIds,int pageNo,int pageSize){
		List<EventVO> list = eventService.getEvents(userIds,pageNo,pageSize);
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		List<String> dates = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			
			String date = dateformat.format(list.get(i).getEvent().getBegintime());
			if(!dates.contains(date)){
				dates.add(date);
				list.get(i).setNewDateFlag(true);
			}
			
			list.get(i).setProfile(profileService.findProfileById(list.get(i).getMember().getUserid()));
			System.out.println(list.get(i).getProfile().getUserid());
			List<ZyProfile> profiles = this.getEventMembers(list.get(i).getEvent().getId());
			list.get(i).setMembers(profiles);
			
			list.get(i).setCreateUser(profileService.findProfileById(list.get(i).getEvent().getCreateuserid()));
			int photosCnt = photoService.getPhotosCntByEventId(list.get(i).getEvent().getId());
			List<FeedBean> feeds = feedFacade.getEventNewsFeed(""+list.get(i).getEvent().getId(),1,Integer.MAX_VALUE);
			list.get(i).getEvent().setPhotosCnt(photosCnt);
			list.get(i).getEvent().setCommentsCnt(feeds.size());
			
			if(list.get(i).getEvent().getEndtime()!=null){
				if(list.get(i).getEvent().getEndtime().before(new Date())){
					list.get(i).setExpired(true);
				}
			}
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
	
	public boolean isMemberInEvent(int memberId,int eventId){
		List<ZyProfile> list = this.getEventMembers(eventId);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUserid()==memberId){
				return true;
			}
		}
		return false;
	}

	public List<EventVO> getEventsByType(int userId,int type,int pageNo,int pageSize){
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		List<String> dates = new ArrayList<String>();
		List<EventVO> results = new ArrayList<EventVO>();
		List<ZyEvent> events = eventService.getEventsByType(type, pageNo, pageSize);
		for(int i=0;i<events.size();i++){
			EventVO eventVO =  new EventVO();
			String date = dateformat.format(events.get(i).getBegintime());
			if(!dates.contains(date)){
				dates.add(date);
				eventVO.setNewDateFlag(true);
			}
			
			eventVO.setEvent(events.get(i));
			eventVO.setProfile(profileService.findProfileById(events.get(i).getCreateuserid()));
			List<ZyProfile> members = this.getEventMembers(events.get(i).getId());
			eventVO.setMembers(members);
			
			
			int photosCnt = photoService.getPhotosCntByEventId(events.get(i).getId());
			List<FeedBean> feeds = feedFacade.getEventNewsFeed(""+events.get(i).getId(),1,Integer.MAX_VALUE);
			events.get(i).setPhotosCnt(photosCnt);
			events.get(i).setCommentsCnt(feeds.size());
			
			List<ZyProfile> profiles = this.getEventMembers(events.get(i).getId());
			for(int m=0;m<profiles.size();m++){
				if(profiles.get(m).getUserid()==userId){
					eventVO.setJoined(true);
					break;
				}
			}
			
			results.add(eventVO);
		}
		return results;
	}
	
	public List<EventVO> getHotPubEvents(int userId,int pageNo,int pageSize){
		List<ZyEvent> events = this.eventService.getHotPubEvents(pageNo, pageSize);
		List<EventVO> results = new ArrayList<EventVO>();
		for(int i=0;i<events.size();i++){
			EventVO vo = new EventVO();
			vo.setEvent(events.get(i));
			vo.setCreateUser(profileService.findProfileById(events.get(i).getCreateuserid()));
			List<ZyProfile> members = this.getEventMembers(events.get(i).getId());
			vo.setMembers(members);
			
			int photosCnt = photoService.getPhotosCntByEventId(events.get(i).getId());
			List<FeedBean> feeds = feedFacade.getEventNewsFeed(""+events.get(i).getId(),1,Integer.MAX_VALUE);
			events.get(i).setPhotosCnt(photosCnt);
			events.get(i).setCommentsCnt(feeds.size());
			List<ZyProfile> profiles = this.getEventMembers(events.get(i).getId());
			for(int m=0;m<profiles.size();m++){
				if(profiles.get(m).getUserid()==userId){
					vo.setJoined(true);
					break;
				}
			}
			results.add(vo);
		}
		return results;
	}
	
	public void createPlace(ZyRecommplace place){
		eventService.createPlace(place);
	}
	
	public ZyRecommplace getPlace(int placeId){
		return eventService.getPlace(placeId);
	}
}
