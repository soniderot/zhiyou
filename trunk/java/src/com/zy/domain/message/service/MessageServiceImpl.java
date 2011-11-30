package com.zy.domain.message.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.zy.common.model.ZyMessage;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.DateUtil;
import com.zy.common.util.TextUtil;
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

		List<MessageBean> messagebean = new ArrayList<MessageBean>();

		for (ZyMessage msg : msgs) {
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

	public boolean senderDeleteMessage(long messageId){
		ZyMessage message = messageDao.load(messageId);
		message.setDeletedbysender("T");
		messageDao.saveOrUpdate(message);
		return true;
	}
	
	public boolean receiverDeleteMessage(long messageId){
		ZyMessage message = messageDao.load(messageId);
		message.setDeletedbyreceiver("T");
		messageDao.saveOrUpdate(message);
		return true;
	}
	
	public boolean readMessage_tx(long messageId, int userid){
		ZyMessage message = messageDao.load(messageId);
		if (message.getReceiverid() == userid) {
			message.setIsread("T");
		}
		messageDao.update(message);
		return true;
	}
	
	public boolean unReadMessage_tx(long[] messageIds){
		for (int i = 0; i < messageIds.length; i++) {
			ZyMessage message = messageDao.get(messageIds[i]);
			message.setIsread(null);
			messageDao.update(message);
		}
		return true;
	}
	
	public ZyMessage getMessageById(long messageId){
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
		messageDao.save(message);
		// Email notification to be done
		ZyProfile sender = profileService.findProfileById(message.getSenderid());
		ZyProfile receiver = profileService.findProfileById(message.getReceiverid());

		//String link = Constants.USHI_DOMAINNAME+ "/msg/message!getMessageInbox.jhtml";
		try {
			String subject = MessageFormat.format(TextUtil.getText("email_message_sendmessage_notification",Locale.CHINA),new String[]{sender.getUsername()});
			Map root = new HashMap();
			root.put("senderName", sender.getUsername());
			root.put("sendtime", DateUtil.formatDate(message.getCreatetime(),
					DateUtil.patternDateTime));
			root.put("subject", message.getSubject());
			root.put("content", message.getBody());
			//root.put("siteurl", Constants.USHI_DOMAINNAME);
			root.put("messageid",message.getId());
//			root.put("link", link);
			mailqueueService.sendFormatEmail_tx(sender.getEmail(), sender.getUsername(), receiver.getEmail(),receiver.getUsername(), subject, "sendMessage", root, false);
			//LocaleUtil.getUserLocale() change to database TABLE BNS_PROFILE locale
		} catch (Exception e) {

		}
		return true;
	}
	
	//public boolean runMessageForbidTask();
	
	//public short getMessageForbidStatus(int userId, short useQuoteCoin);
	
	//public void spamMessage(long messageId);
}
