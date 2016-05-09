package com.jacksen.java.leetcode;

import java.util.HashSet;

/**
 * 202. Happy Number
 * 
 * @author jacksen
 * @date 2016年5月9日11:20:44
 * 
 */
public class HappyNumber {

	public static void main(String[] args) {
		// System.out.println(12 / (int) 10.0);
		System.out.println(isHappy2(7));
	}

	/**
	 * 递归做法 <br />
	 * 循环计算位数平方和的算法有点繁杂。<br />
	 * 计算平方的时候使用Math.pow反而复杂了。<br />
	 * 有可能出现循环判断的情况，所以需要保存每个计算出来的和。故此方法不可取。
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		int len = String.valueOf(n).length();
		int temp = 0;
		if (n >= 10) {
			while (--len > 0) {
				temp += (int) (Math.pow(n / (int) (Math.pow(10, len)), 2));
				n = n % (int) (Math.pow(10, len));
			}
			temp += (int) (Math.pow(n, 2));
			return isHappy(temp);
		} else if (n == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isHappy2(int n) {
		HashSet<Integer> set = new HashSet<>();
		int sum;
		while (n != 1) {
			if (set.contains(n)) {
				return false;
			}
			set.add(n);

			//
			sum = 0;
			while (n != 0) {
				sum += (n % 10) * (n % 10);
				n /= 10;
			}
			n = sum;
		}
		return true;
	}
}
