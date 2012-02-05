package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyInterest;

public interface InterestDao extends BaseDao<ZyInterest, Integer> {

	public int getTagCount();
	
	public List<ZyInterest> getInterestsByPagination(int pageNo, int pageSize);

	public ZyInterest loadInterestByTag(String tag);
	
	public ZyInterest loadInterestById(int id);

	
}
