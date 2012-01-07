package com.zy.action.search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SearchFacade;
import com.zy.facade.vo.SearchFormVo;
import com.zy.facade.vo.SearchResultVo;

public class SearchAction {
	private int startAge = 20;
	private int endAge = 25;
	private short gender;
	private String keyword;
	private int pageNo;
	private SearchFacade searchFacade;
	private ProfileFacade profileFacade;
	
	private String flag ;
	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
		if(flag!=null){
			ActionUtil.getSession().remove("matchPageNo");
		}
		int pageSize = 10;
		System.out.println("-----------startAge"+startAge);
		System.out.println("-----------keyword"+keyword);
		System.out.println("--------------into execute----------"+pageNo);
		SearchFormVo vo = new SearchFormVo();
		
		 DateFormat df = new SimpleDateFormat("yyyyMMdd");
		 System.out.println(df.format(DateUtil.computeBirthDate(25)));
		
		if(gender>0){
			vo.setGender(gender);
		}
		
		if(keyword!=null&&keyword.trim().length()>0&&!keyword.equalsIgnoreCase("键入关键字")){
			vo.setKeyword(keyword);
		}
		
		vo.setEnd(df.format(DateUtil.computeBirthDate(startAge)));
		vo.setStart(df.format(DateUtil.computeBirthDate(endAge)));
		vo.setExclude1d(true);
		
		List<SearchResultVo> results = searchFacade.getProfilesBySearch_tx(ActionUtil.getSessionUserId(),vo,2000);
		
		profileList = new ArrayList<ZyProfile>();
		
		if(ActionUtil.getSession().get("matchPageNo")==null){
			for(int i=0;i<results.size()&&i<10;i++){
				if(i+pageNo*pageSize>results.size()){
					ActionUtil.getSession().put("matchPageNo",pageNo);
					break;
				}
				profileList.add(profileFacade.findProfileById(results.get(i+pageNo*pageSize).getProfileId()));
			}
		}
		
		if(ActionUtil.getSession().get("matchPageNo")!=null){
			System.out.println("-------------into---matchpageno---"+ActionUtil.getSession().get("matchPageNo")+"------------size:"+profileList.size());
			if(profileList.size()<=10){
				System.out.println("after------------into---matchpageno---"+ActionUtil.getSession().get("matchPageNo")+"------------size:"+profileList.size());
				int pageNo = Integer.valueOf((Integer)ActionUtil.getSession().get("matchPageNo"));
				System.out.println("page-------"+pageNo);
				for(int i=0;i<results.size()&&i<10;i++){
					Random r = new Random();
					int num = r.nextInt(pageNo-1);
					System.out.println("num-------"+num);
					profileList.add(profileFacade.findProfileById(results.get(i+num*pageSize).getProfileId()));
				}
			}
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
