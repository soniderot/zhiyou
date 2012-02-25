package com.zy.action.search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.LogUtil;
import com.zy.common.util.Page;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;
import com.zy.facade.SearchFacade;
import com.zy.facade.vo.PageListVO;
import com.zy.facade.vo.SearchFormVo;
import com.zy.facade.vo.SearchResultVo;

public class SearchAction {
	private int startAge = 20;
	private int endAge = 40;
	private short gender = 0;
	private short matchgender = 0;
	private String keyword;
	private int pageNo;
	private SearchFacade searchFacade;
	private ProfileFacade profileFacade;
	
	private String flag ;
	private String listFlag;
	//private int pageSize = 10;
	private Page page;
	
	private int profileId;
	private String match;
	private SNSFacade snsFacade;
	
	
	public SNSFacade getSnsFacade() {
		return snsFacade;
	}
	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public short getMatchgender() {
		return gender;
	}
	public void setMatchgender(short matchgender) {
		this.matchgender = matchgender;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getListFlag() {
		return listFlag;
	}
	public void setListFlag(String listFlag) {
		this.listFlag = listFlag;
	}
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
		System.out.println("-----------------into search execute---------");
		profileList = new ArrayList<ZyProfile>();
		if(profileId>0&&!"1".equals(flag)){
			System.out.println("-----------------profile.id---------"+profileId);
			profileList.add(profileFacade.findProfileById(profileId));
			return "match.search.ajax";
		}
		System.out.println("in before search vos.size---------");
		List<SearchResultVo> results = (List<SearchResultVo>)ActionUtil.getRequest().getSession().getAttribute("match_results");
		System.out.println("in search vos.size---------"+results.size());
		int index = 0;
		for(int i=0;results!=null&&i<results.size();i++){
			if(results.get(i).getProfileId()==profileId){
				index = i;
			}
		}
		for(int i=0;results!=null&&i<results.size();i++){
			if(i>index){
				System.out.println("index=="+index);
				System.out.println("newprofileid.i=="+i);
				System.out.println("newprofileid=="+results.get(i).getProfileId());
				profileList.add(profileFacade.findProfileById(results.get(i).getProfileId()));
		
			}
		}
		return "match.search.ajax";
	}
	public String execute_old() {
		//if(flag!=null){
		//	ActionUtil.getSession().remove("matchPageNo");
		//}
		int pageSize = 10;
		SearchFormVo vo = new SearchFormVo();
		
		 DateFormat df = new SimpleDateFormat("yyyyMMdd");
		 System.out.println(df.format(DateUtil.computeBirthDate(25)));
		
		if(gender>0){
			vo.setGender(gender);
		}
		
		if(keyword!=null&&keyword.trim().length()>0&&!keyword.equalsIgnoreCase("输入关键字")){
			vo.setKeyword(keyword);
		}
		
		
		vo.setEnd(df.format(DateUtil.computeBirthDate(startAge)));
		vo.setStart(df.format(DateUtil.computeBirthDate(endAge)));
		vo.setExclude1d(true);
		vo.setExcludeReq(true);
		
		List<SearchResultVo> results = searchFacade.getProfilesBySearch_tx(ActionUtil.getSessionUserId(),vo,2000);
		
		profileList = new ArrayList<ZyProfile>();
		
		if(listFlag!=null){
			for(int i=0;i<results.size()&&i<10;i++){
				
				profileList.add(profileFacade.findProfileById(results.get(i+pageNo*pageSize).getProfileId()));
			}
			return "match.search.results";
		}
		
		if(ActionUtil.getSession().get("matchPageNo")==null){
			for(int i=0;i<results.size()&&i<10;i++){
				if(i+pageNo*pageSize>results.size()){
					ActionUtil.getSession().put("matchPageNo",pageNo);
					break;
				}
				profileList.add(profileFacade.findProfileById(results.get(i+pageNo*pageSize).getProfileId()));
			}
		}
		
		
		/*
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
		*/
		
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
	
	public String search() {
		int pageSize = 12;
		
		if("1".equals(match)){
			int count = snsFacade.getMatchedFriends(ActionUtil.getSessionUserId(), pageNo, Integer.MAX_VALUE).size();
			profileList = snsFacade.getMatchedFriends(ActionUtil.getSessionUserId(), pageNo, pageSize);
			//profileList = new ArrayList<ZyProfile>();
			//for(int i=0;i<100;i++)
			//profileList.add(profileFacade.findProfileById(1));
			page = new Page(count,pageNo,pageSize,5);
			return "match.search.list";
		}
		SearchFormVo vo = new SearchFormVo();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		if (keyword != null && keyword.trim().length() > 0
				&& !keyword.equalsIgnoreCase("输入关键字")) {
			vo.setKeyword(keyword);
		}
//System.out.println("new startAge---------"+startAge);
//System.out.println("new endAge---------"+endAge);
		vo.setEnd(df.format(DateUtil.computeBirthDate(startAge)));
		vo.setStart(df.format(DateUtil.computeBirthDate(endAge)));
		vo.setExclude1d(true);
		vo.setGender(gender);
		vo.setExcludeReq(true);
		//vo.setExcludeReq(true);

		//PageListVO<SearchResultVo> results = searchFacade.getProfilesBySearch(ActionUtil.getSessionUserId(), vo, pageNo,pageSize,2000);

		PageListVO<SearchResultVo> results = null;
		List<SearchResultVo> vos = searchFacade.getProfilesBySearch_tx(ActionUtil.getSessionUserId(), vo,2000);
		
		ActionUtil.getRequest().getSession().setAttribute("match_results", vos);
		
		System.out.println("vos.size---"+vos.size());
		if (vos != null) {
			if (pageNo <= 0)
				pageNo = 1;
			int startRows = (pageNo - 1) * pageSize;
			int endRows = pageNo * pageSize;
			int endIndex = (vos.size() - endRows) > 0 ? endRows : vos.size();
			LogUtil.info("-----api search--pageNo---" + pageNo + "---startRows---" + startRows + "--endIndex---" + endIndex);
			List<SearchResultVo> sublist = vos.subList(startRows, endIndex);
			PageListVO<SearchResultVo> pageList = new PageListVO<SearchResultVo>(sublist, pageNo, pageSize, vos.size());
			results = pageList;
		}
		
		
		//System.out.println("results.list.size----"+results.getList().size());
		profileList = new ArrayList<ZyProfile>();
		page = results.getPage();

		for (int i = 0; i < results.getList().size(); i++) {
			profileList.add(profileFacade.findProfileById(results.getList().get(i).getProfileId()));
		}
		return "match.search.list";
	}
}
