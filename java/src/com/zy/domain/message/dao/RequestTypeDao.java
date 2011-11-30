package com.zy.domain.message.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyRequesttype;

public interface RequestTypeDao extends BaseDao<ZyRequesttype, Integer>{
	
	public ZyRequesttype getRequestType(short eventid);
	public List<ZyRequesttype> getRequestType();
}
