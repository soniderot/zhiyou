package com.zy.action.profile;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.SecurityUtil;
import com.zy.facade.ProfileFacade;

public class ValidateAction extends MemberAction{
	
	private ProfileFacade profileFacade;
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String checkEmailAjax(){
    try {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String email = request.getParameter("email");
    	ZyProfile profile = this.profileFacade.findProfileByEmail(email);
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      if (profile == null) {
      	out.print("false");
      } else {
      	out.print("true");
      }
      out.flush();    
      out.close();    

    } catch (Exception e) {
        // TODO: handle exception    
        e.printStackTrace();    
    }    
    return null;  
	}

	public String checkPasswordAjax(){
    try {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String password = request.getParameter("password");
    	password = SecurityUtil.getMD5(password);
    	ZyProfile profile = this.profileFacade.findProfileById(ActionUtil.getSessionUserId());
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      if (password.equals(profile.getPasswd())) {
      	out.print("true");
      } else {
      	out.print("false");
      }
      out.flush();    
      out.close();    

    } catch (Exception e) {
        // TODO: handle exception    
        e.printStackTrace();    
    }    
    return null;  
	}
	
}
