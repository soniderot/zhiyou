package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZyInterest;
import com.zy.domain.option.dao.InterestDao;

public class InterestServiceImpl implements InterestService{
	private InterestDao interestDao;
	
	public InterestDao getInterestDao() {
		return interestDao;
	}

	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}

	@Override
	public ZyInterest getInterestById(int id) {
		return this.interestDao.load(id);
	}

	@Override
	public List<ZyInterest> getInterestsByPagination(int pageNo, int pageSize) {
		return this.interestDao.getInterestsByPagination(pageNo, pageSize);
	}
	
	@Override
	public int getInterestsCount() {
		return this.interestDao.getTagCount();
	}

	@Override
	public ZyInterest getInterestByTag(String tag) {
		return this.interestDao.loadInterestByTag(tag);
	}

	@Override
	public void saveOrUpdateInterest(ZyInterest interest) {
		this.interestDao.saveOrUpdate(interest);
	}
}
