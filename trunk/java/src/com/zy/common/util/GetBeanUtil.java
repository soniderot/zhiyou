package com.zy.common.util;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//import com.zy.common.util.ConfigurationUtil;


public class GetBeanUtil {
	private static GetBeanUtil instance;
	private static ApplicationContext ctx;
	public static GetBeanUtil getInstance() {
		if (instance == null) {	
			synchronized (GetBeanUtil.class) {
				if (instance == null) {
					instance = new GetBeanUtil();
				}
			}
		}
		return instance;
	}
	
   public Object getBean(String beanname)
    {
	   ServletContext context =null;
	   	try
	   	{
	   		context=ServletActionContext.getServletContext();
	   	}
	   	catch(NullPointerException ne)
	   	{
	   		if (ctx == null)
				ctx = new ClassPathXmlApplicationContext(new String[] {
						"applicationContext.xml", "applicationContext-dao.xml",
						"applicationContext-service.xml",
						"applicationContext-facade.xml" });
			return ctx.getBean(beanname);
	   	}
	   	WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		if (context != null) {
			return ctx.getBean(beanname);
		} else {
			return null;
		}
    	
    }
	
	
}
