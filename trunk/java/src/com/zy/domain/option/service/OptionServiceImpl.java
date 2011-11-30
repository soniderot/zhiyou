package com.zy.domain.option.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zy.common.model.ZyOption;
import com.zy.domain.option.dao.OptionDAO;

public class OptionServiceImpl implements OptionService {
	private OptionDAO optionDAO;
	
	public void setOptionDAO(OptionDAO optionDAO) {
		this.optionDAO = optionDAO;
	}

	@Override
	public List<ZyOption> getOptionList(String handle) {
		return optionDAO.getOptionList(handle);
	}

	@Override
	public ZyOption getOptionByValue(int optionId,String handle) {
		return optionDAO.getOptionByValue(optionId,handle);
	}

	@Override
	public Map<String, String> getOptionContentMap(String handle) {
		List<ZyOption> ol = getOptionList(handle);
		Map<String, String> m = new HashMap<String, String>();
		for(ZyOption o:ol){
			m.put(o.getOptionid().toString(),o.getContent());
		}
		return m;
	}

	@Override
	public List<ZyOption> getOptionByValue(int[] optionId,
			String handle) {
		return optionDAO.getOptionByValue(optionId,handle);
	}
	
	public List<ZyOption> getBlurOptionList(String handel)
	{
		return optionDAO.getBlurOptionList(handel);
	}

}
