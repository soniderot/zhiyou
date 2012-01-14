package com.zy.domain.sns.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.zy.Constants;
import com.zy.common.exception.GraphIsInitializingException;
import com.zy.common.model.ZyFollow;
import com.zy.common.model.ZyFriend;
import com.zy.common.model.ZyFriendDetail;
import com.zy.common.model.ZyFriendgroup;
import com.zy.common.model.ZyFriendintroduce;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRecommfriend;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.sns.dao.FollowDao;
import com.zy.domain.sns.dao.FriendDao;
import com.zy.domain.sns.dao.InviteByAddressDao;
import com.zy.domain.sns.dao.RecommendUserDao;
import com.zy.domain.sns.dao.SNSGroupDao;
import com.zy.domain.sns.dao.SNSIntroduceDao;

public class SNSServiceImpl implements SNSService{
	private FriendDao friendDao;
	
	
	private SNSGroupDao snsGroupDao;
	private FollowDao zyFollowDao;
	private SNSIntroduceDao zyIntroduceDao;
	private ProfileService profileService;
	private InviteByAddressDao inviteByAddressDao;
	private RecommendUserDao recommendUserDao;
	
	
	static{
		try{
			GraphSingleton.getInstance();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public FriendDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	public SNSGroupDao getSnsGroupDao() {
		return snsGroupDao;
	}

	public void setSnsGroupDao(SNSGroupDao snsGroupDao) {
		this.snsGroupDao = snsGroupDao;
	}


	public FollowDao getZyFollowDao() {
		return zyFollowDao;
	}

	public void setZyFollowDao(FollowDao zyFollowDao) {
		this.zyFollowDao = zyFollowDao;
	}

	public SNSIntroduceDao getZyIntroduceDao() {
		return zyIntroduceDao;
	}

	public void setZyIntroduceDao(SNSIntroduceDao zyIntroduceDao) {
		this.zyIntroduceDao = zyIntroduceDao;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public InviteByAddressDao getInviteByAddressDao() {
		return inviteByAddressDao;
	}

	public void setInviteByAddressDao(InviteByAddressDao inviteByAddressDao) {
		this.inviteByAddressDao = inviteByAddressDao;
	}

	/**
	 * add friend into table and graph
	 */
	public void addFriend(int userId,int friendId) throws GraphIsInitializingException{
		System.out.println("--------------------------------------");
		
		//friendDao.getFriends(userId, friendId);
		//friendDao.getFriends(userId, friendId);
		
		if(friendDao.getFriends(userId, friendId).size()>0){
			return;
		}
		
		ZyFriend ZyFriend1 = new ZyFriend(userId,friendId,0,new java.util.Date());
		friendDao.save(ZyFriend1);
		ZyFriend ZyFriend2 = new ZyFriend(friendId,userId,0,new java.util.Date());
		friendDao.save(ZyFriend2);
		Graph newGraph = GraphSingleton.getInstance().getGraph();
		newGraph.addNode(new GraphNode(userId,new java.util.Date()));
        newGraph.addNode(new GraphNode(friendId,new java.util.Date()));
        newGraph.addEdge(userId,friendId); 
	}
	
	/**
	 * remove friend from friend table and graph
	 */
	public void removeFriend(int userId,int friendId) throws GraphIsInitializingException{
		if(friendDao.getFriends(userId, friendId).size()==0){
			return;
		}
		friendDao.deleteAll(friendDao.getFriends(userId, friendId));
		Graph newGraph = GraphSingleton.getInstance().getGraph();
		//newGraph.deleteNode(userId);
		//newGraph.deleteNode(friendId);
        newGraph.deleteEdge(userId,friendId); 
	}
	
	
	/**
	 * 
	 */
	public void requestNewIntroduce(ZyFriendintroduce introduce){
		if(checkIfTargetInSNS(introduce.getUserid().intValue(),introduce.getTargetid().intValue(),(short)1)){
			return;
		}
		introduce.setStatus(Constants.SNS_INTRODUCE_PENDING);
		introduce.setCreatetime(new Date());
		zyIntroduceDao.save(introduce);
	}
	
	/**
	 * 
	 */
	public void forwardIntroduction(int rootIntroduceId,int userId,int nextIntroducerId,String message){
		//change previous introduces status
		ZyFriendintroduce introduce =zyIntroduceDao.load(rootIntroduceId);
		introduce.setStatus(Constants.SNS_INTRODUCE_FORWARED);
		
	}
	
	/**
	 * 
	 */
	public void declineIntroduction(int rootIntroduceId,int userId,String message){
		ZyFriendintroduce introduce =zyIntroduceDao.load(rootIntroduceId);
		introduce.setStatus(Constants.SNS_INTRODUCE_DECLINED);
	}
	
	/**
	 * get friendid from graph
	 */
	public List<Integer> getAllFriendsInRange(int userId,short degree){
		try{
			//System.out.println("start=="+new java.util.Date().getTime());
			UserNetwork userNetwork = new UserNetwork(userId,GraphSingleton.getInstance().getGraph(),degree);
			//System.out.println("---"+userNetwork.getFriendsByDegree((short)1).size());
			//System.out.println("end=="+new java.util.Date().getTime());
			ArrayList<Integer> results = new ArrayList<Integer>();
			
			for(short i=1;i<=degree&&i<=Graph.DEFAULT_MAX_DEPTH;i++){
				results.addAll(userNetwork.getFriendsByDegree(i));	
			}
			//System.out.println("end2=="+new java.util.Date());
			//return userNetwork.getFriendsByDegree(degree);
			return results;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ArrayList<Integer>();
	}
	
	
	public int getAllFriendsCntInRange(int userId,short degree){
		return getAllFriendsInRange(userId,degree).size();
	}
	
	public int getAllFriendsCntByDegree(int userId,short degree){
		return getAllFriendsByDegree(userId,degree).size();
	}
	
	public List<Integer> getAllFriendsByDegree(int userId,short degree){
		try{
			UserNetwork userNetwork = new UserNetwork(userId,GraphSingleton.getInstance().getGraph(),degree);
			//System.out.println(userNetwork.getFriendsByDegree(degree).size());
			
			return userNetwork.getFriendsByDegree(degree);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ArrayList<Integer>();
	}
	

	public List<ZyProfile> getAllFriends(int userId,short degree){
		List<ZyProfile> profiles = new ArrayList<ZyProfile>();
		try{
			List<Integer> list = getAllFriendsInRange(userId,degree);
			for(int i=0;list!=null&&i<list.size();i++){
				profiles.add(profileService.findProfileById(list.get(i)));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return profiles;
	}
	

	/**
	 * wrap friendid into profile
	 */
	public List<ZyProfile> getAllFriends(int userId,int ZyGroupId,short degree){
		List<ZyProfile> profiles = new ArrayList<ZyProfile>();
		try{
			List<Integer> list = getAllFriendsInRange(userId,degree);
			for(int i=0;list!=null&&i<list.size();i++){
				try{
						if(ZyGroupId<=0){
							profiles.add(profileService.findProfileById(list.get(i)));
						}
						else if(new Integer(ZyGroupId).equals(friendDao.load(userId,list.get(i)).getGroupid())){
							profiles.add(profileService.findProfileById(list.get(i)));
						}
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return profiles;
	}
	
	/**
	 * 
	 */
	public boolean checkIfTargetInZyGroup(int userId,int targetId,int ZyGroupId){
		boolean result = false;
		try{
			List<Integer> list = getAllFriendsInRange(userId,(short)1);
			if(!list.contains(targetId)){
				return false;
			}
			for(int i=0;list!=null&&i<list.size();i++){
					if(new Integer(ZyGroupId).equals(friendDao.load(userId,list.get(i)).getGroupid())){
						if(targetId==list.get(i)){
							return true;
						}
					}		
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	/**
	 * get connnections to target
	 */

	public List<GraphPath> getConnections(int sourceUserId,int targetUserId,boolean shortest) throws GraphIsInitializingException{
		UserNetwork userNetwork = new UserNetwork(sourceUserId,GraphSingleton.getInstance().getGraph(),Graph.DEFAULT_MAX_DEPTH);
		List<GraphPath> list = userNetwork.getConnections(targetUserId).getShortestPaths();
		/*
		for(int i=0;list!=null&&i<list.size();i++){
			GraphPath path = list.get(i);
			System.out.println("path.lenght=="+path.size());
			for(int j=0;j<path.getNodes().size();j++)
			System.out.println(path.getNodes().get(j));
		}*/
		if(shortest==true){
			return userNetwork.getConnections(targetUserId).getShortestPaths();
		}else{
			return userNetwork.getConnections(targetUserId).getPaths();
		}
	}
	
	
	/**
	 * get user network
	 * 
	 */
	public UserNetwork getUserNetwork(int userId) throws GraphIsInitializingException{
		return new UserNetwork(userId,GraphSingleton.getInstance().getGraph(),Graph.DEFAULT_MAX_DEPTH);
	}
	
	/**
	 * get whole graph
	 */
	public Graph getGraphMap() throws GraphIsInitializingException{
		//System.out.println(graph.loadObject().size());
		return GraphSingleton.getInstance().getGraph();
	}
	
	/**
	 * create Zy group
	 */
	public ZyFriendgroup addSNSGroup(int userId,String groupName) throws Exception{
		if(snsGroupDao.getFriendGroup(userId, groupName)!=null){
			throw new Exception("group :"+groupName +" already exist");
		}
		ZyFriendgroup ZyGroup = new ZyFriendgroup(new Integer(userId),groupName,new java.util.Date());
		snsGroupDao.save(ZyGroup);
		return ZyGroup;
	}
	
	/**
	 * remove a Zy group
	 */
	public void removeSNSGroup(int ZyGroupId,int operatorId){
		List<ZyFriend> friends = friendDao.getFriendsByGroupId(ZyGroupId);
		for(int i=0;i<friends.size();i++){
			friends.get(i).setGroupid(null);
		}
		
		snsGroupDao.deleteByKey(ZyGroupId);
	}
	
	/**
	 *manage Zy group type 0:add type 1:remove
	 */
	public void manageSNSGroup(int userId,int ZyGroupId,int profileIds[],int type){
		// check if the ZyGroupId belong to the user
		boolean flag = false;
		List<ZyFriendgroup> groups = this.getFriendGroups(userId);
		for(int i=0;groups!=null&&i<groups.size();i++){
			if(ZyGroupId==groups.get(i).getId()){
				flag = true;
				break;
			}
		}
		if(flag==false) return;

		if(profileIds!=null){
			try{
				UserNetwork userNetwork = new UserNetwork(userId,GraphSingleton.getInstance().getGraph(),Graph.DEFAULT_MAX_DEPTH);
				List<Integer> friendIds = userNetwork.getFriendsByDegree((short)1);
				
				//for(int i=0;i<friendIds.size();i++){
					//System.out.println(friendIds.get(i));
				//}
				for(int i=0;profileIds!=null&&i<profileIds.length;i++){
					
					if(friendIds.contains(new Integer(profileIds[i]))){
						
						ZyFriend friend = friendDao.load(userId, profileIds[i]);
						if(type==0){
							friend.setGroupid(ZyGroupId);
						}
						if(type==1){
							friend.setGroupid(0);
						}
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	
	public List<ZyFriendgroup> getFriendGroups(int userId){
		return snsGroupDao.getFriendGroups(userId);
	}
	
	
	public void cleanSnsGroup(int ZyGroupId){
		List<ZyFriend> friends = friendDao.getFriendsByGroupId(ZyGroupId);
		for(int i=0;friends!=null&&i<friends.size();i++){
			friends.get(i).setGroupid(null);
		}
	}
	
	public void updateSNSGroup(int userId,int ZyGroupId,String groupName){
		snsGroupDao.load(ZyGroupId).setGroupname(groupName);
	}
	
	/**
	 * 
	 */
	public List<ZyFollow> getFollow(int followerId,int pageNo, int pageSize){
		
		return zyFollowDao.getFollow(followerId,pageNo,pageSize);
	}
	
	/**
	 * 
	 */
	public List<ZyFollow> getFollowMe(int userId,int pageNo, int pageSize){
		return zyFollowDao.getFollowMe(userId,pageNo,pageSize);
	
	}
	
	
	public void addFollow(int userId,int targetId){
		List<ZyFollow> list = getFollow(userId,1,Integer.MAX_VALUE);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUserid()==targetId){
				return;
			}
		}
		ZyFollow follower = new ZyFollow(targetId,userId,new Date());
		zyFollowDao.save(follower);
	}
	public void removeFollow(int userId,int targetId){
		List<ZyFollow> list = this.getFollow(userId,1,Integer.MAX_VALUE);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getUserid()==targetId){
					zyFollowDao.delete(list.get(i));
					return;
				}
			}
		}
	}
	
	/**
	 * 
	 */
	public List<ZyFriendDetail> get1stFriends(int userId,int pageNo,int pageSize){
		return get1stFriends(userId,pageNo,pageSize,0);
	}
	
	
	public List<ZyFriendDetail> get1stFriends(int userId,int pageNo,int pageSize,int sorting){
		List<ZyFriendDetail> list = friendDao.get1stFriends(userId, pageNo, pageSize);
		
		for(int i=0;i<list.size();i++){
			try{
			if(list.get(i).getFriend().getGroupid()!=null&&list.get(i).getFriend().getGroupid().intValue()!=0){
				ZyFriendgroup group = snsGroupDao.load(list.get(i).getFriend().getGroupid().intValue());
				list.get(i).setGroup(group);
			}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		//System.out.println("*****size is:"+list.size());
		
		return list;
	}
	
	/**
	 * get 1st friends according to query condition
	 */
	public List<ZyFriendDetail> get1stFriends(int userId,Object queryValue,int pageNo,int pageSize,int type){
		return friendDao.get1stFriends(userId,queryValue,pageNo,pageSize,type,0);
	}
	
	
	/**
	 * 
	 * @param userId
	 * @param targetId
	 * @param degree
	 * @return
	 */
	public boolean checkIfTargetInSNS(int userId,int targetId,short degree){
		short targetdegree = getTargetDegree(userId,targetId);
		if(degree==targetdegree){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @param userId
	 * @param targetId
	 * @return
	 */
	public boolean checkIfTargetInSNS(int userId,int targetId){
		short degree = getTargetDegree(userId,targetId);
		if(degree>=0){
			return true;
		}else{
			return false;
		}
	}
	
	/***
	 * 
	 * @param userId
	 * @param targetId
	 * @return
	 */
	public short getTargetDegree(int userId,int targetId){
		if(userId==targetId){
			return 0;
		}
		
		try{
			for(short i=1;i<=3;i++){
				//System.out.println("begnin1=="+new java.util.Date().getTime()+","+i);
				
				List<Integer> friends = null;
				if(Constants.cache.get()==null){
					Constants.cache.set(new java.util.HashMap<String,List<Integer>>());
				}
				HashMap<String,List<Integer>> map = (HashMap<String,List<Integer>>)Constants.cache.get();
				List<Integer> tempList = map.get("friends-"+userId+"-"+i);
				if(tempList!=null){
					friends = tempList;
				}else{
					friends = this.getAllFriendsByDegree(userId,i);
					map.put("friends-"+userId+"-"+i,friends);
				}
				//System.out.println("begnin2=="+new java.util.Date().getTime()+","+i);
				if(friends.contains(targetId)){
					//System.out.println("begnin3=="+new java.util.Date().getTime());
					return i;
				}
			}
			/*
			List<GraphPath> paths = this.getConnections(userId, targetId,true);
			if(paths!=null&&paths.size()>0){
				return (short)(paths.get(0).getLength()-1);
			}*/
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 100;
	}
	
	
	
	/**
	 * 
	 */
	public List<ZyProfile> getMutualFriends(int userId,int targetId){
		ArrayList<ZyProfile> mutuFriends = new ArrayList<ZyProfile>();
		try{
			List<Integer> selfFriends = getAllFriendsInRange(userId,(short)1);
			List<Integer> targetFriends = getAllFriendsInRange(targetId,(short)1);
			if(selfFriends!=null&&targetFriends!=null&&selfFriends.size()>0&&targetFriends.size()>0){
				for(int i=0;i<targetFriends.size();i++){
					if(selfFriends.contains(targetFriends.get(i))){
						ZyProfile profile = profileService.findProfileById(targetFriends.get(i));
						mutuFriends.add(profile);
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return mutuFriends;
	}
	
	/* 
	 * this method has performance improvement space
	 */
	public int getMutualFriendsCnt(int userId,int targetId){
		int count = 0;
		try{
			List<Integer> selfFriends = getAllFriendsInRange(userId,(short)1);
			List<Integer> targetFriends = getAllFriendsInRange(targetId,(short)1);
			if(selfFriends!=null && targetFriends!=null && selfFriends.size()>0 && targetFriends.size()>0){
				for(int i=0;i<targetFriends.size();i++){
					if(selfFriends.contains(targetFriends.get(i))){
						count++;
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return count;
	}
	
	
	
	
	public boolean checkIfSentIntroduceBefore(int userId,int targetUserId){
		List<ZyFriendintroduce> list = zyIntroduceDao.getPendingIntroduces(userId, targetUserId);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	
	public boolean checkIfAllowSendIntroduce(int userId,int targetUserId){
		if(this.checkIfTargetInSNS(userId, targetUserId,(short)1)==true){
			return false;
		}
		return !this.checkIfSentIntroduceBefore(userId, targetUserId);
	}
    
    @Override
    public boolean checkIfFollow(int userId, int followId) {
        return zyFollowDao.isFollow(userId, followId);
    }

    public List<ZyRecommfriend> getRecommendUsers(int userId,int pageNo, int pageSize){
    	return recommendUserDao.getRecommendUsers(userId, pageNo, pageSize);
    }
    
    public void createRecommendUser(ZyRecommfriend friend){
    	recommendUserDao.save(friend);
    }

	public RecommendUserDao getRecommendUserDao() {
		return recommendUserDao;
	}

	public void setRecommendUserDao(RecommendUserDao recommendUserDao) {
		this.recommendUserDao = recommendUserDao;
	}

}
