package com.zy.domain.message.dao;

import java.util.Date;
import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyMessage;

public interface MessageDao  extends BaseDao<ZyMessage, Integer> {
	
	public void save(ZyMessage message);

	public void delete(ZyMessage message);
	
	public void update(ZyMessage message);
	
	public List<ZyMessage> loadForInbox(int userid, int pageNo, int pageSize);
	
	public List<ZyMessage> loadForOutbox(int userid, int pageNo, int pageSize);
	
	public int countForInbox(int userid);
	
	public int countForOutbox(int userid);
	
	public int countForNewInbox(int userid);
	
}
