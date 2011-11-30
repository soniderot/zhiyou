package com.zy.common.util;
/**
 * 
 * @author Bing
 *
 * Nov 6, 2009 11:20:15 AM

 * @Description:illegal words filter
 */
public interface ContentFilter {
	/**
	 * Bing
	 * check if include illegal content
	 * @param aContent
	 * @return
	 */
	public boolean check(String aContent);
	/**
	 * Bing
	 * filt illegal content
	 * @param aContent
	 * @return
	 */
	public String filtContent(String aContent);
}
