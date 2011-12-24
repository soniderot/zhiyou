package com.zy.domain.photo.service;

import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;

public interface PhotoService {
	public List<ZyAlbum> getAlbumList(int userId);
	public ZyPhoto getPhoto(int photoId);
	public void createPhoto(ZyPhoto photo);
}
