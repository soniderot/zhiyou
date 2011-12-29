package com.zy.domain.message.service;

import java.util.List;

import com.zy.common.model.ZyRequest;
import com.zy.domain.message.bean.RequestBean;

public interface RequestService {
	public List<RequestBean> getUserRequestInbox(int userid, short eventkey,short pagenumber,short pagesize);
	
	public  List<RequestBean> getUserRequestOutbox(int userid, short eventkey,short pagenumber,short pagesize);
	
	public  List<RequestBean> getUserRequestHistory(int userid, short eventkey,short pagenumber,short pagesize);
	
	public RequestBean getUserReuqest(int rid);
	
	public boolean sendRequest(int senderid, int receiverid, short eventkey,int referenceId, String message, String[] parameter);
	
	public boolean approveRequest_tx(int id);
	
	public boolean approveRequest_tx(short eventkey, int referenceid);
	
	public boolean neglectRequest_tx(int id);
	
	public boolean neglectRequest_tx(short eventkey, int referenceid);
	
	public boolean neglectRequestByRefId_tx(int referenceid);
	
	public int countForNewRequest(int userid, short eventkey);
	
	public int countForNewRequest(int userid, short eventkey, short eventkey2,short eventkey3);
	
	public int countForRequestHistory(int userid, short eventkey);
	
	public int countForRequestSent(int userid, short eventkey);
	
	public boolean deleteRequest_tx(int id);

	public int countForRequestInboxHistory(int userid);
	
    public ZyRequest getRequest(int senderid, int receiverid, short eventkey, int referenceid);
	
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey);	
	
	public List<ZyRequest> getRequests(int senderid, int receiverid, short eventkey);
	
	public List<ZyRequest> getRequests(int referenceid);
	
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey, int referenceid,short status);
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey,short status);
	
	//public List<ZyRequest> getRecommendRequests(int receiverid, int referenceid);
	
	//public boolean checkSNSInviteOptionForbided(int userId, short eventKey);
	
	//public boolean runRequestForbidTask();
	
	//public int countTodayRequestBySender(int senderid);
	
	public ZyRequest getRequest(int requestid);
	
	public List<Integer> findAllNewRequestId(int userid, short eventkey);
	
	public List<ZyRequest> getRequest(int receiverid, short eventkey, int referenceid);
	
}
