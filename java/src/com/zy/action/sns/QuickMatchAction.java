package com.zy.action.sns;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.facade.ProfileFacade;
import com.zy.facade.RequestFacade;
import com.zy.facade.SearchFacade;

public class QuickMatchAction extends ActionSupport{
	private int startAge = 20;
	private int endAge = 25;
	private short gender;
	private String keyword;
	private int pageNo;
	private SearchFacade searchFacade;
	private ProfileFacade profileFacade;
	private RequestFacade requestFacade;
	private int friendId;
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public RequestFacade getRequestFacade() {
		return requestFacade;
	}
	public void setRequestFacade(RequestFacade requestFacade) {
		this.requestFacade = requestFacade;
	}
	public int getStartAge() {
		return startAge;
	}
	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}
	public int getEndAge() {
		return endAge;
	}
	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}
	public short getGender() {
		return gender;
	}
	public void setGender(short gender) {
		this.gender = gender;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}
	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	private List<ZyProfile> profileList;
	

	public SearchFacade getSearchFacade() {
		return searchFacade;
	}
	public void setSearchFacade(SearchFacade searchFacade) {
		this.searchFacade = searchFacade;
	}
	public List<ZyProfile> getProfileList() {
		return profileList;
	}
	public void setProfileList(List<ZyProfile> profileList) {
		this.profileList = profileList;
	}


	public String execute() {
		ActionUtil.getSession().remove("matchPageNo");
		return "match.search";
	}
	
	public String addMatchProfile(){
		requestFacade.sendRequest_tx(ActionUtil.getSessionUserId(),friendId,(short)1,0, "看过你的资料很感兴趣，可以认识一下吗", null);
		return NONE;
	}
}
