package com.zy.action.profile;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.common.util.ActionUtil;
import com.zy.facade.MessageFacade;
import com.zy.facade.NotifyFacade;
import com.zy.facade.RequestFacade;

public class MemberAction extends ActionSupport{
	private int newrequestcnt = 0;
	private int newnotificationcnt =0;
	private int newmessagecnt = 0;
	private RequestFacade requestFacade;
	private NotifyFacade notifyFacade;
	private MessageFacade messageFacade;
	

	public MessageFacade getMessageFacade() {
		return messageFacade;
	}
	public void setMessageFacade(MessageFacade messageFacade) {
		this.messageFacade = messageFacade;
	}
	public NotifyFacade getNotifyFacade() {
		return notifyFacade;
	}
	public void setNotifyFacade(NotifyFacade notifyFacade) {
		this.notifyFacade = notifyFacade;
	}
	public RequestFacade getRequestFacade() {
		return requestFacade;
	}
	public void setRequestFacade(RequestFacade requestFacade) {
		this.requestFacade = requestFacade;
	}
	public int getNewrequestcnt() {
		return newrequestcnt;
	}
	public void setNewrequestcnt(int newrequestcnt) {
		this.newrequestcnt = newrequestcnt;
	}
	public int getNewnotificationcnt() {
		return newnotificationcnt;
	}
	public void setNewnotificationcnt(int newnotificationcnt) {
		this.newnotificationcnt = newnotificationcnt;
	}
	public int getNewmessagecnt() {
		return newmessagecnt;
	}
	public void setNewmessagecnt(int newmessagecnt) {
		this.newmessagecnt = newmessagecnt;
	}
	public String execute(){
		try{
		newrequestcnt = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(),1,10000).size();
		newnotificationcnt = notifyFacade.countForNewNotification(ActionUtil.getSessionUserId());
		newmessagecnt = messageFacade.countForNewInbox(ActionUtil.getSessionUserId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "member.header";
	}
}
