package com.zy.action.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZyInterest;
import com.zy.common.util.ActionUtil;
import com.zy.facade.OptionFacade;

public class InterestAction {
	private String tagName;
	private int pageNo;
	private OptionFacade optionFacade;
	
	public OptionFacade getOptionFacade() {
		return optionFacade;
	}

	public void setOptionFacade(OptionFacade optionFacade) {
		this.optionFacade = optionFacade;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public String createInterestAjax(){
		
    HttpServletResponse response = ServletActionContext.getResponse();    
    response.setCharacterEncoding("UTF-8");
    PrintWriter out;
    try {
    	out = response.getWriter();
			ZyInterest interest = optionFacade.getInterestByTag(tagName);
			if (interest == null) {
				interest = new ZyInterest();
				interest.setTag(tagName);
				interest.setUserid(ActionUtil.getSessionUserId());
				interest.setFlag(0);
				interest.setCreatetime(new Date());
				optionFacade.saveOrUpdateInterest(interest);
			} else {
				int hot = interest.getHot();
				interest.setHot(hot + 1);
				optionFacade.saveOrUpdateInterest(interest);
			}
	    out.print(interest.getId());
	    out.flush();
	    out.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getInterestsAjax() {
		List<ZyInterest> interests = optionFacade.getInterestsByPagination(pageNo, 12);
		HttpServletRequest request = ActionUtil.getRequest();
		request.setAttribute("interests", interests);
		return "interest.nextpage";
	}

}
