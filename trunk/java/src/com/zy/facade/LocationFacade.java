package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyCity;
import com.zy.common.model.ZySchool;

public interface LocationFacade {
	public List<ZyCity> getCitiesByKey(String key);
	public ZyCity getCity(int cityId);
	public List<ZySchool> getAllSchool();
	public List<ZySchool> getSchoolsByKey(String key);
}
