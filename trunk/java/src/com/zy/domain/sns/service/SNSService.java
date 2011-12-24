package com.zy.domain.sns.service;
import java.util.List;

import com.zy.common.exception.GraphIsInitializingException;
import com.zy.common.model.ZyFollow;
import com.zy.common.model.ZyFriendDetail;
import com.zy.common.model.ZyFriendgroup;
import com.zy.common.model.ZyFriendintroduce;
import com.zy.common.model.ZyProfile;


public interface SNSService {
	
	public void addFriend(int userId,int friendId) throws GraphIsInitializingException;
	
	public void removeFriend(int userId,int friendId) throws GraphIsInitializingException;
	
	public void forwardIntroduction(int rootIntroduceId,int userId,int nextIntroducerId,String message);
	
	public void declineIntroduction(int rootIntroduceId,int userId,String message);
	
	public List<Integer> getAllFriendsInRange(int userId,short degree) ;
	
	public int getAllFriendsCntInRange(int userId,short degree) ;
	
	public int getAllFriendsCntByDegree(int userId,short degree) ;
	
	public List<Integer> getAllFriendsByDegree(int userId,short degree) ;
    
	public List<ZyProfile> getAllFriends(int userId,short degree);
	
	public List<GraphPath> getConnections(int sourceUserId,int targetUserId,boolean shortest) throws GraphIsInitializingException;
	
	public UserNetwork getUserNetwork(int userId) throws GraphIsInitializingException;
	
	public Graph getGraphMap()throws GraphIsInitializingException;
	
	public ZyFriendgroup addSNSGroup(int userId,String groupName) throws Exception;
	
	public void removeSNSGroup(int snsGroupId,int operatorId);
	
	public void manageSNSGroup(int userId,int snsGroupId,int profileIds[],int type);
	
	public void updateSNSGroup(int userId,int snsGroupId,String groupName);
	
	public List<ZyFriendgroup> getFriendGroups(int userId);
	
	//public List<ZyFriendgroup> getFriendGroupsAndCnt(int userId);
	
	public void cleanSnsGroup(int snsGroupId);
	
	public List<ZyFollow> getFollow(int followerId,int pageNo, int pageSize);
	public List<ZyFollow> getFollowMe(int userId,int pageNo, int pageSize);
	
	public void addFollow(int userId,int targetId);
	public void removeFollow(int userId,int targetId);
	
	public void requestNewIntroduce(ZyFriendintroduce introduce);
	
	public List<ZyFriendDetail> get1stFriends(int userId,int pageNo,int pageSize);
	
	//public List<Integer> get1stFriendUserids(int userId,int pageNo,int pageSize);
	
	//public List<ZyFriendDetail> get1stFriendsWithAvatar(int userId, int size, String[] briefKeywords);
	
	public List<ZyFriendDetail> get1stFriends(int userId,Object queryValue,int pageNo,int pageSize,int type);
	
    public List<ZyFriendDetail> get1stFriends(int userId,int pageNo,int pageSize,int sorting);
    //public List<ZyFriendDetail> getMutualFriends(int userId, int targetUserId, int pageNo,int pageSize);
	
	//public List<ZyFriendDetail> get1stFriends(int userId,Object queryValue,int pageNo,int pageSize,int type,int sorting);
	
	public List<ZyProfile> getAllFriends(int userId,int snsGroupId,short degree);
	
	//public boolean checkIfTargetInSNSGroup(int userId,int targetId,int snsGroupId);
	
	public boolean checkIfTargetInSNS(int userId,int targetId,short degree);
	
	public boolean checkIfTargetInSNS(int userId,int targetId);
	
	public short getTargetDegree(int userId,int targetId);
	 
	//public List<ZyFriendintroduce> getIntroduceHis(int rootId);
	
	//public void updateIntroduceHisStatus(int rootId,short status);
	
	public List<ZyProfile> getMutualFriends(int userId,int targetId);
	
	//public int getMutualFriendsCnt(int userId,int targetId);
	
	//public int get1stFriendsCnt(int userId);
	
	//public int get1stFriendsCnt(int userId,Object value,int type);
	
	//public List<ZyFriendintroduce> terminateSameIntroduceReq(ZyFriendintroduce rootIntroduce);
	
	//public String generatePrivateKey(Integer userid, String[] mobile);
	
	//public boolean checkIfSentReqBefore(int userId,int targetUserId);
		
	public boolean checkIfFollow(int userId,int targetUserId);
	//public int getCntFollow(int followerId);
	//public int getCntFollowMe(int userId);

}
