package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyCity;
import com.zy.domain.option.dao.CityDao;

public class CityServiceImpl implements CityService {
	private CityDao cityDao;

	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public List<ZyCity> getCitiesByRegionId(int regionId) {
		return this.cityDao.getCitiesByRegionId(regionId);
	}
	
	public List<ZyCity> getCitiesByKey(String key) {
		return this.cityDao.getCitiesByKey(key);
	}
	
	public ZyCity getCity(int cityId){
		return this.cityDao.getCity(cityId);
	}
}
