package com.zy.action.feed;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.Constants;
import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyFriendgroup;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyPhoto;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.common.util.Page;
import com.zy.domain.feed.bean.CommentBean;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.facade.FeedFacade;
import com.zy.facade.MessageFacade;
import com.zy.facade.NotifyFacade;
import com.zy.facade.PhotoFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.QuestionFacade;
import com.zy.facade.RequestFacade;
import com.zy.facade.SNSFacade;
import com.zy.facade.vo.FriendJoinedVO;
import com.zy.facade.vo.QuestionVO;

public class FeedAction extends ActionSupport{
	private FeedFacade feedFacade;
	private ProfileFacade profileFacade;
	private QuestionFacade questionFacade;
	private RequestFacade requestFacade;
	private MessageFacade messageFacade;
	private SNSFacade snsFacade;
	private List<FeedBean> feeds;
	
	private short pageNo = 1;
	private short pageSize = 12;
	
	private String feedmessage;
	private int messagegroup;
	
	private FeedBean feedBean;
	
	private File feedphoto;
	private String feedphotoContentType;
	
	private String feedtype;
	
	private PhotoFacade photoFacade;
	
	private String handle;
	
	private int feedId;
	
	private String feedComment;
	private String question;
	private String[] options;
	private ZyNewsfeedcomment comment;
	private ZyProfile user;
	private Page page;
	
	private int eventId;
	private List<ZyProfile> friends;
	private List<FriendJoinedVO> groupFriends;
	private int questionId;
	private int optionId;
	private List<QuestionVO> askedFriends;
	private String invitees;
	private String fromPage;
	private boolean optionAddAble;
	private String optionText;
	private ZyAnsweroption answerOption;
	
	private NotifyFacade notifyFacade;
	
	private int friendId;
	private int groupId;
	private ZyFriendgroup friendGroup;
	
	private List<ZyProfile> friendsInGroup;
	
	public List<FriendJoinedVO> getGroupFriends() {
		return groupFriends;
	}
	public void setGroupFriends(List<FriendJoinedVO> groupFriends) {
		this.groupFriends = groupFriends;
	}
	public ZyFriendgroup getFriendGroup() {
		return friendGroup;
	}
	public void setFriendGroup(ZyFriendgroup friendGroup) {
		this.friendGroup = friendGroup;
	}
	public List<ZyProfile> getFriendsInGroup() {
		return friendsInGroup;
	}
	public void setFriendsInGroup(List<ZyProfile> friendsInGroup) {
		this.friendsInGroup = friendsInGroup;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public NotifyFacade getNotifyFacade() {
		return notifyFacade;
	}

	public void setNotifyFacade(NotifyFacade notifyFacade) {
		this.notifyFacade = notifyFacade;
	}

	public MessageFacade getMessageFacade() {
		return messageFacade;
	}

	public void setMessageFacade(MessageFacade messageFacade) {
		this.messageFacade = messageFacade;
	}
	
	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	
	public ZyAnsweroption getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(ZyAnsweroption answerOption) {
		this.answerOption = answerOption;
	}
	
	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public boolean isOptionAddAble() {
		return optionAddAble;
	}

	public void setOptionAddAble(boolean optionAddAble) {
		this.optionAddAble = optionAddAble;
	}

	public String getFromPage() {
		return fromPage;
	}

	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}

	public String getInvitees() {
		return invitees;
	}

	public RequestFacade getRequestFacade() {
		return requestFacade;
	}

	public void setRequestFacade(RequestFacade requestFacade) {
		this.requestFacade = requestFacade;
	}
	
	public void setInvitees(String invitees) {
		this.invitees = invitees;
	}

	public List<QuestionVO> getAskedFriends() {
		return askedFriends;
	}

	public void setAskedFriends(List<QuestionVO> askedFriends) {
		this.askedFriends = askedFriends;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public List<ZyProfile> getFriends() {
		return friends;
	}

	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
	}

	

	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public ZyProfile getUser() {
		return user;
	}

	public void setUser(ZyProfile user) {
		this.user = user;
	}

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public ZyNewsfeedcomment getComment() {
		return comment;
	}

	public void setComment(ZyNewsfeedcomment comment) {
		this.comment = comment;
	}

