package test;

import java.util.List;

import octazen.addressbook.Contact;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.common.model.ZyProfile;
import com.zy.facade.SNSFacade;

public class Test {
	public static void main(String[] args) throws Exception{
		//System.out.println(SecurityUtil.getMD5("123456"));
		ClassPathXmlApplicationContext   appContext   =   new   ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-dao.xml","applicationContext-service.xml","applicationContext-facade.xml"});
		//ProfileFacade profileFacade = (ProfileFacade)appContext.getBean("profileFacade");
		//System.out.println("username=="+profileFacade.findBasicProfileById(1).getEmail());
		//GraphDao dao = new GraphDao();
		//dao.loadObject();
		
		SNSFacade snsFacade = (SNSFacade)appContext.getBean("snsFacade");
		snsFacade.addFriend(2,3);
		//Thread.sleep(5000);
		List<Integer> list = snsFacade.getAllFriendsByDegree(1,(short)2);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		//snsFacade.addSNSGroup(1,"mynew group");
		//snsFacade.removeSNSGroup(1,0);
		
		int[] array = new int[]{2};
		snsFacade.manageSNSGroup(1,2,array,0);
		
		List<ZyProfile> list1 = snsFacade.getAllFriends(1,2,(short)1);
		for(int i=0;i<list1.size();i++){
			System.out.println(list1.get(i).getUsername()+"---"+list1.get(i).getUserid());
		}
		
		List<ZyProfile> list2 = snsFacade.getMutualFriends(1,3);
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i).getUsername()+"---"+list2.get(i).getUserid());
		}
		
		List<Contact> list3 = snsFacade.importAddressBook(1,"kelvin_shpd@hotmail.com", "hahawhoami");
		for(int i=0;i<list3.size();i++){
			System.out.println(list3.get(i).getName()+"------"+list3.get(i).getEmail());
		}
		snsFacade.getProfilesYouMayKnow(1);
	}
}
