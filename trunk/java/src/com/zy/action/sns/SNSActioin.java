package com.zy.action.sns;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import octazen.addressbook.Contact;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.Constants;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.Page;
import com.zy.facade.EventFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.RequestFacade;
import com.zy.facade.SNSFacade;
import com.zy.facade.SearchFacade;
import com.zy.facade.vo.EventVO;
import com.zy.facade.vo.ProfileVO;
import com.zy.facade.vo.SearchFormVo;
import com.zy.facade.vo.SearchResultVo;
public class SNSActioin extends ActionSupport{
	private int friendId;
	private int[] profileIds;
	private SNSFacade snsFacade;
	private List<Contact> contacts;
	private String emailAddress;
	private String emailPass;
	private List<ZyProfile> profiles;
	private Page page;
	private int pageNo = 1;
	private int pageSize = 10;
	
	
	private List<ZyProfile> friends;
	
	private List<ProfileVO> profilesVO;
	
	
	private int startAge = 20;
	private int endAge = 25;
	
	private SearchFacade searchFacade;
	private ProfileFacade profileFacade;
	
	private String keyword;
	private short gender ;
	
	private ZyProfile profile;
	
	private String flag;
	
	
	private String[] emails;
	private String[] names;
	
	private RequestFacade requestFacade;
	private boolean errorFlag;
	
	private boolean keyWordSearch;
	private boolean runFlag;
	
	private EventFacade eventFacade;
	
	private List<EventVO> events;
	private List<ZyProfile> matchedProfiles;
	
	private int snsGroupId;
	private short degree=1;
	
	private String snsGroupname;
	
	private int cityid;
	private int hometownid;
	private int collegeid;
	private boolean mutualFriend;
	
	private String cityname;
	private String hometownname;
	private String collegename;
	
	private List<ZyProfile> searchProfiles;
	

	public List<ZyProfile> getSearchProfiles() {
		return searchProfiles;
	}

