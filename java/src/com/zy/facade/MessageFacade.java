package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyMessage;
import com.zy.domain.message.bean.MessageBean;

public interface MessageFacade {
public boolean sendMessage(ZyMessage message);
	
	public List<MessageBean> getMessageInbox(int userId,short pagenumber,short pagesize);
	
	public List<MessageBean> getMessageOutbox(int userId,short pagenumber,short pagesize);

	public boolean senderDeleteMessage(long message);
	
	public boolean receiverDeleteMessage(long messageId);
	
	public boolean readMessage_tx(long messageId, int userid);
	
	//public boolean unReadMessage_tx(long[] messageId);

	//public List<ReplyBean> getMessageReply(long messageId);
	
	public ZyMessage getMessageById(long messageId);
	
	public int countForInbox(int userid);
	
	public int countForOutbox(int userid);
	
	public int countForNewInbox(int userid);

}
