package com.zy.domain.sns.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyFriendgroup;

public class SNSGroupDaoImpl extends HibernateDao<ZyFriendgroup,Integer> implements SNSGroupDao {
	public List<ZyFriendgroup> getFriendGroups(int userId){
		String hql = "from ZyFriendgroup where userid=?";
		return this.find(hql,userId);
	}
	
	public ZyFriendgroup getFriendGroup(int userId,String groupname){
		String hql = "from ZyFriendgroup where userid=? and groupname = ?";
		List<ZyFriendgroup> groups = this.find(hql, new Object[] { userId,groupname});
		if(groups!=null&&groups.size()>0){
			return groups.get(0);
		}else{
			return null;
		}
	}
	
}