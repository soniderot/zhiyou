package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyProfile;
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
}
