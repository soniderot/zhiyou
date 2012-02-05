package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyInterest;

public class InterestDaoImpl extends HibernateDao<ZyInterest, Integer> implements InterestDao {

	@Override
	public ZyInterest loadInterestByTag(String tag) {
		String hql = "from ZyInterest where tag=?";
		List<ZyInterest> list= getHibernateTemplate().find(hql,new Object[]{tag});
		if (list != null && list.size() > 0)
			return (ZyInterest)list.get(0);
		return null;
	}

	@Override
	public List<ZyInterest> getInterestsByPagination(int pageNo, int pageSize) {
		String hql = "from ZyInterest where";
		hql += " flag = 1";
		return loadByPagenation(hql, pageNo, pageSize);
	}

	@Override
	public int getTagCount() {
		String hql = "select count(id) from ZyInterest where flag = 1";
		return getTotalRows(hql);
	}

	@Override
	public ZyInterest loadInterestById(int id) {
		String hql = "from ZyInterest where id=?";
		List<ZyInterest> list= getHibernateTemplate().find(hql,new Object[]{id});
		if (list != null && list.size() > 0)
			return (ZyInterest)list.get(0);
		return null;
	}

}
