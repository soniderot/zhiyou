package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyDistrict;
import com.zy.common.model.ZyInterest;
import com.zy.common.model.ZySchool;
import com.zy.domain.option.service.DistrictService;
import com.zy.domain.option.service.InterestService;
import com.zy.domain.option.service.SchoolService;
import com.zy.facade.OptionFacade;

public class OptionFacadeImpl implements OptionFacade{
	private DistrictService districtService;
	private SchoolService schoolService;
	private InterestService interestService;
	
	public InterestService getInterestService() {
		return interestService;
	}

	public void setInterestService(InterestService interestService) {
		this.interestService = interestService;
	}

	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public List<ZyDistrict> getDistricts(int cityid){
		return districtService.getDistrictsByCityId(cityid);
	}
	
	public List<ZySchool> getAllSchools(){
		return this.schoolService.getAllSchools();
	}
	
	public void updateSchool(ZySchool school){
		this.schoolService.updateSchool(school);
	}

	@Override
	public List<ZyInterest> getInterestsByPagination(int pageNo, int pageSize) {
		return interestService.getInterestsByPagination(pageNo, pageSize);
	}

	@Override
	public ZyInterest getInterestByTag(String tag) {
		return interestService.getInterestByTag(tag);
	}

	@Override
	public ZyInterest getInterestById(int id) {
		return interestService.getInterestById(id);
	}

	@Override
	public void saveOrUpdateInterest(ZyInterest interest) {
		interestService.saveOrUpdateInterest(interest);
	}

	@Override
	public int getInterestsCount() {
		return interestService.getInterestsCount();
	}
}
