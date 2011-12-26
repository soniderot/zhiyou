package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyDistrict;

public interface DistrictService {
	public List<ZyDistrict> getDistrictsByCityId(int cityId);	
	public ZyDistrict getDistrict(int districtId);
}
