package com.zy.domain.message.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyNotification;

public interface NotificationDao extends BaseDao<ZyNotification, Integer> {
	
	public List<ZyNotification> getAllUserNotification(int userid);
	
	public List<ZyNotification> getUserNotification(int userid,int pageSize,int pageNo);
	
	public int getUserNotificationCNT(int userId);
	
	public List<ZyNotification> getUserUnreadNotification(int userid,int num);
	
	public int countForNotification(int userid);
	
	
}

