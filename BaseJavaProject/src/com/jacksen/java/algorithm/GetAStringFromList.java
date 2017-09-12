package com.jacksen.java.algorithm;

/**
 * 有一个字符串排列 A, B, C, D...Z, AA, AB, AC...AZ, BA, BB, BC... BZ... 给定一个数值，输出对应的字符串
 * 
 * @author Admin
 * 
 */
public class GetAStringFromList {

	public static void main(String[] args) {
		// System.out.println(getLetter(2));

		int num = 250;

		StringBuilder sBuilder = new StringBuilder();
		while (num / 27 > 0) {
			sBuilder.append(getLetter(num / 27 - 1));
			num -= (num / 27) * 26;
		}

		sBuilder.append(getLetter(num % 27));

		System.out.println(sBuilder.toString());
	}

	private static Character getLetter(int index) {
		return (char) ('A' + index);
	}

}
