package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyExternalinvite;

public class InviteByAddressDaoImpl extends HibernateDao<ZyExternalinvite, Integer> implements InviteByAddressDao {
	
	public List<String> getExistedInviteEmails(int userId){
		List<String> results = new java.util.ArrayList<String>();
		String hql = "select email from ZyExternalinvite where userid=?";
		java.util.Iterator iter = this.iterate(hql,new Object[] {userId});
		while(iter.hasNext()){
			Object obj = (Object)iter.next();
			//System.out.println(obj.toString());
			results.add((String)obj);
		}
		return results;
	}
	
	public List<Integer> getProfilesFromInvites(String[] emailAddress) {
		
		List<Integer> results = new java.util.ArrayList<Integer>();
		String hql = "select receiverid from ZyExternalinvite where email in (:addressarray) and receiverid is not null and receiverid!=0";
		
		java.util.Iterator iter = this.getSession().createQuery(hql).setParameterList("addressarray",emailAddress).iterate();
		
		while(iter.hasNext()){
			Object obj = (Object)iter.next();
			results.add((Integer)obj);
		}
		return results;
	}
}
