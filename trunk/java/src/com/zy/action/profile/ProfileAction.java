package com.zy.action.profile;

import java.util.List;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.Page;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.facade.FeedFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;

public class ProfileAction {
	private int userid;
	private ProfileFacade profileFacade;
	private ZyProfile profile;
	private List<ZyProfile> friends;
	private List<ZyProfile> profiles;
	private SNSFacade snsFacade;
	private List<FeedBean> feeds;
	private int pageNo = 1;
	private int pageSize = 10;
	
	private FeedFacade feedFacade;
	private Page page;
	
	private String[] viewType = new String[]{"","","",""};
	
	private boolean friendFlag;

	public boolean isFriendFlag() {
		return friendFlag;
	}

	public void setFriendFlag(boolean friendFlag) {
		this.friendFlag = friendFlag;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String[] getViewType() {
		return viewType;
	}

	public void setViewType(String[] viewType) {
		this.viewType = viewType;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
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

	public List<ZyProfile> getFriends() {
		return friends;
	}

	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
	}

	public List<ZyProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ZyProfile> profiles) {
		this.profiles = profiles;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public ZyProfile getProfile() {
		return profile;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String viewProfileInfo(){
		profile = profileFacade.findProfileById(userid);
		friends = snsFacade.getAllFriends(userid,0,(short)1);
		
		profiles = snsFacade.getProfilesYouMayKnow(userid);
		viewType[1] = "selectedItem open";
		
		if(userid==ActionUtil.getSessionUserId()){
			friendFlag = true;
		}
		
		for(int i=0;i<friends.size();i++){
			if(friends.get(i).getUserid()==ActionUtil.getSessionUserId()){
				friendFlag = true;
				break;
			}
		}
		
		return "profile.info";
	}
	
	public String viewProfilePhoto(){
		return "profile.photo";
	}
	
	public String viewProfileFeeds(){
		feeds = feedFacade.getNewsFeed(""+userid,null,pageNo,pageSize);
		profile = profileFacade.findProfileById(userid);
		profiles = snsFacade.getProfilesYouMayKnow(userid);
		viewType[0] = "selectedItem open";
		int count = feedFacade.getNewsFeed(""+userid,null,1,Integer.MAX_VALUE).size();
		page = new Page(count,pageNo,10,5);
		return "profile.feeds";
	}
	
	public String viewProfileFriends(){
		profile = profileFacade.findProfileById(userid);
		friends = snsFacade.getAllFriends(userid,0,(short)1);
		
		profiles = snsFacade.getProfilesYouMayKnow(userid);
		viewType[3] = "selectedItem open";
		
		int count = friends.size();
		if(friends.size()>=pageSize*pageNo){
			friends = friends.subList(pageSize*(pageNo-1),pageSize*pageNo);
		}else{
			friends = friends.subList(pageSize*(pageNo-1),friends.size());
		}
		page = new Page(count,pageNo,pageSize,5);
		
		return "profile.friends";
	}
}
