package com.zy.common.util;

import java.util.Set;
import java.util.TreeSet;

import com.google.gdata.util.common.base.StringUtil;
import com.zy.Constants;


public class RecommendHelper {
    private static Set<Integer> pymkFlagList = null;
    private static Set<Integer> pymwkFlagList = null;

    

    private static void init() {
        pymkFlagList = new TreeSet<Integer>();
        pymwkFlagList = new TreeSet<Integer>();
        
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_INVITE);
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_IP);
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_EDU);
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_CAREER);
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_SEARCH_HISTORY);
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_EMAILDOMAIN);
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_COMMENT_MESSAGE);
        pymkFlagList.add(Constants.RECOMMEND_PROFILE_MESSAGE);
        
        pymwkFlagList.add(Constants.RECOMMEND_PROFILE_MUTUAL_FRIEND);
        pymwkFlagList.add(Constants.RECOMMEND_PROFILE_TITLE);
        pymwkFlagList.add(Constants.RECOMMEND_PROFILE_MUTUAL_FRIEND_INDUSTRY);
        pymwkFlagList.add(Constants.RECOMMEND_PROFILE_MUTUAL_GROUP);
        pymwkFlagList.add(Constants.RECOMMEND_PROFILE_MUTUAL_EVENT);
        pymwkFlagList.add(Constants.RECOMMEND_PROFILE_NEWUSER);
    }
    
    public static Boolean isPYMK(String flagString) {
        if (StringUtil.isEmptyOrWhitespace(flagString)) {
            return null;
        }
        if (pymkFlagList == null || pymwkFlagList == null) {
            init();
        }
        String[] flags = flagString.split(",");
        for (int i = 0; i < flags.length; i++) {
            if (pymkFlagList.contains(Integer.parseInt(flags[i]))) {
                return true;
            }
        }
        return false;
    }

}
