package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.Constants;
import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyPhoto;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.common.util.ActionUtil;
import com.zy.domain.event.service.EventService;
import com.zy.domain.feed.bean.CommentBean;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.domain.feed.service.FeedService;
import com.zy.domain.photo.service.PhotoService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.question.service.QuestionService;
import com.zy.facade.FeedFacade;
import com.zy.facade.vo.OptionVO;

public class FeedFacadeImpl implements FeedFacade{
	private FeedService feedService;
	private EventService eventService;
	private ProfileService profileService;
	private PhotoService photoService;
	private QuestionService questionService;
	
	
	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public FeedService getFeedService() {
		return feedService;
	}

	public void setFeedService(FeedService feedService) {
		this.feedService = feedService;
	}
	
	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	public void addNewFriendNewsFeed(int userId,int friendId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setHandle(Constants.SNS_SHARE_CONNECTION);
		feed.setBody("" + friendId); // do by you
		feed.setCreated(new Date());
		feedService.addNewsFeed(feed);
	}
	
	public FeedBean addNewPhotoNewsFeed(int userId,int photoId){
		FeedBean bean = new FeedBean();
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(photoService.getPhoto(photoId).getCreatetime());
		feed.setHandle("sns.publish.photo");
		feed.setBody(""+photoId);
		feedService.addNewsFeed(feed);
		bean.setFeed(feed);
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		bean.setPhoto(photoService.getPhoto(photoId));
		return bean;
	}
	
	public void addNewEventNewsFeed(int userId,int enentId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.event.create");
		feed.setBody(""+enentId);
		feedService.addNewsFeed(feed);
	}
	
	public FeedBean addNewBlogNewsFeed(int userId,String message){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.publish.text");
		feed.setBody(message);
		feedService.addNewsFeed(feed);
		
		FeedBean bean = new FeedBean();
		bean.setFeed(feed);
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		return bean;
	}
	
	public void addAcceptEventInviteNewsFeed(int userId,int eventId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.event.join");
		feed.setBody(""+eventId);
		feedService.addNewsFeed(feed);
	}
	
	public FeedBean addNewQuestionNewsFeed(int userId,int questionId, String question){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setReferenceid(questionId);
		feed.setBody(question);
		feed.setHandle("sns.publish.question");
		feed.setCreated(new Date());
		feedService.addNewsFeed(feed);
		FeedBean feedBean = new FeedBean();
		ZyQuestion zyQuestion = questionService.getQuestionById(questionId);
		List<ZyAnsweroption> options = questionService.getOptionsByQuestion(questionId);
		feedBean.setQuestion(zyQuestion);
		List<OptionVO> optionList = new ArrayList<OptionVO>();
		for (int i = 0; i < options.size(); i++) {
			ZyAnsweroption option = options.get(i);
			OptionVO optionVo = new OptionVO();
			optionVo.setOption(option);
			optionList.add(optionVo);
		}
		feedBean.setOptions(optionList);
		feedBean.setFeed(feed);
		feedBean.setUser(profileService.findProfileById(userId));
		return feedBean;
	}
	
	public void addNewAnswerNewsFeed(int userId,int answerId){
		ZyNewsfeed feed = new ZyNewsfeed();
		feedService.addNewsFeed(feed);
	}
	
