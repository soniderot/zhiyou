package com.zy.domain.photo.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyPhoto;

public interface PhotoDao extends BaseDao<ZyPhoto,Integer>{
	public List<ZyPhoto> getPhotosInAlbum(int albumId,int pageNo,int pageSize);
	public List<ZyPhoto> getPhotosByEventId(int eventId,int pageNo,int pageSize);
	public int getPhotosCntByEventId(int eventId);
}
