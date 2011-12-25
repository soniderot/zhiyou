package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyRecommplace;

public class RecommPlaceDaoImpl extends HibernateDao<ZyRecommplace, Integer> implements RecommPlaceDao{
	public List<ZyRecommplace> getRecommPlaces(int districtid,int subcategoryid){
		String hql = "from ZyRecommplace where districtid = ? and subcategoryid = ?";
		return this.find(hql,new Object[]{districtid,subcategoryid});
	}
	
	public List<ZyRecommplace> getRecommPlaces(int subcategoryid){
		String hql = "from ZyRecommplace where subcategoryid = ?";
		return this.find(hql,new Object[]{subcategoryid});
	}
}
