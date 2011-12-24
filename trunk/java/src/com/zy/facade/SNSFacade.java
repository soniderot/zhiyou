package com.zy.facade;

import java.util.List;

import octazen.addressbook.Contact;

import com.zy.common.model.ZyFriendgroup;
import com.zy.common.model.ZyProfile;

public interface SNSFacade {
	public void addFriend(int userId,int friendId);
	
	public void removeFriend(int userId,int friendId);
	
	public List<ZyFriendgroup> getFriendGroups(int userId);
	
	//get friend id by degreee
	public List<Integer> getAllFriendsByDegree(int userId,short degree);
	
	public ZyFriendgroup addSNSGroup(int userId,String groupName) throws Exception;
	
	public void removeSNSGroup(int ZyGroupId,int operatorId);
	
	/**
	 *manage Zy group type 0:add type 1:remove
	 */
	public void manageSNSGroup(int userId,int ZyGroupId,int profileIds[],int type);
	
	public List<ZyProfile> getAllFriends(int userId,int ZyGroupId,short degree);
	
	public List<ZyProfile> getMutualFriends(int userId,int targetId);
	
	public void updateSNSGroup(int userId,int snsGroupId,String groupName);
	
	public List<Contact> importAddressBook(int userId, String email, String password);
	
	public List<ZyProfile> getProfilesYouMayKnow(long userId);
}
