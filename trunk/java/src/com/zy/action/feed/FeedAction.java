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
		feeds = feedFacade.getNewsFeed(str,null,1,10);
		return "member.feeds";
	}
	
}
