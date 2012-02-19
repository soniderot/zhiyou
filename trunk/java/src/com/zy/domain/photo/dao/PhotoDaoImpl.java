package com.zy.domain.photo.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyPhoto;

public class PhotoDaoImpl extends HibernateDao<ZyPhoto, Integer> implements PhotoDao{
	public List<ZyPhoto> getPhotosInAlbum(int albumId,int pageNo,int pageSize){
		String hql = "from ZyPhoto where albumno = ? and deleted is null order by id desc";
		return this.loadByPage(hql,pageNo,pageSize,new Object[]{albumId});
	}
	
	public List<ZyPhoto> getPhotosByEventId(int eventId,int pageNo,int pageSize){
		String hql = "from ZyPhoto where eventid = ? and deleted is null order by id desc";
		return this.loadByPagenation(hql,pageNo,pageSize,new Object[]{eventId});
	}
	public int getPhotosCntByEventId(int eventId){
		String hql = "select count(*) from ZyPhoto where eventid = ? and deleted is null";
		return this.getTotalRows(hql,new Object[]{eventId});
	}
}
