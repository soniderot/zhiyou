package com.zy.domain.message.service;

import java.util.List;

import com.zy.domain.message.bean.NotificationBean;

public interface NotificationService {
	public boolean systemSendNotification(int receiverId, short eventKey, Object[] p);
	
	public List<NotificationBean> getUserNotification(int userId,int pageSize,int pageNo);
	
	public int getUserNotificationCNT(int userId);
	
	public List<NotificationBean> getUserNotificationLimitNum(int userId,int num);
	
	public boolean userDeleteNotification(int notificationId, int userId);
	
	public boolean readNotification(List<Integer> notificationIds);
	
	public boolean unreadNotification(int notificationId[]);
	
	public int countForNewNotification(int userid);	
	
	public boolean deleteAllNotification(int userid);

}
