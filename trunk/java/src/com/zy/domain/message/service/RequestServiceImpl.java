package com.zy.domain.message.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRequest;
import com.zy.common.model.ZyRequesttype;
import com.zy.domain.message.bean.RequestBean;
import com.zy.domain.message.dao.RequestDao;
import com.zy.domain.message.dao.RequestTypeDao;
import com.zy.domain.profile.service.ProfileService;

public class RequestServiceImpl implements RequestService {
	private RequestDao requestDao;
	private RequestBean requestBean;
	private RequestTypeDao requestTypeDao;
	private ProfileService profileService;
	
	private static int APPROVED_REQUEST=1;
	private static int NEGLECTED_REQUEST=2;
	private static int DELETED_REQUEST=-1;
	private static int NOT_DELETED=0;

	private ZyRequesttype r1 = null;
	private ZyRequesttype r2 = null;
	private ZyRequesttype r5 = null;
	private ZyRequesttype r16 = null;

	public RequestDao getRequestDao() {
		return requestDao;
	}

	public void setRequestDao(RequestDao requestDao) {
		this.requestDao = requestDao;
	}

	public RequestBean getRequestBean() {
		return requestBean;
	}

	public void setRequestBean(RequestBean requestBean) {
		this.requestBean = requestBean;
	}

	public RequestTypeDao getRequestTypeDao() {
		return requestTypeDao;
	}

