package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyRequest;
import com.zy.domain.event.service.EventService;
import com.zy.domain.message.bean.RequestBean;
import com.zy.domain.message.service.RequestService;
import com.zy.facade.FeedFacade;
import com.zy.facade.RequestFacade;
import com.zy.facade.SNSFacade;

public class RequestFacadeImpl implements RequestFacade{
	private RequestService requestService;
	private SNSFacade snsFacade;
	private FeedFacade feedFacade;
	
	private EventService eventService;
	
	
	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}

	public boolean sendRequest_tx(int senderid, int receiverid, short eventkey,int referenceId,
			String message, String[] parameter){
		requestService.sendRequest(senderid, receiverid, eventkey, referenceId, message, parameter);
		return true;
	}
	
	public boolean approveRequest_tx(int id){
		requestService.approveRequest_tx(id);
		ZyRequest request = requestService.getRequest(id);
		if(request.getEventkey()==1){//add friend
			snsFacade.addFriend(request.getSenderid(),request.getReceiverid());
			feedFacade.addNewFriendNewsFeed(request.getSenderid(),request.getReceiverid());
		}
		if(request.getEventkey()==5){//join event
			eventService.addMember(request.getReceiverid(),request.getReferenceid());
		}
		return false;
	}
	
	public boolean neglectRequest_tx(int id){
		requestService.neglectRequest_tx(id);
		return true;
	}
	
	public List<RequestBean> getUserRequestInbox(int userid, int pageNo, int pageSize){
		List<RequestBean> results = requestService.getUserRequestInbox(userid,(short)0,(short)pageNo,(short)pageSize);
		for(int i=0;i<results.size();i++){
			if(results.get(i).getRequest().getEventkey()==5){
				ZyEvent event = eventService.getEvent(results.get(i).getRequest().getReferenceid());
				results.get(i).setEvent(event);
			}
		}
		return results;
	}
	
	public List<ZyRequest> getRequest(int receiverid, short eventkey, int referenceid){
		return requestService.getRequest(receiverid, eventkey, referenceid);
	}
}
