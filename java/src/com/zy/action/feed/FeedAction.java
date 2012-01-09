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
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyPhoto;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.common.util.Page;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.facade.FeedFacade;
import com.zy.facade.PhotoFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.QuestionFacade;
import com.zy.facade.SNSFacade;

public class FeedAction extends ActionSupport{
	private FeedFacade feedFacade;
	private ProfileFacade profileFacade;
	private QuestionFacade questionFacade;
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
	
	private String eventId;
	

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
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
	
	public String execute(){
		System.out.println("--------------into-------------feed--------handle----"+handle);
		List<Integer> ids = snsFacade.getAllFriendsByDegree(ActionUtil.getSessionUserId(),(short)1);
		ids.add(ActionUtil.getSessionUserId());
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
			feeds = feedFacade.getNewsFeed(str,null,pageNo,pageSize);
			count = feedFacade.getNewsFeed(str,null,1,Integer.MAX_VALUE).size();
		}else{
			String str1 = handle.replaceAll(",", "','");
			feeds = feedFacade.getNewsFeed(str,"'"+str1+"'",pageNo,pageSize);
			count = feedFacade.getNewsFeed(str,"'"+str1+"'",1,Integer.MAX_VALUE).size();
		}
		System.out.println("-------------count------------"+count);
		page = new Page(count,pageNo,10,5);
		
		return "member.feeds";
	}
	
	public String updateStatusAjax() {
		System.out.println("------------------into update status ajax-------------"+feedtype);
		System.out.println("-----------------------file----------"+feedphoto);
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
			photo.setFilename("/photos/album/"+str);
			List<ZyAlbum> albums = photoFacade.getAlbumList(ActionUtil.getSessionUserId());
			if(albums.size()>0){
				photo.setAlbumno(albums.get(0).getId());
			}else{
				photo.setAlbumno(0);
			}
			photo.setCreatetime(new Date());
			photo.setUserid(ActionUtil.getSessionUserId());
			photoFacade.createPhoto(photo);
			if(eventId==null||eventId.trim().length()==0){
				feedBean = feedFacade.addNewPhotoNewsFeed(ActionUtil.getSessionUserId(),photo.getId());
			}else{
				feedBean = feedFacade.addNewEventPhotoNewsFeed(ActionUtil.getSessionUserId(),Integer.valueOf(eventId).intValue(),photo.getId());
			}
		} else if (feedmessage!=null&&feedmessage.trim().length()>0){
			System.out.println("---------------feedmessage------------"+eventId);
			if(eventId==null||eventId.trim().length()==0){
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
		return "member.addfeedcomment.ajax";
	}
	
	public String sharedFeed(){
		feedFacade.shareNewsFeed_tx(ActionUtil.getSessionUserId(), feedId);
		//return NONE;
		return "to.member.feeds";
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
}
