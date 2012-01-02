package com.zy.facade;

import com.zy.common.model.ZyEducation;
import com.zy.common.model.ZySchool;

public interface EducationFacade {
	public ZySchool getSchoolByUser(int userId);
	public void addEducation (ZyEducation education);
	public void updateEducation (ZyEducation education);
}
