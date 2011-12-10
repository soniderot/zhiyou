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
      //��ȡԭʼ��PrintWriter����,�Ա������Ӧ���,��������ת��ĳ����ͼ    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //�����ַ���
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //ֱ��������Ӧ������
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
