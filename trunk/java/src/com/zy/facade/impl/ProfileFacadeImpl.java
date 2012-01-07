package com.zy.facade.impl;

import java.util.HashMap;

import com.zy.Constants;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.BASE64Util;
import com.zy.domain.message.service.MailqueueService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.facade.ProfileFacade;

public class ProfileFacadeImpl implements ProfileFacade {
	
	private static final int BUFFER_SIZE = 16 * 1024;

	private ProfileService profileService;
	private MailqueueService mailqueueService;
	

	public MailqueueService getMailqueueService() {
		return mailqueueService;
	}

	public void setMailqueueService(MailqueueService mailqueueService) {
		this.mailqueueService = mailqueueService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	public ZyProfile findProfileById(int profileId){
		ZyProfile profile =  profileService.findProfileById(profileId);
		
		/*
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("receiverName", profile.getUsername());
		//map.put("link", this.generateInviteLink(userId));
		//map.put("country", "china");
		map.put("profile",profile);
		map.put("domainname", Constants.DOMAINNAME);
		String link = mailqueueService.generateEmailverifyLink(profile);
		map.put("link",Constants.DOMAINNAME+"/usr/landing!verify.jhtml?token="+link);
		mailqueueService.sendFormatEmail_tx(profile.getEmail(),profile.getUsername(),profile.getEmail(),profile.getUsername(),
				  "欢迎你加入知友", "zy_welcome",map , true);
		*/
		return profile;
		
	}
	public ZyProfile checkProfileLogin(String email,String password){
		return profileService.checkProfileLogin(email, password);
	}
	public void addProfile(ZyProfile profile){
		String passwd = profile.getPasswd();
		profileService.insertProfile(profile);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("receiverName", profile.getUsername());
		//map.put("link", this.generateInviteLink(userId));
		//map.put("country", "china");
		map.put("profile",profile);
		map.put("password", passwd);
		map.put("domainname", Constants.DOMAINNAME);
		String link = mailqueueService.generateEmailverifyLink(profile);
		map.put("link",Constants.DOMAINNAME+"/usr/landing!verify.jhtml?verifytoken="+link);
		mailqueueService.sendFormatEmail_tx("no_reply@zy.com","知友网",profile.getEmail(),profile.getUsername(),
				  "欢迎你加入知友", "zy_welcome",map , true);
		
	}
	
	public ZyProfile findProfileByEmail(String email){
		return profileService.findProfileByEmail(email);
	}
	
	public ZyProfile findProfileByName(String userName){
		return profileService.findProfileByName(userName);
	}
	
	public void updateProfile(ZyProfile profile){
		profileService.updateProfile(profile);
	}
	
	public ZyProfile findProfileByToken(String token){
		return profileService.findProfileByToken(token);
	}
	
	
	public void verifyEmail_tx(String link) {
		String token = BASE64Util.decode(link);
		String[] params = token.split(",");
		ZyProfile profile = profileService.findProfileById(Integer.parseInt(params[0]));
		if(params[2].equals(profile.getEmail()))
		{
			profile.setEmailstatus(Constants.USER_EMAIL_VERIFIED);
			profileService.updateProfile(profile);
		}
	}
}
