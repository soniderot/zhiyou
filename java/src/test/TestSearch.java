package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.facade.SearchFacade;
import com.zy.facade.vo.SearchFormVo;
import com.zy.facade.vo.SearchResultVo;

public class TestSearch {
	public static void main(String[] args){
		SearchFormVo vo = new SearchFormVo();
		vo.setFullname("田");
		ClassPathXmlApplicationContext   appContext   =   new   ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-dao.xml","applicationContext-service.xml","applicationContext-facade.xml"});
		SearchFacade searchFacade = (SearchFacade)appContext.getBean("searchFacade");
		List<SearchResultVo>  list = searchFacade.getProfilesBySearch_tx(1, vo,100);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getProfileId());
		}
		System.out.println(list.size());
	}
}
