package com.zy.domain.photo.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyAlbum;

public interface AlbumDao extends BaseDao<ZyAlbum,Integer>{
	public List<ZyAlbum> getAlbumList(int userId);
}
