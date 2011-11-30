package com.zy.common.cache;

import java.util.Map;
import com.zy.Constants;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.AddrUtil;

public class MemCache implements Cache{
	private static MemcachedClient memcachedClient = null;
	static{
		try{
			memcachedClient = new MemcachedClient(AddrUtil.getAddresses(Constants.MEMCACHED_SERVER));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public Object get(String key) {
		return memcachedClient.get(key);
	}

	public Map<String, Object> getMulti(String... keys) {
		return memcachedClient.getBulk(keys);
	}

	public void set(String key, int cacheTimeSeconds, Object o) {
		 memcachedClient.set(key, cacheTimeSeconds, o);
	}
	
	public void set(String key, Object o) {
		set(key,Integer.MAX_VALUE,o);
	}

	public void delete(String key) {
		memcachedClient.delete(key);
	}
}
