package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;

public interface PhotoFacade {
	public List<ZyAlbum> getAlbumList(int userId);
	public void createPhoto(ZyPhoto photo);
}
