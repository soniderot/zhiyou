package com.zy.action.profile;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport{

	public String getNewrequestcnt() {
		try {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	// ȡ�����������
    	int requestCnt = 0;
      //��ȡԭʼ��PrintWriter����,�Ա������Ӧ���,��������ת��ĳ����ͼ    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //�����ַ���
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //ֱ��������Ӧ������

      out.print(requestCnt);
      out.flush();    
      out.close();    

    } catch (Exception e) {
        e.printStackTrace();    
    }    
    return null; 
	}

	public String getNewnotificationcnt() {
		try {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	// ȡ����֪ͨ����
    	int notificationCnt = 11;
      //��ȡԭʼ��PrintWriter����,�Ա������Ӧ���,��������ת��ĳ����ͼ    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //�����ַ���
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //ֱ��������Ӧ������

      out.print(notificationCnt);
      out.flush();    
      out.close();    

    } catch (Exception e) {
        e.printStackTrace();    
    }    
    return null; 
	}

	public String getNewmessagecnt() {
		try {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	// ȡ������Ϣ����
    	int messageCnt = 12;
      //��ȡԭʼ��PrintWriter����,�Ա������Ӧ���,��������ת��ĳ����ͼ    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //�����ַ���
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //ֱ��������Ӧ������

      out.print(messageCnt);
      out.flush();    
      out.close();    

    } catch (Exception e) {
        e.printStackTrace();    
    }    
    return null; 
	}

	public String execute(){
		return "member.header";
	}
	
	
}
