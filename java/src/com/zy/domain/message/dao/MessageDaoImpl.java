package com.zy.domain.message.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyMessage;

public class MessageDaoImpl extends HibernateDao <ZyMessage, Long>  implements MessageDao {

	@Override
	public List<ZyMessage> loadForInbox(int userid, int pageNo, int pageSize) {
		String hql = "from ZyMessage where receiverid =? and deletedbyreceiver is null order by createtime desc";
		return this.loadByPage(hql, pageNo, pageSize, new Object[] { userid});
	}
	
	public int countForInbox(int userid){
		String hql = "select count(*) from ZyMessage receiverid =? and deletedbyreceiver is null";
		return this.getTotalRows(hql, new Object[] { userid});
	}
	
	public int countForNewInbox(int userid){
		String hql = "select count(*) from ZyMessage where receiverid =? and deletedbyreceiver is null and isread is null";
		return this.getTotalRows(hql, new Object[] { userid });
	}

	@Override
	public List<ZyMessage> loadForOutbox(int userid, int pageNo, int pageSize) {
		String hql = "from ZyMessage where senderid =? and deletedbysender is null order by createtime desc";
		return this.loadByPage(hql, pageNo, pageSize, new Object[] { userid});
	}
	
	public int countForOutbox(int userid){
		String hql = "select count(*) from ZyMessage where senderid =? and deletedbysender is null";
		return this.getTotalRows(hql, new Object[] { userid});
	}	
	
}
