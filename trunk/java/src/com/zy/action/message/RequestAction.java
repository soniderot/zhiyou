package com.zy.action.message;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZyProfile;

public class RequestAction {
	public String execute(){
		return "member.requests";
	}
	public String addFriendRequest() {
    try {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String objectUserId = request.getParameter("to");
    	String requestContent = request.getParameter("content");
    	// �־û�����
    	
      //��ȡԭʼ��PrintWriter����,�Ա������Ӧ���,��������ת��ĳ����ͼ    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //�����ַ���
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //ֱ��������Ӧ������

      out.print("true");
      out.flush();    
      out.close();    

    } catch (Exception e) {
        // TODO: handle exception    
        e.printStackTrace();    
    }    
    return null;  

	}
}
