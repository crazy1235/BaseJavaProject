package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * @author Admin
 * 
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("DCXXI"));
	}

	public int romanToInt(String s) {
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		int result = map(s.charAt(length - 1));
		for (int i = length - 2; i >= 0; i--) {
			if (map(s.charAt(i)) >= map(s.charAt(i + 1))) { // +
				result += map(s.charAt(i));
			} else {
				result -= map(s.charAt(i));
			}
		}
		return result;
	}

	public int map(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
