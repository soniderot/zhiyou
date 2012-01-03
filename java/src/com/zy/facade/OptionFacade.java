package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyDistrict;
import com.zy.common.model.ZySchool;

public interface OptionFacade {
	public List<ZyDistrict> getDistricts(int cityid);
	
	public List<ZySchool> getAllSchools();
	
	public void updateSchool(ZySchool school);
}
