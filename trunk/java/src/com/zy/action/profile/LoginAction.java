package com.zy.action.profile;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.zy.Constants;
import com.zy.action.interceptor.AuthorityInterceptor;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.CookieUtil;
import com.zy.facade.FeedFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;

public class LoginAction extends MemberAction{
	private ProfileFacade profileFacade;
	private String email;
	private String password;
	
	private String token;
	
	private SNSFacade snsFacade;
	private FeedFacade feedFacade;
	
	private boolean rememberMe;
	

	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	public FeedFacade getFeedFacade() {
		return feedFacade;
	}
	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}
	public SNSFacade getSnsFacade() {
		return snsFacade;
	}
	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}
	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute(){
		if(email==null||password==null||email.trim().length()==0||password.trim().length()==0){
			if(ActionContext.getContext().getSession().get(Constants.USER_SESSION_KEY)!=null){
				return "login.welcome";
			}
			return "login.fail";
		}
		ZyProfile user = profileFacade.checkProfileLogin(email, password);
		
		if(user!=null){
			System.out.println("------------into welcome----------"+user.getAvatar());
			if(user.getAvatar()==null||user.getAvatar().equalsIgnoreCase("/images/DEFAULT.JPG")||user.getAvatar().equalsIgnoreCase("//images/DEFAULT.JPG")){
				ActionContext.getContext().getSession().put("userlogo",null);
			}else{
				ActionContext.getContext().getSession().put("userlogo",user.getAvatar());
			}
			
			
			if (rememberMe) {
				Cookie cookie=CookieUtil.addUserToCookie(user.getEmail()+ "," + user.getPasswd(),rememberMe);
				cookie.setMaxAge(60 * 60 * 24 * 365);
				ServletActionContext.getResponse().addCookie(cookie);
			}
			
			
			user.setLastlogintime(new Date());
			if(user.getToken()==null||user.getToken().trim().length()==0){
				user.setToken(UUID.randomUUID().toString());
			}
			profileFacade.updateProfile(user);
			
			ActionContext.getContext().getSession().put(Constants.USER_SESSION_KEY, user);
		    ActionContext.getContext().getSession().put(Constants.USERID_SESSION_KEY, user.getUserid());		    
		    
		    if(token!=null&&token.trim().length()>0){
		    	ZyProfile friend = profileFacade.findProfileByToken(token);
		    	if(friend!=null){
		    		snsFacade.addFriend(user.getUserid(), friend.getUserid());
		    		feedFacade.addNewFriendNewsFeed(user.getUserid(), friend.getUserid());
		    	}
		    }
		    
		    if(ActionContext.getContext().getSession().get(AuthorityInterceptor.GOING_TO_URL_KEY)!=null){
		    	String url = (String)ActionContext.getContext().getSession().get(AuthorityInterceptor.GOING_TO_URL_KEY);
		    	try{
		    		ActionUtil.getResponse().sendRedirect(url);
		    		return NONE;
		    	}catch(Exception ex){
		    		ex.printStackTrace();
		    	}
		    	
		    }
		    return "login.welcome";
		}else{
			System.out.println("------------into fail----------");
			return "login.fail";
		}
		
	}
}
