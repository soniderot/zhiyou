package com.zy.common.util;

import java.security.MessageDigest;

public class MD5 {
	public final static String MD5(String s) {
        char hexDigits[] = {
                           '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                           'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
    	String Userid = "A709995";
    	String Userpws = "ushi98313";
    	String Cardid = "140101";
    	String Cardnum = "0.2";
    	String Sporder_id = "13721";
    	String sporder_time = "20110830101514";
    	String game_userid = "18221003056";
    	
    	
    	String md5_str = "";
    	String version = "4.0";
    	String KeyStr = "OFCARD"; 
    	String md5pwd = MD5.MD5("ushi98313");
//    	System.out.println(MD5.MD5("ushi98313"));
//        System.out.println((MD5.MD5(Userid+Userpws+Cardid+Cardnum+Sporder_id+sporder_time+game_userid+KeyStr)).toUpperCase());


//        String md5str = "A706893" + "0d98eeaa4c009f5df7d00af2acd956af" + "140101" + "0.2" + "13720"+"20110830101514" +"18221003056" + "OFCARD";
        
        System.out.println(MD5.MD5(KeyStr).toUpperCase());
//        http://api2.ofpay.com/onlineorder.do?userid=A709995&userpws=440922dffe92f11d29d89d9a209a0df4&cardid=140101&cardnum=0.2&sporder_id=10000&sporder_time=20110916102235&game_userid=18221003056&md5_str=674272A39CFA041247E575B371A31CC0&version=4.0

//        String url = "http://api2.ofpay.com/onlineorder.do?userid=A706893&userpws=0d98eeaa4c009f5df7d00af2acd956af&cardid=140101&cardnum=0.2&sporder_id=13720&sporder_time=20110830101514&game_userid=18221003056&md5_str=E2381FAFC8AEF32835B6D66C4869FF99&version=4.0";
    }
} 
