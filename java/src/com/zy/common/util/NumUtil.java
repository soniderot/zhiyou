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
    
    public static int getPercent(short type){
    	if(type==Constants.PROFILE_FILLPERCENT_CAREER || type==Constants.PROFILE_FILLPERCENT_EDUCATION){
    		return 25;
    	}
    	if(type==Constants.PROFILE_FILLPERCENT_AVATAR || type==Constants.PROFILE_FILLPERCENT_CONTACT){
    		return 15;
    	}
    	if(type==Constants.PROFILE_FILLPERCENT_CAREERSUM || type==Constants.PROFILE_FILLPERCENT_EXPERTSKILL){
    		return 10;
    	}
    	return -1;
    }
    
    public static int getPercentByItems(int items){
		List<Integer> all = split(items,6);
		int type = 0;
		for(int i=0;i<all.size();i++){
			type+=getPercent(all.get(i).shortValue());			
		}
		return type;
    } 
    
    public static void main(String args[]){
    	System.out.println("<p>--------------------</p>");
    	
    	System.out.println(NumUtil.split(10,55));
    }
}
