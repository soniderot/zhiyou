package com.zy.domain.message.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyNotificationtype;

public interface NotificationTypeDao extends BaseDao<ZyNotificationtype, Integer> {
	public ZyNotificationtype getNotificationType(short eventkey);
	public List<ZyNotificationtype> getNotificationType();
}
