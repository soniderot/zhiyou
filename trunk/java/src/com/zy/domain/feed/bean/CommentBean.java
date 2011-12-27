package com.zy.domain.feed.bean;

import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyProfile;

public class CommentBean {
	private ZyNewsfeedcomment comment;
	private ZyProfile user;
	public ZyNewsfeedcomment getComment() {
		return comment;
	}
	public void setComment(ZyNewsfeedcomment comment) {
		this.comment = comment;
	}
	public ZyProfile getUser() {
		return user;
	}
	public void setUser(ZyProfile user) {
		this.user = user;
	}
}
