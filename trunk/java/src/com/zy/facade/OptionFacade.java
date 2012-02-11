package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyDistrict;
import com.zy.common.model.ZyInterest;
import com.zy.common.model.ZySchool;

public interface OptionFacade {
	
	public List<ZyInterest> getInterestsByPagination(int pageNo, int pageSize);
	
	public int getInterestsCount();
	
	public ZyInterest getInterestByTag(String tag);
	
	public ZyInterest getInterestById(int id);
	
	public void saveOrUpdateInterest(ZyInterest interest);
	
	public void updateSchool(ZySchool school);
	
	public List<ZyDistrict> getDistricts(int cityid);
}
