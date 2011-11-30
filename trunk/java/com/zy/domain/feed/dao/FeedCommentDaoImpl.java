package com.zy.domain.feed.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyNewsfeedcomment;

public class FeedCommentDaoImpl extends HibernateDao<ZyNewsfeedcomment, Integer> implements FeedCommentDao{
	@Override
	public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId) {
		String hql = "from ZyNewsfeedcomment where newsfeedid=? and content <> ''";
		return this.find(hql, new Object[] { feedId });
	}

	@Override
	public int getCntCommentsByFeedId(int feedId) {
		String hql = "select count(*) from ZyNewsfeedcomment where newsfeedid=? and content <> '' ";
		return this.getTotalRows(hql, new Object[] { feedId });
	}

	@Override
	public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId, int pageNo, int pageSize) {
		String hql = "from ZyNewsfeedcomment where newsfeedid=? and content <> '' ";
		return this.loadByPagenation(hql, pageNo, pageSize, new Object[] { feedId });
	}
}
