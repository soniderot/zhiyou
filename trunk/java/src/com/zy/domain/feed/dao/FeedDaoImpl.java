package com.zy.domain.feed.dao;

import java.util.List;

import com.zy.Constants;
import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyNewsfeed;
import com.zy.domain.feed.bean.FeedBean;

public class FeedDaoImpl extends HibernateDao<ZyNewsfeed, Integer> implements FeedDao {
	@Override
	public List<ZyNewsfeed> getNewsFeed(String ids, String handles, int pageNo, int pageSize) {
		String hql = "from ZyNewsfeed where userid in(" + ids + ") and handle in(" + handles + ") order by id desc ";
		if(handles==null){
			hql = "from ZyNewsfeed where userid in(" + ids + ")  order by id desc ";
		}
		// LogUtil.info(hql);
		return this.loadByPagenation(hql, pageNo, pageSize);
	}

	@Override
	public List<ZyNewsfeed> getNewsFeed(int userId, String handles, int pageNo, int pageSize) {
		String hql = "from ZyNewsfeed where userid=? and handle in(" + handles + ") order by id desc ";
		return this.loadByPagenation(hql, pageNo, pageSize, new Object[] { userId });
	}

	@Override
	public ZyNewsfeed getNewsFeedByHandle(String handle, int userId) {
		String hql = "from ZyNewsfeed where userid=? and handle= ? order by id desc ";
		List<ZyNewsfeed> list = this.loadTopRows(hql, 1, new Object[] { userId, handle });
		if (list.size() == 1)
			return list.get(0);
		return null;
	}
	
	/*
	public ZyNewsfeed getNewsFeedByHandle(String handle, String body, int userId) {
		String hql = "from ZyNewsfeed where userid=? and handle= ? and body =? order by id desc ";
		List<ZyNewsfeed> list = this.loadTopRows(hql, 1, new Object[] { userId, handle, body });
		if (list.size() == 1)
			return list.get(0);
		return null;
	}*/


	/*
	public List<ZyNewsfeed> getMyComment(int pageNo, int pageSize, int userId) {
		String hql = "select distinct n from ZyNewsfeed n, ZyNewsfeedcomment c where (handle =? or handle =? or handle =?) and c.newsfeedid = n.id and c.userid = ? order by n.id desc ";
		return this.loadByPagenation(hql, pageNo, pageSize,
				new Object[] {Constants.SNS_SHARE_TEXT, Constants.SNS_SHARE_LINKURL, Constants.SNS_SHARE_DOCUMENT, userId });
	}

	@Override
	public int getMyCommentCount(int userId) {
		String hql = "select count(distinct n.id) from ZyNewsfeed n, ZyNewsfeedcomment c where (handle =? or handle =? or handle =?) and c.newsfeedid = n.id and c.userid = ?";
		return this.getTotalRows(hql, new Object[] {Constants.SNS_SHARE_TEXT, Constants.SNS_SHARE_LINKURL, Constants.SNS_SHARE_DOCUMENT, userId });
	}*/
	
	@Override
	public List<Integer> getNewsFeed(int userId, String handles) {
		String hql = "select id from ZyNewsfeed where userid=? and handle in(" + handles + ") order by id desc ";
		return this.getHibernateTemplate().find(hql, new Object[] { userId });
	}
	

	/*
	public boolean isExist(long remoteid,int userid,short extType) {
		String hql="from ZyNewsfeed as model where model.remoteid=? and model.userid=? and (model.feedfrom=? or model.feedfrom=0)";
		List<ZyNewsfeed> list = find(hql,new Object[]{remoteid,userid,extType});
		return list.size()>0;
	}
	
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String content,Date beginDate,Date endDate){
		String columnName = null;
		if(Constants.SNS_SHARE_TEXT.equals(handle)){
			columnName = "freetext";
		}else if(Constants.SNS_SHARE_LINKURL.equals(handle)){
			columnName = "title";
		}else{
			return null;
		}
		String hql="from ZyNewsfeed as model where model.userid=? and model.handle=? and model."+columnName+"=? and model.created>? and model.created<?";
		List<ZyNewsfeed> list = find(hql,new Object[]{userId,handle,content,beginDate,endDate});
		return list;
	}*/
	
	
	@Override
	public List<ZyNewsfeed> getMyComment(int pageNo, int pageSize, int userId) {
		String hql = "select distinct n from ZyNewsfeed n, ZyNewsfeedcomment c where (handle =? or handle =? or handle =?) and c.newsfeedid = n.id and c.userid = ? order by n.id desc ";
		return this.loadByPagenation(hql, pageNo, pageSize,
				new Object[] {Constants.SNS_SHARE_TEXT, Constants.SNS_SHARE_LINKURL, Constants.SNS_SHARE_DOCUMENT, userId });
	}

	@Override
	public int getMyCommentCount(int userId) {
		String hql = "select count(distinct n.id) from ZyNewsfeed n, ZyNewsfeedcomment c where (handle =? or handle =? or handle =?) and c.newsfeedid = n.id and c.userid = ?";
		return this.getTotalRows(hql, new Object[] {Constants.SNS_SHARE_TEXT, Constants.SNS_SHARE_LINKURL, Constants.SNS_SHARE_DOCUMENT, userId });
	}
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String body){
		String hql = "from ZyNewsfeed where userid=? and handle= ? and body = ? ";
		List<ZyNewsfeed> list = this.loadTopRows(hql, 1, new Object[] { userId, handle,body });
		return list;
	}
	
	public List<ZyNewsfeed> getEventNewsFeed(String ids,int pageNo,int pageSize){
		String hql = "from ZyNewsfeed where referenceid in(" + ids + ") and handle in('sns.event.text','sns.event.photo') order by id desc ";
		
		// LogUtil.info(hql);
		return this.loadByPagenation(hql, pageNo, pageSize);
	}

	@Override
	public ZyNewsfeed getFeedByReferenceId(int referenceId) {
		String hql = "from ZyNewsfeed where referenceid=?";
		List<ZyNewsfeed> list = this.loadTopRows(hql, 1, new Object[] {referenceId});
		if (list.size() == 1)
			return list.get(0);
		return null;
	}
}
