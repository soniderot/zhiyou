package com.zy.action.event;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.facade.EventFacade;
import com.zy.facade.FeedFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;
import com.zy.facade.vo.EventVO;

public class EventAction {
	private SNSFacade snsFacade;
	private FeedFacade feedFacade;
	
	private List<ZyProfile> friends;
	
	//private ZyEvent event;
	
	private String event_start;
	private String start_time_min;
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
	private int pageSize = 12;
	private List<EventVO> userevents;
	
	private boolean friendFlag;
	
	
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

	public String getEvent_start() {
		return event_start;
	}

	public void setEvent_start(String event_start) {
		this.event_start = event_start;
	}

	public String getStart_time_min() {
		return start_time_min;
	}

	public void setStart_time_min(String start_time_min) {
		this.start_time_min = start_time_min;
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
		if(userevents.size()==0){
			return "member.emtyevents";
		}else{
			return "member.events";
		}
	}
	
	public String createOrUpdate() {
		if(eventId>0){
			ZyEvent event = eventFacade.getEvent(eventId);
			eventname = event.getEventname();
			address = event.getAddress();
			detail = event.getDetail();
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
		
		event.setAddress(address);
		event.setCreatetime(new Date());
		event.setBegintime(new Date());
		event.setEndtime(new Date());
		event.setCityid(8843);
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
			event.setLogo("/photos/event/"+str);
		}else{
			event.setLogo("/images/event.jpg");
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
			String[] array = invitees.split(" ");
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<array.length;i++){
				list.add(Integer.valueOf(array[i]));
			}
			System.out.println("----------begin to send invites----------");
			eventFacade.sendEventInvites(event, list);
		}
		
		
		return "my.events";
	}
	
	public String viewEvent(){
		event = eventFacade.getEvent(eventId);
		createUser = profileFacade.findProfileById(event.getCreateuserid());
		members = eventFacade.getEventMembers(eventId);
		return "view.event.detail";
	}
	
	public String quitEvent(){
		eventFacade.removeMember(ActionUtil.getSessionUserId(), eventId);
		return "my.events";
	}
	
	public String joinEvent(){
		eventFacade.addMember(ActionUtil.getSessionUserId(), eventId);
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
		System.out.println("----------------events.size----------"+userevents.size());
		if(userevents.size()==0){
			return "member.emtyevents";
		}else{
			return "member.events";
		}
	}

}
