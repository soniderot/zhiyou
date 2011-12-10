package com.zy.action.profile;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZyProfile;
import com.zy.facade.ProfileFacade;

public class ValidateAction extends MemberAction{
	
	private ProfileFacade profileFacade;
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String checkEmail(){
    try {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String email = request.getParameter("email");
    	ZyProfile profile = this.profileFacade.findProfileByEmail(email);
      //获取原始的PrintWriter对象,以便输出响应结果,而不用跳转到某个试图    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //设置字符集
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //直接输入响应的内容
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

}
