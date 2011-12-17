package com.zy.facade;

import java.util.List;
import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyProfile;

public interface EventFacade {
	public void createEvent(ZyEvent event);
	public void sendEventInvites(ZyEvent event,List<Integer> profileIds);
	public List<ZyProfile> getEventMembers(int eventId);
	public void addMember(int userId,int eventId);
	public ZyEvent getEvent(int eventId);
}