	public void setRequestTypeDao(RequestTypeDao requestTypeDao) {
		this.requestTypeDao = requestTypeDao;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	private void rentTemplate() {
		// String locale = LocaleUtil.getUserLocale();
		List<ZyRequesttype> requesttypeList = requestTypeDao.getRequestType();
		for (ZyRequesttype requesttype : requesttypeList) {
			if (requesttype.getEventkey() == 1) {
				r1 = requesttype;
			} else if (requesttype.getEventkey() == 2) {
				r2 = requesttype;
			} else if (requesttype.getEventkey() == 5) {
				r5 = requesttype;
			} else if (requesttype.getEventkey() == 16) {
				r16 = requesttype;
			}
		}
	}

	public List<RequestBean> getUserRequestInbox(int userid, short eventkey,
			short pagenumber, short pagesize) {
		// String locale = LocaleUtil.getUserLocale();
		List<ZyRequest> requests = requestDao.getRequestInbox(userid, eventkey,
				pagenumber, pagesize);
		List<RequestBean> requestBean = new ArrayList<RequestBean>();
		rentTemplate();
		for (ZyRequest request : requests) {
			RequestBean bean = new RequestBean();
			bean.setRequest(request);
			String[] paras = null;
			if (request.getParameters() != null) {
				paras = request.getParameters().split(",");
			}
			
			//new friend invite
			if (request.getEventkey() == 1) {
				ZyProfile user = profileService.findProfileById(request.getSenderid());
				bean.setProfile(user);
				
				bean.setContent(MessageFormat.format(r1.getTemplate(),user.getUserid(),user.getUsername()));
			}
			
			//new event invite
			if (request.getEventkey() == 5) {
				ZyProfile user = profileService.findProfileById(request.getSenderid());
				bean.setProfile(user);
				
				bean.setContent(MessageFormat.format(r5.getTemplate(),user.getUserid(),user.getUsername()));
			}
			
			if(request.getEventkey()==16){
				ZyProfile user = profileService.findProfileById(request.getSenderid());
				bean.setProfile(user);
				bean.setContent(MessageFormat.format(r16.getTemplate(),user.getUserid(),user.getUsername()));
			}

			requestBean.add(bean);
		}

		return requestBean;
	}

	public List<RequestBean> getUserRequestOutbox(int userid, short eventkey,
			short pagenumber, short pagesize) {
		List<ZyRequest> requests = requestDao.getUserRequestOutbox(userid, eventkey,
				pagenumber, pagesize);
		List<RequestBean> requestBean = new ArrayList<RequestBean>();
		rentTemplate();
		for (ZyRequest request : requests) {
			RequestBean bean = new RequestBean();
			bean.setRequest(request);
			String[] paras = null;
			if (request.getParameters() != null) {
				paras = request.getParameters().split(",");
			}
			
			//new friend invite
			if (request.getEventkey() == 1) {
				ZyProfile user = profileService.findProfileById(request.getReceiverid());
				bean.setProfile(user);
				
				bean.setContent(MessageFormat.format(r1.getTemplate2(),user.getUserid(),user.getUsername()));
			}
			
			//new event invite
			if (request.getEventkey() == 5) {
				ZyProfile user = profileService.findProfileById(request.getReceiverid());
				bean.setProfile(user);
				
				bean.setContent(MessageFormat.format(r5.getTemplate2(),user.getUserid(),user.getUsername()));
			}
			
			if (request.getEventkey() == 16) {
				ZyProfile user = profileService.findProfileById(request.getReceiverid());
				bean.setProfile(user);
				
				bean.setContent(MessageFormat.format(r16.getTemplate2(),user.getUserid(),user.getUsername()));
			}

			requestBean.add(bean);
		}

		return requestBean;
	}

	public List<RequestBean> getUserRequestHistory(int userid, short eventkey,
			short pagenumber, short pagesize) {
		List<ZyRequest> requests = requestDao.getUserRequestHistory(userid, eventkey,
				pagenumber, pagesize);
		List<RequestBean> requestBean = new ArrayList<RequestBean>();
		rentTemplate();
		for (ZyRequest request : requests) {
			RequestBean bean = new RequestBean();
			bean.setRequest(request);
			String[] paras = null;
			if (request.getParameters() != null) {
				paras = request.getParameters().split(",");
			}

			if (request.getEventkey() == 2) {
				ZyProfile user = profileService.findProfileById(Integer
						.valueOf(paras[0]));
				ZyProfile user2 = profileService.findProfileById(Integer
						.valueOf(paras[1]));
				bean.setContent(MessageFormat.format(r2.getTemplate(), user
						.getUsername(), user2.getUsername()));
			}

			requestBean.add(bean);
		}

		return requestBean;
	}

	public RequestBean getUserReuqest(int rid) {
		ZyRequest request=requestDao.get(rid);
		RequestBean bean=null;
		if(request != null)
		{
			bean=new RequestBean();
			bean.setRequest(request);
			bean.setRequestType(requestTypeDao.getRequestType(request.getEventkey()));
			bean.setProfile(profileService.findProfileById(request.getSenderid()));
		}
		return bean;
	}

	public boolean sendRequest(int senderid, int receiverid, short eventkey,
			int referenceId, String message, String[] parameter) {
		ZyRequest request=new ZyRequest();
		request.setEventkey(eventkey);
		request.setReferenceid(referenceId);
		request.setSenderid(senderid);
		request.setReceiverid(receiverid);
		request.setStatus(0);
		request.setIsdeleted(null);
		request.setMessage(message);
		
		if (parameter != null) {
		    if(eventkey==1){
		        request.setParameters(parameter[0]);
		    }
		    if(eventkey==2||eventkey==8||eventkey==9){
		        request.setParameters(parameter[0]+","+parameter[1]);
		    }
		    if(eventkey==3){
		        request.setParameters(parameter[0]+","+parameter[1]);
		    }
		    if(eventkey==6){			
		        request.setParameters(parameter[0]+","+parameter[1]);
		    }
		    
		}
		request.setCreatetime(new Date());
		requestDao.save(request);
		return true;
	}

	public boolean approveRequest_tx(int id) {
		ZyRequest request=requestDao.get(id);
		request.setStatus(0+APPROVED_REQUEST);
		requestDao.update(request);
		return true;
	}

	public boolean approveRequest_tx(short eventkey, int referenceid) {
		ZyRequest request=requestDao.get(eventkey, referenceid);
		if(request!=null){
			request.setStatus(0+APPROVED_REQUEST);
			requestDao.update(request);
			return true;
		}
		return false;
	}

	public boolean neglectRequest_tx(int id) {
		System.out.println("reqid-----------------"+id);
		ZyRequest request=requestDao.get(id);
		request.setStatus(0+NEGLECTED_REQUEST);
		requestDao.update(request);
		return true;
	}

	public boolean neglectRequest_tx(short eventkey, int referenceid) {
		ZyRequest request=requestDao.get(eventkey, referenceid);
		request.setStatus(0+NEGLECTED_REQUEST);
		requestDao.update(request);
		return true;
	}

	public boolean neglectRequestByRefId_tx(int referenceid) {
		ZyRequest request=requestDao.getByRefId(referenceid);
		if(request==null){
			return true;
		}
		request.setStatus(NEGLECTED_REQUEST);
		requestDao.update(request);
		return true;
	}

	public int countForNewRequest(int userid, short eventkey) {
		return requestDao.countForNewRequest(userid, eventkey);
	}

	public int countForNewRequest(int userid, short eventkey, short eventkey2,
			short eventkey3) {
		return requestDao.countForNewRequest(userid, eventkey,eventkey2,eventkey3);
	}

	public int countForRequestHistory(int userid, short eventkey) {
		return requestDao.countForRequestHistory(userid, eventkey);
	}

	public int countForRequestSent(int userid, short eventkey) {
		return requestDao.countForRequestSent(userid, eventkey);
	}

	public boolean deleteRequest_tx(int id) {
		ZyRequest request=requestDao.load(id);
		request.setIsdeleted("T");
		requestDao.update(request);
		return true;
	}

	public int countForRequestInboxHistory(int userid) {
		return this.requestDao.countForRequestInboxHistory(userid);
	}

	public ZyRequest getRequest(int senderid, int receiverid, short eventkey,
			int referenceid) {
		return this.requestDao.getRequest(senderid, receiverid, eventkey,referenceid);
	}

	public ZyRequest getRequest(int senderid, int receiverid, short eventkey) {
		return this.requestDao.getRequest(senderid, receiverid, eventkey);
	}

	public List<ZyRequest> getRequests(int senderid, int receiverid,
			short eventkey) {
		return this.requestDao.getRequests(senderid, receiverid, eventkey);
	}

	public List<ZyRequest> getRequests(int referenceid) {
		return this.requestDao.getRequests(referenceid);
	}
	
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey,
			int referenceid, short status) {
		return this.requestDao.getRequest(senderid, receiverid, eventkey,referenceid);
	}

