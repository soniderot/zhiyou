package com.zy.action.message;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.common.model.ZyMessage;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.Page;
import com.zy.domain.message.bean.MessageBean;
import com.zy.facade.MessageFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;

public class MessageAction extends ActionSupport{
	private MessageFacade messageFacade;
	private ProfileFacade profileFacade;
	private short pageNo = 1;
	private short pageSize = 10;
	private List<MessageBean> messages;

	private int messageId;
	
	private List<ZyProfile> friends;
	private SNSFacade snsFacade;
	//private int[] selectedFriends;
	private String message;
	private String selectedFriends;
	
	private List<MessageBean> zyMessages;
	
	private ZyProfile sender;
	private ZyProfile receiver;
	
	private String replyMessage;
	private int receiverId;
	
	private Page page;
	
	private String type;
	
	
	
	/*
	public int[] getSelectedFriends() {
		return selectedFriends;
	}


	public void setSelectedFriends(int[] selectedFriends) {
		this.selectedFriends = selectedFriends;
	}*/


	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public int getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}


	public String getReplyMessage() {
		return replyMessage;
	}


	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}


	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}


	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}


	public ZyProfile getSender() {
		return sender;
	}


	public void setSender(ZyProfile sender) {
		this.sender = sender;
	}


	public ZyProfile getReceiver() {
		return receiver;
	}


	public void setReceiver(ZyProfile receiver) {
		this.receiver = receiver;
	}


	public List<MessageBean> getZyMessages() {
		return zyMessages;
	}


	public void setZyMessages(List<MessageBean> zyMessages) {
		this.zyMessages = zyMessages;
	}


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
		int count = 0;
		if(type!=null&&type.equalsIgnoreCase("outbox")){
			messages = messageFacade.getMessageOutbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
			count = messageFacade.getMessageOutbox(ActionUtil.getSessionUserId(), (short)1, Integer.MAX_VALUE).size();
		}else{
			messages = messageFacade.getMessageInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
			count = messageFacade.getMessageInbox(ActionUtil.getSessionUserId(), (short)1, Integer.MAX_VALUE).size();
		}
		System.out.println("-------------messages.size-----------"+messages.size());
		friends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(), 0, (short)1);
		page = new Page(count,pageNo,10,5);
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
		if(message.getSenderid()==ActionUtil.getSessionUserId()){
			messageFacade.senderDeleteMessage(messageId);
		}else{
			messageFacade.receiverDeleteMessage(messageId);
		}
		messages = messageFacade.getMessageInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		System.out.println("-------------messages.size-----------"+messages.size());
		return "member.messages";
	}

	public String viewMessage(){
		ZyMessage message = messageFacade.getMessageById(messageId);
		sender = profileFacade.findProfileById(message.getSenderid());
		receiver = profileFacade.findProfileById(message.getReceiverid());
		zyMessages = messageFacade.getMessagesByIds(message.getParentids());
		messageFacade.readMessage_tx(messageId,ActionUtil.getSessionUserId());
		MessageBean bean = new MessageBean();
		bean.setMessage(message);
		bean.setProfile(sender);
		zyMessages.add(bean);
		return "member.messagedetail";
	}

	public String replyMessage(){
		System.out.println("replymessage--------------"+replyMessage);
		ZyMessage message = new ZyMessage();
		message.setBody(replyMessage);
		message.setSubject(replyMessage);
		message.setCreatetime(new Date());
		message.setParentid(0);
		message.setReceiverid(receiverId);
		message.setSenderid(ActionUtil.getSessionUserId());
		
		ZyMessage oldMessage = messageFacade.getMessageById(messageId);
		if(oldMessage.getParentids()!=null&&oldMessage.getParentids().trim().length()>0){
			message.setParentids(oldMessage.getParentids()+","+messageId);
		}else{
			message.setParentids(""+messageId);
		}
		messageFacade.sendMessage(message);
		return "to.member.inboxmessages";
	}
	public String getSelectedFriends() {
		return selectedFriends;
	}


	public void setSelectedFriends(String selectedFriends) {
		this.selectedFriends = selectedFriends;
	}

}
