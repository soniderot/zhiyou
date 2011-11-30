package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyDistrict;

public class DistrictDaoImpl extends HibernateDao<ZyDistrict, Integer> implements DistrictDao{
	public List<ZyDistrict> getDistrictsByCityId(int cityId){
		String hql = "from ZyDistrict where cityid=? ";
		return this.find(hql, new Object[] { cityId});
	}
}
