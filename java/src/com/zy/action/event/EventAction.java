package com.zy.action.event;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.zy.Constants;
import com.zy.common.model.ZyDistrict;
import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventcategory;
import com.zy.common.model.ZyPhoto;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyRecommplace;
import com.zy.common.model.ZyRequest;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.common.util.Page;
import com.zy.domain.feed.bean.FeedBean;
import com.zy.facade.EventFacade;
import com.zy.facade.FeedFacade;
import com.zy.facade.OptionFacade;
import com.zy.facade.PhotoFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.RequestFacade;
import com.zy.facade.SNSFacade;
import com.zy.facade.vo.EventVO;
import com.zy.facade.vo.FeedVO;

public class EventAction {
	private SNSFacade snsFacade;
	private FeedFacade feedFacade;
	
	private RequestFacade requestFacade;
	
	private List<ZyProfile> friends;
	
	//private ZyEvent event;
	
	private String startDate;
	private String startHour;
	
	private String endDate;
	private String endHour;
	
	
	private String detail;
	private String address;
	private String eventname;
	
	private EventFacade eventFacade;
	private String invitees;
	
	
	private File logo;
	private String logoContentType;
	
	private int eventId;
	private ZyEvent event;
	private ZyProfile createUser;
	private List<ZyProfile> members;
	
	private ProfileFacade profileFacade;
	private int pageNo = 1;
	private int pageSize = 10;
	private List<EventVO> userevents;
	
	private boolean friendFlag;
	private boolean joined;
	private List<ZyEventcategory> eventCategorys;
	private int eventCategory;
	private OptionFacade optionFacade;
	private List<ZyDistrict> districts;
	private int districtId;
	private int subcateGoryId;
	private List<ZyRecommplace> places;
	private List<FeedVO> eventPhotos;
	private PhotoFacade photoFacade;
	private Page page;
	
	
	private List<FeedBean> feeds;
	private List<EventVO> friendEvents;
	private List<EventVO> publicEvents;	
	private short publicflag;
	private int photoId;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public PhotoFacade getPhotoFacade() {
		return photoFacade;
	}

	public void setPhotoFacade(PhotoFacade photoFacade) {
		this.photoFacade = photoFacade;
	}

	public List<FeedVO> getEventPhotos() {
		return eventPhotos;
	}

	public void setEventPhotos(List<FeedVO> eventPhotos) {
		this.eventPhotos = eventPhotos;
	}
	
	public short getPublicflag() {
		return publicflag;
	}

	public void setPublicflag(short publicflag) {
		this.publicflag = publicflag;
	}

	public List<EventVO> getFriendEvents() {
		return friendEvents;
	}

	public void setFriendEvents(List<EventVO> friendEvents) {
		this.friendEvents = friendEvents;
	}

	public List<EventVO> getPublicEvents() {
		return publicEvents;
	}

	public void setPublicEvents(List<EventVO> publicEvents) {
		this.publicEvents = publicEvents;
	}

