package com.zy.domain.feed.bean;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyPhoto;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.facade.vo.OptionVO;

public class FeedBean {
	private ZyNewsfeed feed;
	private List<CommentBean> comments;
	private ZyEvent event;
	private ZyProfile user;
	private ZyProfile friend;
	private ZyPhoto photo;
	private ZyNewsfeed oldFeed;
	private ZyQuestion question;
	private List<OptionVO> options;
	//private ZyProfile oldUser;
	
	private ZyProfile atuser;
	
	private int lastFeedId;
	private int nextFeedId;
	
	private List<AtFeedBean> atfeeds;
	
	private List<ZyProfile> atusers;
	
	
	public List<ZyProfile> getAtusers() {
		return atusers;
	}
	public void setAtusers(List<ZyProfile> atusers) {
		this.atusers = atusers;
	}
	public List<AtFeedBean> getAtfeeds() {
		return atfeeds;
	}
	public void setAtfeeds(List<AtFeedBean> atfeeds) {
		this.atfeeds = atfeeds;
	}
	public int getLastFeedId() {
		return lastFeedId;
	}
	public void setLastFeedId(int lastFeedId) {
		this.lastFeedId = lastFeedId;
	}
	public int getNextFeedId() {
		return nextFeedId;
	}
	public void setNextFeedId(int nextFeedId) {
		this.nextFeedId = nextFeedId;
	}
	public ZyProfile getAtuser() {
		return atuser;
	}
	public void setAtuser(ZyProfile atuser) {
		this.atuser = atuser;
	}
	public ZyQuestion getQuestion() {
		return question;
	}
	public List<OptionVO> getOptions() {
		return options;
	}
	public void setQuestion(ZyQuestion question) {
		this.question = question;
	}
	public void setOptions(List<OptionVO> options) {
		this.options = options;
	}
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
