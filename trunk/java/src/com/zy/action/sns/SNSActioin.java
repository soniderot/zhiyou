package com.zy.action.sns;
import com.zy.common.util.ActionUtil;
import com.zy.facade.SNSFacade;
public class SNSActioin {
	private int friendId;
	private int[] profileIds;
	private SNSFacade snsFacade;
	
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
		return null;
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
	
	private String getContactsFromAddressBook() {
		return null;
	}
	
	//get peoples you want to know 
	public String listPeopleYouMayWantKnow() {
		return null;
	}
	
	//get peoples you may to know
	public String listPeopleYouMayKnow() {
		return null;
	}
	
}
