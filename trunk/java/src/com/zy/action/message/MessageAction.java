package com.zy.action.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.domain.message.bean.MessageBean;
import com.zy.facade.MessageFacade;
import com.zy.facade.SNSFacade;

public class MessageAction {
	private MessageFacade messageFacade;
	private short pageNo = 1;
	private short pageSize = 12;
	private List<MessageBean> messages;
	private List<ZyProfile> friends;
	private SNSFacade snsFacade;

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}
	public List<ZyProfile> getFriends() {
		return friends;
	}

	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
	}

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
		friends = snsFacade.getAllFriends(1, 0, (short)1);
		return "member.messages";
	}
	
	//into compose message page
	public String composeMessage() {
		return null;
	}
	
	public String sendMessageAjax(){

    	HttpServletRequest request = ServletActionContext.getRequest();
    	String recipients = request.getParameter("recipients");
    	String message = request.getParameter("message");
    	// send message here

    	return "member.message.sent";  
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
