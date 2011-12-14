package com.zy.domain.event.service;

import com.zy.common.model.ZyEvent;
import com.zy.domain.event.dao.EventDao;

public class EventServiceImpl implements EventService{
	private EventDao eventDao;
	
	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public ZyEvent getEvent(int id){
		return eventDao.load(id);
	}
}
