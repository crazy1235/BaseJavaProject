package com.jacksen.java.test;

import java.security.MessageDigest;

public class Test5 {

	public static void main(String[] args) {
		String time = String.valueOf(System.currentTimeMillis());
		int mac = 0;
		for (int i = 0, len = time.length(); i < len - 2;) {
			int tmp = Integer.parseInt(time.substring(i, i + 2));
			mac += tmp;
			i = i + 3;
		}
		mac += Integer.parseInt(time.substring(time.length() - 2));
		System.out.println(time + "," + mac);
		
		System.out.println(md5("123456"));
	}

	
	public static String md5(String s) {
		char hexDigits[] = { '0', 'E', '2', 'A', '6', '3', '4', 'D', '5', '1',
				'C', '7', '8', '9', 'B', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
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
			return null;
		}
	}
}
