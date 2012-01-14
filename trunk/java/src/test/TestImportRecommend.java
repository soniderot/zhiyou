package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.facade.ProfileFacade;

public class TestImportRecommend {
	public static void main(String[] args){
		ClassPathXmlApplicationContext   appContext   =   new   ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-dao.xml","applicationContext-service.xml","applicationContext-facade.xml"});
		ProfileFacade profileFacade = (ProfileFacade)appContext.getBean("profileFacade");
	}
}
