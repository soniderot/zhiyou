package com.zy.domain.event.service;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventmember;

public interface EventService {
	public ZyEvent getEvent(int id);
	public void createEvent(ZyEvent event);
	public void sendInvites(int userId,int eventId,List<Integer> profileIds);
	public List<ZyEventmember> getEventMembers(int eventId);
	
	public void addMember(int userId,int eventId);
}
