package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyEventmember;

public class EventMemberDaoImpl extends HibernateDao<ZyEventmember, Integer> implements EventMemberDao{
	public List<ZyEventmember> getMembers(int eventId) {
		String hql = "from ZyEventmember where eventid = ? ";
		return this.find(hql, new Object[] {eventId});
	}
	
	public void removeMember(int userId,int eventId){
		String hql = "from ZyEventmember where userid=? and eventid=?";
		List<ZyEventmember> list = this.find(hql, new Object[] {userId,eventId});
		this.deleteAll(list);
	}
}
