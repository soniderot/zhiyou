package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyQuestion;
import com.zy.domain.event.service.EventService;
import com.zy.domain.message.bean.NotificationBean;
import com.zy.domain.message.service.MailqueueService;
import com.zy.domain.message.service.NotificationService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.question.service.QuestionService;
import com.zy.facade.NotifyFacade;

public class NotifyFacadeImpl implements NotifyFacade{
	private NotificationService notificationService;
	private EventService eventService;
	private ProfileService profileService;
	private QuestionService questionService;
	
	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public List<NotificationBean> getUserNotification(int userId,int pageSize,int pageNo) {
		List<NotificationBean> results =  notificationService.getUserNotification(userId,pageSize,pageNo);
		for(int i=0;i<results.size();i++){
			if(results.get(i).getNotification().getEventkey()==5){
				ZyEvent event = eventService.getEvent(Integer.valueOf(results.get(i).getNotification().getParameters()));
				results.get(i).setEvent(event);
			}
			if(results.get(i).getNotification().getEventkey()==16){
				ZyQuestion question = questionService.getQuestionById(Integer.valueOf(results.get(i).getNotification().getParameters()));
				results.get(i).setQuestion(question);
			}
		}
		return results;
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
	
	public void sendAcceptFriendInviteNotify(int senderId,int receiverId){
		notificationService.sendAcceptFriendInviteNotify(senderId,receiverId);
	}
	
	public void sendAcceptEventInviteNotify(int senderId,int receiverId,int eventId){
		notificationService.sendAcceptEventInviteNotify(senderId,receiverId,eventId);
	}
	
	public void sendAnswerQuestionNotify(int senderId,int receiverId,int questionId){
		notificationService.sendAcceptEventInviteNotify(senderId,receiverId,questionId);
	}
}
