package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;
import com.zy.domain.photo.service.PhotoService;
import com.zy.facade.PhotoFacade;

public class PhotoFacadeImpl implements PhotoFacade{
	private PhotoService photoService;
	
	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	public List<ZyAlbum> getAlbumList(int userId){
		return photoService.getAlbumList(userId);
	}
	
	public void createPhoto(ZyPhoto photo){
		photoService.createPhoto(photo);
	}
}
