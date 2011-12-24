package com.zy.domain.photo.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyAlbum;
import com.zy.common.model.ZyPhoto;

public class AlbumDaoImpl extends HibernateDao<ZyAlbum, Integer> implements AlbumDao{
	public List<ZyAlbum> getAlbumList(int userId){
		String hql = "from ZyAlbum where userid = ?";
		return this.find(hql, new Object[]{userId});
	}
}
