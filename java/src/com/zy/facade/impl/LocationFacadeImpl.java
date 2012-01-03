package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyCity;
import com.zy.common.model.ZySchool;
import com.zy.domain.option.service.CityService;
import com.zy.domain.option.service.SchoolService;
import com.zy.facade.LocationFacade;

public class LocationFacadeImpl implements LocationFacade {
	
	private CityService cityService;
	private SchoolService schoolService;
	
	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

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
	
	@Override
	public List<ZySchool> getSchoolsByKey(String key) {
		return schoolService.getSchoolsByKey(key);
	}

	@Override
	public List<ZySchool> getAllSchool() {
		return schoolService.getAllSchools();
	}

	@Override
	public ZyCity getCity(int cityId) {
		return cityService.getCity(cityId);
	}
	
	public List<ZyCity> getCities(){
		return cityService.getCities();
	}

	public void updateCity(ZyCity city){
		cityService.updateCity(city);
	}
}
