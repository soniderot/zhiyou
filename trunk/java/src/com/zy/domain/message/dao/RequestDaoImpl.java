package com.zy.domain.message.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.zy.Constants;
import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyRequest;

public class RequestDaoImpl extends HibernateDao <ZyRequest, Integer> implements RequestDao {

	@Override
	public List<ZyRequest> getRequestInbox(int userid,short pagenumber,short pagesize) {
		String hql="from ZyRequest where status=0 and receiverid=? order by id desc";
		return this.loadByPagenation(hql, pagenumber, pagesize, new Object[] { userid});
	}
	
	@Override
	public List<ZyRequest> getRequestInbox(int userid, short eventkey,short pagenumber,short pagesize){
		String hql;
		if(eventkey==0){
			hql = "from ZyRequest where status=0 and receiverid="+userid+" order by id desc";
		}else{
			if(eventkey==1){
				hql="from ZyRequest where status=0 and eventkey in (1,6,9)"+" and receiverid="+userid+" order by id desc";
			}else if(eventkey==2){
				hql="from ZyRequest where status=0 and eventkey in (2,3,8)"+" and receiverid="+userid+" order by id desc";
			}else{
				if(eventkey == 10 || eventkey == 11){
					//add for endorse
					hql = "from ZyRequest where status=0 and eventkey in (10,11) and receiverid="+userid+" order by id desc";
				} else {
					hql="from ZyRequest where status=0 and eventkey="+eventkey+" and receiverid="+userid+" order by id desc";
				}
				
			}
			
		}
		return this.loadByPage(hql, pagenumber, pagesize);
	}

	@Override
	public List<ZyRequest> getUserRequestOutbox(int userid,short pagenumber,short pagesize) {
		String hql="from ZyRequest where senderid=? order by id desc";
		return this.loadByPagenation(hql, pagenumber, pagesize, new Object[] { userid});
	}
	
	@Override
	public List<ZyRequest> getUserRequestOutbox(int userid, short eventkey,short pagenumber,short pagesize) {
		String hql;
		if(eventkey==0){
			hql = "from ZyRequest where senderid="+userid+" order by id desc";
		}else{
			
			if(eventkey==1){
				hql="from ZyRequest where status=0 and eventkey in (1,6,9)"+" and senderid="+userid+" order by id desc";
			}else if(eventkey==2){
				hql="from ZyRequest where status=0 and eventkey in (2,3,8)"+" and senderid="+userid+" order by id desc";
			}else{
				hql="from ZyRequest where status=0 and eventkey="+eventkey+" and senderid="+userid+" order by id desc";
			}
//		String hql="from ZyRequest where eventkey=? and senderid=? order by id desc";
		}
		return this.loadByPage(hql, pagenumber, pagesize);
	}

