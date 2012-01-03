package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZySchool;

public interface SchoolService {
	public ZySchool getSchoolById(int id);
	public List<ZySchool> getSchools();
	public List<ZySchool> getAllSchools();
	public List<ZySchool> getSchoolsByKey(String key);
	public void updateSchool(ZySchool school);
}
