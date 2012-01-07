/**
 * 
 */
package com.zy.domain.message.service;

import java.util.Date;
import java.util.Map;

import com.zy.Constants;
import com.zy.common.model.ZyMailqueue;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.BASE64Util;
import com.zy.common.util.MailThread;
import com.zy.common.util.MailUtil;
import com.zy.domain.message.dao.MailqueueDao;

public class MailqueueServiceImpl implements MailqueueService {

	MailqueueDao mailqueueDao;

	public MailqueueDao getMailqueueDao() {
		return mailqueueDao;
	}

	public void setMailqueueDao(MailqueueDao mailqueueDao) {
		this.mailqueueDao = mailqueueDao;
	}

	public void sendFormatEmail_tx(String from, String senderName, String to,
			String receiverName, String subject, String templateName, Map root, boolean isRealtime) {

		boolean cansend = true;

		if (cansend) {
			if (isRealtime) {
				MailThread mailThread = new MailThread();
				//mailThread.setFrom(Constants.SYSTEM_EMAIL_ADDRESS);
				//if ("feedback".equals(templateName)) {
					mailThread.setFrom(from);
				//}
				mailThread.setSenderName(senderName);
				mailThread.setTo(to);
				mailThread.setSubject(subject);
				mailThread.setTemplateName(templateName + ""  + ".ftl");
				mailThread.setRoot(root);
				new Thread(mailThread).start();
			} else {
				ZyMailqueue mailqueue = new ZyMailqueue();
				// mailqueue.setSender(from);
				mailqueue.setSender(Constants.SYSTEM_EMAIL_ADDRESS);
				mailqueue.setReceiver(to);
				mailqueue.setSubject(subject);
				mailqueue.setSendername(senderName);
				mailqueue.setReceivername(receiverName);
				mailqueue.setCreatetime(new Date());
				mailqueue.setTemplate(templateName);
				String message = MailUtil.merge(templateName + "_" + ".ftl", root);
				mailqueue.setContent(message);
				mailqueue.setStatus((short)0); // 0:to be sent, 1:sent
				mailqueueDao.save(mailqueue);
			}
		}
	}

	
	@Override
	public String generateEmailverifyLink(ZyProfile profile) {
		StringBuffer sb = new StringBuffer();
		String link = sb.append(profile.getUserid()).append(",").append(
				Constants.EMAILVERIFY_PRIVATE_KEY).append(",").append(
				profile.getEmail()).toString();
		return BASE64Util.encode(link);
	}

}
