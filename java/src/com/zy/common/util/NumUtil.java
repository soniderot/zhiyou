package com.zy.common.util;

import java.util.ArrayList;
import java.util.List;

import com.zy.Constants;

/**
 * While I wrote down follow code, only God and me can understand. to this day, only lonely God.
 * @author Patrick
 */
public class NumUtil {

    public static List<Integer> split(int i,int num) { 
    	List<Integer> a= new ArrayList<Integer>();
    	for(int j=0;j<num;j++) {
    		if((i&1<<j)>0) {
    			a.add(1<<j);
    		}
    	}
    	return a;
    }
    
    public static boolean ifExist(int comp,int single) {
    	return (comp&single)>0;
    }
    
    public static int firstNoExist(int comp,int num){
    	for(int i=1;i<=(1<<num);i*=2) {
    		if((comp&i)==0) {
    			return i;
    		}
    	}
    	return 0;
    }
    
   
    
    public static void main(String args[]){
    	System.out.println("<p>--------------------</p>");
    	
    	System.out.println(NumUtil.split(10,55));
    }
}
