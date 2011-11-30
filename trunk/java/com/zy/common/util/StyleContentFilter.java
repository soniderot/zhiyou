package com.zy.common.util;

/**
 * 
 * @author Bing
 *
 * Mar 5, 2010 11:00:35 AM

 * @Description:
 */
public class StyleContentFilter implements ContentFilter{

	private ContentFilter filter;
	public StyleContentFilter()
	{
		
	}
	public StyleContentFilter(ContentFilter filter)
	{
		this.filter=filter;
	}
	public boolean check(String content) {
		return false;
	}
	/**
	 * remove the middle content between "<style></style>"
	 */
	public String filtContent(String content) {
		String _content=content;
		if(this.filter != null)
		{
			_content=this.filter.filtContent(content);
		}
		try
		{
			String str1=_content.substring(0,_content.indexOf("<style>"));
			String str2=_content.substring(_content.indexOf("</style>")+8, _content.length()-1);
			
			_content=str1+str2;
		}
		catch(Exception e)
		{
			//not found <style> tag
		}
		
		return _content;
	}
	
}
