package com.zy.facade.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import com.zy.Constants;
import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.common.model.ZyRequest;
import com.zy.common.util.ActionUtil;
import com.zy.domain.event.service.EventService;
import com.zy.domain.message.bean.RequestBean;
import com.zy.domain.message.service.MailqueueService;
import com.zy.domain.message.service.NotificationService;
import com.zy.domain.message.service.RequestService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.question.service.QuestionService;
import com.zy.facade.FeedFacade;
import com.zy.facade.RequestFacade;
import com.zy.facade.SNSFacade;

public class RequestFacadeImpl implements RequestFacade{
	private RequestService requestService;
	private SNSFacade snsFacade;
	private FeedFacade feedFacade;
	
	private EventService eventService;
	private MailqueueService mailqueueService;
	private ProfileService profileService;
	
	private QuestionService questionService;
	private NotificationService notificationService;
	
	
	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public MailqueueService getMailqueueService() {
		return mailqueueService;
	}

	public void setMailqueueService(MailqueueService mailqueueService) {
		this.mailqueueService = mailqueueService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}
	
	public boolean sendRequest_tx(int senderid, int receiverid, short eventkey,int referenceId,
			String message, String[] parameter,String matchflag){
		if(!"T".equalsIgnoreCase(matchflag)){
			return this.sendRequest_tx(senderid, receiverid, eventkey, referenceId, message, parameter);
		}else{
			requestService.sendRequest(senderid, receiverid, eventkey, referenceId, message, parameter,matchflag);
			if(eventkey==1){
				ZyProfile profile = profileService.findProfileById(senderid);
				ZyProfile friend = profileService.findProfileById(receiverid);
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("receiverName", friend.getUsername());
				map.put("senderName", profile.getUsername());
				map.put("acceptLink", Constants.DOMAINNAME+"/usr/request.jhtml");
				map.put("profile",profile);
				map.put("domainname", Constants.DOMAINNAME);
				mailqueueService.sendFormatEmail_tx(profile.getEmail(),profile.getUsername(),friend.getEmail(),friend.getUsername(),
						  "朋友邀请你加入知友", "zy_internal_invite",map , true);
			}
			return true;
		}
	}

	public boolean sendRequest_tx(int senderid, int receiverid, short eventkey,int referenceId,
			String message, String[] parameter){
		requestService.sendRequest(senderid, receiverid, eventkey, referenceId, message, parameter);
		if(eventkey==1){
			ZyProfile profile = profileService.findProfileById(senderid);
			ZyProfile friend = profileService.findProfileById(receiverid);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("receiverName", friend.getUsername());
			map.put("senderName", profile.getUsername());
			map.put("acceptLink", Constants.DOMAINNAME+"/usr/request.jhtml");
			map.put("profile",profile);
			map.put("domainname", Constants.DOMAINNAME);
			mailqueueService.sendFormatEmail_tx(profile.getEmail(),profile.getUsername(),friend.getEmail(),friend.getUsername(),
					  "朋友邀请你加入知友", "zy_internal_invite",map , true);
		}
		
		if(eventkey==5){
			ZyProfile profile = profileService.findProfileById(senderid);
			ZyProfile friend = profileService.findProfileById(receiverid);
			ZyEvent event = eventService.getEvent(referenceId);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("receiverName", friend.getUsername());
			map.put("senderName", profile.getUsername());
			map.put("acceptLink", Constants.DOMAINNAME+"/usr/request.jhtml");
			map.put("profile",profile);
			map.put("event", event);
			map.put("detail","");
			if(event.getDetail()!=null){
				map.put("detail",event.getDetail());
			}
			String pattern = "yyyy/MM/dd HH:mm";
			DateFormat df = new SimpleDateFormat(pattern);
			map.put("begintime",df.format(event.getBegintime()));
			map.put("endintime",df.format(event.getEndtime()));
			map.put("domainname", Constants.DOMAINNAME);
			mailqueueService.sendFormatEmail_tx(profile.getEmail(),profile.getUsername(),friend.getEmail(),friend.getUsername(),
					  "朋友邀请你加入活动", "zy_event_invite",map , true);
			
		}
		return true;
	}
	
