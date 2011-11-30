package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyCity;

public interface CityService {
	public List<ZyCity> getCitiesByRegionId(int regionId);
	
	public ZyCity getCity(int cityId);
}
