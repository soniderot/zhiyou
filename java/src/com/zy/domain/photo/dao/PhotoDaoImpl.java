package com.zy.domain.photo.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyPhoto;

public class PhotoDaoImpl extends HibernateDao<ZyPhoto, Integer> implements PhotoDao{
	public List<ZyPhoto> getPhotosInAlbum(int albumId){
		String hql = "from ZyPhoto where albumno = ?";
		return this.find(hql,new Object[]{albumId});
	}
}
