package com.zy.action.profile;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.facade.ProfileFacade;

public class UploadAction {
	private File logo;
	private String logoContentType;
	private ProfileFacade profileFacade;
	
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String getLogoContentType() {
		return logoContentType;
	}

	public void setLogoContentType(String logoContentType) {
		this.logoContentType = logoContentType;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public String execute(){
		System.out.println("logo-------"+logo);
		String filetype = null;
		filetype = FileUtil.isJPGorPNG(this.getLogoContentType());
		if (StringUtils.isBlank(filetype)) {
			return "member.landing";
		}
		String token = UUID.randomUUID() + "";
		String fn = token + filetype;
		String fileName = FileUtil.copy(logo, "D:\\workspace\\zy\\zhiyou\\photos", fn);
		System.out.println(fileName);
		String datedir = DateUtil.formatDate(new Date());
		String str = datedir + "/" + fn;
		
		System.out.println(str);
		ActionContext.getContext().getSession().put("userlogo","/photos/"+str);
		ZyProfile profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
		profile.setAvatar("/photos/"+str);
		profileFacade.updateProfile(profile);
		return "member.landing";
	}
}
