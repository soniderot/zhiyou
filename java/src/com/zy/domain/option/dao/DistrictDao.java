package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyDistrict;

public interface DistrictDao extends BaseDao<ZyDistrict, Integer>{
	public List<ZyDistrict> getDistrictsByCityId(int cityId);
}
