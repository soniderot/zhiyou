package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyFriendgroup;
public interface SNSGroupDao extends BaseDao<ZyFriendgroup, Integer>{
	public List<ZyFriendgroup> getFriendGroups(int userId);
	
	public ZyFriendgroup getFriendGroup(int userId,String groupname);

}
