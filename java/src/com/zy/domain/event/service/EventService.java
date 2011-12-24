package com.zy.domain.event.service;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventmember;
import com.zy.facade.vo.EventVO;

public interface EventService {
	public ZyEvent getEvent(int id);
	public void createEvent(ZyEvent event);
	public void sendInvites(int userId,int eventId,List<Integer> profileIds);
	public List<ZyEventmember> getEventMembers(int eventId);
	
	public void addMember(int userId,int eventId);
	public void updateEvent(ZyEvent event);
	public List<EventVO> getEvents(String userIds,int pageNo,int pageSize);
	public void removeMember(int userId,int eventId);
}