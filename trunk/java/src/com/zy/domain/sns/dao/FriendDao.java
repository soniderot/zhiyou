package com.zy.domain.sns.dao;
import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyFriend;
import com.zy.common.model.ZyFriendDetail;
import com.zy.common.model.ZyProfile;

public interface FriendDao extends BaseDao<ZyFriend, Integer>{
	public List<ZyFriend> getFriends(int userId,int friendId);
	
	public ZyFriend load(int userId,int friendId);
	
	public List<ZyFriendDetail> get1stFriends(int userId,int pageNo,int pageSize);
	
	public List<ZyFriend> getFriendsByGroupId(int userId,int snsGroupId);
	
	public List<ZyFriend> getFriendsByGroupId(int snsGroupId);
	
	public List<ZyFriendDetail> get1stFriends(int userId,Object value,int pageNo,int pageSize,int type,int sorting);
	
	public List<ZyProfile> getFriendsByName(int userId,String username,boolean likeFlag);
	
	public List<ZyFriend> getMatchedFriends(int userId,int pageNo,int pageSize);
}
