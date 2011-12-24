package com.zy.action.sns;
import java.util.ArrayList;
import java.util.List;

import octazen.addressbook.Contact;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.Page;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;
import com.zy.facade.SearchFacade;
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
		return "friends.list";
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
		contacts = snsFacade.importAddressBook(ActionUtil.getSessionUserId(), emailAddress, emailPass);
		return "contacts";
	}
	
	public void validateGetContactsFromAddressBook(){
		if(emailAddress==null||emailAddress.trim().length()==0){
			addFieldError("emailAddress", "email.required");
		}
		if(emailPass==null||emailPass.trim().length()==0){
			addFieldError("emailPass", "pass.required");
		}
	}
	
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
		if(profiles.size()<10){
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
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		return "you.mayknow";
	}
	
	public String search(){
		SearchFormVo vo = new SearchFormVo();
		if(keyword!=null&&keyword.trim().length()>0){
			vo.setKeyword(keyword);
		}
		if(gender>0){
			vo.setGender(gender);
		}
		//vo.setKeyWordSearch(true);
		List<SearchResultVo> results = searchFacade.getProfilesBySearch_tx(ActionUtil.getSessionUserId(),vo,500);
		profiles = new ArrayList<ZyProfile>();
		for(int i=0;i<results.size();i++){
			profiles.add(profileFacade.findProfileById(results.get(i).getProfileId()));
		}
		
		//profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		page = new Page(profiles.size(),pageNo,10,5);
		if(profiles.size()>=pageSize*pageNo){
			profiles = profiles.subList(pageSize*(pageNo-1),pageSize*pageNo);
		}else{
			profiles = profiles.subList(pageSize*(pageNo-1),profiles.size());
		}
		
		return "search.result";
	}
	
	public String getFriendsList(){
		friends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),0,(short)1);
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		return "friends.list";
	}
	
}
