package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyMessage;
import com.zy.domain.message.bean.MessageBean;

public interface MessageFacade {
public boolean sendMessage(ZyMessage message);
	
	public List<MessageBean> getMessageInbox(int userId,short pagenumber,int pagesize);
	
	public List<MessageBean> getMessageOutbox(int userId,short pagenumber,int pagesize);

	public boolean senderDeleteMessage(int message);
	
	public boolean receiverDeleteMessage(int messageId);
	
	public boolean readMessage_tx(int messageId, int userid);
	
	//public boolean unReadMessage_tx(int[] messageId);

	//public List<ReplyBean> getMessageReply(int messageId);
	
	public ZyMessage getMessageById(int messageId);
	
	public int countForInbox(int userid);
	
	public int countForOutbox(int userid);
	
	public int countForNewInbox(int userid);
	
	public List<MessageBean> getMessagesByIds(String ids);
	
	public void updateMessage(ZyMessage message);

}
