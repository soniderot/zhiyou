package com.zy.action.message;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.common.model.ZyMessage;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.domain.message.bean.MessageBean;
import com.zy.facade.MessageFacade;
import com.zy.facade.SNSFacade;

public class MessageAction extends ActionSupport{
	private MessageFacade messageFacade;
	private short pageNo = 1;
	private short pageSize = 12;
	private List<MessageBean> messages;

	private int messageId;
	
	private List<ZyProfile> friends;
	private SNSFacade snsFacade;
	//private int[] selectedFriends;
	private String message;
	private String selectedFriends;
	
	/*
	public int[] getSelectedFriends() {
		return selectedFriends;
	}


	public void setSelectedFriends(int[] selectedFriends) {
		this.selectedFriends = selectedFriends;
	}*/


	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getMessageId() {
		return messageId;
	}


	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}


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

		messages = messageFacade.getMessageInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		System.out.println("-------------messages.size-----------"+messages.size());
		friends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(), 0, (short)1);
		return "member.messages";
	}
	
	//into compose message page
	public String composeMessage() {
		return null;
	}
	
	public String sendMessageAjax(){
		System.out.println(ActionUtil.getRequest().getParameter("selectedFriends"));
		try{
		if(selectedFriends!=null&&selectedFriends.length()>0){
			String str = selectedFriends.replaceAll("\\[","");
			str = str.replaceAll("\\]", "");
			String[] array = str.split(",");
			for(int i=0;i<array.length;i++){
				System.out.println(array[i]);
				ZyMessage zyMessage = new ZyMessage();
				zyMessage.setSenderid(ActionUtil.getSessionUserId());
				zyMessage.setReceiverid(Integer.valueOf(array[i]));
				zyMessage.setCreatetime(new Date());
				zyMessage.setSubject(message);
				messageFacade.sendMessage(zyMessage);
			}
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return NONE;  
		/*
		for(int i=0;selectedFriends!=null&&selectedFriends.length>0;i++){
			ZyMessage zyMessage = new ZyMessage();
			zyMessage.setSenderid(ActionUtil.getSessionUserId());
			zyMessage.setReceiverid(selectedFriends[i]);
			zyMessage.setCreatetime(new Date());
			zyMessage.setSubject(message);
			messageFacade.sendMessage(zyMessage);
		}*/
    	
	}
	
	public String getMessageInbox() {
		messages = messageFacade.getMessageInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		System.out.println("-------------messages.size-----------"+messages.size());
		return "member.messages";
	}
	
	public String getMessageOutbox() {
		return null;
	}
	
	public String deleteMessage(){
		ZyMessage message = messageFacade.getMessageById(messageId);
		if(message.getSenderid()==message.getSenderid()){
			messageFacade.senderDeleteMessage(messageId);
		}else{
			messageFacade.receiverDeleteMessage(messageId);
		}
		messages = messageFacade.getMessageInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		System.out.println("-------------messages.size-----------"+messages.size());
		return "member.messages";
	}


	public String getSelectedFriends() {
		return selectedFriends;
	}


	public void setSelectedFriends(String selectedFriends) {
		this.selectedFriends = selectedFriends;
	}

}
