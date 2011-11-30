package com.zy.domain.option.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyOption;

public interface OptionDAO extends BaseDao<ZyOption, Integer> {
	public List<ZyOption> getOptionList(String handle);
	public List<ZyOption> getOptionList_nosort(String handle);
	public ZyOption getOptionByValue(int optionId,String handle);
	public List<ZyOption> getOptionByValue(int[] optionId, String handle);
	/**
	 * Bing
	 * blur query 
	 * example: select * from bns_option bo where bo.handle like '%+handle+%'
	 * 2010-8-27
	 * @param locale
	 * @param handel
	 * @return
	 */
	public List<ZyOption> getBlurOptionList(String handel);
}
