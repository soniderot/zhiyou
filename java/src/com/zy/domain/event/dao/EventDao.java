package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyEvent;
import com.zy.facade.vo.EventVO;

public interface EventDao extends BaseDao<ZyEvent,Integer>{
	public List<EventVO> getEvents(String userIds,int pageNo,int pageSize);
}