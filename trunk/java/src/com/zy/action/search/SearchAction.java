package com.zy.action.search;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SearchFacade;
import com.zy.facade.vo.SearchFormVo;
import com.zy.facade.vo.SearchResultVo;

public class SearchAction {
	private int ageFrom = 20;
	private int ageTo = 25;
	private short gender;
	private int highSchoolId;
	private int pageNo;
	private SearchFacade searchFacade;
	private ProfileFacade profileFacade;
	
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}
	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}
	public int getAgeFrom() {
		return ageFrom;
	}
	public int getAgeTo() {
		return ageTo;
	}
	public short getGender() {
		return gender;
	}
	public int getHighSchoolId() {
		return highSchoolId;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}
	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}
	public void setGender(short gender) {
		this.gender = gender;
	}
	public void setHighSchoolId(int highSchoolId) {
		this.highSchoolId = highSchoolId;
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
		System.out.println("--------------into execute----------"+pageNo);
		SearchFormVo vo = new SearchFormVo();
		vo.setGender((short)1);
		List<SearchResultVo> results = searchFacade.getProfilesBySearch_tx(ActionUtil.getSessionUserId(),vo,500);
		profileList = new ArrayList<ZyProfile>();
		for(int i=0;i<results.size();i++){
			profileList.add(profileFacade.findProfileById(results.get(i).getProfileId()));
		}
		/*
		profileList = new ArrayList();
		Profile profile1 = new Profile();
		profile1.setUsername("aaa");
		profile1.setCountryname("bbb");
		profileList.add(profile1);
		Profile profile2 = new Profile();
		profile2.setUsername("ccc");
		profile2.setCountryname("ddd");
		profileList.add(profile2);*/
		return "match.search.ajax";
	}
}