	public int getFeedId() {
		return feedId;
	}

	public String getFeedComment() {
		return feedComment;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public void setFeedComment(String feedComment) {
		this.feedComment = feedComment;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public PhotoFacade getPhotoFacade() {
		return photoFacade;
	}

	public void setPhotoFacade(PhotoFacade photoFacade) {
		this.photoFacade = photoFacade;
	}

	public String getFeedtype() {
		return feedtype;
	}

	public void setFeedtype(String feedtype) {
		this.feedtype = feedtype;
	}

	public File getFeedphoto() {
		return feedphoto;
	}

	public void setFeedphoto(File feedphoto) {
		this.feedphoto = feedphoto;
	}

	public String getFeedphotoContentType() {
		return feedphotoContentType;
	}

	public void setFeedphotoContentType(String feedphotoContentType) {
		this.feedphotoContentType = feedphotoContentType;
	}

	public FeedBean getFeedBean() {
		return feedBean;
	}

	public void setFeedBean(FeedBean feedBean) {
		this.feedBean = feedBean;
	}

	public String getFeedmessage() {
		return feedmessage;
	}

	public int getMessagegroup() {
		return messagegroup;
	}

	public void setFeedmessage(String feedmessage) {
		this.feedmessage = feedmessage;
	}

	public void setMessagegroup(int messagegroup) {
		this.messagegroup = messagegroup;
	}

	public short getPageNo() {
		return pageNo;
	}

	public void setPageNo(short pageNo) {
		this.pageNo = pageNo;
	}

	public short getPageSize() {
		return pageSize;
	}

	public void setPageSize(short pageSize) {
		this.pageSize = pageSize;
	}

	public List<FeedBean> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<FeedBean> feeds) {
		this.feeds = feeds;
	}

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getOptions() {
		return options;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public QuestionFacade getQuestionFacade() {
		return questionFacade;
	}

	public void setQuestionFacade(QuestionFacade questionFacade) {
		this.questionFacade = questionFacade;
	}
	
	public String getAtmeFeed(){
		feeds = feedFacade.getAtNewsFeed(ActionUtil.getSessionUserId(),pageNo,pageSize);
		for(int i=0;i<feeds.size();i++){
			if(!"Y".equalsIgnoreCase(feeds.get(i).getFeed().getAtread())){
				ZyNewsfeed zyFeed = feeds.get(i).getFeed();
				zyFeed.setAtread("Y");
				feedFacade.updateNewsFeed(zyFeed);
			}
		}
		int count = 0;
		System.out.println("-------------count------------"+count);
		page = new Page(count,pageNo,pageSize,5);
		
		return "member.feeds";
	}
	
	public String execute(){
		System.out.println("--------------into-------------feed--------handle----"+handle);
		List<Integer> ids = snsFacade.getAllFriendsByDegree(ActionUtil.getSessionUserId(),(short)1);
		int userId = ActionUtil.getSessionUserId();
		ids.add(userId);
		String str = "";
		for(int i=0;i<ids.size();i++){
			if(i!=ids.size()-1){
				str = str+ids.get(i)+",";
			}else{
				str = str+ids.get(i);
			}
		}
		int count = 0;
		if(handle==null||handle.trim().length()==0){
			feeds = feedFacade.getNewsFeed(userId, str,null,pageNo,pageSize);
			count = feedFacade.getNewsFeed(userId, str,null,1,Integer.MAX_VALUE).size();
		}else{
			String str1 = handle.replaceAll(",", "','");
			feeds = feedFacade.getNewsFeed(userId, str,"'"+str1+"'",pageNo,pageSize);
			count = feedFacade.getNewsFeed(userId, str,"'"+str1+"'",1,Integer.MAX_VALUE).size();
		}
		System.out.println("-------------count------------"+count);
		page = new Page(count,pageNo,10,5);
		
		return "member.feeds";
	}
	
	public String uploadEventPhoto() {
		System.out.println(eventId);
		// photo description
		System.out.println(feedmessage);
		
		if (feedphoto!=null) {
			String filetype = null;
			filetype = FileUtil.isJPGorPNG(this.getFeedphotoContentType());
			if (StringUtils.isBlank(filetype)) {
				return "member.event.photos";
			}
			String root = ServletActionContext.getServletContext().getRealPath("/");
			final String photoDir = File.separator + "photos/album";
			String token = UUID.randomUUID() + "";
			String fn = token + filetype;
			String fileName = FileUtil.copy(feedphoto, root + photoDir, fn);
			System.out.println(fileName);
			String datedir = DateUtil.formatDate(new Date());
			String str = datedir + "/" + fn;
			
			System.out.println(str);
			ZyPhoto photo = new ZyPhoto();
			photo.setPhotoFilename("/photos/album/"+str);
			List<ZyAlbum> albums = photoFacade.getAlbumList(ActionUtil.getSessionUserId());
			if(albums.size()>0){
				photo.setAlbumno(albums.get(0).getId());
			}else{
				photo.setAlbumno(0);
			}
			photo.setCreatetime(new Date());
			photo.setUserid(ActionUtil.getSessionUserId());
			photo.setEventid(eventId);
			photoFacade.createPhoto(photo);
			
			feedBean = feedFacade.addNewEventPhotoNewsFeed(ActionUtil.getSessionUserId(),Integer.valueOf(eventId).intValue(),photo.getId());
			
		}
		
		return "eventaction.detail";
	}
	
	
	public String updateStatusAjax() {
		
		if (feedphoto!=null) {
			String filetype = null;
			filetype = FileUtil.isJPGorPNG(this.getFeedphotoContentType());
			if (StringUtils.isBlank(filetype)) {
				return "member.addfeed.ajax";
			}
			String root = ServletActionContext.getServletContext().getRealPath("/");
			final String photoDir = File.separator + "photos/album";
			String token = UUID.randomUUID() + "";
			String fn = token + filetype;
			String fileName = FileUtil.copy(feedphoto, root + photoDir, fn);
			System.out.println(fileName);
			String datedir = DateUtil.formatDate(new Date());
			String str = datedir + "/" + fn;
			
			System.out.println(str);
			ZyPhoto photo = new ZyPhoto();
			photo.setPhotoFilename("/photos/album/"+str);
			List<ZyAlbum> albums = photoFacade.getAlbumList(ActionUtil.getSessionUserId());
			if(albums.size()>0){
				photo.setAlbumno(albums.get(0).getId());
			}else{
				photo.setAlbumno(0);
			}
			photo.setCreatetime(new Date());
			photo.setUserid(ActionUtil.getSessionUserId());
			photoFacade.createPhoto(photo);
			
			if(eventId==0){
				feedBean = feedFacade.addNewPhotoNewsFeed(ActionUtil.getSessionUserId(),photo.getId());
			}else{
				feedBean = feedFacade.addNewEventPhotoNewsFeed(ActionUtil.getSessionUserId(),Integer.valueOf(eventId).intValue(),photo.getId());
			}
		} else if (feedmessage!=null&&feedmessage.trim().length()>0){
			System.out.println("---------------feedmessage------------"+eventId);
			if(eventId==0){
				feedBean = feedFacade.addNewBlogNewsFeed(ActionUtil.getSessionUserId(), feedmessage);
			}else{
				System.out.println("--------------begin to add event newsfeed----"+eventId);
				feedBean = feedFacade.addNewEventBlogNewsFeed(ActionUtil.getSessionUserId(),Integer.valueOf(eventId), feedmessage);
			}
		} else {
			// add question here
			List<String> newOptions = new ArrayList<String>();
			if (options != null && options.length > 0) {
				for (int i = 0; i< options.length; i++) {
					String option = options[i];
					if (!"".equals(option)) {
						newOptions.add(option);
					}
				}
			}
			
			ZyQuestion zyQuestion = new ZyQuestion();
			zyQuestion.setSummary(question);
			zyQuestion.setOptionaddable(optionAddAble);
			zyQuestion.setUserid(ActionUtil.getSessionUserId());
			if (newOptions.size() > 0) {
				zyQuestion.setType(Constants.QUESTION_TYPE_OPTIONS);
			} else {
				zyQuestion.setType(Constants.QUESTION_TYPE_COMMON);
			}
			questionFacade.addQuestion(zyQuestion);
			questionFacade.addAnswerQuestion(newOptions, zyQuestion.getId());
			feedBean = feedFacade.addNewQuestionNewsFeed(ActionUtil.getSessionUserId(), zyQuestion.getId(), question);
		}
		feeds = new ArrayList<FeedBean>();
		feeds.add(feedBean);
		
		if(friendId>0){
			ZyNewsfeed feed = feedBean.getFeed();
			feed.setAtuserid(friendId);
			String username = profileFacade.findProfileById(friendId).getUsername();
			if("status".equalsIgnoreCase(feedtype)){
				feed.setBody(feedmessage.replace("@"+username+":",""));
			}
			feedFacade.updateNewsFeed(feed);
		}
		return "member.addfeed.ajax";
	}
	
	public String addFeedCommentAjax() {
		// save this.feedId this.feedComment here
		System.out.println("----feedid------"+feedId);
		System.out.println("----feedComment------"+feedComment);
		
		comment = new ZyNewsfeedcomment();
		comment.setNewsfeedid(feedId);
		comment.setContent(feedComment);
		comment.setCreated(new Date());
		comment.setUserid(ActionUtil.getSessionUserId());
		feedFacade.addComment(comment);
		
		user = profileFacade.findProfileById(comment.getUserid());
		
		System.out.println("--------before return------------");
		if ("questionDetail".equals(fromPage)) {
			return "question.addfeedcomment.ajax";
		}
		return "member.addfeedcomment.ajax";
	}
	
	public String sharedFeedAjax(){
		String shareReason = ActionUtil.getRequest().getParameter("shareReason");
		feedFacade.shareNewsFeed_tx(ActionUtil.getSessionUserId(), feedId, shareReason);
		//return NONE;
		return "member.sharefeeds.pop";
	}
	
	public String manageFeedCommentAjax() {
		try {
	    //commentId : commentId
	    //manageType : manageType 1:delete
			System.out.println("-------manageFeedCommentAjax---" );
			int commentId = Integer.parseInt(ActionUtil.getRequest().getParameter("commentId"));
			System.out.println("-------manageFeedCommentAjax---" + commentId);
			int manageType = Integer.parseInt(ActionUtil.getRequest().getParameter("manageType"));
			if(manageType == 1) {
				feedFacade.removeComment(commentId);
	      HttpServletResponse response = ServletActionContext.getResponse();    
	      response.setCharacterEncoding("UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print("true");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deleteFeedAjax() {
		try {
			int feedId = Integer.parseInt(ActionUtil.getRequest().getParameter("feedId"));
			feedFacade.removeFeed(feedId);
      HttpServletResponse response = ServletActionContext.getResponse();    
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print("true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String blockFeedAjax() {
		try {
			int feedId = Integer.parseInt(ActionUtil.getRequest().getParameter("feedId"));
			feedFacade.blockFeed(feedId, ActionUtil.getSessionUserId());
      HttpServletResponse response = ServletActionContext.getResponse();    
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print("true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String voteOptionAjax() {
		int optionId = Integer.parseInt(ActionUtil.getRequest().getParameter("optionId"));
		ZyAnsweroption option = questionFacade.getAnsweroptionById(optionId);
		List<ZyAnswer> answers = questionFacade.getAnswerByUserAndOption(ActionUtil.getSessionUserId(), optionId);
		ZyAnswer answer = null;
		if (answers != null && answers.size() > 0) {
			answer = answers.get(0);
		}
		int hot;
		if (answer == null) {
			hot = option.getHot() + 1;
			option.setHot(hot);
			questionFacade.updateAnsweroption(option);
			answer = new ZyAnswer();
			answer.setAnswer(option.getSummary());
			answer.setCreatetime(new Date());
			answer.setQuestionid(option.getQuestionid());
			answer.setOptionanswer(optionId);
			answer.setUserid(ActionUtil.getSessionUserId());
			questionFacade.addAnswer(answer);
		} else {
			hot = option.getHot() - 1;
			option.setHot(hot);
			questionFacade.updateAnsweroption(option);
			questionFacade.removeAnswer(answer.getId());
		}
		try {
	    HttpServletResponse response = ServletActionContext.getResponse();    
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    out.print(hot);
	    out.flush();
	    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String askFriendsAjax() {
		askedFriends = questionFacade.getAskedFriends(ActionUtil.getSessionUserId(), questionId);
		return "ask.friends.ajax";
	}
	
	public String inviteFriendsAjax() {
		String result = "false";
		String message = ActionUtil.getRequest().getParameter("inviteMessage");
		if(invitees != null && invitees.length() > 0){
			String[] array = invitees.split(" ");
			for(int i = 0; i < array.length; i++){
				requestFacade.sendRequest_tx(ActionUtil.getSessionUserId(), Integer.valueOf(array[i]), (short)16, questionId, message, null);
			}
			result = "true";
		}
    try {
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(result);
      out.flush();    
      out.close();    
    } catch (Exception e) {  
      e.printStackTrace();    
    }
		return null;
	}

	public String addQuestionOptionAjax() {
		answerOption = new ZyAnsweroption();
		answerOption.setQuestionid(questionId);
		answerOption.setSummary(optionText);
		answerOption.setHot(0);
		questionFacade.addAnsweroption(answerOption);
		return "member.addOption.ajax";
	}
	
	public String getOptionUsersAjax() {
		friends = questionFacade.getOptionUsers(optionId);
		return "member.getOptionUsers.pop";
	}

	public String getNoticeAjax() {
    try {
  		int newrequestcnt = requestFacade.getUserRequestInbox(ActionUtil.getSessionUserId(),1,10000).size();
  		int newnotificationcnt = notifyFacade.countForNewNotification(ActionUtil.getSessionUserId());
  		int newmessagecnt = messageFacade.countForNewInbox(ActionUtil.getSessionUserId());
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(newrequestcnt + " " + newmessagecnt + " " + newnotificationcnt);
      out.flush();    
      out.close();    
    } catch (Exception e) {   
      e.printStackTrace();    
    }
    return null;
	}

	public String showBigPhotoAjax() {
		feedBean = new FeedBean();
		ZyNewsfeed feed = feedFacade.getFeedById(feedId);
		feedBean.setFeed(feed);
		ZyProfile user = profileFacade.findProfileById(feed.getUserid());
		feedBean.setUser(user);
		while ("sns.share.photo".equals(feed.getHandle())) {
			feed = feedFacade.getFeedById(Integer.parseInt(feed.getBody()));
		}
		ZyPhoto photo = photoFacade.getPhoto(Integer.parseInt(feed.getBody()));
		feedBean.setPhoto(photo);
		List<CommentBean> comments = feedFacade.getFeedCommentsById(feedId);
		feedBean.setComments(comments);
		return "member.feed.bigPhoto";
	}
	
	public String getFeedsOfGroup(){
		List<ZyProfile> list = snsFacade.getAllFriends(ActionUtil.getSessionUserId(),groupId,(short)1);
		friendGroup = snsFacade.getSNSGroup(groupId);
		System.out.println(friendGroup.getGroupname());
		if(list.size()==0){
			return "snsgroup.feeds";
		}
		friendsInGroup = list;
		System.out.println("--------------into-------------feed--------handle----"+handle);
		int userId = ActionUtil.getSessionUserId();
		
		String str = "";
		for(int i=0;i<list.size();i++){
			if(i!=list.size()-1){
				str = str+list.get(i).getUserid()+",";
			}else{
				str = str+list.get(i).getUserid();
			}
		}
		int count = 0;
		if(handle==null||handle.trim().length()==0){
			feeds = feedFacade.getNewsFeed(userId, str,null,pageNo,pageSize);
			count = feedFacade.getNewsFeed(userId, str,null,1,Integer.MAX_VALUE).size();
		}else{
			String str1 = handle.replaceAll(",", "','");
			feeds = feedFacade.getNewsFeed(userId, str,"'"+str1+"'",pageNo,pageSize);
			count = feedFacade.getNewsFeed(userId, str,"'"+str1+"'",1,Integer.MAX_VALUE).size();
		}
		System.out.println("-------------count------------"+count);
		page = new Page(count,pageNo,10,5);
		
		return "snsgroup.feeds";
	}

	public String getGrpFriendsAjax() {
		groupFriends = snsFacade.getGroupFriends(ActionUtil.getSessionUserId(), groupId);
		return "snsgroup.friends";
	}
}
