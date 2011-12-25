package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyEventcategory;

public interface EventCategoryDao extends BaseDao<ZyEventcategory,Integer>{
	public List<ZyEventcategory> getEventCategorys();
}
