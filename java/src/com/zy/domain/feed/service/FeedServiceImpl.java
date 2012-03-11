package com.zy.domain.feed.service;

import java.util.Date;
import java.util.List;

import com.zy.Constants;
import com.zy.common.model.ZyBlockedfeeds;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyNewsfeedtype;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.domain.feed.dao.BlockedFeedsDao;
import com.zy.domain.feed.dao.FeedCommentDao;
import com.zy.domain.feed.dao.FeedDao;
import com.zy.domain.feed.dao.FeedTypeDao;

public class FeedServiceImpl implements FeedService{
	
	private FeedDao newsFeedDao;
	private FeedTypeDao newsFeedTypeDao;
	private FeedCommentDao newsFeedCommentDao;
	private BlockedFeedsDao blockedFeedsDao;
	
	
	public BlockedFeedsDao getBlockedFeedsDao() {
		return blockedFeedsDao;
	}

	public void setBlockedFeedsDao(BlockedFeedsDao blockedFeedsDao) {
		this.blockedFeedsDao = blockedFeedsDao;
	}

	public FeedDao getNewsFeedDao() {
		return newsFeedDao;
	}

	public void setNewsFeedDao(FeedDao newsFeedDao) {
		this.newsFeedDao = newsFeedDao;
	}

	public FeedTypeDao getNewsFeedTypeDao() {
		return newsFeedTypeDao;
	}

	public void setNewsFeedTypeDao(FeedTypeDao newsFeedTypeDao) {
		this.newsFeedTypeDao = newsFeedTypeDao;
	}

	public FeedCommentDao getNewsFeedCommentDao() {
		return newsFeedCommentDao;
	}

	public void setNewsFeedCommentDao(FeedCommentDao newsFeedCommentDao) {
		this.newsFeedCommentDao = newsFeedCommentDao;
	}

	public void addNewsFeed(ZyNewsfeed feed){
		if(feed.getFeedfrom()==null){
			feed.setFeedfrom(0);
			//feed.setRemoteid(0L);
		}
		if (feed.getHandle().equals(Constants.SNS_SHARE_PROFILE)) {
			// 24 hours check
			ZyNewsfeed f = this.newsFeedDao.getNewsFeedByHandle(feed.getHandle(), feed.getUserid());
			if (f == null)
				this.newsFeedDao.save(feed);
			else {
				long currentTime = new Date().getTime();
				long dbTime = f.getCreated().getTime();
				long h24 = 24 * 60 * 60 * 1000;
				if ((currentTime - dbTime) > h24) {
					this.newsFeedDao.save(feed);
				}
			}
		}else if (feed.getHandle().equals(Constants.SNS_INIT_INTRODUCE)) {
			ZyNewsfeed f = this.newsFeedDao.getNewsFeedByHandle(feed.getHandle(), feed.getUserid());
			if (f == null)
				this.newsFeedDao.save(feed);
			else {
				long currentTime = new Date().getTime();
				long dbTime = f.getCreated().getTime();
				long h24 = 24 * 60 * 60 * 1000;
				if ((currentTime - dbTime) > h24) {
					this.newsFeedDao.save(feed);
				}else{
					f.setCreated(new Date());
					f.setBody(feed.getBody());
					this.newsFeedDao.update(f);
				}
			}
		}
		else if (feed.getHandle().equals(Constants.SNS_SHARE_CONNECTION)) {
			// 24 hours check
			ZyNewsfeed f = this.newsFeedDao.getNewsFeedByHandle(feed.getHandle(), feed.getUserid());
			if (true||f == null) {
				this.newsFeedDao.save(feed);
			} else {
				String currentTime = DateUtil.formatDate(new Date(), DateUtil.patternDate);
				String dbTime = DateUtil.formatDate(f.getCreated(), DateUtil.patternDate);
				if (currentTime.equals(dbTime)) {// merge add friend news
													// feed,same day
					//try to truncate the same feed
					boolean exist = false;
					String[] users = f.getBody().split(",");
					for(String user : users){
						if(user.equals(feed.getBody())){
							exist = true;
							break;
						}
					}
					
					if(!exist){
						f.setBody(f.getBody() + "," + feed.getBody());
						f.setCreated(new Date());
						this.newsFeedDao.update(f);
					}
				} else {
					this.newsFeedDao.save(feed);
				}
			}
		}  else {
			this.newsFeedDao.save(feed);
		}
	}
	
	public ZyNewsfeed getFeedById(int id){
		return newsFeedDao.load(id);
	}
	public List<ZyNewsfeedtype> getFeedTypeBySetting(String setting){
		return null;
	}

