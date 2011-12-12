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
    	// 取得新请求个数
    	int requestCnt = 0;
      //获取原始的PrintWriter对象,以便输出响应结果,而不用跳转到某个试图    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //设置字符集
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //直接输入响应的内容

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
    	// 取得新通知个数
    	int notificationCnt = 11;
      //获取原始的PrintWriter对象,以便输出响应结果,而不用跳转到某个试图    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //设置字符集
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //直接输入响应的内容

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
    	// 取得新信息个数
    	int messageCnt = 12;
      //获取原始的PrintWriter对象,以便输出响应结果,而不用跳转到某个试图    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //设置字符集
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //直接输入响应的内容

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
