package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyRegion;

public class RegionDaoImpl extends HibernateDao<ZyRegion, Integer> implements RegionDao {

	@Override
	public List<ZyRegion> getRegionsByCountryId(int countryId) {
		String hql = "from ZyRegion where countryid=? order by sortorder";
		return this.find(hql, new Object[] { countryId});
	}

	@Override
	public ZyRegion getRegion(int regionId) {
		return this.load(regionId);
	}

}