	public List<ZyNewsfeed> getNewsFeed(int userId, String ids,String handles,int pageNo,int pageSize){
		List<ZyBlockedfeeds> feeds = blockedFeedsDao.getBlockedFeedsByUser(userId);;
		String blockedfeeds = "0";
		for (int i=0; i < feeds.size(); i++) {
			blockedfeeds  += "," + feeds.get(i).getFeedid();
		}
		return this.newsFeedDao.getNewsFeed(ids, handles, blockedfeeds, pageNo, pageSize);
	}
	
	public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId){
		return this.newsFeedCommentDao.getCommentsByFeedId(feedId);
	}
	public int getCommentsCountByFeedId(int feedId){
		return this.newsFeedCommentDao.getCntCommentsByFeedId(feedId);
	}
	public List<ZyNewsfeedcomment> getCommentsByFeedId(int feedId,int pageNo,int pageSize){
		return this.newsFeedCommentDao.getCommentsByFeedId(feedId, pageNo, pageSize);
	}
	
	public void addComment(ZyNewsfeedcomment comment){
		this.newsFeedCommentDao.save(comment);
		ZyNewsfeed f = this.newsFeedDao.load(comment.getNewsfeedid());
		f.setComments(this.newsFeedCommentDao.getCntCommentsByFeedId(comment.getNewsfeedid()));
		this.newsFeedDao.update(f);
	}
	
	public List<ZyNewsfeedtype> getFeedTypeByHandles(String handles){
		return newsFeedTypeDao.getFeedTypeByHandles(handles);
	}
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handles,int pageNo,int pageSize){
		return this.newsFeedDao.getNewsFeed(userId, handles, pageNo, pageSize);
	}
	
	public void deleteNewsFeed(int feedId){
		ZyNewsfeed f = this.newsFeedDao.load(feedId);
			this.newsFeedDao.delete(f);
		this.newsFeedDao.delete(f);
	}
	
	public void updateNewsFeed(ZyNewsfeed feed){
		this.newsFeedDao.update(feed);
	}
	
	
	public void removeComment(int commentId){
		this.getNewsFeedCommentDao().deleteByKey(commentId);
	}
	
	public List<ZyNewsfeed> getMyComment(int pageNo, int pageSize, int userId){
		return this.newsFeedDao.getMyComment(pageNo, pageSize, userId);
	}
	public int getMyCommentCount(int userId){
		return this.newsFeedDao.getMyCommentCount(userId);
	}
	
	public List<Integer> getNewsFeed(int userId, String handles){
		return this.newsFeedDao.getNewsFeed(userId, handles);
	}
	
	public ZyNewsfeedcomment getNewsfeedComment(int commentid){
		return this.newsFeedCommentDao.get(commentid);
	}
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String body){
		return this.newsFeedDao.getNewsFeed(userId, handle, body);
	}
	
	/*
	public ZyNewsfeed getShareFeed(String handle, int userId){
		return null;
	}
	public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String content,Date beginDate,Date endDate){
		return null;
	}*/
	
	public List<ZyNewsfeed> getEventNewsFeed(String ids,int pageNo,int pageSize){
		return this.newsFeedDao.getEventNewsFeed(ids, pageNo, pageSize);
	}

	@Override
	public ZyNewsfeed getFeedByReferenceId(int referenceId) {
		return this.newsFeedDao.getFeedByReferenceId(referenceId);
	}
	
	public List<ZyNewsfeed> getAtNewsFeed(int atuserId,int pageNo,int pageSize){
		return this.newsFeedDao.getAtNewsFeed(atuserId, pageNo, pageSize);
	}
	
	public List<ZyNewsfeed> getUnreadAtNewsFeed(int atuserId,int pageNo,int pageSize){
		return this.newsFeedDao.getUnreadAtNewsFeed(atuserId, pageNo, pageSize);
	}
	
	public int getUnreadAtNewsFeedCnt(int atuserId){
		return this.newsFeedDao.getUnreadAtNewsFeedCnt(atuserId);
	}

	@Override
	public void blockFeed(int feedId, int userId) {
		ZyBlockedfeeds entity = new ZyBlockedfeeds();
		entity.setFeedid(feedId);
		entity.setUserid(userId);
		entity.setCreatetime(new Date());
		blockedFeedsDao.save(entity);
	}
	
	public List<Integer> getNewsFeed(String handles,String body){
		return this.newsFeedDao.getNewsFeed(handles, body);
	}
}
