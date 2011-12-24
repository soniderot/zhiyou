package com.zy.domain.photo.service;

import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;
import com.zy.domain.photo.dao.AlbumDao;
import com.zy.domain.photo.dao.PhotoDao;

public class PhotoServiceImpl implements PhotoService{
	private AlbumDao albumDao;
	private PhotoDao photoDao;
	
	public PhotoDao getPhotoDao() {
		return photoDao;
	}

	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

	public AlbumDao getAlbumDao() {
		return albumDao;
	}

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	public List<ZyAlbum> getAlbumList(int userId){
		List<ZyAlbum> results = albumDao.getAlbumList(userId);
		for(int i=0;i<results.size();i++){
			int cnt = photoDao.getPhotosInAlbum(results.get(i).getId()).size();
			results.get(i).setPhotosCnt(cnt);
		}
		return results;
	}
	
	public ZyPhoto getPhoto(int photoId){
		return photoDao.load(photoId);
	}
	
	public void createPhoto(ZyPhoto photo){
		System.out.println("------------begin to save---------");
		photoDao.save(photo);
	}
}
