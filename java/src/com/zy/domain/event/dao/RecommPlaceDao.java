package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyRecommplace;

public interface RecommPlaceDao extends BaseDao<ZyRecommplace,Integer>{
	public List<ZyRecommplace> getRecommPlaces(int districtid,int subcategoryid);
}
