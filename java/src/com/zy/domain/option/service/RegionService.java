package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyRegion;

public interface RegionService {
	public List<ZyRegion> getRegionsByCountryId(int countryId);
	
	public ZyRegion getRegion(int regionId);
}
