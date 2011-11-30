package com.zy.domain.option.service;

import java.util.List;
import java.util.Map;

import com.zy.common.model.ZyOption;

public interface OptionService {
	public List<ZyOption> getOptionList(String handle);
	public Map<String,String> getOptionContentMap(String handle);
	public ZyOption getOptionByValue(int optionId,String handle);
	public List<ZyOption> getOptionByValue(int[] optionId, String handle);
	
	public List<ZyOption> getBlurOptionList(String handel);
}
