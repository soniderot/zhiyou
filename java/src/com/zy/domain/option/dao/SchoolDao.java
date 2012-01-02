package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZySchool;

public interface SchoolDao extends BaseDao<ZySchool, Integer> {
	public List<ZySchool> getApprovedSchools();
	public List<ZySchool> getUnapprovedSchools();
	public List<ZySchool> getAllSchools();

	public int getAllSchoolCount();
	public int getApprovedSchoolCount();
	public int getUnapprovedSchoolCount();
	public int getSchoolCount(short flag, int verifiedSchoolId);
	
	public List<ZySchool> getSchoolsByPagination(int pageNo, int pageSize, short flag, int verifiedSchoolId);
	public List<ZySchool> getSchoolsByVerifiedSchoolId(int verifiedSchoolId);
	

	public ZySchool loadSchoolByName(String name);
	
	public ZySchool loadSchoolById(int id);
	
	public List<ZySchool> getSchoolsByKey(String key);
	
}
