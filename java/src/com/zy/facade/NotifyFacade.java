package com.zy.facade;

import java.util.List;

import com.zy.domain.message.bean.NotificationBean;

public interface NotifyFacade {
	public List<NotificationBean> getUserNotification(int userId,int pageSize,int pageNo);
	
	public boolean systemSendNotification_tx(int receiverId, short eventKey, Object[] p);
	
	public int countForNewNotification(int userid);
	
	public boolean readNotification_tx(List<Integer> notificationIds);
	
	public boolean userDeleteNotification_tx(int notificationId, int userId);
}
