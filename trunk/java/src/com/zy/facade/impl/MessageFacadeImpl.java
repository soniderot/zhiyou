package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.model.ZyMessage;
import com.zy.domain.message.bean.MessageBean;
import com.zy.domain.message.service.MessageService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.facade.MessageFacade;

public class MessageFacadeImpl implements MessageFacade{
	private MessageService messageService;
	private ProfileService profileService;
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public boolean sendMessage(ZyMessage message){
		System.out.println(message.getSubject());
		return messageService.sendMessage(message);
	}
	
	public List<MessageBean> getMessageInbox(int userId,short pagenumber,int pagesize){
		return messageService.getMessageInbox(userId, pagenumber, pagesize);
	}
	
	public List<MessageBean> getMessageOutbox(int userId,short pagenumber,int pagesize){
		return messageService.getMessageOutbox(userId, pagenumber, pagesize);
	}

	public boolean senderDeleteMessage(int message){
		return messageService.senderDeleteMessage(message);
	}
	
	public boolean receiverDeleteMessage(int messageId){
		return messageService.receiverDeleteMessage(messageId);
	}
	
	public boolean readMessage_tx(int messageId, int userid){
		return messageService.readMessage_tx(messageId, userid);
	}
	
	

	//public List<ReplyBean> getMessageReply(long messageId);
	
	public ZyMessage getMessageById(int messageId){
		return messageService.getMessageById(messageId);
	}
	
	public int countForInbox(int userid){
		return messageService.countForInbox(userid);
	}
	
	public int countForOutbox(int userid){
		return messageService.countForOutbox(userid);
	}
	
	public int countForNewInbox(int userid){
		return messageService.countForNewInbox(userid);
	}

	public List<MessageBean> getMessagesByIds(String ids){
		List<ZyMessage> messages = messageService.getMessagesByIds(ids);
		List<MessageBean> results = new ArrayList<MessageBean>();
		for(int i=0;i<messages.size();i++){
			MessageBean bean = new MessageBean();
			bean.setMessage(messages.get(i));
			bean.setProfile(profileService.findProfileById(messages.get(i).getSenderid()));
			results.add(bean);
		}
		return results;
	}
	
	public void updateMessage(ZyMessage message) {
		messageService.updateMessage(message);
	}
}
