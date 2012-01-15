package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyRequest;
import com.zy.domain.message.bean.RequestBean;

public interface RequestFacade {
	public boolean sendRequest_tx(int senderid, int receiverid, short eventkey,int referenceId,
			String message, String[] parameter);
	
	public boolean approveRequest_tx(int id);
	
	public boolean neglectRequest_tx(int id);
	
	public void cancelRequest_tx(int senderId, int receiverId, short eventkey);
	
	public List<RequestBean> getUserRequestInbox(int userid, int pageNo, int pageSize);
	
	public List<ZyRequest> getRequest(int receiverid, short eventkey, int referenceid);
	
	public List<RequestBean> getUserRequestOutbox(int userid, int pageNo, int pageSize);

	public ZyRequest getRequest(int senderid, int receiverid, short eventkey);
	
	public List<ZyRequest> getRequests(int receiverId,short eventkey);
}