	@Override
	public List<ZyRequest> getUserRequestHistory(int userid,short pagenumber,short pagesize) {
		String hql="from ZyRequest where status>0 and receiverid=? order by id desc";
		return this.loadByPagenation(hql, pagenumber, pagesize, new Object[] { userid});
	}
	
	
	@Override
	public List<ZyRequest> getUserRequestHistory(int userid, short eventkey,short pagenumber,short pagesize) {
		String hql;
		if(eventkey==0){
			hql="from ZyRequest where status>0 and receiverid="+userid+" order by id desc";
		}else{
			if(eventkey==1){
				hql="from ZyRequest where status>0 and eventkey in (1,6,9)"+" and receiverid="+userid+" order by id desc";
			}else if(eventkey==2){
				hql="from ZyRequest where status>0 and eventkey in (2,3,8)"+" and receiverid="+userid+" order by id desc";
			}else{
				hql="from ZyRequest where status>0 and eventkey="+eventkey+" and receiverid="+userid+" order by id desc";
			}
		}
		return this.loadByPagenation(hql, pagenumber, pagesize);
	}
	
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey, int referenceid){
		String hql="from ZyRequest where senderid=? and receiverid=? and eventkey=? and referenceid=?";
		List<ZyRequest> requests= this.find(hql, new Object[] { senderid, receiverid, eventkey, referenceid});
		if(requests.size()!=0)
			return requests.get(0);
		else
			return null;
		
	}
	@Override
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey) {
		String hql="from ZyRequest where senderid=? and receiverid=? and eventkey=?";
		List<ZyRequest> requests= this.find(hql, new Object[] { senderid, receiverid, eventkey});
		if(requests.size()!=0)
			return requests.get(0);
		else
			return null;
	}

	public ZyRequest getRequest(int senderid, int receiverid, short eventkey, int referenceid,short status)
	{
		String hql="from ZyRequest where senderid=? and receiverid=? and eventkey=? and referenceid=? and status=? and isdeleted is null";
		List<ZyRequest> requests= this.find(hql, new Object[] { senderid, receiverid, eventkey, referenceid,status});
		if(requests.size()!=0)
			return requests.get(0);
		else
			return null;
	}
	public ZyRequest getRequest(int senderid, int receiverid, short eventkey,short status)
	{
		String hql="from ZyRequest where senderid=? and receiverid=? and eventkey=? and status=? and isdeleted is null";
		List<ZyRequest> requests= this.find(hql, new Object[] { senderid, receiverid, eventkey,status});
		if(requests.size()!=0)
			return requests.get(0);
		else
			return null;
	}

	
	
	/**
	 * Bing
	 * query user request included accept and reject excluded deleted
	 */
	public List<ZyRequest> getUserRequestInboxHistory(int userid,short pagenumber,short pagesize)
	{
		String hql="from ZyRequest where status>=0 and receiverid=? order by id desc";
		return this.loadByPagenation(hql, pagenumber, pagesize, new Object[] { userid});
	}
	
	
	
	
	/**
	 * Bing
	 * query user request count included accept and reject excluded deleted
	 */
	public int countForRequestInboxHistory(int userid) {
		String hql = "select count(*) from ZyRequest where receiverid =? and status>=0";
		return this.getTotalRows(hql, new Object[] { userid });
	}
	
	@Override
	public ZyRequest getByRefId(int referenceid) {
		String hql="from ZyRequest where referenceid=? order by id desc";		
		List<ZyRequest> requests = this.find(hql, new Object[] { referenceid});
		if(requests!=null&&requests.size()>0){
			return requests.get(0);
		}else{
			return null;
		}
	}

	

	@Override
	public ZyRequest get(short eventkey, int referenceid) {
		String hql="from ZyRequest where eventkey=? and referenceid=? order by id desc";		
		List<ZyRequest> list= this.find(hql, new Object[] { eventkey, referenceid});
		if(list.size()>0)
			return list.get(0);
		return null;
	}
//	@Override
//	public int countForNewRequest(int userid) {
//		String hql = "select count(*) from ZyRequest where receiverid =? and status=0";
//		return this.getTotalRows(hql, new Object[] { userid });
//	}
	
	@Override
	public int countForNewRequest(int userid, short eventkey) {
		String hql;
		if(eventkey==0){
			hql = "select count(*) from ZyRequest where receiverid ="+userid+" and status=0";
		}else{
			if(eventkey == 10 || eventkey == 11){
				hql = "select count(*) from ZyRequest where receiverid ="+userid+" and eventkey in (10,11) and status=0";
			} else {
				hql = "select count(*) from ZyRequest where receiverid ="+userid+" and eventkey="+eventkey+" and status=0";
			}
		}
		return this.getTotalRows(hql);
	}
	
	@Override
	public int countForNewRequest(int userid, short eventkey,short eventkey2,short eventkey3) {
		String hql = "select count(*) from ZyRequest where receiverid =? and (eventkey=? or eventkey=? or eventkey=?) and status=0";
		return this.getTotalRows(hql, new Object[] { userid, eventkey,eventkey2,eventkey3 });
	}

