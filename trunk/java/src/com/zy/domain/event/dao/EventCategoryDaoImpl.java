package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyEventcategory;

public class EventCategoryDaoImpl extends HibernateDao<ZyEventcategory, Integer> implements EventCategoryDao{
	public List<ZyEventcategory> getEventCategorys(){
		String hql = "from ZyEventcategory";
		return this.find(hql);
	}
}