	public void setSearchProfiles(List<ZyProfile> searchProfiles) {
		this.searchProfiles = searchProfiles;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getHometownname() {
		return hometownname;
	}

	public void setHometownname(String hometownname) {
		this.hometownname = hometownname;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getHometownid() {
		return hometownid;
	}

	public void setHometownid(int hometownid) {
		this.hometownid = hometownid;
	}

	public int getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}

	public boolean isMutualFriend() {
		return mutualFriend;
	}

	public void setMutualFriend(boolean mutualFriend) {
		this.mutualFriend = mutualFriend;
	}

	public String getSnsGroupname() {
		return snsGroupname;
	}

	public void setSnsGroupname(String snsGroupname) {
		this.snsGroupname = snsGroupname;
	}

	public short getDegree() {
		return degree;
	}

	public void setDegree(short degree) {
		this.degree = degree;
	}

	public int getSnsGroupId() {
		return snsGroupId;
	}

	public void setSnsGroupId(int snsGroupId) {
		this.snsGroupId = snsGroupId;
	}

	public List<ZyProfile> getMatchedProfiles() {
		return matchedProfiles;
	}

	public void setMatchedProfiles(List<ZyProfile> matchedProfiles) {
		this.matchedProfiles = matchedProfiles;
	}

	public List<EventVO> getEvents() {
		return events;
	}

	public void setEvents(List<EventVO> events) {
		this.events = events;
	}

	public EventFacade getEventFacade() {
		return eventFacade;
	}

	public void setEventFacade(EventFacade eventFacade) {
		this.eventFacade = eventFacade;
	}

	public boolean isRunFlag() {
		return runFlag;
	}

	public void setRunFlag(boolean runFlag) {
		this.runFlag = runFlag;
	}

	public boolean isKeyWordSearch() {
		return keyWordSearch;
	}

	public void setKeyWordSearch(boolean keyWordSearch) {
		this.keyWordSearch = keyWordSearch;
	}

	public boolean isErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public RequestFacade getRequestFacade() {
		return requestFacade;
	}

	public void setRequestFacade(RequestFacade requestFacade) {
		this.requestFacade = requestFacade;
	}

	public String[] getEmails() {
		return emails;
	}

	public String[] getNames() {
		return names;
	}

	public void setEmails(String[] emails) {
		this.emails = emails;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public ZyProfile getProfile() {
		return profile;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
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

	public SearchFacade getSearchFacade() {
		return searchFacade;
	}

	public void setSearchFacade(SearchFacade searchFacade) {
		this.searchFacade = searchFacade;
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

	public List<ProfileVO> getProfilesVO() {
		return profilesVO;
	}

	public void setProfilesVO(List<ProfileVO> profilesVO) {
		this.profilesVO = profilesVO;
	}

	public List<ZyProfile> getFriends() {
		return friends;
	}

	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<ZyProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ZyProfile> profiles) {
		this.profiles = profiles;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailPass() {
		return emailPass;
	}

	public void setEmailPass(String emailPass) {
		this.emailPass = emailPass;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public int[] getProfileIds() {
		return profileIds;
	}

	public void setProfileIds(int[] profileIds) {
		this.profileIds = profileIds;
	}

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	
	//remove friend from sns friends list
	public String removeFriend() {
		snsFacade.removeFriend(ActionUtil.getSessionUserId(), friendId);
		profiles = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),0,(short)1);
		return "to.friends.list";
	}
	
	// user create a new sns group
	public String addSNSGroup() {
		return null;
	}
	
	// user remove a sns group
	public String removeSNSGroup() {
		return null;
	}
	
	// user manage(add/remove) friends in a sns group
	public String addProfiles2SNSGroup() {
		return null;
	}
	
	//manage sns groups 
	public String manageSNSGroup() {
		return null;
	}

	//update sns groups (usually sns group name)
	public String updateSNSGroup() {
		return null;
	}
	
	//invite profiles from addressbook
	public String inviteProfilesInAddressBook() {
		return null;
	}
	
	//invite internal user
	public String inviteProfile() {
		return null;
	}
	
	public String getContactsFromAddressBook() {
		if(emailAddress==null||emailAddress.trim().length()==0||emailPass==null||emailPass.trim().length()==0){
			errorFlag = true;
			return "invite";
		}
		contacts = snsFacade.importAddressBook(ActionUtil.getSessionUserId(), emailAddress, emailPass);
		if(contacts==null||contacts.size()==0){
			errorFlag = true;
			return "invite";
		}
		return "contacts";
	}
	/*
	public void validateGetContactsFromAddressBook(){
		if(emailAddress==null||emailAddress.trim().length()==0){
			addFieldError("emailAddress", "email.required");
		}
		if(emailPass==null||emailPass.trim().length()==0){
			addFieldError("emailPass", "pass.required");
		}
	}*/
	
	public String viewInvitePage() {
		return "invite";
	}
	
	//get peoples you want to know 
	public String listPeopleYouWantKnow() {
		profiles = new ArrayList<ZyProfile>();
		List<Integer> ids = snsFacade.getAllFriendsByDegree(ActionUtil.getSessionUserId(),(short)2);
		for(int i=0;i<ids.size();i++){
			profiles.add(profileFacade.findProfileById(ids.get(i)));
		}
		//profiles = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),0,(short)2);
		if(profiles.size()<50){
			List<ZyProfile> list = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
			profiles.addAll(list);
		}
		
		page = new Page(profiles.size(),pageNo,10,5);
		if(profiles.size()>=pageSize*pageNo){
			profiles = profiles.subList(pageSize*(pageNo-1),pageSize*pageNo);
		}else{
			profiles = profiles.subList(pageSize*(pageNo-1),profiles.size());
		}
		for (int i = 0; i < profiles.size(); i++) {
			System.out.println(profiles.get(i).getUserid() + " : " + profiles.get(i).getUsername());
		}
		
		
		profilesVO = new ArrayList<ProfileVO>();
		for(int i=0;i<profiles.size();i++){
			ProfileVO vo = new ProfileVO();
			if(requestFacade.getRequest(ActionUtil.getSessionUserId(),profiles.get(i).getUserid(), Constants.INVITEFRIEND_REQ)!=null){
				vo.setRequestOutFlag(true);
			}else{
				if(requestFacade.getRequest(profiles.get(i).getUserid(),ActionUtil.getSessionUserId(), Constants.INVITEFRIEND_REQ)!=null){
					vo.setRequestInFlag(true);
				}
			}
			vo.setProfile(profiles.get(i));
			List<ZyProfile> list = snsFacade.getMutualFriends(ActionUtil.getSessionUserId(),profiles.get(i).getUserid());
			vo.setMuFriends(list);
			profilesVO.add(vo);
		}
		
		
		
		return "you.wanttoknow";
	}
	
	//get peoples you may to know
	public String listPeopleYouMayKnow() {
		//if(snsFacade.getAllFriendsByDegree(ActionUtil.getSessionUserId(),(short)1).size()==0){
			//return "you.mayknow";
		//}
		//profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		//return "you.mayknow";
		
		
		profiles = new ArrayList<ZyProfile>();
		List<Integer> ids = snsFacade.getAllFriendsByDegree(ActionUtil.getSessionUserId(),(short)2);
		for(int i=0;i<ids.size();i++){
			profiles.add(profileFacade.findProfileById(ids.get(i)));
		}
		//profiles = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),0,(short)2);
		if(profiles.size()<10){
			List<ZyProfile> list = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
			profiles.addAll(list);
		}
		
		page = new Page(profiles.size(),pageNo,pageSize,5);
		if(profiles.size()>=pageSize*pageNo){
			profiles = profiles.subList(pageSize*(pageNo-1),pageSize*pageNo);
		}else{
			profiles = profiles.subList(pageSize*(pageNo-1),profiles.size());
		}
		for (int i = 0; i < profiles.size(); i++) {
			System.out.println(profiles.get(i).getUserid() + " : " + profiles.get(i).getUsername());
		}
		
		String friendIds = "";
		List<ZyProfile> myFriends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),snsGroupId,(short)1);
		for(int i=0;i<myFriends.size();i++){
			if(i==myFriends.size()-1){
				friendIds = friendIds + myFriends.get(i).getUserid();
			}else{
				friendIds = friendIds + myFriends.get(i).getUserid()+",";
			}
			
		}
		
		if(friendIds.trim().length()>0){
			friendIds = ActionUtil.getSessionUserId()+","+friendIds;
		}
		else{
			friendIds = ActionUtil.getSessionUserId()+"";
		}
		events =eventFacade.getEvents(ActionUtil.getSessionUserId(),friendIds,1,5);
		
		
		matchedProfiles = snsFacade.getMatchedFriends(ActionUtil.getSessionUserId(), 1, 6);
		return "you.mayknow";
	}
	
	public String keyWordSearch(){
		SearchFormVo vo = new SearchFormVo();
		keyWordSearch = true;
		if(keyword!=null&&keyword.trim().length()>0){
			vo.setKeyword(keyword);
			vo.setKeyWordSearch(true);
			List<SearchResultVo> results = searchFacade.getProfilesBySearch_tx(ActionUtil.getSessionUserId(),vo,500);
			searchProfiles = new ArrayList<ZyProfile>();
			for(int i=0;i<results.size();i++){
				searchProfiles.add(profileFacade.findProfileById(results.get(i).getProfileId()));
			}
			
			System.out.println("profiles.size---------------"+searchProfiles.size());
			//profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
			page = new Page(searchProfiles.size(),pageNo,pageSize,5);
			if(searchProfiles.size()>=pageSize*pageNo){
				searchProfiles = searchProfiles.subList(pageSize*(pageNo-1),pageSize*pageNo);
			}else{
				System.out.println("--------------into second search-------------");
				searchProfiles = searchProfiles.subList(pageSize*(pageNo-1),searchProfiles.size());
				//profiles = new ArrayList<ZyProfile>();
				System.out.println("--------------after into second search-------------"+searchProfiles.size());
			}	
			return "search.result";
		}else{
			return "search.result";
		}
	}
	
	public String search(){
		System.out.println("cityname------------"+cityname);
		if(flag==null){
			return "search.result";
		}
		SearchFormVo vo = new SearchFormVo();
		if(cityid>0){
			vo.setCityId(cityid);
		}
		
		if(collegeid>0){
			vo.setSchoolId(collegeid);
		}
		
		if(hometownid>0){
			vo.setHomeId(hometownid);
		}
		
		if(mutualFriend){
			vo.setScope(2);
		}
		
		//vo.setScope(2);
		//vo.setCityId(8843);
		//vo.setSchoolId(2);
		
		
		if(keyword!=null&&keyword.trim().length()>0){
			vo.setKeyword(keyword);
		}
		if(gender>0){
			vo.setGender(gender);
		}
		
		vo.setExclude1d(true);
		
		 DateFormat df = new SimpleDateFormat("yyyyMMdd");
		 System.out.println(df.format(DateUtil.computeBirthDate(25)));
		
		vo.setEnd(df.format(DateUtil.computeBirthDate(startAge)));
		vo.setStart(df.format(DateUtil.computeBirthDate(endAge)));
		//vo.setKeyWordSearch(true);
		List<SearchResultVo> results = new ArrayList<SearchResultVo>();
		
		if(runFlag==true){
			results = searchFacade.getProfilesBySearch_tx(ActionUtil.getSessionUserId(),vo,500);
			ActionUtil.getSession().put("search_results", results);
		}else{
			results = (List<SearchResultVo>)ActionUtil.getSession().get("search_results");
		}
		
		searchProfiles = new ArrayList<ZyProfile>();
		for(int i=0;i<results.size();i++){
			searchProfiles.add(profileFacade.findProfileById(results.get(i).getProfileId()));
		}
		
		//profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		page = new Page(searchProfiles.size(),pageNo,pageSize,5);
		if(searchProfiles.size()>=pageSize*pageNo){
			searchProfiles = searchProfiles.subList(pageSize*(pageNo-1),pageSize*pageNo);
		}else{
			searchProfiles = searchProfiles.subList(pageSize*(pageNo-1),searchProfiles.size());
		}
		
		return "search.result";
	}
	
	public String getFriendsList(){
		profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
		friends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),0,(short)degree);
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		
		int count = friends.size();
		if(friends.size()>=pageSize*pageNo){
			friends = friends.subList(pageSize*(pageNo-1),pageSize*pageNo);
		}else{
			friends = friends.subList(pageSize*(pageNo-1),friends.size());
		}
		page = new Page(count,pageNo,pageSize,5);
		
