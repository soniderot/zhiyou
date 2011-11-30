package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyFollow;
public class FollowDaoImpl extends HibernateDao<ZyFollow,Integer> implements FollowDao {
	public List<ZyFollow> getFollow(int userId,int pageNo, int pageSize) {
		String hql = "from ZyFollow where userid=?";
		return this.loadByPagenation(hql,pageNo,pageSize,new Object[] { userId});
	}
	
	public List<ZyFollow> getFollowMe(int followId,int pageNo, int pageSize) {
		String hql = "from ZyFollower where followid=?";
		return this.loadByPagenation(hql,pageNo,pageSize,new Object[] { followId});
	}


    @Override
    public boolean isFollow(int userId, int followId) {
        String hql = "select count(id) from ZyFollow where userid=? and followid=?";
        int num = getTotalRows(hql, new Integer[]{userId, followId});
        return (num > 0)? true : false;
    }
}
