package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventcategory;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRecommplace;
import com.zy.facade.vo.EventVO;

public interface EventFacade {
	public void createEvent(ZyEvent event);
	public void sendEventInvites(ZyEvent event,List<Integer> profileIds);
	public List<ZyProfile> getEventMembers(int eventId);
	public void addMember(int userId,int eventId);
	public void removeMember(int userId,int eventId);
	public ZyEvent getEvent(int eventId);
	public void updateEvent(ZyEvent event);
	public List<EventVO> getEvents(int userId,String userIds,int pageNo,int pageSize);
	public List<ZyEventcategory> getEventCategorys();
	public List<ZyRecommplace> getRecommPlaces(int districtid,int subcategoryid);
	public List<EventVO> getEventFriends(int userId, int eventId);
	public List<ZyProfile> getRequestSentTo(int eventId);
	public boolean isMemberInEvent(int memberId,int eventId);
	
	public List<EventVO> getEventsByType(int userId,int type,int pageNo,int pageSize);
	public List<EventVO> getFriendsEvents(int userId,int pageNo,int pageSize);
	
	public List<EventVO> getHotPubEvents(int userId,int pageNo,int pageSize);
	public void createPlace(ZyRecommplace place);
	public ZyRecommplace getPlace(int placeId);
}
