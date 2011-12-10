package com.zy.domain.profile.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyProfile;


public class ProfileDaoImpl extends HibernateDao<ZyProfile, Integer> implements ProfileDao {
	
	public ZyProfile findProfileByEmail(String email){
		String hql="from ZyProfile where email=?";
		List<ZyProfile> list=null;
		list = this.find(hql, email);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public ZyProfile findProfileByName(String userName) {
		String hql="from ZyProfile where username=?";
		List<ZyProfile> list=null;
		list = this.find(hql, userName);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
}