	public List<FeedBean> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<FeedBean> feeds) {
		this.feeds = feeds;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<ZyRecommplace> getPlaces() {
		return places;
	}

	public void setPlaces(List<ZyRecommplace> places) {
		this.places = places;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getSubcateGoryId() {
		return subcateGoryId;
	}

	public void setSubcateGoryId(int subcateGoryId) {
		this.subcateGoryId = subcateGoryId;
	}

	public List<ZyDistrict> getDistricts() {
		return districts;
	}

	public void setDistricts(List<ZyDistrict> districts) {
		this.districts = districts;
	}

	public OptionFacade getOptionFacade() {
		return optionFacade;
	}

	public void setOptionFacade(OptionFacade optionFacade) {
		this.optionFacade = optionFacade;
	}

	public int getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(int eventCategory) {
		this.eventCategory = eventCategory;
	}

	public List<ZyEventcategory> getEventCategorys() {
		return eventCategorys;
	}

	public void setEventCategorys(List<ZyEventcategory> eventCategorys) {
		this.eventCategorys = eventCategorys;
	}

	public boolean isJoined() {
		return joined;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}

	public RequestFacade getRequestFacade() {
		return requestFacade;
	}

	public void setRequestFacade(RequestFacade requestFacade) {
		this.requestFacade = requestFacade;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public boolean isFriendFlag() {
		return friendFlag;
	}

	public void setFriendFlag(boolean friendFlag) {
		this.friendFlag = friendFlag;
	}

	public List<EventVO> getUserevents() {
		return userevents;
	}

	public void setUserevents(List<EventVO> userevents) {
		this.userevents = userevents;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public ZyProfile getCreateUser() {
		return createUser;
	}

	public void setCreateUser(ZyProfile createUser) {
		this.createUser = createUser;
	}

	public List<ZyProfile> getMembers() {
		return members;
	}

	public void setMembers(List<ZyProfile> members) {
		this.members = members;
	}

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public ZyEvent getEvent() {
		return event;
	}

	public void setEvent(ZyEvent event) {
		this.event = event;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public String getLogoContentType() {
		return logoContentType;
	}

	public void setLogoContentType(String logoContentType) {
		this.logoContentType = logoContentType;
	}

	public String getInvitees() {
		return invitees;
	}

	public void setInvitees(String invitees) {
		this.invitees = invitees;
	}

	public EventFacade getEventFacade() {
		return eventFacade;
	}

	public void setEventFacade(EventFacade eventFacade) {
		this.eventFacade = eventFacade;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}
	public List<ZyProfile> getFriends() {
		return friends;
	}

	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
	}
	
	public String getEvents(){
		System.out.println("--------------into-------------activitys");
		userevents = eventFacade.getEvents(ActionUtil.getSessionUserId(),""+ActionUtil.getSessionUserId(), pageNo, pageSize);
		System.out.println("----------------events.size----------"+userevents.size());
		
		friendEvents = eventFacade.getFriendsEvents(ActionUtil.getSessionUserId(), pageNo, pageSize);
		publicEvents = eventFacade.getHotPubEvents(ActionUtil.getSessionUserId(),1, pageSize);
		int count = eventFacade.getEvents(ActionUtil.getSessionUserId(),""+ActionUtil.getSessionUserId(), 1, Integer.MAX_VALUE).size();
		page = new Page(count,pageNo,pageSize,5);
		if(userevents.size()==0){
			//return "member.emtyevents";
			return "member.events";
		}else{
			return "member.events";
		}
	}
	
	
	public String createOrUpdate() {
		eventCategorys = eventFacade.getEventCategorys();
		int userid = ActionUtil.getSessionUserId();
		int cityid=8843;
		try{
		cityid = profileFacade.findProfileById(userid).getCityid();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		districts = optionFacade.getDistricts(cityid);
		SimpleDateFormat dateformat1=new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateformat2=new SimpleDateFormat("HH:mm");
		startDate = dateformat1.format(new Date());
		endDate = dateformat1.format(new Date());
		if(eventId>0){
			event = eventFacade.getEvent(eventId);
			eventname = event.getEventname();
			address = event.getAddress();
			detail = event.getDetail();
			startDate = dateformat1.format(event.getBegintime());
			startHour = dateformat2.format(event.getBegintime());
			if(startHour.indexOf("0")==0){
				startHour = startHour.substring(1);
			}
			endDate = dateformat1.format(event.getEndtime());
			endHour =  dateformat2.format(event.getEndtime());
			if(endHour.indexOf("0")==0){
				endHour = endHour.substring(1);
			}
			
			this.eventCategory = event.getSubcategoryid();
			System.out.println("------------eventCategory-----"+eventCategory);
			this.districtId = event.getDistrictid();
			
			members = eventFacade.getEventMembers(eventId);
		}
		friends = snsFacade.getAllFriends(ActionUtil.getSessionUserId(), 0, (short)1);
		return "member.cteateOrUpdateEvent";
	}
	
	public String saveEvent(){
		System.out.println("logo-------"+logo);
		
		System.out.println("---------event.name------"+eventname);
		System.out.println(ActionUtil.getRequest().getParameter("invitees"));
		
		ZyEvent event = new ZyEvent();
		
		if(eventId>0){
			event.setLogo(eventFacade.getEvent(eventId).getLogo());
		}
		
		System.out.println("-----------------publicflag----------------"+publicflag);
		if(publicflag>0){
			event.setType(1);
		}else{
			event.setType(0);
		}
		event.setPhotosCnt(publicflag);
		event.setAddress(address);
		event.setCreatetime(new Date());
		event.setBegintime(new Date());
		event.setEndtime(new Date());
		
		if(startDate!=null&&startDate.trim().length()>0){
			try{
				String begin = startDate+" "+startHour;
				System.out.println("----------------begin----------"+begin);
				String pattern = "MM/dd/yyyy HH:mm";
				DateFormat df = new SimpleDateFormat(pattern);
				System.out.println(df.parse(begin));
				event.setBegintime(df.parse(begin));
			}catch(Exception ex){
				
			}
		}

		if(endDate!=null&&endDate.trim().length()>0){
			try{
				String end = endDate+" "+endHour;
				System.out.println("----------------end----------"+end);
				String pattern = "MM/dd/yyyy HH:mm";
				DateFormat df = new SimpleDateFormat(pattern);
				System.out.println(df.parse(end));
				event.setEndtime(df.parse(end));
			}catch(Exception ex){
				
			}
		}
		
		ZyProfile user = (ZyProfile)ActionUtil.getSession().get(Constants.USER_SESSION_KEY);
		event.setCityid(user.getCityid());
		event.setSubcategoryid(eventCategory);
		event.setDistrictid(districtId);
		event.setCreateuserid(ActionUtil.getSessionUserId());
		event.setUpdatetime(new Date());
		event.setEventname(eventname);
		event.setDetail(detail);
		
		if(logo!=null){
			String filetype = null;
			filetype = FileUtil.isJPGorPNG(this.getLogoContentType());
			if (StringUtils.isBlank(filetype)) {
				return "member.landing";
			}
			String token = UUID.randomUUID() + "";
			String fn = token + filetype;
			String fileName = FileUtil.copy(logo, "D:\\workspace\\zy\\zhiyou\\photos\\event", fn);
			System.out.println(fileName);
			String datedir = DateUtil.formatDate(new Date());
			String str = datedir + "/" + fn;
			
			System.out.println(str);
			//event.setLogo("/photos/event/"+str);
			event.setEventLogo("/photos/event/"+str);
		}else{
			if(eventId==0)
				event.setLogo("/images/event.jpg");
		}
		
		if(event.getCityid()==null){
			event.setCityid(8843);
		}
		if(eventId>0){
			event.setId(eventId);
			eventFacade.updateEvent(event);
		}else{
			eventFacade.createEvent(event);
			eventFacade.addMember(event.getCreateuserid(), event.getId());
			feedFacade.addNewEventNewsFeed(ActionUtil.getSessionUserId(), event.getId());
		}
		
		if(invitees!=null&&invitees.length()>0){
			System.out.println("----------begin to send invites----------");
			String[] array = invitees.split(" ");
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<array.length;i++){
				requestFacade.sendRequest_tx(ActionUtil.getSessionUserId(), Integer.valueOf(array[i]), (short)5, event.getId(),null, null);
				//list.add(Integer.valueOf(array[i]));
			}
			
			//eventFacade.sendEventInvites(event, list);
		}
		
		
		return "my.events";
	}
	
	public String viewEvent() {
		event = eventFacade.getEvent(eventId);
		createUser = profileFacade.findProfileById(event.getCreateuserid());
		members = eventFacade.getEventMembers(eventId);
		for(int i=0;i<members.size();i++){
			if(ActionUtil.getSessionUserId()==members.get(i).getUserid().intValue()){
				joined = true;
				break;
			}
		}
		eventPhotos = photoFacade.getEventPhotos(eventId, 1, 6);
		feeds = feedFacade.getEventNewsFeed(""+eventId,pageNo,pageSize);
		int count = feedFacade.getEventNewsFeed(""+eventId,1,Integer.MAX_VALUE).size();
		page = new Page(count,pageNo,pageSize,5);
		
		return "view.event.detail";
	}
	
	public String viewEventPhotos() {
		event = eventFacade.getEvent(eventId);
		createUser = profileFacade.findProfileById(event.getCreateuserid());
		members = eventFacade.getEventMembers(eventId);
		for(int i=0;i<members.size();i++){
			if(ActionUtil.getSessionUserId()==members.get(i).getUserid().intValue()){
				joined = true;
				break;
			}
		}
		eventPhotos = photoFacade.getEventPhotos(eventId, 1, 100);
		return "view.event.photos";
	}
	
	public String quitEvent(){
		eventFacade.removeMember(ActionUtil.getSessionUserId(), eventId);
		return "my.events";
	}
	
	public String joinEvent(){
		if(eventFacade.isMemberInEvent(ActionUtil.getSessionUserId(), eventId)){
			return "my.events";
		}
		eventFacade.addMember(ActionUtil.getSessionUserId(), eventId);
		List<ZyRequest> list = requestFacade.getRequest(ActionUtil.getSessionUserId(), (short)5, eventId);
		for(int i=0;i<list.size();i++){
			requestFacade.approveRequest_tx(list.get(i).getId());
		}
		
		if(list.size()==0){
			feedFacade.addAcceptEventInviteNewsFeed(ActionUtil.getSessionUserId(), eventId);
		}
		
		return "my.events";
	}
	
	public String getFriendsEvents(){
		friendFlag = true;
		String str = "";
		List<Integer> friendIds = snsFacade.getAllFriendsByDegree(ActionUtil.getSessionUserId(),(short)1);
		for(int i=0;i<friendIds.size();i++){
			if(i!=friendIds.size()-1){
				str = str+friendIds.get(i)+",";
			}else{
				str = str+friendIds.get(i);
			}
		}
		System.out.println("--------------into---friends----------activitys");
		userevents = eventFacade.getEvents(ActionUtil.getSessionUserId(),str, pageNo, pageSize);
		publicEvents = eventFacade.getHotPubEvents(ActionUtil.getSessionUserId(),1, pageSize);
		System.out.println("----------------events.size----------"+userevents.size());
		
		int count = eventFacade.getEvents(ActionUtil.getSessionUserId(),str, 1, Integer.MAX_VALUE).size();
		page = new Page(count,pageNo,10,5);
		
		if(userevents.size()==0){
			//return "member.emtyevents";
			return "member.events";
		}else{
			return "member.events";
		}
	}
	
	public String getRecommPlaces(){
		System.out.println("-------eventCategory---"+eventCategory+"-----districtId"+districtId);
		places = eventFacade.getRecommPlaces(eventCategory,districtId);
		return "recommend.places";
	}

	public String getEventFriendsAjax() {
		userevents = eventFacade.getEventFriends(ActionUtil.getSessionUserId(), eventId);
		return "member.friends";
	}
	
	public String inviteFriendsAjax() {
		boolean result = false;
		String message = ActionUtil.getRequest().getParameter("inviteMessage");
		if(invitees != null && invitees.length() > 0){
			String[] array = invitees.split(" ");
			for(int i = 0; i < array.length; i++){
				requestFacade.sendRequest_tx(ActionUtil.getSessionUserId(), Integer.valueOf(array[i]), (short)5, eventId, message, null);
			}
			result = true;
		}
    try {
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(result+"");
      out.flush();    
      out.close();    
    } catch (Exception e) {  
      e.printStackTrace();    
    }
		return null;
	}
	
	public String listMembers(){
		friends = eventFacade.getEventMembers(eventId);
		members = friends;
		event = eventFacade.getEvent(eventId);

		createUser = profileFacade.findProfileById(event.getCreateuserid());
		
		for(int i=0;i<friends.size();i++){
			if(ActionUtil.getSessionUserId()==friends.get(i).getUserid().intValue()){
				joined = true;
				break;
			}
		}
		return "event.members";
	}
	
	public String getPubEvents(){
		publicflag = 1;
		System.out.println("--------------into-------------activitys");
		publicEvents = eventFacade.getHotPubEvents(ActionUtil.getSessionUserId(),1, pageSize);
		userevents = eventFacade.getEventsByType(ActionUtil.getSessionUserId(),1,1, pageSize);
		int count = eventFacade.getEventsByType(ActionUtil.getSessionUserId(),1,1, Integer.MAX_VALUE).size();
		page = new Page(count,pageNo,pageSize,5);
		if(userevents.size()==0){
			//return "member.emtyevents";
			return "member.events";
		}else{
			return "member.events";
		}
	}
	
	public String showBigPhotoAjax() {
		return "";
	}
	
	public static void main(String[] args) throws Exception{
		String str = "2011/12/12 12:00:00";
		String pattern = "yyyy/MM/dd HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		System.out.println(df.parse(str));
	}
	
	
}
