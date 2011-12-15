package com.zy.action.feed;

import java.util.List;

import com.zy.common.util.ActionUtil;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.facade.FeedFacade;
import com.zy.facade.SNSFacade;

public class FeedAction {
	private FeedFacade feedFacade;
	private SNSFacade snsFacade;
	private List<FeedBean> feeds;
	
	private short pageNo = 1;
	private short pageSize = 12;
	
	
	public short getPageNo() {
		return pageNo;
	}

	public void setPageNo(short pageNo) {
		this.pageNo = pageNo;
	}

	public short getPageSize() {
		return pageSize;
	}

	public void setPageSize(short pageSize) {
		this.pageSize = pageSize;
	}

	public List<FeedBean> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<FeedBean> feeds) {
		this.feeds = feeds;
	}

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public String execute(){
		System.out.println("--------------into-------------feed");
		List<Integer> ids = snsFacade.getAllFriendsByDegree(ActionUtil.getSessionUserId(),(short)1);
		ids.add(ActionUtil.getSessionUserId());
		String str = "";
		for(int i=0;i<ids.size();i++){
			if(i!=ids.size()-1){
				str = str+ids.get(i)+",";
			}else{
				str = str+ids.get(i);
			}
		}
		feeds = feedFacade.getNewsFeed(str,null,pageNo,pageSize);
		return "member.feeds";
	}
	
}
