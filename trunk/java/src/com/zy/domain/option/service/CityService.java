package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyCity;

public interface CityService {
	public List<ZyCity> getCitiesByRegionId(int regionId);
	public List<ZyCity> getCitiesByKey(String key);
	public ZyCity getCity(int cityId);
}
