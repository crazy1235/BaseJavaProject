package com.jacksen.java.algorithm;

/**
 * 求猫扑素数
 * @author jacksen
 * @date 2017-9-5 下午3:57:14
 */
public class MopPrime {

	public static void main(String[] args) {

		// System.out.println(Math.sqrt(17));

		/*
		 * int x = 100; for (int i = 1; i <= x; i++) { if (isPrime(i)) {
		 * System.out.print(i + " "); } }
		 */

		int y = 233333;
		if (isMopPrime(y)) {
			if (isPrime(y)) {
				System.out.println("true");
			}
		}

	}

	/**
	 * 判断是否为素数
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isPrime(int a) {
		if (a < 2) {
			return false;
		} else {
			for (int i = 2; i < Math.sqrt(a); i++) {
				if (a % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isMopPrime(int a) {
		if (a < 10) {
			return a == 2;
		} else {
			return (a % 10 == 3) && isMopPrime(a / 10);
		}
	}
}
