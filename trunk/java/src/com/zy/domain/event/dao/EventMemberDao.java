package com.zy.domain.event.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyEventmember;

public interface EventMemberDao extends BaseDao<ZyEventmember,Integer>{
	public List<ZyEventmember> getMembers(int eventId);
}
