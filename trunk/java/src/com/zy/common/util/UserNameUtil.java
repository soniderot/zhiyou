package com.zy.common.util;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.zy.Constants;


public class UserNameUtil {
    /**
     * @author calvin
     * user name background validation
     * 1. check parenthesis
     * 2. check Chinese family name
     * 3. check prohibited characters/words 
     */
    public static String validateUserName(String nameString) {
        if (StringUtils.isEmpty(nameString)) {
            return null;
        }
        // for safety, rip off all characters that might attempt to attack
        nameString = nameString.replaceAll("[<>,'\"]*;", "");
        // 1. check parenthesis in pairs
        int left = nameString.indexOf("(");
        int right = nameString.indexOf(")");
        int leftCN = nameString.indexOf("（");
        int rightCN = nameString.indexOf("）");
        if (left>right || (left==-1 && right>-1) || leftCN>rightCN || (leftCN==-1 && rightCN>-1)) {
            return Constants.UNPAIRED_PARENTHESIS;
        }
        // 2. check Chinese family name
        //rip off Chinese parenthesis
        String str = nameString.replaceFirst("（","").replaceFirst("）","");
        //get the first Chinese character
        char[] chars = str.toCharArray();
        int i = -1; //used to mark the first Chinese character
        while (++i < chars.length && chars[i] < Byte.MAX_VALUE) {} // while chars[i] < 127

        int maxFamilyName = 5;
        String familyName = null;
        for (int len = 1; len <= str.length()-i && len <= maxFamilyName; len++) { // at most check 5-character Chinese family name
            String temp = new String(chars, i, len);
            //validate the family name
            if (Constants.chineseFamilyNameSet.contains(temp)) {
                familyName = temp;
            }
        }
        if (familyName == null) {
            return Constants.INVALID_FAMILY_NAME;
        }
        // 3. check forbidden characters/words
        //get the rest part of the name(given name)
        int j = i + familyName.length() - 1;
        int k = i + familyName.length(); // used to mark the first character of given name
        while (++j < chars.length && chars[j] > Byte.MAX_VALUE) {}
        String givenName = new String(chars, k, j - k);
        String fullName = familyName + givenName;
        if (Constants.forbiddenWordSet.contains(givenName) || Constants.forbiddenWordSet.contains(fullName)) {
            return Constants.FORBIDDEN_WORDS;
        }
        else {
            Iterator<String> itr = Constants.forbiddenWordSet.iterator();
            while (itr.hasNext()) {
                String s = itr.next();
                if (givenName.indexOf(s) != -1 || fullName.indexOf(s) != -1) {
                    return Constants.FORBIDDEN_WORDS;
                }
            }
        }
        return Constants.SUCCESS_VALIDATION;
    }

}
