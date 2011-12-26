package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyDistrict;
import com.zy.domain.option.service.DistrictService;
import com.zy.facade.OptionFacade;

public class OptionFacadeImpl implements OptionFacade{
	private DistrictService districtService;
	
	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public List<ZyDistrict> getDistricts(int cityid){
		return districtService.getDistrictsByCityId(cityid);
	}
}
