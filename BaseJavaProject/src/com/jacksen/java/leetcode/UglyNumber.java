package com.jacksen.java.leetcode;

/**
 * 263. Ugly Number
 * 
 * @author jacksen
 * @date 2016年5月9日15:16:18
 * 
 */
public class UglyNumber {
	public static void main(String[] args) {

		System.out.println(isUgly3(14));

	}

	/**
	 * 2ms
	 * 
	 * @author jacksen
	 * @param num
	 * @return
	 */
	public static boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
			if (num / 2 == 1 || num / 3 == 1 || num / 5 == 1) {
				return true;
			}
			if (num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 递归调用 <br />
	 * 2ms
	 * 
	 * @author jacksen
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isUgly2(int num) {
		if (num <= 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		if (num % 2 == 0) {
			return isUgly2(num / 2);
		}
		if (num % 3 == 0) {
			return isUgly2(num / 3);
		}
		if (num % 5 == 0) {
			return isUgly2(num / 5);
		}
		return false;
	}

	// return num == 1;

	/**
	 * 3ms
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isUgly3(int num) {
		if (num <= 0) {
			return false;
		}
		int[] factors = new int[] { 2, 3, 5 };
		for (int i : factors) {
			while (num % i == 0) {
				num /= i;
			}
		}
		return num == 1;
	}

	/**
	 * @author http://www.jiuzhang.com/solutions/ugly-number/
	 * @param num
	 * @return
	 */
	public static boolean isUgly4(int num) {
		if (num <= 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}
}
