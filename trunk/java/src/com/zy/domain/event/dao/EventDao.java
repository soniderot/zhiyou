package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyEvent;
import com.zy.facade.vo.EventVO;

public interface EventDao extends BaseDao<ZyEvent,Integer>{
	public List<EventVO> getEvents(String userIds,int pageNo,int pageSize);
	
	public List<ZyEvent> getEventsByType(int type,int pageNo,int pageSize);
	
	public List<ZyEvent> getDistinctEvents(String userIds,int pageNo,int pageSize);
	
	public List<ZyEvent> getHotPubEvents(int pageNo,int pageSize);
}
