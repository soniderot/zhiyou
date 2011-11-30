package com.zy.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.TitleTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class HtmlUtil {

	public static String getTitle(String linkurl) {
		String title = linkurl;
		Parser p = null;
		try {
			p = new Parser(linkurl);
			//change url string type
			p.setEncoding("gbk");
			NodeClassFilter f = new NodeClassFilter(TitleTag.class);
			NodeList titlelist = p.extractAllNodesThatMatch(f);
			if (titlelist != null && titlelist.size() > 0) {
				title = ((TitleTag) titlelist.elementAt(0)).getStringText();
				//万能转换代码 add by johnny
				if(!"GB2312".equals( p.getEncoding()))
				{
					//add by liubing
					if(!"GBK".equalsIgnoreCase(p.getEncoding()))
					{
						title = StringHelper.changeTitleTypeFromUrl(title, p.getEncoding(), "UTF-8");
					}
				}
				title = StringEscapeUtils.unescapeHtml(title);
			}
			if(StringUtils.isNotBlank(title)){
				if(title.length()>255){
					title=StringEscapeUtils.unescapeHtml(title);
					title=StringHelper.subStringByByte(title, 255);
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);
		}
		return title;
	}
	/**
	 * remove<br \><script>
	 * @param content
	 * @return
	 */
	public static String getFormattedContent(String content) {
		String formattedContent = StringEscapeUtils.escapeHtml(content);
		return StringUtils.replace(formattedContent, "\n", "<br>");
	}
	/**
	 * replace \r\n to <br \><script>
	 * @param content
	 * @return
	 */
	public static String getFormattedContentNew(String content) {
		String formattedContent = StringEscapeUtils.escapeHtml(content);
//		String formattedContent = content;
		return StringUtils.replace(formattedContent, "\r\n", "<br>").replace(" ", "&nbsp;&nbsp;");
	}
	public static String getFeedFormattedContent(String content) {
		String formattedContent = StringEscapeUtils.escapeHtml(content);
		return StringUtils.replace(formattedContent, "\n", " ");
	}
	/**
	 * Bing
	 * @param str
	 * @return
	 */
	public static String ChangeString(String str)
	{
		return ChangeString(str,false,true);
	}
	/**
	 * Bing
	 * @param str
	 * @return
	 */
	public static String ChangeString(String str,Boolean nbsp)
	{
		return ChangeString(str,nbsp,true);
	}
	/**
	 * Bing
	 * @param str
	 * @return
	 */
	public static String ChangeString(String str,Boolean nbsp,Boolean br)
	{
		if(str != null && !"".equals(str))
		{
			str=ChangeStringBack(str);
			String formattedContent = StringEscapeUtils.escapeHtml(str);
			if(nbsp)
			{
				formattedContent = formattedContent.replaceAll(" ","&nbsp;");
			}
			if(br)
			{
				formattedContent = formattedContent.replaceAll("\r\n","<br>");
				formattedContent = formattedContent.replaceAll("\n","<br>");
			}
			return formattedContent;
		}
		return str;
	}
	/**
	 * Bing
	 * @param str
	 * @return
	 */
	public static String ChangeStringBack(String str)
	{
		if(str != null && !"".equals(str))
		{
			str=StringEscapeUtils.unescapeHtml(str);
			str = str.replaceAll("\r\r","");
		}
		
		return str;
	}
	public static String changeStringForReply(String str)
	{
		str=ChangeStringBack(str);
			str = StringEscapeUtils.escapeHtml(str);
			//str = str.replaceAll(" ","&nbsp;");//&nbsp;空格换行的时候不识别
			str = str.replaceAll("\r\n","<br> ");
			str = str.replaceAll("\n","<br> ");
			str= str.replaceAll("&lt;p class=&quot;quote-txt&quot; &gt;", "<p class=\"quote-txt\" >");
			str=str.replaceAll("&lt;/p&gt;", "</p>");
			str=allowhttpandemaillinks(str);
		return str;
	}
	public static String kickaway(String str)
	{
		if(str.indexOf("\r\n\r\n\r\n") != -1)
		{
			str=str.replaceAll("\r\n\r\n","\r\n");
			str=str.replaceAll("       ", "");
			str=kickaway(str);
		}
		
		return str;
	}
	/**
	 * Bing
	 * 2010-06-04
	 * example:
	 * replace string sadfhttp://www.baidu.com sdfsdfsaf xxx http://www.google.cn asdfsafasf http://dddd
	 * to sadf<a href='http://www.baidu.com'>http://www.baidu.com</a> sdfsdfsafxxx<a href='http://www.google.cn'>http://www.google.cn</a> asdfsafasf<a href='http://dddd'>http://dddd</a> 
	 * @param str
	 * @return
	 */
	public static String allowhttplinks2(String str) 
	{
		if(str == null) return str;
		String[] s=str.split("&nbsp;");
		try
		{
			for(int m=0;m<s.length;m++)
			{
				String str1=s[m];
				int i=str1.lastIndexOf("http://");
				if(i != -1)
				{
						String str2=str1.substring(i);
						if(str2.indexOf("&lt;/a&gt") != -1)
						{
							str2=str2.substring(0,str2.indexOf("&lt;/a&gt"));
						}
						if(str2.indexOf("<br>") != -1)
						{
							str2=str2.substring(0,str2.indexOf("<br>"));
						}
						
						s[m]=str1.replace(str2, " <a href='"+str2+"' target='_blank'>"+str2+"</a> ");
				}
				s[m]=s[m]+"&nbsp;";
			}
			
		}
		catch(Exception e)
		{
			
		}
		
		return StringUtils.join(s);
	}
	public static String allowhttplinks(String str)
	{
		if(str == null) return str;
		str=str.replace("http://http://", "http://");
		String strtemp=str;
		str=ChangeStringBack(str);
		String regEx="http://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		Pattern p = Pattern.compile(regEx);
        Matcher c = p.matcher(str);
        List<String> linklist=new ArrayList<String>();
        while (c.find()) {
        	String sss=c.group(0);
        	linklist.add(sss);
        }
        for(int i=0;i<linklist.size();i++)
        {
        	String link=linklist.get(i);
        	String newlink=ChangeString(link);
        	strtemp=strtemp.replace(newlink, " <a href='"+newlink+"' target='_blank'>"+newlink+"</a> ");
        }
		return strtemp;
	}
	/**
	 * Bing
	 * 2010-06-04
	 * @param str
	 * @return
	 */
	public static String allowemaillinks(String str)
	{
		try
		{
			//String regEx="[a-zA-Z0-9-_]+@(\\w+.)+[a-z]{2,3}";
			String regEx="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
			Pattern p = Pattern.compile(regEx);
	        Matcher m = p.matcher(str);   
	        List<String> emaillist=new ArrayList<String>();
	        while (m.find()) {
	        	String email=m.group(0);
	        	if(email.indexOf("<br") != -1)
	        	{
	        		email=email.substring(0,email.indexOf("<br"));
	        	}
	        	if(email.indexOf("<br>") != -1)
	        	{
	        		email=email.substring(0,email.indexOf("<br>"));
	        	}
	        	if(email.indexOf("&") != -1)
	        	{
	        		email=email.substring(0,email.indexOf("&"));
	        	}
	        	if(!emaillist.contains(email))
	        	{
	        		emaillist.add(email);
	        	}
	        }
	        for(int i=0;i<emaillist.size();i++)
	        {
	        	String email=emaillist.get(i);
	        	str=str.replaceAll(email, "<a href='mailto:"+email+"' >"+email+"</a>&nbsp;");
	        }
		}
		catch(Exception e)
		{
			
		}
		
        return str;
	}
	/**
	 * Bing
	 * @param str
	 * @return
	 */
	public static String allowhttpandemaillinks(String str)
	{
		str=allowhttplinks(str);
		str=allowemaillinks(str);
		return str;
	}
	
	public static String filterSingleQuotation(String str){
		if(StringUtils.isNotBlank(str)){
			str=str.replaceAll("\\\\","\\\\\\\\");
			str=str.replaceAll("'", "\\'");
			str=str.replaceAll("\"","\\\"");
			return str;
		}
		return "";
		
	}
	/**
	 * Bing
	 * @return
	 */
	public static String removeHtmlTags(String str)
	{
		if(str != null)
		{
			str=str.replaceAll("<", "");
			str=str.replaceAll(">", "");
			str=str.replaceAll("\r\n", "");
			str=str.replaceAll("\n", "");
		}
		return str;
	}
	
	
	public static void main(String [] args)
	{
//		System.out.println(StringEscapeUtils.escapeHtml("<p class=\"quote-txt\" >"));
//		System.out.println(StringEscapeUtils.escapeHtml("</p>"));
		
//		List<List<Object>> sss=JDBCUtil.executeQuery("select * from GRP_REPLY gr where gr.id=461");
//		List c=sss.get(0);
//		String a=(String)c.get(3);
//		System.out.println(changeStringForReply(a));
		
//		String asa="sadfhttp://www.baidu.com sdfsdfsaf xxx http://www.google.cn</a> asdfsafasf http://dddd ";
//		System.out.println(allowhttplinks(ChangeString(asa)));
		
//		String bbb="森梵文创-王淼<miaowang1978@163.com> 13:01:30 森梵文创-王淼<miaowang1978@163.com> 13:01:30 森梵文创-王淼<miaowang1978@126.com> 13:01:30 ";
//		System.out.println(ChangeString(bbb));
//		//System.out.println(allowemaillinks(bbb));
//		System.out.println(allowemaillinks(ChangeString(bbb)));
		//System.out.println(allowemaillinks(bbb));
		
		//System.out.println("filterSingleQuotation"+filterSingleQuotation("aaaaaaaaa'aaaaa"));
		String str="<br><br>&#19968;&#12289;&#22522;&#26412;&#20449;&#24687; <br><br><br>&#20027;&#39064;&#65306;&#12298;&#30005;&#23376;&#21830;&#21153;&#25968;&#25454;&#20998;&#26512;&#12299;<br><br>&#26102;&#38388;&#65306;2010.8.21 &#21608;&#20845;&#19979;&#21320;&#65288;2.00&mdash;5.30&#65289;<br>";
		String str2=HtmlUtil.ChangeStringBack(str);
		System.out.println(str);
		System.out.println(HtmlUtil.allowhttplinks(str2));
	}
	
	public static String removeNewLineTags(String str)
	{
		if(str != null)
		{
			str=str.replaceAll("\r\n", "");
			str=str.replaceAll("\n", "");
			str=str.replaceAll("\r", "");
		}
		return str;
	}
	
}