	public ZyRequest getRequest(int senderid, int receiverid, short eventkey,
			short status) {
		return this.requestDao.getRequest(senderid, receiverid, eventkey,status);
	}


	public ZyRequest getRequest(int requestid) {
		return this.requestDao.load(requestid);
	}

	public List<Integer> findAllNewRequestId(int userid, short eventkey) {
		return this.requestDao.findAllNewRequestId(userid, eventkey);
	}
	
	public List<ZyRequest> getRequest(int receiverid, short eventkey, int referenceid){
		return this.requestDao.getRequest(receiverid, eventkey, referenceid);
	}
	
	public List<ZyRequest> getSameRequests(int senderid, int receiverid, short eventkey){
		return this.requestDao.getSameRequests(senderid, receiverid, eventkey);
	}
	
	
	public List<ZyRequest> getSameRequests(int senderid, int receiverid, short eventkey,int referenceid){
		return this.requestDao.getSameRequests(senderid, receiverid, eventkey);
	}
	
	public List<ZyRequest> getRequests(int receiverId,short eventkey){
		return this.requestDao.getRequests(receiverId, eventkey);
	}

	@Override
	public void deleteRequest(ZyRequest request) {
		this.requestDao.delete(request);
	}
	
	public boolean sendRequest(int senderid, int receiverid, short eventkey,
			int referenceId, String message, String[] parameter,String matchflag) {
		ZyRequest request=new ZyRequest();
		request.setEventkey(eventkey);
		request.setReferenceid(referenceId);
		request.setSenderid(senderid);
		request.setReceiverid(receiverid);
		request.setStatus(0);
		request.setIsdeleted(null);
		request.setMessage(message);
		request.setMatchflag(matchflag);
		
		if (parameter != null) {
		    if(eventkey==1){
		        request.setParameters(parameter[0]);
		    }
		    if(eventkey==2||eventkey==8||eventkey==9){
		        request.setParameters(parameter[0]+","+parameter[1]);
		    }
		    if(eventkey==3){
		        request.setParameters(parameter[0]+","+parameter[1]);
		    }
		    if(eventkey==6){			
		        request.setParameters(parameter[0]+","+parameter[1]);
		    }
		    
		}
		request.setCreatetime(new Date());
		requestDao.save(request);
		return true;
	}
	
	public List<ZyRequest> getPendingMatchRequests(int userId,int pageNo,int pageSize){
		return requestDao.getPendingMatchRequests(userId, pageNo, pageSize);
	}
	
	public List<ZyRequest> getMatchedRequests(int userId,int pageNo,int pageSize){
		return requestDao.getMatchedRequests(userId, pageNo, pageSize);
	}
}
