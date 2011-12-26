package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyCity;
import com.zy.domain.option.service.CityService;
import com.zy.facade.LocationFacade;

public class LocationFacadeImpl implements LocationFacade {
	
	private CityService cityService;
	
	public CityService getCityService() {
		return cityService;
	}
	
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	
	@Override
	public List<ZyCity> getCitiesByKey(String key) {
		return cityService.getCitiesByKey(key);
	}
	
}
