package com.zy.action.profile;

import java.util.ArrayList;
import java.util.List;

import com.zy.Constants;
import com.zy.common.model.ZyCity;
import com.zy.common.model.ZyInterest;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRequest;
import com.zy.common.model.ZySchool;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.Page;
import com.zy.common.util.StringUtil;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.facade.EducationFacade;
import com.zy.facade.FeedFacade;
import com.zy.facade.LocationFacade;
import com.zy.facade.OptionFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.RequestFacade;
import com.zy.facade.SNSFacade;

public class ProfileAction {
	private int userid;
	private ProfileFacade profileFacade;
	private RequestFacade requestFacade;
	private OptionFacade optionFacade;
	private LocationFacade locationFacade;
	private EducationFacade educationFacade;
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
	
	private String token;
	
	private boolean requestOutFlag;
	
	private boolean requestInFlag;


	public LocationFacade getLocationFacade() {
		return locationFacade;
	}

	public EducationFacade getEducationFacade() {
		return educationFacade;
	}

	public void setLocationFacade(LocationFacade locationFacade) {
		this.locationFacade = locationFacade;
	}

	public void setEducationFacade(EducationFacade educationFacade) {
		this.educationFacade = educationFacade;
	}

	public OptionFacade getOptionFacade() {
		return optionFacade;
	}

	public void setOptionFacade(OptionFacade optionFacade) {
		this.optionFacade = optionFacade;
	}
	
	public RequestFacade getRequestFacade() {
		return requestFacade;
	}

	public void setRequestFacade(RequestFacade requestFacade) {
		this.requestFacade = requestFacade;
	}

	public boolean isRequestOutFlag() {
		return requestOutFlag;
	}

	public void setRequestOutFlag(boolean requestOutFlag) {
		this.requestOutFlag = requestOutFlag;
	}

	public boolean isRequestInFlag() {
		return requestInFlag;
	}

	public void setRequestInFlag(boolean requestInFlag) {
		this.requestInFlag = requestInFlag;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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
	
	private void setFriendRequestFlag(){
		friends = snsFacade.getAllFriends(userid,0,(short)1);
		if(userid==ActionUtil.getSessionUserId()){
			friendFlag = true;
		}
		
		for(int i=0;i<friends.size();i++){
			if(friends.get(i).getUserid()==ActionUtil.getSessionUserId()){
				friendFlag = true;
				break;
			}
		}
		
		if(friendFlag==true){
			return;
		}
		ZyRequest request = requestFacade.getRequest(ActionUtil.getSessionUserId(),userid,Constants.INVITEFRIEND_REQ);
		if(request!=null){
			this.requestOutFlag = true;
			return;
		}else{
			request = requestFacade.getRequest(userid,ActionUtil.getSessionUserId(),Constants.INVITEFRIEND_REQ);
			if(request!=null){
				this.requestInFlag = true;
			}
			return;
		}
	}

	public String viewProfileInfo_old(){
		profile = profileFacade.findProfileById(userid);
		profile.setHobbyList(getHobbyList(profile.getHobby()));
		friends = snsFacade.getAllFriends(userid,0,(short)1);
		profiles = snsFacade.getProfilesYouMayKnow(userid);
		viewType[1] = "selectedItem open";
		setFriendRequestFlag();
		return "profile.info";
	}
	
	public String viewProfilePhoto(){
		setFriendRequestFlag();
		return "profile.photo";
	}
	
	public String viewProfileInfo(){
		setFriendRequestFlag();
		feeds = feedFacade.getNewsFeed(userid,""+userid,null,pageNo,pageSize);
		profile = profileFacade.findProfileById(userid);
		profile.setHobbyList(getHobbyList(profile.getHobby()));
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		if (profile.getHometownid() != null) {
			ZyCity home = locationFacade.getCity(profile.getHometownid());
			profile.setHometownname(home.getCityname());
		}
		ZySchool school = educationFacade.getSchoolByUser(userid);
		if (school != null) {
			profile.setCollegename(school.getSchoolname());
		}
		viewType[0] = "selectedItem open";
		int count = feedFacade.getNewsFeed(userid,""+userid,null,1,Integer.MAX_VALUE).size();
		page = new Page(count,pageNo,pageSize,5);
		return "profile.feeds";
	}
	
	public String viewProfileFeeds(){
		setFriendRequestFlag();
		feeds = feedFacade.getNewsFeed(userid,""+userid,null,pageNo,pageSize);
		profile = profileFacade.findProfileById(userid);
		profile.setHobbyList(getHobbyList(profile.getHobby()));
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		if (profile.getHometownid() != null) {
			ZyCity home = locationFacade.getCity(profile.getHometownid());
			profile.setHometownname(home.getCityname());
		}
		ZySchool school = educationFacade.getSchoolByUser(userid);
		if (school != null) {
			profile.setCollegename(school.getSchoolname());
		}
		viewType[0] = "selectedItem open";
		int count = feedFacade.getNewsFeed(userid,""+userid,null,1,Integer.MAX_VALUE).size();
		page = new Page(count,pageNo,pageSize,5);
		return "profile.feeds";
	}
	
	public String viewProfileFriends(){
		setFriendRequestFlag();
		profile = profileFacade.findProfileById(userid);
		friends = snsFacade.getAllFriends(userid,0,(short)1);
		
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
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
	
	private List<ZyInterest> getHobbyList(String hobby) {
		List<ZyInterest> hobbies = new ArrayList<ZyInterest>();
		if (!StringUtil.isNull(hobby)) {
			String[] hobbyArr = hobby.split(" ");
			for(int i = 0; i < hobbyArr.length; i++) {
				ZyInterest interest = optionFacade.getInterestById(Integer.parseInt(hobbyArr[i]));
				hobbies.add(interest);
			}
		}
		return hobbies;
	}
}
