package com.zy.common.cache;

import java.io.Serializable;
import java.util.Map;

public class CacheManager {
	private static Cache cache = new MemCache();//to do
	public static Object get(String key) {
		return cache.get(key);
	}

	public static Map<String, Object> getMulti(String... keys) {
		return cache.getMulti(keys);
	}

	public static void set(String key, int cacheTimeSeconds, Object o) {
		cache.set(key, cacheTimeSeconds, o);
	}
	
	public static void set(String key, Object o) {
		set(key,Integer.MAX_VALUE,o);
	}

	public static void delete(String key) {
		cache.delete(key);
	}
	
	public static void main(String[] args){
		
	}
}