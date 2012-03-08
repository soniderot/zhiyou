package com.zy.domain.photo.service;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyPhoto;
import com.zy.domain.feed.dao.FeedDao;
import com.zy.domain.photo.dao.AlbumDao;
import com.zy.domain.photo.dao.PhotoDao;
import com.zy.facade.vo.EventVO;
import com.zy.facade.vo.FeedVO;

public class PhotoServiceImpl implements PhotoService{
	private AlbumDao albumDao;
	private PhotoDao photoDao;
	private FeedDao feedDao;
	
	public FeedDao getFeedDao() {
		return feedDao;
	}

	public void setFeedDao(FeedDao feedDao) {
		this.feedDao = feedDao;
	}

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
			int cnt = photoDao.getPhotosInAlbum(results.get(i).getId(),1,Integer.MAX_VALUE).size();
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
	
	public List<ZyPhoto> getPhotoList(int albumId,int pageNo,int pageSize){
		return photoDao.getPhotosInAlbum(albumId,pageNo,pageSize);
	}
	public ZyAlbum getAlbum(int albumId){
		return albumDao.load(albumId);
	}
	
	public void createAlbum(ZyAlbum album){
		albumDao.save(album);
	}
	
	public void deleteAlbum(int albumId){
		albumDao.deleteByKey(albumId);
	}
	
	public void deletePhoto(int photoId){
		ZyPhoto photo = photoDao.load(photoId);
		photo.setDeleted("T");
		photoDao.update(photo);
		//photoDao.deleteByKey(photoId);
	}
	public void updateAlbum(ZyAlbum album){
		albumDao.update(album);
	}
	
	public void updatePhoto(ZyPhoto photo){
		photoDao.update(photo);
	}
	public List<FeedVO> getPhotosByEventId(int eventId,int pageNo,int pageSize) {
		List<FeedVO> eventPhotos = new ArrayList<FeedVO>();
		List<ZyPhoto> photos = photoDao.getPhotosByEventId(eventId, pageNo, pageSize);
		if (photos == null) {
			return eventPhotos;
		}
		for (int i = 0; i < photos.size(); i ++) {
			FeedVO feedPhoto = new FeedVO();
			ZyPhoto photo = photos.get(i);
			ZyNewsfeed feed = feedDao.getNewsFeedByHandle("sns.event.photo", photo.getId() + "");
			feedPhoto.setFeed(feed);
			feedPhoto.setPhoto(photo);
			eventPhotos.add(feedPhoto);
		}
		return eventPhotos;
	}
	public int getPhotosCntByEventId(int eventId){
		return photoDao.getPhotosCntByEventId(eventId);
	}
}
