package com.zy.domain.event.service;

import java.util.Date;
import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventinvite;
import com.zy.common.model.ZyEventmember;
import com.zy.domain.event.dao.EventDao;
import com.zy.domain.event.dao.EventInviteDao;
import com.zy.domain.event.dao.EventMemberDao;

public class EventServiceImpl implements EventService{
	private EventDao eventDao;
	private EventInviteDao eventInviteDao;
	private EventMemberDao eventMemberDao;
	
	public EventMemberDao getEventMemberDao() {
		return eventMemberDao;
	}

	public void setEventMemberDao(EventMemberDao eventMemberDao) {
		this.eventMemberDao = eventMemberDao;
	}

	public EventInviteDao getEventInviteDao() {
		return eventInviteDao;
	}

	public void setEventInviteDao(EventInviteDao eventInviteDao) {
		this.eventInviteDao = eventInviteDao;
	}

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public ZyEvent getEvent(int id){
		return eventDao.load(id);
	}
	
	public void createEvent(ZyEvent event){
		eventDao.save(event);
	}
	
	public List<ZyEventmember> getEventMembers(int eventId){
		return eventMemberDao.getMembers(eventId);
	}
	
	public void sendInvites(int userId,int eventId,List<Integer> profileIds){
		for(int i=0;profileIds!=null&&i<profileIds.size();i++){
			ZyEventinvite invite = new ZyEventinvite();
			invite.setCreatetime(new Date());
			invite.setEventid(eventId);
			invite.setSenderid(userId);
			invite.setReceiverid(profileIds.get(i));
			invite.setStatus((short)0);
			eventInviteDao.save(invite);
		}
	}
	
	public void addMember(int userId,int eventId){
		ZyEventmember entity = new ZyEventmember();
		entity.setCreatetime(new Date());
		entity.setEventid(eventId);
		entity.setUserid(userId);
		eventMemberDao.save(entity);
	}
}
