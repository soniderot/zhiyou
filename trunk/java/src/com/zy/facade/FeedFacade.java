package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyAtfeed;
import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.domain.feed.bean.AtFeedBean;
import com.zy.domain.feed.bean.CommentBean;
import com.zy.domain.feed.bean.FeedBean;

public interface FeedFacade {
	public void addNewFriendNewsFeed(int userId,int friendId);
	
	public FeedBean addNewPhotoNewsFeed(int userId,int photoId);
	
	public void addNewEventNewsFeed(int userId,int enentId);
	
	public FeedBean addNewBlogNewsFeed(int userId,String message);
	
	public void addAcceptEventInviteNewsFeed(int userId,int eventId);
	
	public FeedBean addNewQuestionNewsFeed(int userId,int questionId, String question);
	
	public void addNewAnswerNewsFeed(int userId,int answerId);

	public List<FeedBean> getNewsFeed(int userId, String ids,String handles,int pageNo,int pageSize);
	
	public FeedBean shareNewsFeed_tx(int userId,int feedId, String shareReason);
	
	public void addComment(ZyNewsfeedcomment comment);
	
	public void removeComment(int commentid);
	
	public void removeFeed(int feedId);
	
	public void blockFeed(int feedId, int userId);
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String body);
	
	public List<FeedBean> getEventNewsFeed(String ids,int pageNo,int pageSize);
	
	public FeedBean addNewEventPhotoNewsFeed(int userId,int eventId,int photoId);
	
	public FeedBean addNewEventBlogNewsFeed(int userId,int eventId,String message);
	
	public void updateNewsFeed(ZyNewsfeed feed);
	
	public List<FeedBean> getAtNewsFeed(int atuserId,int pageNo,int pageSize);
	
	public List<ZyNewsfeed> getUnreadAtNewsFeed(int atuserId,int pageNo,int pageSize);
	
	public int getUnreadAtNewsFeedCnt(int atuserId);
	
	public List<CommentBean> getFeedCommentsById (int feedId);
	
	public ZyNewsfeed getFeedById(int feedId);
	
	public List<Integer> getNewsFeed(String handles,String body);
	
	public List<AtFeedBean> getAtFeedsByUserId(int userId,int pageNo,int pageSize);
	
	public List<ZyAtfeed> getUnReadAtFeeds(int userId,int pageNo,int pageSize);
	
	public void readAtFeed_tx(int atfeedId);
	
	public List<ZyEvent> getEventsAndReqs(int userId);
	
	public void addAtFeed(ZyAtfeed atfeed);
	
	public List<AtFeedBean> getAtFeedsByFeedId(int feedId,int pageNo,int pageSize);
}
