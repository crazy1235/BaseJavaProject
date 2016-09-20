package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * @author jacksen
 * @date 2016-9-20 下午7:17:35
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		String result = new ZigZagConversion().convert("abcdefghijklm", 4);
		System.out.println(result);
	}

	public String convert(String s, int numRows) {
		int length = s.length();
		if (length <= numRows || numRows == 1) {
			return s;
		}

		char[] chs = new char[length];

		int m = length / (2 * numRows - 2);
		int n = length % (2 * numRows - 2);

		int j = 0;
		int k = 0;
		for (int i = 0; i < numRows; i++) {

			if (i == 0) {
				k = m + (n > 0 ? 1 : 0);
			} else if (i == numRows - 1) {
				k = m + n / numRows;
			} else {
				k = 2 * m + (n / (i + 1) > 0 ? 1 : 0)
						+ (n / (2 * numRows - 2 - (i - 1)) > 0 ? 1 : 0);
			}

			int temp = 0;

			int other = 0;

			for (int l = 0; l < k; l++) {
				if (i == 0) {
					chs[j++] = s.charAt(i + (2 * numRows -2) * l);
				} else if (i == numRows - 1) {
					chs[j++] = s.charAt(i + (2 * numRows -2) * l);
				} else {
					if (temp < k) {
						if (temp % 2 == 0) {
							chs[j++] = s.charAt(other * (2 * numRows - 2) + i);
							
						} else {
							if ((other + 1) * (2 * numRows - 2) - i < length) {
								chs[j++] = s.charAt((other + 1) * (2 * numRows - 2) - i);
							}
							other++;
						}
						temp++;
					}

				}

			}

		}

		return new String(chs);
	}
}
