package com.zy.domain.feed.dao;

import java.util.Date;
import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyNewsfeed;

public interface FeedDao extends BaseDao<ZyNewsfeed,Integer>{
	public List<ZyNewsfeed> getNewsFeed(String userids,String handles,int pageNo,int pageSize);
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handles,int pageNo,int pageSize);
	
	public ZyNewsfeed getNewsFeedByHandle(String handle ,int userId);
	//public ZyNewsfeed getNewsFeedByHandle(String handle ,String body,int userId);
	
	public List<ZyNewsfeed> getMyComment(int pageNo,int pageSize, int userId);
	public int getMyCommentCount(int userId);
	
	public List<Integer> getNewsFeed(int userId, String handles);
	
	//public boolean isExist(long remoteid,int userid,short extType);
	
	//public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String content,Date beginDate,Date endDate);
}
