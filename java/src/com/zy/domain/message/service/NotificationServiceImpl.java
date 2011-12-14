package com.zy.domain.message.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.Constants;
import com.zy.common.model.ZyNotification;
import com.zy.common.model.ZyNotificationtype;
import com.zy.common.model.ZyProfile;
import com.zy.domain.message.bean.NotificationBean;
import com.zy.domain.message.dao.NotificationDao;
import com.zy.domain.message.dao.NotificationTypeDao;
import com.zy.domain.profile.service.ProfileService;

public class NotificationServiceImpl implements NotificationService{
	
	private NotificationDao notificationDao;
	private NotificationTypeDao notificationTypeDao;
	private ProfileService profileService;
	
	private ZyNotificationtype n1_zh_CN=null;
	
	private boolean flag=false;
	
	private void fetchTemplate(){
		List<ZyNotificationtype> notificationtypeList_zh = notificationTypeDao.getNotificationType();
		for(ZyNotificationtype notificationtype:notificationtypeList_zh){
			short ek = notificationtype.getEventkey();
			if(ek==1){
				n1_zh_CN = notificationtype;
			}
			flag=true;
		}
	}
	
	public NotificationDao getNotificationDao() {
		return notificationDao;
	}

	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	}

	public NotificationTypeDao getNotificationTypeDao() {
		return notificationTypeDao;
	}

	public void setNotificationTypeDao(NotificationTypeDao notificationTypeDao) {
		this.notificationTypeDao = notificationTypeDao;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public boolean systemSendNotification(int receiverId, short eventKey, Object[] p){
		if(eventKey==0 || receiverId<=0){
		    return false;
		}else{
			ZyNotification ntf=new ZyNotification();
			ntf.setReceiverid(receiverId);
			ntf.setEventkey(eventKey);			
			String para="";
			switch(eventKey){
				case 1:
					para = p[0].toString();
					break;
			}
			ntf.setParameters(para);			
			ntf.setIsread(null);
			ntf.setIsdeleted(null);					
			ntf.setCreatetime(new Date());
			notificationDao.save(ntf);
			return true;			
		}
	}
	
	public List<NotificationBean> getUserNotification(int userId,int pageSize,int pageNo){
		List<ZyNotification> notifications=notificationDao.getUserNotification(userId,pageSize,pageNo);
		System.out.println("-----------notify2.size---"+notifications.size());
		List<NotificationBean>  notificationsbean= new ArrayList<NotificationBean>();
		if(!flag){
			fetchTemplate();
		}
		ZyProfile u = profileService.findProfileById(userId);
		for(ZyNotification ntf: notifications){
			System.out.println("^^^^^^^^^^^^^^^^^^^^^");
			String content="";
			NotificationBean bean=new NotificationBean();
			if(ntf.getParameters() == null){continue;}
			String[] p = ntf.getParameters().split(",");
			int temp = ntf.getEventkey();
			//if(u.getLocale().equals("zh_CN")){
				if(temp == 1){
					ZyProfile user = profileService.findProfileById(Integer.parseInt(p[0]));
					bean.setProfile(user);
					content = MessageFormat.format(n1_zh_CN.getContent(),user.getUsername());
				}
				
			//}
			
			bean.setId(ntf.getId());
			bean.setContent(content);
			bean.setCreatetime(ntf.getCreatetime());
			bean.setIsread("T");
			notificationsbean.add(bean);		
		}	
		return notificationsbean;
	}
	
	public int getUserNotificationCNT(int userId){
		return notificationDao.getUserNotificationCNT(userId);
	}
	
	public List<NotificationBean> getUserNotificationLimitNum(int userId,int num){
		List<ZyNotification> notifications=notificationDao.getUserUnreadNotification(userId,num);
		List<NotificationBean>  notificationbean= new ArrayList<NotificationBean>();
		if(!flag){
			fetchTemplate();
		}
		for(int i=0;i<notifications.size();i++){
			ZyNotification ntf = notifications.get(i);
			String content="";
			NotificationBean bean=new NotificationBean();
			if(ntf.getParameters() == null){continue;}
			String[] p = ntf.getParameters().split(",");
			int temp = ntf.getEventkey();
			ZyProfile u = profileService.findProfileById(userId);
			//if(u.getLocale().equals("zh_CN")){
				if(temp == 1){
					ZyProfile user = profileService.findProfileById(Integer.parseInt(p[0]));
					content = MessageFormat.format(n1_zh_CN.getContent(),user.getUsername());
				}
			//}
			bean.setId(ntf.getId());
			bean.setContent(content);
			bean.setCreatetime(ntf.getCreatetime());
			bean.setIsread(ntf.getIsread());
			notificationbean.add(bean);		
		}	
		return notificationbean;
	}
	
	public boolean userDeleteNotification(int notificationId, int userId){
		ZyNotification notification=this.notificationDao.get(notificationId);
		if(notification!=null && notification.getReceiverid()==userId){
			notification.setIsdeleted("T");
			this.notificationDao.update(notification);
			return true;
		}
		return false;
	}
	
	public boolean readNotification(List<Integer> notificationIds){
		for(int i=0;i<notificationIds.size();i++){
			ZyNotification notification=notificationDao.load(notificationIds.get(i));
			notification.setIsread("T");
			notificationDao.update(notification);
		}
		return true;
	}
	
	public boolean unreadNotification(int notificationIds[]){
		for(int i=0;i<notificationIds.length;i++){
			ZyNotification notification=notificationDao.load(notificationIds[i]);
			notification.setIsread(null);
			notificationDao.save(notification);
		}
		return true;
	}
	
	public int countForNewNotification(int userid){
		return notificationDao.countForNotification(userid);
	}
	
	public boolean deleteAllNotification(int userid){
		List<ZyNotification> notifications=notificationDao.getAllUserNotification(userid);
		for(ZyNotification ntf: notifications){
			ntf.setIsdeleted("T");
			this.notificationDao.update(ntf);
		}
		return true;
	}
}
