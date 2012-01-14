package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyFollow;
import com.zy.common.model.ZyRecommfriend;
public interface RecommendUserDao extends BaseDao<ZyRecommfriend, Integer>{
	public List<ZyRecommfriend> getRecommendUsers(int userId,int pageNo, int pageSize);
}
