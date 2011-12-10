package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.List;

import octazen.addressbook.Contact;

import com.zy.common.model.ZyFriendgroup;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ImportAddressUtil;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.sns.service.SNSService;
import com.zy.facade.SNSFacade;

public class SNSFacadeImpl implements SNSFacade{
	private SNSService snsService;
	private ProfileService profileService;
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public SNSService getSnsService() {
		return snsService;
	}

	public void setSnsService(SNSService snsService) {
		this.snsService = snsService;
	}

	public void addFriend(int userId,int friendId){
		try {
			if(userId == friendId){
				return;
			}
			snsService.addFriend(userId, friendId);
			
			//to do 
			//send email to notify friend;
			//call notification serverice;
			//call feedservice to add news feed
			//call mailqueue serverice;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void removeFriend(int userId,int friendId){
		try{
			snsService.removeFriend(userId, friendId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public List<ZyFriendgroup> getFriendGroups(int userId){
		return snsService.getFriendGroups(userId);
	}
	
	public List<Integer> getAllFriendsByDegree(int userId,short degree){
		return snsService.getAllFriendsByDegree(userId,degree);
	}
	
	public ZyFriendgroup addSNSGroup(int userId,String groupName) throws Exception{
		return snsService.addSNSGroup(userId, groupName);
	}
	
	public void removeSNSGroup(int zyGroupId,int operatorId){
		snsService.removeSNSGroup(zyGroupId,operatorId);
	}
	
	/**
	 *manage Zy group type 0:add type 1:remove
	 */
	public void manageSNSGroup(int userId,int zyGroupId,int profileIds[],int type){
		snsService.manageSNSGroup(userId,zyGroupId, profileIds, type);
	}
	
	public List<ZyProfile> getAllFriends(int userId,int zyGroupId,short degree){
		return snsService.getAllFriends(userId, zyGroupId, degree);
	}
	
	public List<ZyProfile> getMutualFriends(int userId,int targetId){
		return snsService.getMutualFriends(userId, targetId);
	}
	
	//change sns groupname
	public void updateSNSGroup(int userId,int snsGroupId,String groupName){
		snsService.updateSNSGroup(userId, snsGroupId, groupName);
	}
	
	public List<Contact> importAddressBook(int userId, String email, String password){
		List<Contact> list = new ArrayList<Contact>();
		
		if(true){
			//list.add(new Contact("abc","abc@sina.com"));
			
			//return list;
		}
		try {
			// list = SimpleAddressBookImporter.fetchContacts(email, password);
			list = ImportAddressUtil.importAddress(email, password);
			for (int i = 0; list != null && i < list.size(); i++) {
				if (list.get(i).getEmail().equalsIgnoreCase(email)) {
					list.remove(i);
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		/*
		removeExistedEmails(userId, Constants.InviteType.INVITE_BY_ADDRESSBOOK
				.getInviteType(), list);*/
		// List<Profile> profiles =
		// getProfilesFromAddressBook(userId,email,password);
		return list;
	}
	
	public List<ZyProfile> getProfilesYouMayKnow(long userId){
		List<ZyProfile> list = new ArrayList<ZyProfile>();
		for(int i=0;i<20;i++){
		list.add(profileService.findProfileById(2));
		list.add(profileService.findProfileById(3));
		}
		return list;
	}
}
