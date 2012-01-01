package com.zy.domain.message.service;

import java.util.List;

import com.zy.common.model.ZyMessage;
import com.zy.domain.message.bean.MessageBean;

public interface MessageService {
	public boolean sendMessage(ZyMessage message);
	
	public List<MessageBean> getMessageInbox(int userId,short pagenumber,short pagesize);
	
	public List<MessageBean> getMessageOutbox(int userId,short pagenumber,short pagesize);

	public boolean senderDeleteMessage(int message);
	
	public boolean receiverDeleteMessage(int messageId);
	
	public boolean readMessage_tx(int messageId, int userid);
	
	public boolean unReadMessage_tx(int[] messageId);

	//public List<ReplyBean> getMessageReply(long messageId);
	
	public ZyMessage getMessageById(int messageId);
	
	public int countForInbox(int userid);
	
	public int countForOutbox(int userid);
	
	public int countForNewInbox(int userid);
	
	//public boolean runMessageForbidTask();
	
	//public short getMessageForbidStatus(int userId, short useQuoteCoin);
	
	//public void spamMessage(int messageId);
	
	public List<ZyMessage> getMessagesByIds(String ids);
}
