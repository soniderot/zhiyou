package com.zy.action.profile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.github.mhendred.face4j.model.Face;
import com.utils.CropFaceUtils;
import com.utils.FaceCrop;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ObjectFactory;
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
		String root = ServletActionContext.getServletContext().getRealPath("/");
		final String photoDir = File.separator + "photos";
		String token = UUID.randomUUID() + "";
		String fn = token + filetype;
		String fileName = FileUtil.copy(logo, root + photoDir, fn);
		System.out.println(fileName);
		String datedir = DateUtil.formatDate(new Date());
		String str = datedir + "/" + fn;
		
		System.out.println(str);
		//ActionContext.getContext().getSession().put("userlogo","/photos/"+str);
		ZyProfile profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
		profile.setProfileAvatar("/photos/"+str);
		profileFacade.updateProfile(profile);
		
		ActionContext.getContext().getSession().put("userlogo",profile.getBigavatar());
		return "member.landing";
	}
	
	public String uploadPhotoAjax(){
		System.out.println("----------------------into uploadphotoajax------");
    HttpServletResponse response = ServletActionContext.getResponse();    
    response.setCharacterEncoding("UTF-8");
    PrintWriter out;
    try {
    	out = response.getWriter();
			String root = ServletActionContext.getServletContext().getRealPath("/");
			final String photoDir = "photos";
			String token = UUID.randomUUID() + "";
			String filetype = FileUtil.isJPGorPNG(this.getLogoContentType());
			if (StringUtils.isBlank(filetype)) {
				out.print("<script>parent.submitPhotoCallback('error')</script>");
				out.flush();
		    out.close();
				return null;
			}
			String fn = token + filetype;
			String fileName = FileUtil.copy(logo, root + photoDir, fn);
			System.out.println("file name: " + fileName);
			String datedir = "/" + DateUtil.formatDate(new Date()) + "/";
			String str = photoDir  + datedir  + fn;
			ZyProfile profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
			//profile.setProfileAvatar(str);
			Map<String, Object> session  = ActionContext.getContext().getSession();
			session.put("userlogo", profile.getBigavatar());
			HttpServletRequest request = ServletActionContext.getRequest();
			String imageUrl = getUrl(request) + str;

			try {
				Face face = CropFaceUtils.getFirstFace(imageUrl);
	      System.out.println(imageUrl);
	  		if (face != null) {
	      		FaceCrop faceCrop = new FaceCrop();
	      		faceCrop.setCentreX(face.getCenter().x);
	      		faceCrop.setCentreY(face.getCenter().y);
	      		faceCrop.setWidth(face.getWidth());
	      		faceCrop.setHeight(face.getHeight());
	      		session.put("faceCrop", faceCrop);
	  		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			profileFacade.updateProfile(profile);
	    out.print("<script>parent.submitPhotoCallback('" + str + "')</script>");
	    out.flush();
	    out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String deletePhotoAjax(){
		
    HttpServletResponse response = ServletActionContext.getResponse();    
    response.setCharacterEncoding("UTF-8");
    PrintWriter out;
    try {
    	out = response.getWriter();
			ZyProfile profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
			profile.setProfileAvatar("");
			ActionContext.getContext().getSession().remove("userlogo");
			profileFacade.updateProfile(profile);
	    out.print(profile.getGender());
	    out.flush();
	    out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String getUrl(HttpServletRequest request) {
		String url = "http://";
		url = url + request.getServerName() + ":" + request.getServerPort();
		url = url + request.getContextPath() + "/";
		return url;
	}
	
}
