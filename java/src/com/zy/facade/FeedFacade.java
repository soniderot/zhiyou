package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.domain.feed.bean.FeedBean;

public interface FeedFacade {
	public void addNewFriendNewsFeed(int userId,int friendId);
	
	public FeedBean addNewPhotoNewsFeed(int userId,int photoId);
	
	public void addNewEventNewsFeed(int userId,int enentId);
	
	public FeedBean addNewBlogNewsFeed(int userId,String message);
	
	public void addAcceptEventInviteNewsFeed(int userId,int eventId);
	
	public void addNewQuestionNewsFeed(int userId,int questionId);
	
	public void addNewAnswerNewsFeed(int userId,int answerId);

	public List<FeedBean> getNewsFeed(String ids,String handles,int pageNo,int pageSize);
	
	public FeedBean shareNewsFeed(int userId,int feedId);
	
	public void addComment(ZyNewsfeedcomment comment);
}
