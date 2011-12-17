package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.Constants;
import com.zy.common.model.ZyNewsfeed;
import com.zy.domain.event.service.EventService;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.domain.feed.service.FeedService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.facade.FeedFacade;

public class FeedFacadeImpl implements FeedFacade{
	private FeedService feedService;
	private EventService eventService;
	private ProfileService profileService;
	
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public FeedService getFeedService() {
		return feedService;
	}

	public void setFeedService(FeedService feedService) {
		this.feedService = feedService;
	}

	public void addNewFriendNewsFeed(int userId,int friendId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setHandle(Constants.SNS_SHARE_CONNECTION);
		feed.setBody("" + friendId); // do by you
		feed.setCreated(new Date());
		feedService.addNewsFeed(feed);
	}
	
	public void addNewPhotoNewsFeed(int userId,int photoId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.share.photo");
		feed.setBody(""+photoId);
		feedService.addNewsFeed(feed);
	}
	
	public void addNewEventNewsFeed(int userId,int enentId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.event.create");
		feed.setBody(""+enentId);
		feedService.addNewsFeed(feed);
	}
	
	public FeedBean addNewBlogNewsFeed(int userId,String message){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.publish.text");
		feed.setBody(message);
		feedService.addNewsFeed(feed);
		
		FeedBean bean = new FeedBean();
		bean.setFeed(feed);
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		return bean;
	}
	
	public void addAcceptEventInviteNewsFeed(int userId,int eventId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feedService.addNewsFeed(feed);
	}
	
	public void addNewQuestionNewsFeed(int userId,int questionId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feedService.addNewsFeed(feed);
	}
	
	public void addNewAnswerNewsFeed(int userId,int answerId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feedService.addNewsFeed(feed);
	}
	
	public List<FeedBean> getNewsFeed(String ids,String handles,int pageNo,int pageSize){
		List<FeedBean> results = new ArrayList<FeedBean>();
		List<ZyNewsfeed> feeds = feedService.getNewsFeed(ids, handles, pageNo, pageSize);
		for(int i=0;i<feeds.size();i++){
			FeedBean bean = new FeedBean();
			bean.setFeed(feeds.get(i));
			bean.setUser(profileService.findProfileById(feeds.get(i).getUserid()));
			//new event feed
			if(feeds.get(i).getHandle().equals("sns.event.create")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setEvent(eventService.getEvent(id));
				System.out.println(bean.getEvent().getEventname());
			}
			
			//add new friend
			if(feeds.get(i).getHandle().equals("sns.share.connection")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setFriend(profileService.findProfileById(id));
			}
			results.add(bean);
		}
		return results;
	}
}
