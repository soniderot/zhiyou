package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyRegion;
import com.zy.domain.option.dao.RegionDao;

public class RegionServiceImpl implements RegionService {
	private RegionDao regionDao;

	public RegionDao getRegionDao() {
		return regionDao;
	}

	public void setRegionDao(RegionDao regionDao) {
		this.regionDao = regionDao;
	}

	@Override
	public List<ZyRegion> getRegionsByCountryId(int countryId) {
		return this.regionDao.getRegionsByCountryId(countryId);
	}

	@Override
	public ZyRegion getRegion(int regionId) {
		return this.regionDao.getRegion(regionId);
	}

}
