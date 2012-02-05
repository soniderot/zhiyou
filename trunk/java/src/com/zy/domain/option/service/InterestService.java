package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyInterest;

public interface InterestService {
	public ZyInterest getInterestById(int id);
	public List<ZyInterest> getInterestsByPagination(int pageNo, int pageSize);
	public int getInterestsCount();
	public void saveOrUpdateInterest(ZyInterest interest);
	public ZyInterest getInterestByTag(String tag);
}
