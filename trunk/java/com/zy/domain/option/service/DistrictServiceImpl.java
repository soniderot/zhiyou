package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyDistrict;
import com.zy.domain.option.dao.DistrictDao;

public class DistrictServiceImpl implements DistrictService{
	private DistrictDao districtDao;
	
	public DistrictDao getDistrictDao() {
		return districtDao;
	}

	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}

	public List<ZyDistrict> getDistrictsByCityId(int cityId){
		return districtDao.getDistrictsByCityId(cityId);
	}
	
	public ZyDistrict getDistrict(int districtId){
		return districtDao.load(districtId);
	}
}	
