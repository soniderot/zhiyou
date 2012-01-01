package com.zy.domain.message.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.common.model.ZyMessage;
import com.zy.common.model.ZyProfile;
import com.zy.domain.message.bean.MessageBean;
import com.zy.domain.message.dao.MessageDao;
import com.zy.domain.profile.service.ProfileService;

public class MessageServiceImpl implements MessageService {
	
	private MessageDao messageDao;
	private ProfileService profileService;
	private MailqueueService mailqueueService;
	
	public MailqueueService getMailqueueService() {
		return mailqueueService;
	}

	public void setMailqueueService(MailqueueService mailqueueService) {
		this.mailqueueService = mailqueueService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public List<MessageBean> getMessageInbox(int userId,short pagenumber,short pagesize){
		List<ZyMessage> msgs = messageDao.loadForInbox(userId, pagenumber,
				pagesize);
System.out.println("-------msg.size---"+msgs.size());
		List<MessageBean> messagebean = new ArrayList<MessageBean>();

		for (ZyMessage msg : msgs) {
			System.out.println(msg.getBody());
			MessageBean bean = new MessageBean();
			bean.setMessage(msg);
			bean.setProfile(profileService.findProfileById(msg.getSenderid()));
			messagebean.add(bean);
		}
		return messagebean;
	}
	
	public List<MessageBean> getMessageOutbox(int userId,short pagenumber,short pagesize){
		List<ZyMessage> msgs = messageDao.loadForOutbox(userId, pagenumber,
				pagesize);

		List<MessageBean> messagebean = new ArrayList<MessageBean>();

		for (ZyMessage msg : msgs) {
			MessageBean bean = new MessageBean();
			bean.setMessage(msg);
			bean.setProfile(profileService.findProfileById(msg.getReceiverid()));
			messagebean.add(bean);
		}

		return messagebean;
	}

	public boolean senderDeleteMessage(int messageId){
		ZyMessage message = messageDao.load(messageId);
		message.setDeletedbysender("T");
		messageDao.saveOrUpdate(message);
		return true;
	}
	
	public boolean receiverDeleteMessage(int messageId){
		ZyMessage message = messageDao.load(messageId);
		message.setDeletedbyreceiver("T");
		messageDao.saveOrUpdate(message);
		return true;
	}
	
	public boolean readMessage_tx(int messageId, int userid){
		ZyMessage message = messageDao.load(messageId);
		if (message.getReceiverid() == userid) {
			message.setIsread("T");
		}
		messageDao.update(message);
		return true;
	}
	
	public boolean unReadMessage_tx(int[] messageIds){
		for (int i = 0; i < messageIds.length; i++) {
			ZyMessage message = messageDao.get(messageIds[i]);
			message.setIsread(null);
			messageDao.update(message);
		}
		return true;
	}
	
	public ZyMessage getMessageById(int messageId){
		return messageDao.load(messageId);
	}
	
	public int countForInbox(int userid){
		return this.messageDao.countForInbox(userid);
	}
	
	public int countForOutbox(int userid){
		return this.messageDao.countForOutbox(userid);
	}
	
	public int countForNewInbox(int userid){
		return messageDao.countForNewInbox(userid);
	}
	
	public boolean sendMessage(ZyMessage message){
		message.setIsread(null);
		message.setCreatetime(new Date());
		//message.setSubject("测试");
		System.out.println("-----------message-----"+message.getSubject());
		messageDao.save(message);
		// Email notification to be done
		ZyProfile sender = profileService.findProfileById(message.getSenderid());
		ZyProfile receiver = profileService.findProfileById(message.getReceiverid());

		
		return true;
	}
	
	//public boolean runMessageForbidTask();
	
	//public short getMessageForbidStatus(int userId, short useQuoteCoin);
	
	//public void spamMessage(long messageId);
	
	public List<ZyMessage> getMessagesByIds(String ids){
		return messageDao.getMessagesByIds(ids);
	}
}
