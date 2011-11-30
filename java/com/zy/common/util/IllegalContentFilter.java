package com.zy.common.util;
/**
 * 
 * @author Bing
 *
 * Nov 6, 2009 11:28:39 AM

 * @Description:
 */
public class IllegalContentFilter implements ContentFilter{

	private ContentFilter filter;
	public IllegalContentFilter()
	{
		
	}
	public IllegalContentFilter(ContentFilter filter)
	{
		this.filter=filter;
	}
	/**
	 * Bing
	 * illegal words filter
	 */
	public String filtContent(String content) {
		String _content=content;
		if(this.filter != null)
		{
			_content=this.filter.filtContent(content);
		}
		String []s=getIllegalWords();
		for(int i=0;i<s.length;i++)
		{
			if(_content.indexOf(s[i]) != -1)
			{
				_content=_content.replaceAll(s[i], "******");
			}
		}
		return _content;
	}
	/**
	 * Bing
	 * check if include illegal words
	 * return true(include) false(exclude)
	 */
	public boolean check(String content) {
		boolean reslut=false;
		if(this.filter != null)
		{
			reslut=this.filter.check(content);
		}
		String []s=getIllegalWords();
		for(int i=0;i<s.length;i++)
		{
			if(content.indexOf(s[i]) != -1)
			{
				reslut=true;
			}
		}
		return reslut;
	}
	private String[] getIllegalWords()
	{
		
		String s="fuck,shit";
		return s.split(",");
	}
	

}
