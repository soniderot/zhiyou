package com.zy.domain.message.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyRequesttype;

public class RequestTypeDaoImpl extends HibernateDao<ZyRequesttype, Integer> implements RequestTypeDao {

	@Override
	public ZyRequesttype getRequestType(short eventkey) {
		String hql="from ZyRequesttype where eventkey=?";
		List<ZyRequesttype> list = this.find(hql, new Object[] { eventkey});
		if (list.size() == 1){
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<ZyRequesttype> getRequestType() {
		String hql="from ZyRequesttype";
		return this.find(hql);
	}

	

}
