package com.zy.facade.impl;

import java.util.List;

import com.zy.domain.message.bean.NotificationBean;
import com.zy.domain.message.service.NotificationService;
import com.zy.facade.NotifyFacade;

public class NotifyFacadeImpl implements NotifyFacade{
	private NotificationService notificationService;
	
	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public List<NotificationBean> getUserNotification(int userId,int pageSize,int pageNo) {
		return notificationService.getUserNotification(userId,pageSize,pageNo);
	}
	
	public boolean systemSendNotification_tx(int receiverId, short eventKey, Object[] p){
		notificationService.systemSendNotification(receiverId, eventKey, p);
		return true;
	}
	
	public int countForNewNotification(int userid){
		return notificationService.countForNewNotification(userid);
	}
	
	public boolean readNotification_tx(List<Integer> notificationIds){
		return notificationService.readNotification(notificationIds);
	}
	
	public boolean userDeleteNotification_tx(int notificationId, int userId){
		return notificationService.userDeleteNotification(notificationId,userId);
	}
}