		if(flag!=null){
			return "feed.friends.list";
		}
		return "friends.list";
	}
	
	public String selectFriendsAjax() {
		System.out.println("-------------------into select ajax-----------");
		HttpServletRequest request = ActionUtil.getRequest();
		String key = request.getParameter("term");
		if (key.length() == 0) {
			return "friends.list.ajax";
		} else if (key.length() == 1) {
			String firstChar = key.substring(0, 1);
			if (!"@".equals(firstChar)) {
				return "friends.list.ajax";
			}
			friends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),0,(short)1);
		} else {
			String firstChar = key.substring(0, 1);
			if (!"@".equals(firstChar)) {
				return "friends.list.ajax";
			}
			key = key.substring(1);
			// get friends by keyword
			//friends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),0,(short)1);
			friends = snsFacade.getFriendsByName(ActionUtil.getSessionUserId(),key.replace("@",""), true);
		}
		System.out.println("---------friends.size-------"+friends.size());
		return "friends.list.ajax";
	}
	
	public String invite() {
		if (emails != null) {
			for (int i = 0; i < emails.length; i ++)
				if (!"".equals(emails[i])) {
					System.out.println("name:" + names[i] + " emails:" + emails[i]);
					snsFacade.inviteUser(ActionUtil.getSessionUserId(), "bill.tian@meta4-group.com", "Bill");
				}
		}
		return "invite.success";
	}
	
	public String createSnsGroup(){
		try{
			snsFacade.addSNSGroup(ActionUtil.getSessionUserId(), snsGroupname);
		}catch(Exception ex){
			
		}
		return "friends.group.create";
	}
	
	public String updatSnsGroup(){
		snsFacade.updateSNSGroup(ActionUtil.getSessionUserId(), snsGroupId, snsGroupname);
    try {
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(snsGroupname);
      out.flush();    
      out.close();    
    } catch (Exception e) {  
      e.printStackTrace();    
    }
		return null;
	}
	
	public String manageSnsGroup(){
		snsFacade.manageSNSGroup(ActionUtil.getSessionUserId(), snsGroupId, profileIds);
		return "friends.group.detail";
	}
	
	public String deleteSnsGroup() {
		return "friends.group.list";
	}
	
	public String newFrdGrp() {
		return "friends.group.new";
	}
}
