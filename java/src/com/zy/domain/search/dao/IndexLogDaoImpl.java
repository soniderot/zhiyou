package com.zy.domain.search.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyIndexlog;

public class IndexLogDaoImpl extends HibernateDao<ZyIndexlog, Integer> implements IndexLogDao {

	@Override
	public ZyIndexlog getLastIndexLog() {
		String hql = "from ZyIndexlog order by id desc ";
		List<ZyIndexlog> list = this.loadTopRows(hql, 1);
		if (list != null && list.size() == 1)
			return list.get(0);
		return null;
	}

}
