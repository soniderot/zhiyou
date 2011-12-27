package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.Constants;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.domain.event.service.EventService;
import com.zy.domain.feed.bean.CommentBean;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.domain.feed.service.FeedService;
import com.zy.domain.photo.service.PhotoService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.facade.FeedFacade;

public class FeedFacadeImpl implements FeedFacade{
	private FeedService feedService;
	private EventService eventService;
	private ProfileService profileService;
	private PhotoService photoService;
	
	
	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

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
	
	public FeedBean addNewPhotoNewsFeed(int userId,int photoId){
		FeedBean bean = new FeedBean();
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.publish.photo");
		feed.setBody(""+photoId);
		feedService.addNewsFeed(feed);
		bean.setFeed(feed);
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		bean.setPhoto(photoService.getPhoto(photoId));
		return bean;
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
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.event.join");
		feed.setBody(""+eventId);
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
			if(feeds.get(i).getHandle().equals("sns.event.create")||feeds.get(i).getHandle().equals("sns.event.join")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setEvent(eventService.getEvent(id));
				System.out.println(bean.getEvent().getEventname());
			}
			
			//add new friend
			if(feeds.get(i).getHandle().equals("sns.share.connection")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setFriend(profileService.findProfileById(id));
			}
			
			//add new photo
			if(feeds.get(i).getHandle().equals("sns.publish.photo")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setPhoto(photoService.getPhoto(id));
			}
			
			if(feeds.get(i).getHandle().equals("sns.share.text")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setOldFeed(feedService.getFeedById(id));
				bean.setFriend(profileService.findProfileById(feedService.getFeedById(id).getUserid()));
			}
			
			if(feeds.get(i).getHandle().equals("sns.share.photo")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setOldFeed(feedService.getFeedById(id));
				int photoId = Integer.valueOf(feedService.getFeedById(id).getBody());
				bean.setPhoto(photoService.getPhoto(photoId));
				bean.setFriend(profileService.findProfileById(feedService.getFeedById(id).getUserid()));
			}
			
			List<ZyNewsfeedcomment> comments = feedService.getCommentsByFeedId(bean.getFeed().getId());
			List<CommentBean> commentBeans = new ArrayList<CommentBean>();
			for(int j=0;j<comments.size();j++){
				CommentBean commentBean = new CommentBean();
				commentBean.setComment(comments.get(j));
				commentBean.setUser(profileService.findProfileById(comments.get(j).getUserid()));
				commentBeans.add(commentBean);
			}
			bean.setComments(commentBeans);
			results.add(bean);
		}
		return results;
	}
	
	public FeedBean shareNewsFeed_tx(int userId,int feedId){
		ZyNewsfeed oldFeed = feedService.getFeedById(feedId);
		FeedBean bean = new FeedBean();
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		if("sns.publish.text".equalsIgnoreCase(oldFeed.getHandle())){
			feed.setHandle("sns.share.text");
		}
		if("sns.publish.photo".equalsIgnoreCase(oldFeed.getHandle())){
			feed.setHandle("sns.share.photo");
		}
		
		
		feed.setBody(""+feedId);
		feedService.addNewsFeed(feed);
		bean.setFeed(feed);
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		bean.setOldFeed(feedService.getFeedById(feedId));
		return bean;
	}
	
	public void addComment(ZyNewsfeedcomment comment){
		feedService.addComment(comment);
	}
	
	public void removeComment(int userid,int commentid){
		feedService.removeComment(commentid);
	}
}
