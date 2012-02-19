package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.common.model.ZyEvent;
import com.zy.domain.event.dao.EventDao;

public class Test {
	public static void main(String[] args) throws Exception{
		// System.out.println(SecurityUtil.getMD5("123456"));
		ClassPathXmlApplicationContext   appContext   =   new   ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-dao.xml","applicationContext-service.xml","applicationContext-facade.xml"});
		// ProfileFacade profileFacade =
		// (ProfileFacade)appContext.getBean("profileFacade");
		// System.out.println("username=="+profileFacade.findBasicProfileById(1).getEmail());
		// GraphDao dao = new GraphDao();
		// dao.loadObject();
		
		/*
		 * SNSFacade snsFacade = (SNSFacade)appContext.getBean("snsFacade");
		 * snsFacade.addFriend(2,3);
		 * 
		 * List<Integer> list = snsFacade.getAllFriendsByDegree(1,(short)2);
		 * for(int i=0;i<list.size();i++){ System.out.println(list.get(i)); }
		 * 
		 * 
		 * int[] array = new int[]{2}; snsFacade.manageSNSGroup(1,2,array,0);
		 * 
		 * List<ZyProfile> list1 = snsFacade.getAllFriends(1,2,(short)1);
		 * for(int i=0;i<list1.size();i++){
		 * System.out.println(list1.get(i).getUsername()+"---"+list1.get(i).getUserid()); }
		 * 
		 * List<ZyProfile> list2 = snsFacade.getMutualFriends(1,3); for(int
		 * i=0;i<list2.size();i++){
		 * System.out.println(list2.get(i).getUsername()+"---"+list2.get(i).getUserid()); }
		 * 
		 * List<Contact> list3 =
		 * snsFacade.importAddressBook(1,"kelvin_shpd@hotmail.com",
		 * "hahawhoami"); for(int i=0;i<list3.size();i++){
		 * System.out.println(list3.get(i).getName()+"------"+list3.get(i).getEmail()); }
		 * snsFacade.getProfilesYouMayKnow(1);
		 */
		
		/*
		 * RequestFacade requestFacade =
		 * (RequestFacade)appContext.getBean("requestFacade");
		 * requestFacade.sendRequest_tx(1,2, (short)1,0,"hello",null); List<RequestBean>
		 * list = requestFacade.getUserRequestInbox(2,1,100);
		 * System.out.println(list.size()); for(int i=0;i<list.size();i++){
		 * System.out.println(list.get(i).getContent());
		 * System.out.println(list.get(i).getFormatedMsg());
		 * System.out.println(list.get(i).getProfile().getUsername()); }
		 * requestFacade.approveRequest_tx(3);
		 */
		/*
		 * NotifyFacade notifyFacade =
		 * (NotifyFacade)appContext.getBean("notifyFacade"); List<NotificationBean>
		 * list = notifyFacade.getUserNotification(1,1,10000);
		 * System.out.println("notify.size--"+list.size()); for(int i=0;i<list.size();i++){
		 * System.out.println(list.get(i).getId());
		 * System.out.println(list.get(i).getContent()); }
		 */
		
		// notifyFacade.systemSendNotification_tx(1,(short)1,new Object[]{2});
		
		// FeedFacade feedFacade = (FeedFacade)appContext.getBean("feedFacade");
		// feedFacade.addNewFriendNewsFeed(1,2);
		// feedFacade.addNewBlogNewsFeed(1,"大家好！");
		// List<FeedBean> list = feedFacade.getNewsFeed("1,2,3,4",null,1, 1000);
		// for(int i=0;i<list.size();i++){
		// System.out.println(list.get(i).getUser().getUsername());
		// System.out.println(list.get(i).getFeed().getBody());
		// }
		
		/*
		 * SNSFacade snsFacade = (SNSFacade)appContext.getBean("snsFacade");
		 * List<Integer> ids = snsFacade.getAllFriendsByDegree(1,(short)1);
		 * String str = "1"+","; for(int i=0;i<ids.size();i++){
		 * if(i!=ids.size()-1){ str = str+ids.get(i)+","; }else{ str =
		 * str+ids.get(i); } } System.out.println(str);
		 */
		
		/*
		 * MessageFacade messageFacade =
		 * (MessageFacade)appContext.getBean("messageFacade"); List<MessageBean>
		 * list = messageFacade.getMessageInbox(1,(short)1, (short)100);
		 * System.out.println(list.size());
		 */
		
		/*
		FeedFacade feedFacade = (FeedFacade)appContext.getBean("feedFacade");
		
		List<FeedBean> feeds = feedFacade.getAtNewsFeed(1,1,1000);
		
		System.out.println("feeds.size==="+feeds.size());
		
		for(int i=0;i<feeds.size();i++){
			System.out.println("-----feed.id------"+feeds.get(i).getFeed().getId());
		}*/
		
		// List<Integer> ids = snsFacade.getAllFriendsByDegree(3,(short)1);
		// for(int i=0;i<ids.size();i++){
		// System.out.println(ids.get(i));
		// }
		
		/*
		 * List<ZyProfile> profiles = snsFacade.getProfilesYouMayKnow(1);
		 * for(int i=0;i<profiles.size();i++){
		 * System.out.println(profiles.get(i).getUsername()); }
		 */
		
		
		// RequestFacade requestFacade =
		// (RequestFacade)appContext.getBean("requestFacade");
		// requestFacade.sendRequest_tx(1,2,(short)1,0, "hihi", null);
		
		// EventFacade eventFacade =
		// (EventFacade)appContext.getBean("eventFacade");
		// eventFacade.removeMember(1, 6);
		/*
		 * ZyEvent event = new ZyEvent(); event.setAddress("南京东路");
		 * event.setBegintime(new Date()); event.setEndtime(new Date());
		 * event.setCityid(8843); event.setCreateuserid(1);
		 * event.setCreatetime(new Date()); event.setEventname("唱歌比赛");
		 * event.setUpdatetime(new Date()); eventFacade.createEvent(event);
		 */
		
		
		
		// RequestFacade requestFacade =
		// (RequestFacade)appContext.getBean("requestFacade");
		// requestFacade.sendRequest_tx(1,2,(short)5,19,"",null);
		
		/*
		 * EventFacade eventFacade =
		 * (EventFacade)appContext.getBean("eventFacade"); List<ZyRecommplace>
		 * list = eventFacade.getRecommPlaces(1,1); for(int i=0;i<list.size();i++){
		 * System.out.println(list.get(i).getAddress()); }
		 */
		
		// FeedFacade feedFacade = (FeedFacade)appContext.getBean("feedFacade");
		// feedFacade.shareNewsFeed_tx(2,122);
		
		/*
		 MailqueueService mailqueueService =(MailqueueService)appContext.getBean("mailqueueService"); 
		 Map map =new HashMap(); map.put("country","美国");
		 mailqueueService.sendFormatEmail_tx("bill.tian@meta4-group.com","bill","bill.tian@meta4-group.com","xiaobill",
		 "test", "test_en_US",map , true);*/
		 
		
		/*
		 * PhotoFacade photoFacade =
		 * (PhotoFacade)appContext.getBean("photoFacade");
		 * System.out.println(photoFacade.getAlbumList(1).size()); List<ZyAlbum>
		 * list = photoFacade.getAlbumList(1); for(int i=0;i<list.size();i++){
		 * System.out.println(list.get(i).getAlbumname());
		 * System.out.println(list.get(i).getPhotosCnt()); }
		 * 
		 * List<ZyPhoto> list1 = photoFacade.getPhotoList(1,1,100); for(int
		 * i=0;i<list1.size();i++){
		 * System.out.println(list1.get(i).getFilename()); }
		 */
		/*
		 * MessageFacade messageFacade =
		 * (MessageFacade)appContext.getBean("messageFacade"); List<MessageBean>
		 * messages =
		 * messageFacade.getMessageOutbox(1,(short)1,Integer.MAX_VALUE); for(int
		 * i=0;i<messages.size();i++){
		 * System.out.println(messages.get(i).getMessage().getSenderid()+"-----"+messages.get(i).getMessage().getReceiverid()); }
		 */
		
		/*
		FeedFacade feedFacade = (FeedFacade)appContext.getBean("feedFacade");
		List<ZyNewsfeed> list = feedFacade.getNewsFeed(1,"sns.publish.photo", "56");
		for(int i=0;i<list.size();i++){
			System.out.println("feed.id----"+list.get(i).getId());
		}*/
		
		/*
		LocationFacade locatioinFacade = (LocationFacade)appContext.getBean("locationFacade");
		List<ZyCity> citys = locatioinFacade.getCities();
		
		for(int i=0;i<citys.size();i++){
			HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
			outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			char chrs[] = citys.get(i).getCityname().toCharArray();
			StringBuffer sb = new StringBuffer();
			for (char c : chrs) {
				String[] pinyinArray = PinyinHelper
						.toHanyuPinyinStringArray(c, outputFormat);
				if (pinyinArray != null && pinyinArray.length > 0) {
					sb.append(pinyinArray[0] + "");
					
				}
			}
			System.out.println(sb.toString());
			citys.get(i).setCitypinyin(sb.toString());
			locatioinFacade.updateCity(citys.get(i));
		}*/
		
		
		
		/*
		OptionFacade optionFacade = (OptionFacade)appContext.getBean("optionFacade");
		List<ZySchool> schools = optionFacade.getAllSchools();
		
		for(int i=0;i<schools.size();i++){
			HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
			outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			char chrs[] = schools.get(i).getSchoolname().toCharArray();
			StringBuffer sb = new StringBuffer();
			for (char c : chrs) {
				String[] pinyinArray = PinyinHelper
						.toHanyuPinyinStringArray(c, outputFormat);
				if (pinyinArray != null && pinyinArray.length > 0) {
					sb.append(pinyinArray[0] + "");
					
				}
			}
			System.out.println(sb.toString());
			schools.get(i).setSchoolpinyin(sb.toString());
			optionFacade.updateSchool(schools.get(i));
		}*/
		
		//String link = snsFacade.generateInviteLink(1);
		//System.out.println("link---------"+link);
		//snsFacade.inviteUser(1,"bill.tian@meta4-group.com", "Bill");
		
		//ProfileFacade profileFacade =(ProfileFacade)appContext.getBean("profileFacade");
	
		//profileFacade.findProfileById(1);
		
		//RequestFacade requestFacade =(RequestFacade)appContext.getBean("requestFacade");
		//requestFacade.sendRequest_tx(2, 1, (short)5, 1, null, null);
		//snsFacade.addFriend(21, 1);
		
		
		/*
		SNSFacade snsFacade = (SNSFacade)appContext.getBean("snsFacade");
		List<ZyProfile> profiles = snsFacade.getFriendsByName(1, "x",true);
		for(int i=0;i<profiles.size();i++){
			System.out.println("user.id==="+profiles.get(i).getUserid()+"-----username:"+profiles.get(i).getUsername());
		}*/
		
		EventDao eventDao = (EventDao)appContext.getBean("eventDao");
		List<ZyEvent> events = eventDao.getHotPubEvents(1,10000);
		for(int i=0;i<events.size();i++){
			System.out.println(events.get(i).getEventname()+"----"+events.get(i).getId());
		}
	}
}
