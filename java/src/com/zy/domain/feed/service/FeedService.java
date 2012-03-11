package com.zy.domain.feed.service;

import java.util.List;

import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyNewsfeedtype;
import com.zy.domain.feed.bean.FeedBean;

public interface FeedService {
	public void addNewsFeed(ZyNewsfeed feed);
	
	public ZyNewsfeed getFeedById(int id);
	public List<ZyNewsfeedtype> getFeedTypeBySetting(String setting);
	
	public List<ZyNewsfeed> getNewsFeed(int userId, String ids,String handles,int pageNo,int pageSize);
	
	public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId);
	public int getCommentsCountByFeedId(int feedId);
	public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId,int pageNo,int pageSize);
	
	public void addComment(ZyNewsfeedcomment comment);
	
	public List<ZyNewsfeedtype> getFeedTypeByHandles(String handles);
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handles,int pageNo,int pageSize);
	
	public void deleteNewsFeed(int feedId);
	
	public void updateNewsFeed(ZyNewsfeed feed);
	
	//public List<ZyNewsfeed> getMicroblog(int pageNo,int pageSize);
	
	//public int getCntMyMicroblog(int userId);

	//public List<ZyNewsfeed> getMicroblogFav(int pageNo, int pageSize, int userId);
	
	public void removeComment(int commentId);
	
	public void blockFeed(int feedId, int userId);
	
	public List<ZyNewsfeed> getMyComment(int pageNo, int pageSize, int userId);
	public int getMyCommentCount(int userId);
	
	public List<Integer> getNewsFeed(int userId, String handles);
	
	public ZyNewsfeedcomment getNewsfeedComment(int commentid);
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String body);
	
	//public ZyNewsfeed getShareFeed(String handle, int userId);
	//public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String content,Date beginDate,Date endDate);
	
	public List<ZyNewsfeed> getEventNewsFeed(String ids,int pageNo,int pageSize);
	public ZyNewsfeed getFeedByReferenceId(int referenceId);
	
	public List<ZyNewsfeed> getAtNewsFeed(int atuserId,int pageNo,int pageSize);
	
	public List<ZyNewsfeed> getUnreadAtNewsFeed(int atuserId,int pageNo,int pageSize);
	
	public int getUnreadAtNewsFeedCnt(int atuserId);
	
	public List<Integer> getNewsFeed(String handles,String body);
}
