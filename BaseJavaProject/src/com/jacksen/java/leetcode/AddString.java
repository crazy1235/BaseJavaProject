package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/add-strings/
 * 
 * @author Admin
 * 
 */
public class AddString {

	public static void main(String[] args) {
		AddString addString = new AddString();

		String result = addString.addStrings("602", "753");
		System.out.println(result);
	}

	/**
	 * 转成两个char数组，从后向前相加，然后在反转。 <br />
	 * run time : 35ms
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings(String num1, String num2) {
		StringBuffer sb = new StringBuffer();

		int l1 = num1.length();
		int l2 = num2.length();

		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();

		int carry = 0; // 商
		for (int i = 0; i < l1 || i < l2; i++) {
			int a1 = i < l1 ? c1[l1 - i - 1] - 48 : 0;
			int a2 = i < l2 ? c2[l2 - i - 1] - 48 : 0;
			int sum = a1 + a2 + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings2(String num1, String num2) {
		StringBuffer buffer = new StringBuffer();
		int l1 = num1.length();
		int l2 = num2.length();

		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();

		int value1 = 0;
		int value2 = 0;

		int sum = 0;

		int index = 0;
		while (index < l1 && index < l2) {
			sum = c1[index] - 48 + c2[index] - 48;
			value1 = sum / 10;
			value2 = sum % 10;
		}

		return "";
	}

}
