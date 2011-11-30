package com.zy.common.util;

import java.util.Random;

public class PrMsnUrlUtil {
	static int URL_LEN = 4;

	public static String getMsnUr() {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < URL_LEN; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getMsnUr());
	}
}
