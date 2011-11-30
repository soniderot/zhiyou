package com.zy.domain.sns.dao;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyFriendgroup;

import java.util.*;
public interface SNSGroupDao extends BaseDao<ZyFriendgroup, Integer>{
	public List<ZyFriendgroup> getFriendGroups(int userId);
	
	public ZyFriendgroup getFriendGroup(int userId,String groupname);

}
