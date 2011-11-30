package com.zy.domain.feed.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyNewsfeedtype;

public interface FeedTypeDao extends BaseDao<ZyNewsfeedtype, Integer>{
	//public List<ZyNewsfeedtype> getFeedTypeBySetting(String setting);
	public List<ZyNewsfeedtype> getFeedTypeByHandles(String handle);
}
