package com.zy.facade;

import java.util.List;

import octazen.addressbook.Contact;

import com.zy.common.model.ZyFriend;
import com.zy.common.model.ZyFriendgroup;
import com.zy.common.model.ZyMatchanswer;
import com.zy.common.model.ZyMatchquestion;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRecommfriend;
import com.zy.common.model.ZyRequest;

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
	
	public List<ZyProfile> getProfilesYouMayKnow(int userId);
	
	public String generateInviteLink(int userId);
	
	public void inviteUser(int userId,String friendEmail,String friendName);
	
	public List<ZyRecommfriend> getRecommendUsers(int userId,int pageNo, int pageSize);
	
	public void createRecommendUser(ZyRecommfriend friend);
	
	public int getMatchScore(int userId,int friendId);
	
	public int getMatchScore(int userId,int friendId,int category);
	
	public List<ZyMatchquestion> getQuestions(int categoryId,int pageNo,int pageSize);
	public List<ZyMatchquestion> getQuestionAndAnswer(int userId,int categoryId,int pageNo,int pageSize);
	public ZyMatchanswer getAnswer(int userId,int questionId);
	
	public List<ZyProfile> getPendingMatchProfiles(int userId,int pageNo,int pageSize);
	public List<ZyProfile> getMatchedProfiles(int userId,int pageNo,int pageSize);
	
	public List<ZyProfile> getFriendsByName(int userId,String username,boolean likeFlag);
	
	public List<ZyProfile> getMatchedFriends(int userId,int pageNo,int pageSize);
}
