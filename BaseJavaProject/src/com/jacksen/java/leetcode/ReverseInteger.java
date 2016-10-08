package com.jacksen.java.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		int result = new ReverseInteger().reverse(1912164654);
		System.out.println(result);

		System.out.println(1234567899 * 10);
	}

	public int reverse(int x) {

		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}

		return (int) result;
	}

}
