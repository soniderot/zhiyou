package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;

public interface PhotoFacade {
	public List<ZyAlbum> getAlbumList(int userId);
	public ZyAlbum getAlbum(int albumId);
	public ZyPhoto getPhoto(int photoId);
	public void createPhoto(ZyPhoto photo);
	public List<ZyPhoto> getPhotoList(int albumId,int pageNo,int pageSize);
	public List<ZyPhoto> getEventPhotos(int eventId,int pageNo,int pageSize);
	public void createAlbum(ZyAlbum album);
	public void deleteAlbum(int albumId);
	public void deletePhoto(int photoId);
	public void updateAlbum(ZyAlbum album);
	public void updatePhoto(ZyPhoto photo);
}
