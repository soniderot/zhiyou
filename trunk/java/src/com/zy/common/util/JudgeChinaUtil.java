package com.zy.common.util;

/** 
 * @author johnny
 */ 
public class JudgeChinaUtil {
		     /** 
		      * @param args 
		      */  
		    //用于判断中英文进行截位
		     public static String judgeChina(String content,int numlimit) {  
		         Integer index = 0;  
		         StringBuffer sBuffer = new StringBuffer();  
		         for (int i = 0; i < content.length(); i++) {  
		             String bb = content.substring(i, i + 1);  
		             // 生成一个Pattern,同时编译一个正则表达式  
		             boolean cc = bb.matches("[\u4E00-\u9FA5]");  
		               
		             if (index == numlimit) {  
		                 sBuffer.append("..");  
		                 break;  
		             }  
		               
		             if ((index == numlimit-1 && cc)) {  
		                 continue;  
		             }  
		               
		             if (cc) {  
		                 index = index + 2;  
		             } else {  
		                 index = index + 1;  
		             }  
		               
		   
		             sBuffer.append(bb);  
		             if (index > numlimit) {  
		                 sBuffer.append("..");  
		                 break;  
		             }  
		         }  
		         return sBuffer.toString();  
		     }  
		     
		     //判断是否超位
		     public static boolean contentOverLimit(String content,int numlimit) {  
		         Integer index = 0;  
		         StringBuffer sBuffer = new StringBuffer();  
		         for (int i = 0; i < content.length(); i++) {  
		             String bb = content.substring(i, i + 1);  
		             // 生成一个Pattern,同时编译一个正则表达式  
		             boolean cc = bb.matches("[\u4E00-\u9FA5]");  
		             if (cc) {  
		                 index = index + 2;  
		             } else {  
		                 index = index + 1;  
		             }  
		         }  
		         return (index > numlimit);  
		     }
		     
		     public static void main(String[] args) {  
		         String string = "04.偷功.mp3";  
		         System.out.println(judgeChina(string,8));  
		         System.out.println(contentOverLimit(string,8));
		     }  
}
