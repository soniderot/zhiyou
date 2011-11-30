package com.zy.common.util;

public class DigatUtil {
	
	public static String DtoX(int d) {
	     String x = "";
	     if(d<16) {
	    	 x = chang(d);
	    	 
	     } else {

	        int c;
	        int s=0;
	        int n=d;
	        
	        while(n>=16) {
	           s++;
	           n=n/16;
	        }

	        String [] m=new String[s];

	      int i=0;

	      do {
	           c=d/16;

	           m[i++ ]= DigatUtil.chang(d%16);//判断是否大于10，如果大于10，则转换为A-F的格式

	           d=c;

	       }while(c>=16);

	       x=chang(d);

	       for(int j=m.length-1;j>=0;j--)

	       {

	           x+=m[j];

	       }

	     }

	      return x;

	   }


	public static String chang(int d)

	{
	   String x= "";

	   switch(d) {
	   	case 10:
	       x = "A"; 
	       break;

	   	case 11:
	       x = "B"; 
	       break;

	   	case 12:
	       x = "C"; 
	       break;

	   	case 13:
	       x = "D"; 
	       break;

	   	case 14:
	       x = "E"; 
	       break;

	   	case 15:
	       x = "F"; 
	       break;

	    default:
	       x = d + "";
	       break;
	   }

	  return x;

	}

}
