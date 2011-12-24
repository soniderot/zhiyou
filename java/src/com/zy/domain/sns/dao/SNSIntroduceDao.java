package com.zy.domain.sns.dao;
import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyFriendintroduce;
public interface SNSIntroduceDao extends BaseDao<ZyFriendintroduce, Integer>{
	public List<ZyFriendintroduce> getAllIntroduces(int userId);
		
	public List<ZyFriendintroduce> getAllIntroduces(int userId,short status);
	
	public List<ZyFriendintroduce> getAllPendingForward(int userId);
	
	public List<ZyFriendintroduce> getIntroduceHisByRoot(int introduceId);
	
	public ZyFriendintroduce getIntroduce(int userid,int rootid);
	
	public List<ZyFriendintroduce> getIntroduces(int sourceUserId,int targetUserId);
	
	public List<ZyFriendintroduce> getPendingIntroduces(int sourceUserId,int targetUserId);
	
	public ZyFriendintroduce getIntroduces(int sourceUserId,int middleIntroducerId,int targetUserId);
}
