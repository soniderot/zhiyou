package com.zy.domain.profile.service;

import com.zy.common.model.ZyEducation;

public interface EducationService {
	public ZyEducation getEducationByUser(int userId);
	public void addEducation(ZyEducation education);
	public void updateEducation(ZyEducation education);
}