	public boolean approveRequest_tx(int id){
		requestService.approveRequest_tx(id);
		ZyRequest request = requestService.getRequest(id);
		if(request.getEventkey()==1){//add friend
			snsFacade.addFriend(request.getReceiverid(),request.getSenderid());
			feedFacade.addNewFriendNewsFeed(request.getSenderid(),request.getReceiverid());
			notificationService.sendAcceptFriendInviteNotify(request.getReceiverid(),request.getSenderid());
			List<ZyRequest> requests = requestService.getSameRequests(request.getSenderid(),request.getReceiverid(),request.getEventkey());
			for(int i=0;i<requests.size();i++){
				requestService.approveRequest_tx(requests.get(i).getId());
			}
			requests = requestService.getSameRequests(request.getReceiverid(),request.getSenderid(),request.getEventkey());
			for(int i=0;i<requests.size();i++){
				requestService.approveRequest_tx(requests.get(i).getId());
			}
		}
		if(request.getEventkey()==5){//join event
			eventService.addMember(request.getReceiverid(),request.getReferenceid());
			feedFacade.addAcceptEventInviteNewsFeed(request.getReceiverid(),request.getReferenceid());
			notificationService.sendAcceptEventInviteNotify(request.getReceiverid(),request.getSenderid(),request.getReferenceid());
			List<ZyRequest> requests = requestService.getRequest(request.getReceiverid(),request.getEventkey(),request.getReferenceid());
			for(int i=0;i<requests.size();i++){
				requestService.approveRequest_tx(requests.get(i).getId());
			}
			
			ZyProfile user = profileService.findProfileById(ActionUtil.getSessionUserId());
			ZyProfile friend = profileService.findProfileById(request.getSenderid());
			HashMap<String, Object> map = new HashMap<String, Object>();
			ZyEvent event = eventService.getEvent(request.getReferenceid());
			if(event.getDetail()!=null){
				map.put("detail",event.getDetail());
			}
			String pattern = "yyyy/MM/dd HH:mm";
			DateFormat df = new SimpleDateFormat(pattern);
			map.put("begintime",df.format(event.getBegintime()));
			map.put("endintime",df.format(event.getEndtime()));
			map.put("domainname", Constants.DOMAINNAME);
			map.put("profile",user);
			map.put("event", event);
			map.put("detail","");
			map.put("receiverName", friend.getUsername());
			map.put("senderName", user.getUsername());
			if(event.getDetail()!=null){
				map.put("detail",event.getDetail());
			}
			mailqueueService.sendFormatEmail_tx(user.getEmail(),user.getUsername(),friend.getEmail(),friend.getUsername(),
					  "有朋友加入您发起的活动", "zy_event_invite_success",map , true);
		}
		return false;
	}
	
	public boolean neglectRequest_tx(int id){
		requestService.neglectRequest_tx(id);
		ZyRequest request = requestService.getRequest(id);
		if(request.getEventkey()==1){//add friend
			List<ZyRequest> requests = requestService.getSameRequests(request.getSenderid(),request.getReceiverid(),request.getEventkey());
			for(int i=0;i<requests.size();i++){
				requestService.deleteRequest_tx(requests.get(i).getId());
			}
		}
		return true;
	}
	
	public List<RequestBean> getUserRequestInbox(int userid, int pageNo, int pageSize){
		List<RequestBean> results = requestService.getUserRequestInbox(userid,(short)0,(short)pageNo,(short)pageSize);
		for(int i=0;i<results.size();i++){
			if(results.get(i).getRequest().getEventkey()==5){
				ZyEvent event = eventService.getEvent(results.get(i).getRequest().getReferenceid());
				results.get(i).setEvent(event);
			}
			
			if(results.get(i).getRequest().getEventkey()==16){
				ZyQuestion question = questionService.getQuestionById(results.get(i).getRequest().getReferenceid());
				results.get(i).setQuestion(question);
			}
		}
		return results;
	}
	
	public List<RequestBean> getUserRequestOutbox(int userid, int pageNo, int pageSize){
		List<RequestBean> results = requestService.getUserRequestOutbox(userid,(short)0,(short)pageNo,(short)pageSize);
		for(int i=0;i<results.size();i++){
			if(results.get(i).getRequest().getEventkey()==5){
				ZyEvent event = eventService.getEvent(results.get(i).getRequest().getReferenceid());
				results.get(i).setEvent(event);
			}
		}
		return results;
	}
	
	public List<ZyRequest> getRequest(int receiverid, short eventkey, int referenceid){
		return requestService.getRequest(receiverid, eventkey, referenceid);
	}

	@Override
	public void cancelRequest_tx(int senderId, int receiverId, short eventkey) {
		ZyRequest request = requestService.getRequest(senderId, receiverId, eventkey);
		if (request != null) {
			requestService.deleteRequest(request);
		}
	}

	@Override
	public ZyRequest getRequest(int senderId, int receiverId, short eventkey) {
		return requestService.getRequest(senderId, receiverId, eventkey);
	}
	
	public List<ZyRequest> getRequests(int receiverId,short eventkey){
		return requestService.getRequests(receiverId, eventkey);
	}
}
