package com.zy.action.message;

import java.util.List;

import com.zy.common.util.ActionUtil;
import com.zy.domain.message.bean.MessageBean;
import com.zy.facade.MessageFacade;

public class MessageAction {
	private MessageFacade messageFacade;
	private short pageNo = 1;
	private short pageSize = 12;
	private List<MessageBean> messages;
	

	public List<MessageBean> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageBean> messages) {
		this.messages = messages;
	}

	public short getPageNo() {
		return pageNo;
	}

	public void setPageNo(short pageNo) {
		this.pageNo = pageNo;
	}

	public short getPageSize() {
		return pageSize;
	}

	public void setPageSize(short pageSize) {
		this.pageSize = pageSize;
	}

	public MessageFacade getMessageFacade() {
		return messageFacade;
	}

	public void setMessageFacade(MessageFacade messageFacade) {
		this.messageFacade = messageFacade;
	}

	public String execute(){
		return "member.messages";
	}
	
	//into compose message page
	public String composeMessage() {
		return null;
	}
	
	//send message
	public String sendMessage(){
		return null;
	}
	
	public String getMessageInbox() {
		messages = messageFacade.getMessageInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		return "member.messages";
	}
	
	public String getMessageOutbox() {
		return null;
	}
	
	public String deleteMessage(){
		return null;
	}
}
