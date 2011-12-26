package com.zy.action.feed;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZyPhoto;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.facade.FeedFacade;
import com.zy.facade.PhotoFacade;
import com.zy.facade.SNSFacade;

public class FeedAction {
	private FeedFacade feedFacade;
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
		if(handle==null||handle.trim().length()==0){
			feeds = feedFacade.getNewsFeed(str,null,pageNo,pageSize);
		}else{
			String str1 = handle.replaceAll(",", "','");
			feeds = feedFacade.getNewsFeed(str,"'"+str1+"'",pageNo,pageSize);
		}
		return "member.feeds";
	}
	
	public String updateStatusAjax() {
		/*
		System.out.println("------------------into update status ajax-------------");
		feedBean = feedFacade.addNewBlogNewsFeed(ActionUtil.getSessionUserId(), feedmessage);
		return "member.addfeed.ajax";*/
		
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
			photo.setAlbumno(1);
			photo.setCreatetime(new Date());
			photo.setUserid(ActionUtil.getSessionUserId());
			photoFacade.createPhoto(photo);
			
			feedBean = feedFacade.addNewPhotoNewsFeed(ActionUtil.getSessionUserId(),photo.getId());
		} else if ("feedmessage".equals(feedtype)) {
			
			
			feedBean = feedFacade.addNewBlogNewsFeed(ActionUtil.getSessionUserId(), feedmessage);
		} else {
			// add question here
			
			feedBean = feedFacade.addNewBlogNewsFeed(ActionUtil.getSessionUserId(), feedmessage);
		}
		feeds = new ArrayList<FeedBean>();
		feeds.add(feedBean);
		return "member.addfeed.ajax";
	}
	
	public String addFeedCommentAjax() {
		// save this.feedId this.feedComment here
		
		return "member.addfeedcomment.ajax";
	}
	
	public static void main(String[] args){
		String str = "sns.event.create,sns.event.join";
		System.out.println(str.replaceAll(",", "','"));
	}
}
