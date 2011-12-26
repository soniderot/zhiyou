package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyDistrict;

public interface OptionFacade {
	public List<ZyDistrict> getDistricts(int cityid);
}
