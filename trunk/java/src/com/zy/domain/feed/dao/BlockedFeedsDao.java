package com.zy.domain.feed.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyBlockedfeeds;

public interface BlockedFeedsDao extends BaseDao<ZyBlockedfeeds, Integer>{
	public List<ZyBlockedfeeds> getBlockedFeedsByUser(Integer userId);
}
