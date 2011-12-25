package com.zy.action.photo;

import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.facade.PhotoFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;

public class PhotoAction {
	private PhotoFacade photoFacade;
	private ProfileFacade profileFacade;
	private SNSFacade snsFacade;
	private List<ZyProfile> profiles;
	private ZyProfile profile;
	
	private List<ZyAlbum> albums;

	private int userid;
	
	
	
	public ZyProfile getProfile() {
		return profile;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public List<ZyAlbum> getAlbums() {
		return albums;
	}

	public void setAlbums(List<ZyAlbum> albums) {
		this.albums = albums;
	}

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public PhotoFacade getPhotoFacade() {
		return photoFacade;
	}

	public void setPhotoFacade(PhotoFacade photoFacade) {
		this.photoFacade = photoFacade;
	}

	public String getAlbum(){
		profile = profileFacade.findProfileById(userid);
		albums = photoFacade.getAlbumList(userid);
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		return "member.albumlist";
	}

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public List<ZyProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ZyProfile> profiles) {
		this.profiles = profiles;
	}
}
