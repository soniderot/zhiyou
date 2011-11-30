/**
 * 
 */
package com.zy.domain.message.service;

import java.util.Map;

import com.zy.common.model.ZyProfile;



public interface MailqueueService {
	void sendFormatEmail_tx(String from, String senderName, String to, String receiverName, String subject, String templateName, Map root, boolean isRealtime);
    String generateEmailverifyLink(ZyProfile profile);
    
    //public void sendEmail4grouplist(String from, String senderName,String to,String receiverName, String bcc, String subject, String templateName, Map map);
    //public void sendEmail4grouplist2Q(String from, String senderName,String to,String receiverName, String bcc, String subject, String templateName, Map map);
}