	private void generateFeedBeanContent(List<ZyNewsfeed> feeds,List<FeedBean> results){
		for(int i=0;i<feeds.size();i++){
			FeedBean bean = new FeedBean();
			bean.setFeed(feeds.get(i));
			bean.setUser(profileService.findProfileById(feeds.get(i).getUserid()));
			//new event feed
			if(feeds.get(i).getHandle().equals("sns.event.create")||feeds.get(i).getHandle().equals("sns.event.join")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setEvent(eventService.getEvent(id));
				System.out.println(bean.getEvent().getEventname());
			}
			
			if(feeds.get(i).getHandle().equals("sns.event.text")||feeds.get(i).getHandle().equals("sns.event.photo")){
				int id = Integer.valueOf(feeds.get(i).getReferenceid());
				bean.setEvent(eventService.getEvent(id));
				System.out.println(bean.getEvent().getEventname());
				if(feeds.get(i).getHandle().equals("sns.event.photo")){
					int photoId = Integer.valueOf(feeds.get(i).getBody());
					bean.setPhoto(photoService.getPhoto(photoId));
				}
			}
			
			//add new friend
			if(feeds.get(i).getHandle().equals("sns.share.connection")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setFriend(profileService.findProfileById(id));
			}
			
			//add new photo
			if(feeds.get(i).getHandle().equals("sns.publish.photo")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setPhoto(photoService.getPhoto(id));
			}
			
			if(feeds.get(i).getHandle().equals("sns.share.text")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setOldFeed(feedService.getFeedById(id));
				bean.setFriend(profileService.findProfileById(feedService.getFeedById(id).getUserid()));
			}
			
			if(feeds.get(i).getHandle().equals("sns.share.photo")){
				int id = Integer.valueOf(feeds.get(i).getBody());
				bean.setOldFeed(feedService.getFeedById(id));
				int photoId = Integer.valueOf(feedService.getFeedById(id).getBody());
				bean.setPhoto(photoService.getPhoto(photoId));
				bean.setFriend(profileService.findProfileById(feedService.getFeedById(id).getUserid()));
			}
			
			if(feeds.get(i).getHandle().equals("sns.publish.question")) {
				int questionId = feeds.get(i).getReferenceid();
				ZyQuestion question = questionService.getQuestionById(questionId);
				List<ZyAnsweroption> options = questionService.getOptionsByQuestion(questionId);
				List<OptionVO> optionVos = new ArrayList<OptionVO>();
				for (int j = 0; j < options.size(); j++) {
					ZyAnsweroption option = options.get(j);
					List<ZyAnswer> answers = questionService.getOptionUsers(option.getId());
					List<ZyProfile> profiles = new ArrayList<ZyProfile>();
					boolean selected = false;
					for (int k = 0; k < answers.size(); k++) {
						ZyAnswer answer = answers.get(k);
						ZyProfile profile = profileService.findProfileById(answer.getUserid());
						profiles.add(profile);
						if (profile.getUserid() == ActionUtil.getSessionUserId()) {
							selected = true;
						}
					}
					OptionVO optionVo = new OptionVO();
					optionVo.setOption(option);
					optionVo.setSelected(selected);
					optionVo.setOptionProfiles(profiles);
					optionVos.add(optionVo);
				}
				
				bean.setQuestion(question);
				bean.setOptions(optionVos);
			}
			
			List<ZyNewsfeedcomment> comments = feedService.getCommentsByFeedId(bean.getFeed().getId());
			List<CommentBean> commentBeans = new ArrayList<CommentBean>();
			for(int j=0;j<comments.size();j++){
				CommentBean commentBean = new CommentBean();
				commentBean.setComment(comments.get(j));
				commentBean.setUser(profileService.findProfileById(comments.get(j).getUserid()));
				commentBeans.add(commentBean);
			}
			bean.setComments(commentBeans);
			if(feeds.get(i).getAtuserid()!=null&&feeds.get(i).getAtuserid()>0){
				bean.setAtuser(profileService.findProfileById(feeds.get(i).getAtuserid()));
			}
			results.add(bean);
		}
	}
	
	public List<FeedBean> getNewsFeed(int userId, String ids,String handles,int pageNo,int pageSize){
		List<FeedBean> results = new ArrayList<FeedBean>();
		List<ZyNewsfeed> feeds = feedService.getNewsFeed(userId, ids, handles, pageNo, pageSize);
		generateFeedBeanContent(feeds, results);
		return results;
	}
	
