package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyCity;

public interface CityDao extends BaseDao<ZyCity, Integer> {
	public List<ZyCity> getCitiesByRegionId(int regionId);
	public List<ZyCity> getCitiesByKey(String key);
	public ZyCity getCity(int cityId);
}
