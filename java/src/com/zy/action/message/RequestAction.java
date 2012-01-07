package com.zy.action.message;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.Page;
import com.zy.domain.message.bean.RequestBean;
import com.zy.facade.FeedFacade;
import com.zy.facade.RequestFacade;

public class RequestAction extends ActionSupport{
	private int profileId;
	private String content;
	private int pageNo = 1;
	private int pageSize = 10;
	private RequestFacade requestFacade;
	private FeedFacade feedFacade;
	
	private List<RequestBean> requests;
	private short eventkey;
	private String message;
	private int referenceId;
	private int requestId;
	
	private Page page;
	
	private String type;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public short getEventkey() {
		return eventkey;
	}

	public void setEventkey(short eventkey) {
		this.eventkey = eventkey;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public List<RequestBean> getRequests() {
		return requests;
	}

	public void setRequests(List<RequestBean> requests) {
		this.requests = requests;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public RequestFacade getRequestFacade() {
		return requestFacade;
	}

	public void setRequestFacade(RequestFacade requestFacade) {
		this.requestFacade = requestFacade;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String execute(){
		int count = 0;
		if(!"outbox".equalsIgnoreCase(type)){
			requests = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
			count = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), 1, Integer.MAX_VALUE).size();
			page = new Page(count,pageNo,pageSize,5);
			return "member.requests";
		}else{
			requests = requestFacade.getUserRequestOutbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
			count = requestFacade.getUserRequestOutbox(ActionUtil.getSessionUserId(), 1, Integer.MAX_VALUE).size();
			page = new Page(count,pageNo,pageSize,5);
			return "member.outrequests";
		}
		
	}
	
	public String addFriendRequest(){
		System.out.println("--------------into add friend request------------");
		//requestFacade.sendRequest_tx(ActionUtil.getSessionUserId(),profileId, eventkey, referenceId, message,null);
		//return this.NONE;
		System.out.println("---to---"+ActionUtil.getRequest().getParameter("to"));
		System.out.println("---t2---"+ActionUtil.getRequest().getParameter("content"));
		ActionUtil.printStr("true");
		requestFacade.sendRequest_tx(ActionUtil.getSessionUserId(),Integer.valueOf(ActionUtil.getRequest().getParameter("to")).intValue(),(short)1,0, ActionUtil.getRequest().getParameter("content"), null);
		return NONE;
	}
	
	public String deleteRequest(){
		requestFacade.neglectRequest_tx(requestId);
		//requests = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		//int count = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), 1, Integer.MAX_VALUE).size();
		//page = new Page(count,pageNo,pageSize,5);
		return "to.member.requests";
	}
	
	public String approveRequest(){
		requestFacade.approveRequest_tx(requestId);
		//requests = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		//int count = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), 1, Integer.MAX_VALUE).size();
		//page = new Page(count,pageNo,pageSize,5);
		return "to.member.requests";
	}
}
