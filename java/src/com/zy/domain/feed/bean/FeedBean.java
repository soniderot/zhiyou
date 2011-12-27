package com.zy.domain.feed.bean;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyPhoto;
import com.zy.common.model.ZyProfile;

public class FeedBean {
	private ZyNewsfeed feed;
	private List<CommentBean> comments;
	private ZyEvent event;
	private ZyProfile user;
	private ZyProfile friend;
	private ZyPhoto photo;
	private ZyNewsfeed oldFeed;
	//private ZyProfile oldUser;
	
	
	public ZyNewsfeed getOldFeed() {
		return oldFeed;
	}
	public void setOldFeed(ZyNewsfeed oldFeed) {
		this.oldFeed = oldFeed;
	}
	public ZyPhoto getPhoto() {
		return photo;
	}
	public void setPhoto(ZyPhoto photo) {
		this.photo = photo;
	}
	public ZyProfile getUser() {
		return user;
	}
	public void setUser(ZyProfile user) {
		this.user = user;
	}
	public ZyProfile getFriend() {
		return friend;
	}
	public void setFriend(ZyProfile friend) {
		this.friend = friend;
	}
	public ZyNewsfeed getFeed() {
		return feed;
	}
	public void setFeed(ZyNewsfeed feed) {
		this.feed = feed;
	}
	
	
	public List<CommentBean> getComments() {
		return comments;
	}
	public void setComments(List<CommentBean> comments) {
		this.comments = comments;
	}
	public ZyEvent getEvent() {
		return event;
	}
	public void setEvent(ZyEvent event) {
		this.event = event;
	}
	
}
