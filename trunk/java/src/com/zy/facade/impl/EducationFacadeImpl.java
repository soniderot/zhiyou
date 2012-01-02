package com.zy.facade.impl;

import com.zy.common.model.ZyEducation;
import com.zy.common.model.ZySchool;
import com.zy.domain.option.service.SchoolService;
import com.zy.domain.profile.service.EducationService;
import com.zy.facade.EducationFacade;


public class EducationFacadeImpl implements EducationFacade {

	private EducationService educationService;
	private SchoolService schoolService;
	
	public EducationService getEducationService() {
		return educationService;
	}

	public void setEducationService(EducationService educationService) {
		this.educationService = educationService;
	}

	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	@Override
	public ZySchool getSchoolByUser(int userId) {
		ZyEducation education = educationService.getEducationByUser(userId);
		education = educationService.getEducationByUser(userId);
		ZySchool school = schoolService.getSchoolById(education.getSchoolid());
		return school;
	}

	@Override
	public void addEducation(ZyEducation education) {
		educationService.addEducation(education);
	}

	@Override
	public void updateEducation(ZyEducation education) {
		educationService.updateEducation(education);
	}


	
}
