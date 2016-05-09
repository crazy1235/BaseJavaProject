package com.jacksen.java.leetcode;

/**
 * 258. Add Digits
 * 
 * @author jacksen
 * @date 2016年5月9日10:14:31
 * 
 */
public class AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits3(10));
	}

	/**
	 * 递归 <br />
	 * 2ms
	 * 
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
		if (num >= 10) {
			return addDigits(num / 10 + num % 10);
		} else {
			return num;
		}
	}

	/**
	 * 2ms
	 * 
	 * @param num
	 * @return
	 */
	public static int addDigits2(int num) {
		return (num - 1) % 9 + 1;
	}

	/**
	 * 时间复杂度 o(1) <br />
	 * 2ms
	 * 
	 * @param num
	 * @return
	 */
	public static int addDigits3(int num) {
		if (num == 0) {
			return 0;
		}
		if (num % 9 == 0) {
			return 9;
		} else {
			return num % 9;
		}
	}
}
