package com.zy.domain.message.bean;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.common.model.ZyRequest;
import com.zy.common.model.ZyRequesttype;
import com.zy.common.util.HtmlUtil;
import com.zy.common.util.StringHelper;

public class RequestBean {
	private ZyProfile profile;
	private ZyRequest request;
	private String content;
	private ZyRequesttype requestType;
	private List<ZyProfile> renmailist;
	private int profilesize;
	private String formatedMsg;
	private boolean hiddenFormateMsg;
	private String extraInfo;
	private short requestOption;
	private String requestNote;
	
	private ZyEvent event;
	private ZyQuestion question;
	
	public ZyQuestion getQuestion() {
		return question;
	}

	public void setQuestion(ZyQuestion question) {
		this.question = question;
	}

	public ZyEvent getEvent() {
		return event;
	}

	public void setEvent(ZyEvent event) {
		this.event = event;
	}

	public String getFormatedMsg() {
		if(request.getMessage()==null){
			return null;
		}
		String str = request.getMessage();
		
		if(request.getEventkey()==8||request.getEventkey()==9){
			String formattedContent = StringEscapeUtils.unescapeHtml(request.getMessage());
			str = StringUtils.replace(formattedContent, "<br>", "\n");
		}
		
		str = this.wrapMsg(str);
		return HtmlUtil.getFormattedContent(str);
	}
	
	public String getFormatedMsgWithoutWrap() {
		if(request.getMessage()==null){
			return null;
		}
		String str = request.getMessage();
		
		if(request.getEventkey()==8||request.getEventkey()==9){
			String formattedContent = StringEscapeUtils.unescapeHtml(request.getMessage());
			str = StringUtils.replace(formattedContent, "<br>", "\n");
		}
		
		str = StringUtils.replace(str, "\r\n", "<br>");
		str = StringUtils.replace(str, "\n", "<br>");
		return str;
	}
	
	public void setFormatedMsg(String formatedMsg) {
		this.formatedMsg = formatedMsg;
	}
	public List<ZyProfile> getRenmailist() {
		return renmailist;
	}
	public void setRenmailist(List<ZyProfile> renmailist) {
		this.renmailist = renmailist;
	}

	public ZyProfile getProfile() {
		return profile;
	}
	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}
	public ZyRequest getRequest() {
		return request;
	}
	public void setRequest(ZyRequest request) {
		this.request = request;
	}
	public ZyRequesttype getRequestType() {
		return requestType;
	}
	public void setRequestType(ZyRequesttype requestType) {
		this.requestType = requestType;
	}
	public int getProfilesize() {
		return profilesize;
	}
	public void setProfilesize(int profilesize) {
		this.profilesize = profilesize;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public short getRequestOption() {
		return requestOption;
	}
	public void setRequestOption(short requestOption) {
		this.requestOption = requestOption;
	}
	public String getRequestNote() {
		return requestNote;
	}
	public void setRequestNote(String requestNote) {
		this.requestNote = requestNote;
	}
	public boolean getHiddenFormateMsg() {
		return hiddenFormateMsg;
	}
	public void setHiddenFormateMsg(boolean hiddenFormateMsg) {
		this.hiddenFormateMsg = hiddenFormateMsg;
	}
	private String wrapMsg(String msg){
		if(msg == null){
			this.setHiddenFormateMsg(false);
			return "";
		}
		
		int clens = msg.getBytes().length;
		if(clens <= com.zy.Constants.REQUEST_LIST_CONTENT_MAX_SIZE){
			this.setHiddenFormateMsg(false);
			return msg;
		}
		
		this.setHiddenFormateMsg(true);
		
		msg = HtmlUtil.removeNewLineTags(msg);
		clens = msg.getBytes().length;
		if(clens <= com.zy.Constants.REQUEST_LIST_CONTENT_MAX_SIZE){
			return msg;
		}
		
		String wrapedstr = StringHelper.subStringByByte(msg, com.zy.Constants.REQUEST_LIST_CONTENT_MAX_SIZE);
		wrapedstr = wrapedstr + "……";
		return wrapedstr;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	
}
