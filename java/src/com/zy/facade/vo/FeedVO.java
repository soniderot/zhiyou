package com.zy.facade.vo;

import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyPhoto;

public class FeedVO {
	private ZyNewsfeed feed;
	private ZyPhoto photo;
	private int lastFeedId;
	private int nextFeedId;
	

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
	public ZyNewsfeed getFeed() {
		return feed;
	}
	public void setFeed(ZyNewsfeed feed) {
		this.feed = feed;
	}
	public ZyPhoto getPhoto() {
		return photo;
	}
	public void setPhoto(ZyPhoto photo) {
		this.photo = photo;
	}
}
