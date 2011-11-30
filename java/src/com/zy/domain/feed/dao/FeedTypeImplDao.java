package com.zy.domain.feed.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyNewsfeedtype;

public class FeedTypeImplDao extends HibernateDao<ZyNewsfeedtype, Integer> implements FeedTypeDao{
	public List<ZyNewsfeedtype> getFeedTypeByHandles(String handle){
		String hql = "from ZyNewsfeedtype where handle in(" + handle + ") ";
		return this.find(hql);
	}
}
