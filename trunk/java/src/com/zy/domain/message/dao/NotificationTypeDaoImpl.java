package com.zy.domain.message.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyNotificationtype;

public class NotificationTypeDaoImpl extends HibernateDao <ZyNotificationtype, Integer> implements NotificationTypeDao {

	@Override
	public ZyNotificationtype getNotificationType(short eventkey) {
		String hql="from ZyNotificationtype where eventkey=? ";
		List<ZyNotificationtype> list = this.find(hql, new Object[] { eventkey});
		if (list.size() == 1){
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<ZyNotificationtype> getNotificationType() {
		String hql="from ZyNotificationtype ";
		return this.find(hql);
	}

}
