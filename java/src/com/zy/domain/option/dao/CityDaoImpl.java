package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyCity;

public class CityDaoImpl extends HibernateDao<ZyCity, Integer> implements CityDao {

	@Override
	public List<ZyCity> getCitiesByRegionId(int regionId) {
		String hql = "from ZyCity where regionid=?  order by sortorder";
		return this.find(hql, new Object[] { regionId});
	}
	
	public List<ZyCity> getCitiesByKey(String key) {
		String hql = "from ZyCity where citypinyin like ? or cityname like ? order by citypinyin";
		return this.find(hql, new Object[] {key + "%",key + "%"});
	}
	
	public ZyCity getCity(int cityId) {
		return this.load(cityId);
	}

}
