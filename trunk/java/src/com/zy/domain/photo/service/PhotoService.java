package com.zy.domain.photo.service;

import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;
import com.zy.facade.vo.FeedVO;

public interface PhotoService {
	public List<ZyAlbum> getAlbumList(int userId);
	public ZyPhoto getPhoto(int photoId);
	public void createPhoto(ZyPhoto photo);
	public List<ZyPhoto> getPhotoList(int albumId,int pageNo,int pageSize);
	public ZyAlbum getAlbum(int albumId);
	public void createAlbum(ZyAlbum album);
	public void deleteAlbum(int albumId);
	public void deletePhoto(int photoId);
	public void updateAlbum(ZyAlbum album);
	public void updatePhoto(ZyPhoto photo);
	public List<FeedVO> getPhotosByEventId(int eventId,int pageNo,int pageSize);
	public int getPhotosCntByEventId(int eventId);
}
