package com.zy.facade;

import java.util.List;

import com.zy.domain.message.bean.RequestBean;

public interface RequestFacade {
	public boolean sendRequest_tx(int senderid, int receiverid, short eventkey,int referenceId,
			String message, String[] parameter);
	
	public boolean approveRequest_tx(int id);
	
	public boolean neglectRequest_tx(int id);
	
	public List<RequestBean> getUserRequestInbox(int userid, int pageNo, int pageSize);
}