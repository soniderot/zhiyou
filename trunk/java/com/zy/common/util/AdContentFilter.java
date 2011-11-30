package com.zy.common.util;
/**
 * @author Bing
 *
 * Nov 9, 2009 2:43:32 PM

 * @Description:
 */
public class AdContentFilter implements ContentFilter{
	private ContentFilter filter;
	public AdContentFilter()
	{
		
	}
	
	public AdContentFilter(ContentFilter filter)
	{
		this.filter=filter;
	}
	/**
	 * filt email, or telephone or mobile
	 * 
	 * return : true(include) : false(exclude)
	 */
	public String filtContent(String content) {
		String _content=content;
		if(this.filter != null)
		{
			_content=this.filter.filtContent(content);
		}
		String regEx_email="([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";   
        java.util.regex.Pattern p=java.util.regex.Pattern.compile(regEx_email);
        java.util.regex.Matcher m=p.matcher(_content);
        _content=m.replaceAll("***");
        String regEx_telphone="(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?";
        p=java.util.regex.Pattern.compile(regEx_telphone);
        m=p.matcher(_content);
        _content=m.replaceAll("***");
        String regEx_mobile="1[3,5]{1}[0-9]{1}[0-9]{8}";
        p=java.util.regex.Pattern.compile(regEx_mobile);
        m=p.matcher(_content);
        _content=m.replaceAll("***");
       
		return _content;
	}
	/**
	 * Bing
	 * check if include email or telephone or mobile
	 * return true(include) false(exclude)
	 */
	public boolean check(String content) {
		boolean reslut=false;
		if(this.filter != null)
		{
			reslut=this.filter.check(content);
		}
		String regEx_email="[a-z0-9A-Z]+([-|\\.]+[a-z0-9A-Z])*@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}"; 
		//String regEx_email="\\w+([-+.]\\w+)*@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}"; 
        java.util.regex.Pattern p=java.util.regex.Pattern.compile(regEx_email);
        java.util.regex.Matcher m=p.matcher(content);
        boolean result_email=m.matches();
        String regEx_telphone="(0[0-9]{2,3}\\[-_－—]?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?";
        p=java.util.regex.Pattern.compile(regEx_telphone);
        m=p.matcher(content);
        boolean result_telphone=m.matches();
        String regEx_mobile="1[3,5]{1}[0-9]{1}[0-9]{8}";
        p=java.util.regex.Pattern.compile(regEx_mobile);
        m=p.matcher(content);
        boolean result_mobile=m.matches();
        //qq:xxxxx, QQ:xxxxx, qqxxxx, qq群：xxxxxxx 
        String regEx_qq=".+[qq|QQ]{1,}+.+[0-9]{5,}+.";
		p=java.util.regex.Pattern.compile(regEx_qq);
		m=p.matcher(content);
		boolean result_qq=m.matches();
		boolean result_hanzishuzi=hanzicheck(content);
        return result_email||result_telphone||result_mobile||reslut||result_qq||result_hanzishuzi;
	}
	/**
	 * Bing
	 * 如果字符串里面包含连续6位中文数字，那就认为非法
	 * 2010-9-21
	 * @param content
	 * @return
	 */
	private boolean hanzicheck(String content)
	{
		if(content != null && !"".equals(content))
		{
			int [] hanzi={19968,20108,19977,22235,20116,20845,19971,20843,20061,21313};
			char []  content_temp=content.toCharArray();
			for(int m=0;m<content_temp.length;m++)
			{
				for(int n=0;n<hanzi.length;n++)
				{
					int a=(int)content_temp[m];
					if(a == hanzi[n])
					{
						if(m+6 <= content_temp.length)
						{
							String s=content.substring(m,m+6);
							//System.out.println(s);
							char [] t={'0','0','0','0','0','0'};
							for(int j=0;j<6;j++)
							{
								int b=(int)s.charAt(j);
								for(int k=0;k<hanzi.length;k++)
								{
									if(b == hanzi[k])
									{
										t[j]='1';
									}
								}
							}
							if(new String(t).equals("111111"))
							{
								return true;
							}
						}
						else
						{
							return false;
						}
						
					}
				}
			}
		}
		return false;
	}
	public static void main(String [] args)
	{
		//String str="索罗斯对liubing.li@163.com方知道";
		String str="";
		AdContentFilter f=new AdContentFilter();
//		
		System.out.println(f.check(str));;
		//System.out.println(f.hanzicheck(str));
	}
}
