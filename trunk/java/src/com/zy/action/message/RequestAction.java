package com.zy.action.message;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.common.util.ActionUtil;
import com.zy.domain.message.bean.RequestBean;
import com.zy.facade.RequestFacade;

public class RequestAction extends ActionSupport{
	private int profileId;
	private String content;
	private int pageNo;
	private int pageSize = 200;
	private RequestFacade requestFacade;
	
	private List<RequestBean> requests;
	private short eventkey;
	private String message;
	private int referenceId;
	private int requestId;
	

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
		requests = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		return "member.requests";
	}
	
	public String addFriendRequest(){
		System.out.println("--------------into add friend request------------");
		//requestFacade.sendRequest_tx(ActionUtil.getSessionUserId(),profileId, eventkey, referenceId, message,null);
		//return this.NONE;
		System.out.println("---to---"+ActionUtil.getRequest().getParameter("to"));
		System.out.println("---t2---"+ActionUtil.getRequest().getParameter("content"));
		ActionUtil.printStr("true");
		return SUCCESS;
	}
	
	public String deleteRequest(){
		requestFacade.neglectRequest_tx(requestId);
		requests = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		return "member.requests";
	}
	
	public String approveRequest(){
		requestFacade.approveRequest_tx(requestId);
		requests = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(), pageNo, pageSize);
		return "member.requests";
	}
}
