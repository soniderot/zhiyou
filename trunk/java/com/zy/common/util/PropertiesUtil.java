package com.zy.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static PropertiesUtil _proUtil=null;
	private  Properties pro =null;
	private PropertiesUtil()
	{
		
	}
	private PropertiesUtil(String resourceName) throws Exception
	{
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(resourceName+".properties");
		pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			throw new Exception("system error ,open resource error please check file type");
		}
		catch(NullPointerException e)
		{
			throw new Exception("resource "+resourceName+".properties"+" not found! please make sure your have put it in the classes dest");
		}
	}
	public static PropertiesUtil getInstance(String resourceName)throws Exception 
	{
		if(_proUtil != null)
		{
			return _proUtil;
		}
		else
		{
			_proUtil=new PropertiesUtil(resourceName);
		}
		return _proUtil;
	}
	
	public  String get(String key)
	{
		return pro.getProperty(key);
	}
	public static void main(String [] args)
	{
		PropertiesUtil u=null;
		try {
			u = PropertiesUtil.getInstance("wap_config");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u.get("dburl"));
	}
}
