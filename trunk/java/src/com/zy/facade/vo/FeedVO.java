package com.zy.facade.vo;

import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyPhoto;

public class FeedVO {
	private ZyNewsfeed feed;
	private ZyPhoto photo;

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
