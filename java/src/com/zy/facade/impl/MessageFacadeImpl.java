package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyMessage;
import com.zy.domain.message.bean.MessageBean;
import com.zy.domain.message.service.MessageService;
import com.zy.facade.MessageFacade;

public class MessageFacadeImpl implements MessageFacade{
	private MessageService messageService;
	
	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public boolean sendMessage(ZyMessage message){
		return messageService.sendMessage(message);
	}
	
	public List<MessageBean> getMessageInbox(int userId,short pagenumber,short pagesize){
		return messageService.getMessageInbox(userId, pagenumber, pagesize);
	}
	
	public List<MessageBean> getMessageOutbox(int userId,short pagenumber,short pagesize){
		return messageService.getMessageOutbox(userId, pagenumber, pagesize);
	}

	public boolean senderDeleteMessage(long message){
		return messageService.senderDeleteMessage(message);
	}
	
	public boolean receiverDeleteMessage(long messageId){
		return messageService.receiverDeleteMessage(messageId);
	}
	
	public boolean readMessage_tx(long messageId, int userid){
		return messageService.readMessage_tx(messageId, userid);
	}
	
	

	//public List<ReplyBean> getMessageReply(long messageId);
	
	public ZyMessage getMessageById(long messageId){
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

}
