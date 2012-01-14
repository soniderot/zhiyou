package com.zy.domain.sns.dao;

import java.util.Date;
import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyRecommfriend;

public class RecommendUserDaoImpl  extends HibernateDao<ZyRecommfriend,Integer> implements RecommendUserDao{
	public List<ZyRecommfriend> getRecommendUsers(int userId,int pageNo, int pageSize){
		String hql = "from ZyRecommfriend where userid=?";
		return this.loadByPagenation(hql,pageNo,pageSize,new Object[] { userId});
	}
}
