package com.zy.common.util;

import com.opensymphony.xwork2.ActionContext;

public class EnvUtil {

	private static Boolean bWebEnv;
	
	public static boolean isWebEnv(){
		if(bWebEnv != null)
			return bWebEnv;
		
		ActionContext ctx = ActionContext.getContext();
		if(ctx == null){
			bWebEnv = false;
		} else {
			bWebEnv = true;
		}
		return bWebEnv;
	}	
	
}
