package com.jacksen.java.algorithm;

/**
 * 单词反转
 * 
 * @author jacksen
 * @date 2017-9-5 下午4:05:36
 */
public class ReverseString {

	public static void main(String[] args) {
		String str = "abc123";
		System.out.println(reverseString(str));
	}

	private static String reverseString(String s) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--) {
			sBuffer.append(s.charAt(i));
		}
		return sBuffer.toString();
	}

}
