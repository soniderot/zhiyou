package com.zy.action.message;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.util.ActionUtil;
import com.zy.domain.message.bean.NotificationBean;
import com.zy.facade.NotifyFacade;

public class NotificationAction {
	private NotifyFacade notifyFacade;
	private List<NotificationBean> notifys;
	private int notifyId;
	

	public int getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(int notifyId) {
		this.notifyId = notifyId;
	}

	public List<NotificationBean> getNotifys() {
		return notifys;
	}

	public void setNotifys(List<NotificationBean> notifys) {
		this.notifys = notifys;
	}

	public NotifyFacade getNotifyFacade() {
		return notifyFacade;
	}

	public void setNotifyFacade(NotifyFacade notifyFacade) {
		this.notifyFacade = notifyFacade;
	}

	public String execute(){
		notifys = notifyFacade.getUserNotification(1,1,10000);
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<notifys.size();i++){
			if("T".equals(notifys.get(i).getIsread())){
				
				list.add(notifys.get(i).getId());
			}
		}
		if(list.size()>0)
			notifyFacade.readNotification_tx(list);
		return "member.notifications";
	}
	
	public String deleteNotify(){
		notifyFacade.userDeleteNotification_tx(notifyId,ActionUtil.getSessionUserId());
		notifys = notifyFacade.getUserNotification(1,1,10000);
		return "member.notifications";
	}
}
