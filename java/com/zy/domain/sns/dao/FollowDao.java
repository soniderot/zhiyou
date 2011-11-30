package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyFollow;
public interface FollowDao extends BaseDao<ZyFollow, Integer>{
	public List<ZyFollow> getFollow(int followerId,int pageNo, int pageSize);
	public List<ZyFollow> getFollowMe(int userId,int pageNo, int pageSize);
	public boolean isFollow(int userId, int followerId);
}
