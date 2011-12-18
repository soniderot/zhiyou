package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyCity;

public interface LocationFacade {
	public List<ZyCity> getCitiesByKey(String key);
}
