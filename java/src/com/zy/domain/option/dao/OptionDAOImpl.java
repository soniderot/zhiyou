package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyOption;

public class OptionDAOImpl extends HibernateDao<ZyOption, Integer> implements OptionDAO {

	@Override
	public List<ZyOption> getOptionList(String handle) {
		String hql="from ZyOption as model where model.handle='"+handle+"'  order by model.sortorder";
		return getHibernateTemplate().find(hql);
	}
	
	@Override
	public List<ZyOption> getOptionList_nosort(String handle){
		String hql="from ZyOption as model where model.handle='"+handle+"' ";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public ZyOption getOptionByValue(int optionId,String handle) {
		String hql="from ZyOption as model where model.optionid='"+optionId+"' and model.handle='"+handle+"'  order by model.sortorder";
		List<ZyOption> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public List<ZyOption> getOptionByValue(int[] optionId, String handle) {
		String opt = "(";
		for(int i=0; i<optionId.length;i++){
			if(i ==0)
				opt += "'"+optionId[i]+"'";
			else 
				opt += ",'"+optionId[i]+"'";
		}
		opt = opt +")";
		String hql="from ZyOption as model where model.optionid in "+opt+" and model.handle='"+handle+"'  order by model.sortorder";
		List<ZyOption> list = getHibernateTemplate().find(hql);
		return list;
	}
	/**
	 * Bing
	 * blur query 
	 * example: select * from bns_option bo where bo.handle like '%+handle+%'
	 * 2010-8-27
	 * @param locale
	 * @param handel
	 * @return
	 */
	public List<ZyOption> getBlurOptionList(String handel)
	{
		String hql="from ZyOption bo where bo.handle like '%"+handel+"%' ";
		return getHibernateTemplate().find(hql);
	}

}
