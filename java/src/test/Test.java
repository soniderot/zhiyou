package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.common.util.SecurityUtil;
import com.zy.domain.sns.dao.GraphDao;
import com.zy.facade.ProfileFacade;

public class Test {
	public static void main(String[] args){
		//System.out.println(SecurityUtil.getMD5("123456"));
		//ClassPathXmlApplicationContext   appContext   =   new   ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-dao.xml","applicationContext-service.xml","applicationContext-facade.xml"});
		//ProfileFacade profileFacade = (ProfileFacade)appContext.getBean("profileFacade");
		//System.out.println("username=="+profileFacade.findBasicProfileById(1).getEmail());
		GraphDao dao = new GraphDao();
		dao.loadObject();
	}
}
