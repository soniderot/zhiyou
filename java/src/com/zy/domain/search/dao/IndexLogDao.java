package com.zy.domain.search.dao;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyIndexlog;

public interface IndexLogDao extends BaseDao<ZyIndexlog, Integer> {
	
	public ZyIndexlog getLastIndexLog();
	
}