//	@Override
//	public int countForRequestHistory(int userid) {
//		String hql = "select count(*) from ZyRequest where receiverid =? and status>0";
//		return this.getTotalRows(hql, new Object[] { userid });
//	}
	
	@Override
	public int countForRequestHistory(int userid, short eventkey) {
		String hql;
		if(eventkey==0){
			hql = "select count(*) from ZyRequest where receiverid ="+userid+" and status>0";
		}else{
			hql = "select count(*) from ZyRequest where receiverid ="+userid+" and eventkey="+eventkey+" and status>0";
		}
		return this.getTotalRows(hql);
	}

//	@Override
//	public int countForRequestSent(int userid) {
//		String hql = "select count(*) from ZyRequest where senderid =?";
//		return this.getTotalRows(hql, new Object[] { userid });
//	}
	
	@Override
	public int countForRequestSent(int userid, short eventkey) {
		String hql;
		if(eventkey==0){
			hql = "select count(*) from ZyRequest where senderid ="+userid;
		}else{
			hql = "select count(*) from ZyRequest where eventkey="+eventkey+" and senderid ="+userid;
		}
		return this.getTotalRows(hql);
	}
	
	public List<ZyRequest> getRecommendRequests(int receiverid, int referenceid){
		String hql="from ZyRequest where receiverid=? and eventkey=8 and referenceid=?";
		List<ZyRequest> requests= this.find(hql, new Object[] { receiverid, referenceid});
		return requests;
	}
	
	
	public List<ZyRequest> getRequests(int senderid, int receiverid, short eventkey){
		String hql="from ZyRequest where senderid=? and receiverid=? and eventkey=?";
		List<ZyRequest> requests= this.find(hql, new Object[] { senderid, receiverid,eventkey});
		return requests;
		
	}

	public List<ZyRequest> getRequests(int referenceid){
		String hql="from ZyRequest where referenceid=?";
		List<ZyRequest> requests= this.find(hql, new Object[] {referenceid});
		return requests;
		
	}
	

	@Override
	public int countRequestBySender(int senderid, Date startDate, Date finishDate) {
		String hql = "select count(*) from ZyRequest where senderid=? and eventkey=1 and createtime>=? and createtime<?";
		return this.getTotalRows(hql, new Object[]{senderid, startDate, finishDate});
	}

	@Override
	public List<Integer> findAllNewRequestId(int userid, short eventkey) {
		String hql;
		if(eventkey==0){
			hql = "select id from ZyRequest where status=0 and receiverid="+userid+" order by id desc";
		}else{
			if(eventkey==1){
				hql="select id from ZyRequest where status=0 and eventkey in (1,6,9)"+" and receiverid="+userid+" order by id desc";
			}else if(eventkey==2){
				hql="select id from ZyRequest where status=0 and eventkey in (2,3,8)"+" and receiverid="+userid+" order by id desc";
			}else{
				if(eventkey == 10 || eventkey == 11){
					//add for endorse
					hql = "select id from ZyRequest where status=0 and eventkey in (10,11) and receiverid="+userid+" order by id desc";
				} else {
					hql="select id from ZyRequest where status=0 and eventkey="+eventkey+" and receiverid="+userid+" order by id desc";
				}
				
			}
			
		}
		Query query  = this.getSession().createQuery(hql);
		return (List<Integer>)query.list();
	}
	
	public List<ZyRequest> getRequest(int receiverid, short eventkey, int referenceid){
		String hql="from ZyRequest where receiverid=? and eventkey=? and referenceid=? order by id desc";		
		List<ZyRequest> list= this.find(hql, new Object[] {receiverid, eventkey, referenceid});
		return list;
	}
	
	public List<ZyRequest> getSameRequests(int senderid, int receiverid, short eventkey){
		String hql="from ZyRequest where senderid=? and receiverid=? and eventkey=?";
		List<ZyRequest> requests= this.find(hql, new Object[] { senderid, receiverid, eventkey});
		return requests;
	}
	
	public List<ZyRequest> getRequests(int receiverId,short eventkey){
		String hql="from ZyRequest where receiverid=? and eventkey=?";
		List<ZyRequest> requests= this.find(hql, new Object[] {receiverId, eventkey});
		return requests;
	}
}
