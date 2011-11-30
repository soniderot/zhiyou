package com.zy.common.cache;

import java.util.Map;

public interface Cache {
	public Object get(String key);

	public Map<String, Object> getMulti(String... keys);

	public void set(String key, int cacheTimeSeconds, Object o);
	
	public void set(String key, Object o);

	public void delete(String key);
}
