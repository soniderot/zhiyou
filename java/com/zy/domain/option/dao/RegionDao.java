package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyRegion;

public interface RegionDao extends BaseDao<ZyRegion, Integer> {
	
	public List<ZyRegion> getRegionsByCountryId(int countryId);
	public ZyRegion getRegion(int regionId);
}
