package com.jacksen.java.algorithm;

/**
 * 从1到N，求1的个数
 * 
 * @author jacksen
 * @date 2017-9-5 下午3:59:23
 */
public class FromOneToN {

	/**
	 * 给定一个十进制正整数N，写下从1开始，到N的所有整数，然后数一下其中出现的所有“1”的个数。 例如： N=
	 * 2，写下1，2。这样只出现了1个“1”。 N= 12，我们会写下1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
	 * 12。这样，1的个数是5。
	 */
	public static void main(String[] args) {

		int x = 21;

		int result = 0;
		for (int i = 1; i <= x; i++) {
			result += calculateOne(i);
		}

		System.out.println(result);
	}

	public static int calculateOne(int a) {
		if (a < 10) {
			if (a == 1) {
				return 1;
			}
			return 0;
		}
		return calculateOne(a / 10) + calculateOne(a % 10);
	}

}
