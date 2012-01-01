package com.zy.facade.impl;

import java.util.Date;
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
		System.out.println("---------------photo.albumno------------"+photo.getAlbumno());
		if(photo.getAlbumno()==null||photo.getAlbumno()==0){
			List<ZyAlbum> albums = photoService.getAlbumList(photo.getUserid());
			if(albums.size()==0){
				ZyAlbum album = new ZyAlbum();
				album.setLogo(photo.getFilename());
				album.setCreatetime(new Date());
				album.setAlbumname("我的相册");
				album.setPhotosCnt(1);
				album.setUserid(photo.getUserid());
				photoService.createAlbum(album);
				photo.setAlbumno(album.getId());
			}
		}
		photoService.createPhoto(photo);
	}
	
	public List<ZyPhoto> getPhotoList(int albumId,int pageNo,int pageSize){
		return photoService.getPhotoList(albumId,pageNo,pageSize);
	}
	
	public ZyAlbum getAlbum(int albumId){
		return photoService.getAlbum(albumId);
	}
	
	public void createAlbum(ZyAlbum album){
		photoService.createAlbum(album);
	}
	
	public void deletePhoto(int photoId){
		photoService.deletePhoto(photoId);
	}
	
	public void deleteAlbum(int albumId){
		photoService.deleteAlbum(albumId);
		List<ZyPhoto> photos = photoService.getPhotoList(albumId,1,Integer.MAX_VALUE);
		for(int i=0;i<photos.size();i++){
			photoService.deletePhoto(photos.get(i).getId());
		}
	}
	
	public void updateAlbum(ZyAlbum album){
		photoService.updateAlbum(album);
	}
	
	public void updatePhoto(ZyPhoto photo){
		photoService.updatePhoto(photo);
	}
	
	public ZyPhoto getPhoto(int photoId){
		return photoService.getPhoto(photoId);
	}
}
