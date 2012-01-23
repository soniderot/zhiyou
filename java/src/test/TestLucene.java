package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.facade.LuceneIndexFacade;

public class TestLucene {
	public static void main(String[] args){
		ClassPathXmlApplicationContext   appContext   =   new   ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-dao.xml","applicationContext-service.xml","applicationContext-facade.xml"});
		LuceneIndexFacade luceneIndexFacade = (LuceneIndexFacade)appContext.getBean("luceneIndexFacade");
		luceneIndexFacade.doProfileIndex_tx("c://200",100);
		//luceneIndexFacade.doProfileIndex_tx("/test/lucence",100);
	}
}
