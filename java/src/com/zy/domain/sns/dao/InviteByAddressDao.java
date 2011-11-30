package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyExternalinvite;;


public interface InviteByAddressDao extends BaseDao<ZyExternalinvite, Integer> {	
	public List<String> getExistedInviteEmails(int userId);
	
	public List<Integer> getProfilesFromInvites(String[] emailAddress);
}
