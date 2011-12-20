package com.zy.domain.search.service;

import java.util.List;

import com.zy.common.model.ZyIndexlog;
import com.zy.common.model.ZyIndexqueue;
import com.zy.facade.vo.LuceneProfileVo;


public interface LuceneIndexService {
	public void addProfileIndexQueue(int userId);
	
	public void doProfileIndex(List<LuceneProfileVo> profiles,String fp);
	
	public List<ZyIndexqueue> getUsersInQueue(int limitNum);
	
	public void deleteDocument(int userId,String fp);
	
	public void deleteDocument(List<Integer> profileIds,String fp);
	
	public void addIndexLog(ZyIndexlog log);
	
	public ZyIndexlog getLastIndexLog();
	
	public void deleteUsersInQueue(List<ZyIndexqueue> list);
		

}
