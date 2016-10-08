package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * @author Admin
 * 
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(new IntegerToRoman().intToRoman(90));
	}

	public String intToRoman(int num) {
		String result = "";

		int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
				900, 1000 };
		String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
				"XC", "C", "CD", "D", "CM", "M" };

		int i = ints.length - 1;
		while (num != 0) {
			if (num >= ints[i]) {
				result += romans[i];
				num -= ints[i];
			} else {
				i--;
			}
		}

		return result;
	}
	
	
}
