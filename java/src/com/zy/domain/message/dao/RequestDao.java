package com.zy.domain.message.dao;

import java.util.Date;
import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyRequest;

public interface RequestDao extends BaseDao<ZyRequest, Integer>{
	
	public  List<ZyRequest> getRequestInbox(int userid,short pagenumber,short pagesize);
	
	public List<ZyRequest> getRequestInbox(int userid, short eventkey,short pagenumber,short pagesize);
	
	public  List<ZyRequest> getUserRequestOutbox(int userid,short pagenumber,short pagesize);
	
	public  List<ZyRequest> getUserRequestOutbox(int userid, short eventkey,short pagenumber,short pagesize);
	
	public List<ZyRequest> getUserRequestHistory(int userid,short pagenumber,short pagesize);
	
	public  List<ZyRequest> getUserRequestHistory(int userid, short eventkey,short pagenumber,short pagesize);
	
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey, int referenceid);
	
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey);	
	
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey, int referenceid,short status);
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey,short status);
	
	public ZyRequest get(short eventkey, int referenceid);
	
	public ZyRequest getByRefId(int referenceid);
	
//	public int countForNewRequest(int userid);
	
	public int countForNewRequest(int userid, short eventkey);
	
	public int countForNewRequest(int userid, short eventkey,short eventkey2,short eventkey3);
	
//	public int countForRequestHistory(int userid);
	
	public int countForRequestHistory(int userid, short eventkey);
	
//	public int countForRequestSent(int userid);
	
	public int countForRequestSent(int userid, short eventkey);

	
	
	public int countForRequestInboxHistory(int userid);
	public List<ZyRequest> getRecommendRequests(int receiverid,int referenceid);

	public List<ZyRequest> getRequests(int senderid, int receiverid, short eventkey);
	
	public List<ZyRequest> getRequests(int referenceid);
	
	
	public int countRequestBySender(int senderid, Date startDate, Date  finishDate);
	
	public List<Integer> findAllNewRequestId(int userid, short eventkey);
	
	public List<ZyRequest> getRequest(int receiverid, short eventkey, int referenceid);
	
	public List<ZyRequest> getSameRequests(int senderid, int receiverid, short eventkey);

	public List<ZyRequest> getRequests(int receiverId,short eventkey);
}
