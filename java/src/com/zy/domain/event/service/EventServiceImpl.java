package com.zy.domain.event.service;

import java.util.Date;
import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventcategory;
import com.zy.common.model.ZyEventfollow;
import com.zy.common.model.ZyEventinvite;
import com.zy.common.model.ZyEventmember;
import com.zy.common.model.ZyRecommplace;
import com.zy.domain.event.dao.EventCategoryDao;
import com.zy.domain.event.dao.EventDao;
import com.zy.domain.event.dao.EventFollowDao;
import com.zy.domain.event.dao.EventInviteDao;
import com.zy.domain.event.dao.EventMemberDao;
import com.zy.domain.event.dao.RecommPlaceDao;
import com.zy.facade.vo.EventVO;

public class EventServiceImpl implements EventService{
	private EventDao eventDao;
	private EventInviteDao eventInviteDao;
	private EventMemberDao eventMemberDao;
	private EventCategoryDao eventCategoryDao;
	private RecommPlaceDao recommPlaceDao;
	private EventFollowDao eventFollowDao;
	
	public EventFollowDao getEventFollowDao() {
		return eventFollowDao;
	}

	public void setEventFollowDao(EventFollowDao eventFollowDao) {
		this.eventFollowDao = eventFollowDao;
	}

	public RecommPlaceDao getRecommPlaceDao() {
		return recommPlaceDao;
	}

	public void setRecommPlaceDao(RecommPlaceDao recommPlaceDao) {
		this.recommPlaceDao = recommPlaceDao;
	}

	public EventCategoryDao getEventCategoryDao() {
		return eventCategoryDao;
	}

	public void setEventCategoryDao(EventCategoryDao eventCategoryDao) {
		this.eventCategoryDao = eventCategoryDao;
	}

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
	
	public void updateEvent(ZyEvent event){
		eventDao.update(event);
	}
	
	public List<EventVO> getEvents(String userIds,int pageNo,int pageSize){
		return eventDao.getEvents(userIds,pageNo,pageSize);
	}
	
	public void removeMember(int userId,int eventId){
		eventMemberDao.removeMember(userId, eventId);
	}
	
	public List<ZyEventcategory> getEventCategorys(){
		return eventCategoryDao.getEventCategorys();
	}
	
	public List<ZyRecommplace> getRecommPlaces(int districtid,int subcategoryid){
		return recommPlaceDao.getRecommPlaces(districtid, subcategoryid);
	}
	
	public List<ZyEvent> getEventsByType(int type,int pageNo,int pageSize){
		List<ZyEvent> events = eventDao.getEventsByType(type, pageNo, pageSize);
		return events;
	}
	
	public List<ZyEvent> getDistinctEvents(String userIds,int pageNo,int pageSize){
		return eventDao.getDistinctEvents(userIds, pageNo, pageSize);
	}
	
	public List<ZyEvent> getHotPubEvents(int pageNo,int pageSize){
		return eventDao.getHotPubEvents(pageNo, pageSize);
	}
	
	public void createPlace(ZyRecommplace place){
		recommPlaceDao.saveOrUpdate(place);
	}
	
	public ZyRecommplace getPlace(int placeId){
		return recommPlaceDao.get(placeId);
	}
	
	public List<ZyEventfollow> getFollowEvents(int userId,int pageNo,int pageSize){
		return eventFollowDao.getFollowEvents(userId, pageNo, pageSize);
	}
	public List<ZyEventfollow> getEventFollow(int eventId,int pageNo,int pageSize){
		return eventFollowDao.getEventFollow(eventId, pageNo, pageSize);
	}
	public void addEventFollow(int eventId,int userId){
		ZyEventfollow follow = new ZyEventfollow();
		follow.setCreatetime(new Date());
		follow.setEventid(eventId);
		follow.setUserid(userId);
		eventFollowDao.save(follow);
	}
	public void removeEventFollow(int eventId,int userId){
		List<ZyEventfollow> list = eventFollowDao.getFollowEvnets(userId, eventId, 1,Integer.MAX_VALUE);
		for(int i=0;i<list.size();i++){
			eventFollowDao.deleteByKey(list.get(i).getId());
		}
	}
	
	public List<ZyEventfollow> getFollowEvnets(int userId,int eventId,int pageNo,int pageSize){
		return eventFollowDao.getFollowEvnets(userId, eventId, pageNo, pageSize);
	}
}
