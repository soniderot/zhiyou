/**
 * 
 */
package com.zy.common.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Steele
 * @version V 1.0, Dec 14, 2009
 */
public class DESUtil {
	private Cipher encryptCipher = null;
	private Cipher decryptCipher = null;
	public String encrypt(String strIn){
		try {
			return byteArr2HexStr(encrypt(strIn.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String decrypt(String strIn){
		try {
			return new String(decrypt(hexStr2ByteArr(strIn)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DESUtil(String strKey){
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			Key key = getKey(strKey.getBytes());
			encryptCipher = Cipher.getInstance("DES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			decryptCipher = Cipher.getInstance("DES");
			decryptCipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	private byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	private byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);
	}

	private byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	private Key getKey(byte[] arrBTmp) throws Exception {
		byte[] arrB = new byte[8];
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}
	/**  
	 * @param input  
	 * @return  
	 * @throws Exception  
	 */  
	public static String encryptData(String input,String encryptkey) throws Exception {   
	  
	    SecureRandom sr = new SecureRandom();   
	    byte rawKeyData[] = encryptkey.getBytes();   
	    DESKeySpec dks = new DESKeySpec(rawKeyData);   
	  
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");   
	    SecretKey key = keyFactory.generateSecret(dks);   
	  
	    Cipher c = Cipher.getInstance("DES");   
	    c.init(Cipher.ENCRYPT_MODE, key, sr);   
	    byte[] cipherByte = c.doFinal(input.getBytes());   
	    String dec = new BASE64Encoder().encode(cipherByte);   
	    return dec;   
	  
	}   
	  
	/**  
	 * @param input  
	 * @return  
	 * @throws Exception  
	 */  
	public static String decryptData(String input,String decryptkey) throws Exception {   
	    byte[] dec = new BASE64Decoder().decodeBuffer(input);   
	  
	    SecureRandom sr = new SecureRandom();   
	    byte rawKeyData[] = decryptkey.getBytes();   
	  
	    DESKeySpec dks = new DESKeySpec(rawKeyData);   
	  
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");   
	  
	    SecretKey key = keyFactory.generateSecret(dks);   
	  
	    Cipher c = Cipher.getInstance("DES");   
	    c.init(Cipher.DECRYPT_MODE, key, sr);   
	    byte[] clearByte = c.doFinal(dec);   
	  
	    return new String(clearByte);   
	  
	}  
 
	public static void main(String[] args) throws Exception {
		
		Integer userid = 1;
		String privatekey ="4260d2b7f";
		String mobile = "13816917980";
		String value = userid+","+mobile;
		DESUtil desEncrypt = new DESUtil(privatekey);		
		String encryptText = desEncrypt.encrypt(value);
		System.out.println("des:"+encryptText);
		String encrytedlink = BASE64Util.encode(privatekey+","+encryptText);
 		System.out.println("encryted link - " + encrytedlink);

 		//decrypt
 		String link1 = BASE64Util.decode(encrytedlink);
 		System.out.println("after base64 decode link - " + link1);
 	 	String[] params = link1.split(",");				
 	 	DESUtil des=new DESUtil(params[0]);
	 	String decryptText = des.decrypt(params[1]);
		System.out.println("decryted link - " + decryptText);
		System.out.println(privatekey+"/"+userid+"/"+mobile);
		System.out.println(BASE64Util.encode(privatekey+","+userid+","+mobile));
		
		
		System.out.println(BASE64Util.encode(privatekey+","+desEncrypt.encryptData(value,privatekey)));
		System.out.println(desEncrypt.decryptData(desEncrypt.encryptData(value,privatekey),privatekey));
    }
}