	public FeedBean shareNewsFeed_tx(int userId, int feedId, String shareReason){
		ZyNewsfeed oldFeed = feedService.getFeedById(feedId);
		FeedBean bean = new FeedBean();
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		if("sns.publish.text".equalsIgnoreCase(oldFeed.getHandle())||"sns.event.text".equalsIgnoreCase(oldFeed.getHandle())){
			feed.setHandle("sns.share.text");
		}
		if("sns.publish.photo".equalsIgnoreCase(oldFeed.getHandle())||"sns.event.photo".equalsIgnoreCase(oldFeed.getHandle())){
			feed.setHandle("sns.share.photo");
			int photoId = Integer.valueOf(oldFeed.getBody());
			ZyPhoto photo = new ZyPhoto();
			ZyPhoto oldPhoto = photoService.getPhoto(photoId);
			photo.setFilename(oldPhoto.getFilename());
			photo.setSummary(oldPhoto.getSummary());
			photo.setAlbumno(0);
			photo.setCreatetime(new Date());
			photo.setUserid(userId);
			
			List<ZyAlbum> albums = photoService.getAlbumList(userId);
			if(albums.size()>0){
				photo.setAlbumno(albums.get(0).getId());
			}else{
				photo.setAlbumno(0);
			}
			photoService.createPhoto(photo);
		}
		
		feed.setBody(""+feedId);
		feed.setShareReason(shareReason);
		feedService.addNewsFeed(feed);
		bean.setFeed(feed);
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		bean.setOldFeed(feedService.getFeedById(feedId));
		return bean;
	}
	
	public void addComment(ZyNewsfeedcomment comment){
		feedService.addComment(comment);
	}
	
	public void removeComment(int commentid){
		feedService.removeComment(commentid);
	}
	
	@Override
	public void removeFeed(int feedId) {
		feedService.deleteNewsFeed(feedId);
	}
	
	public List<ZyNewsfeed> getNewsFeed(int userId,String handle,String body){
		return feedService.getNewsFeed(userId, handle, body);
	}
	
	public List<FeedBean> getEventNewsFeed(String ids,int pageNo,int pageSize){
		List<FeedBean> results = new ArrayList<FeedBean>();
		List<ZyNewsfeed> feeds = feedService.getEventNewsFeed(ids, pageNo, pageSize);
		this.generateFeedBeanContent(feeds, results);
		return results;
	}
	
	public FeedBean addNewEventPhotoNewsFeed(int userId,int eventId,int photoId){
		FeedBean bean = new FeedBean();
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.event.photo");
		feed.setBody(""+photoId);
		feed.setReferenceid(eventId);
		feedService.addNewsFeed(feed);
		bean.setFeed(feed);
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		bean.setPhoto(photoService.getPhoto(photoId));
		bean.setEvent(eventService.getEvent(eventId));
		return bean;
	}
	
	public FeedBean addNewEventBlogNewsFeed(int userId,int eventId,String message){
		ZyNewsfeed feed = new ZyNewsfeed();
		feed.setUserid(userId);
		feed.setCreated(new Date());
		feed.setHandle("sns.event.text");
		feed.setBody(message);
		feed.setReferenceid(eventId);
		feedService.addNewsFeed(feed);
		
		FeedBean bean = new FeedBean();
		bean.setFeed(feed);
		bean.setEvent(eventService.getEvent(eventId));
		bean.setUser(profileService.findProfileById(feed.getUserid()));
		return bean;
	}
	
	public void updateNewsFeed(ZyNewsfeed feed){
		feedService.updateNewsFeed(feed);
	}
	public List<FeedBean> getAtNewsFeed(int atuserId,int pageNo,int pageSize){
		List<FeedBean> results = new ArrayList<FeedBean>();
		List<ZyNewsfeed> feeds = feedService.getAtNewsFeed(atuserId,pageNo, pageSize);
		System.out.println("--------in facade--------feeds.size-------"+feeds.size());
		generateFeedBeanContent(feeds, results);
		return results;
	}
	
	public List<ZyNewsfeed> getUnreadAtNewsFeed(int atuserId,int pageNo,int pageSize){
		return feedService.getUnreadAtNewsFeed(atuserId, pageNo, pageSize);
	}
	
	public int getUnreadAtNewsFeedCnt(int atuserId){
		return feedService.getUnreadAtNewsFeedCnt(atuserId);
	}
	
	@Override
	public void blockFeed(int feedId, int userId) {
		feedService.blockFeed(feedId, userId);
	}
}
