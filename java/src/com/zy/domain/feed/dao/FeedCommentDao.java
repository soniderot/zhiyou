package com.zy.domain.feed.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyNewsfeedcomment;

public interface FeedCommentDao extends BaseDao<ZyNewsfeedcomment,Integer>{
	public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId);
    public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId,int pageNo,int pageSize);
    public int getCntCommentsByFeedId(int feedId);
}
