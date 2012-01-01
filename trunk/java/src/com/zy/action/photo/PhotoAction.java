package com.zy.action.photo;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.facade.FeedFacade;
import com.zy.facade.PhotoFacade;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;

public class PhotoAction {
	private PhotoFacade photoFacade;
	private ProfileFacade profileFacade;
	private FeedFacade feedFacade;
	private SNSFacade snsFacade;
	private List<ZyProfile> profiles;
	private ZyProfile profile;
	
	private List<ZyAlbum> albums;

	private int userid;
	private int albumId;
	
	private int pageNo = 1;
	private int pageSize = 50;
	
	private List<ZyPhoto> userPhotos;
	
	private ZyAlbum zyAlbum;
	
	private File photo;
	private String photoContentType;
	private String summary;

	private int[] photoIds;
	private String[] newSummarys;
	private int[] newAlbumIds;
	private int albumlogo;
	private int[] deletephotos;
	private String newAlbumId;
	
	
	

	public String getNewAlbumId() {
		return newAlbumId;
	}

	public void setNewAlbumId(String newAlbumId) {
		this.newAlbumId = newAlbumId;
	}

	public int getAlbumlogo() {
		return albumlogo;
	}

	public void setAlbumlogo(int albumlogo) {
		this.albumlogo = albumlogo;
	}

	public int[] getDeletephotos() {
		return deletephotos;
	}

	public void setDeletephotos(int[] deletephotos) {
		this.deletephotos = deletephotos;
	}

	public int[] getPhotoIds() {
		return photoIds;
	}

	public void setPhotoIds(int[] photoIds) {
		this.photoIds = photoIds;
	}

	public String[] getNewSummarys() {
		return newSummarys;
	}

	public void setNewSummarys(String[] newSummarys) {
		this.newSummarys = newSummarys;
	}

	public int[] getNewAlbumIds() {
		return newAlbumIds;
	}

	public void setNewAlbumIds(int[] newAlbumIds) {
		this.newAlbumIds = newAlbumIds;
	}

	public FeedFacade getFeedFacade() {
		return feedFacade;
	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ZyAlbum getZyAlbum() {
		return zyAlbum;
	}

	public void setZyAlbum(ZyAlbum zyAlbum) {
		this.zyAlbum = zyAlbum;
	}

	public List<ZyPhoto> getUserPhotos() {
		return userPhotos;
	}

	public void setUserPhotos(List<ZyPhoto> userPhotos) {
		this.userPhotos = userPhotos;
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

	
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

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
	
	public String getPhotos(){
		zyAlbum = photoFacade.getAlbum(albumId);
		profile = profileFacade.findProfileById(userid);
		userPhotos = photoFacade.getPhotoList(albumId, pageNo, pageSize);
		profiles = snsFacade.getProfilesYouMayKnow(ActionUtil.getSessionUserId());
		return "member.photolist";
	}
	
	public String toUpladPhoto(){
		profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
		albums = photoFacade.getAlbumList(ActionUtil.getSessionUserId());
		return "member.uploadphoto";
	}
	
	public String toCreateAlbum(){
		profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
		return "member.createalbum";
	}

	public String createAlbum(){
		userid = ActionUtil.getSessionUserId();
		zyAlbum.setCreatetime(new Date());
		zyAlbum.setUserid(userid);
		zyAlbum.setLogo("/photos/album/default.jpg");
		photoFacade.createAlbum(zyAlbum);
		return "to.member.albumlist";
	}
	
	public String editAlbum(){
		zyAlbum = photoFacade.getAlbum(albumId);
		return "member.editalbum";
	}
	
	public String updatePhotos(){
		System.out.println("--------albumlogo--------"+albumlogo);
		System.out.println("--------photoIds.size--------"+photoIds.length);
		for(int i=0;photoIds!=null&&photoIds.length>0&&i<photoIds.length;i++){
			System.out.println("photoid----------"+photoIds[i]);
			System.out.println("photo.albumno----------"+newAlbumIds[i]);
			System.out.println("photo.summary----------"+newSummarys[i]);
			
			ZyPhoto photo = photoFacade.getPhoto(photoIds[i]);
			photo.setSummary(newSummarys[i]);
			photo.setAlbumno(newAlbumIds[i]);
			photoFacade.updatePhoto(photo);
		}
		if(deletephotos!=null){
			for(int i=0;i<deletephotos.length;i++){
				System.out.println("--------deletephotos----"+deletephotos[i]);
				photoFacade.deletePhoto(deletephotos[i]);
			}
		}
		
		if(albumlogo>0){
			ZyPhoto photo = photoFacade.getPhoto(albumlogo);
			ZyAlbum album = photoFacade.getAlbum(photo.getAlbumno());
			album.setLogo(photo.getFilename());
			photoFacade.updateAlbum(album);
		}
		userid= ActionUtil.getSessionUserId();
		return "to.member.albumlist";
	}
	
	public String updateAlbum(){
		ZyAlbum album = new ZyAlbum();
		album = photoFacade.getAlbum(albumId);
		album.setAlbumname(zyAlbum.getAlbumname());
		photoFacade.updateAlbum(album);
		userid= ActionUtil.getSessionUserId();
		return "to.member.albumlist";
	}
	
	public String uploadPhoto(){
		System.out.println("------------------------intouploadpic-----------");
		
		
		String filetype = null;
		filetype = FileUtil.isJPGorPNG(this.getPhotoContentType());
		if (StringUtils.isBlank(filetype)) {
			profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
			return "member.uploadphoto";
		}
		String root = ServletActionContext.getServletContext().getRealPath("/");
		final String photoDir = File.separator + "photos/album";
		String token = UUID.randomUUID() + "";
		String fn = token + filetype;
		String fileName = FileUtil.copy(photo, root + photoDir, fn);
		System.out.println(fileName);
		String datedir = DateUtil.formatDate(new Date());
		String str = datedir + "/" + fn;
		
		System.out.println(str);
		ZyPhoto photo = new ZyPhoto();
		photo.setFilename("/photos/album/"+str);
		photo.setUserid(ActionUtil.getSessionUserId());
		photo.setAlbumno(albumId);
		photo.setSummary(summary);
		photo.setCreatetime(new Date());
		try{
		photoFacade.createPhoto(photo);
		}catch(Throwable ex){
			ex.printStackTrace();
		}
		
		System.out.println("----------------after create photo---------"+photo.getId());
		
		feedFacade.addNewPhotoNewsFeed(ActionUtil.getSessionUserId(),photo.getId());
		userid= ActionUtil.getSessionUserId();
		return "to.member.photolist";
	}
	
	public String deleteAlbum(){
		photoFacade.deleteAlbum(albumId);
		userid = ActionUtil.getSessionUserId();
		return "to.member.albumlist";
	}
	
	public String editPhotos(){
		zyAlbum = photoFacade.getAlbum(albumId);
		userPhotos = photoFacade.getPhotoList(albumId, pageNo, pageSize);
		profile = profileFacade.findProfileById(zyAlbum.getUserid());
		albums = photoFacade.getAlbumList(zyAlbum.getUserid());
		
		if(userPhotos.size()>0){
			newAlbumIds = new int[userPhotos.size()];
			newSummarys = new String[userPhotos.size()];
			for(int i=0;i<userPhotos.size();i++){
				newAlbumIds[i] = albumId;
				newSummarys[i] = userPhotos.get(i).getSummary();
			}
		}
		return "member.editphotos";
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