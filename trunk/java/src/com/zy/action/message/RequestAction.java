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
    	// 持久化请求
    	
      //获取原始的PrintWriter对象,以便输出响应结果,而不用跳转到某个试图    
      HttpServletResponse response = ServletActionContext.getResponse();    
      //设置字符集
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      //直接输入响应的内容

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
