package com.jacksen.java.leetcode;

import java.util.Stack;

/**
 * �ַ�����ת
 * 
 * @author jacksen
 * 
 */
public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseString7("yansen"));
	}

	/**
	 * ʱ�临�Ӷ� o(n)
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString(String s) {
		String result = "";
		char[] ch = s.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			result += ch[i];
		}
		return result;
	}

	/**
	 * ʱ�临�Ӷ� o(n)
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString2(String s) {
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}

	/**
	 * ʹ��StringBuffer���е�reverse����
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString3(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	/**
	 * ʱ�临�Ӷ�o(n/2)
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString4(String s) {
		char[] ch = s.toCharArray();
		int halfLength = s.length() / 2;
		char temp;
		for (int i = 0; i < halfLength; i++) {
			temp = ch[s.length() - 1 - i];
			ch[s.length() - 1 - i] = ch[i];
			ch[i] = temp;
		}
		return new String(ch);
	}

	/**
	 * �������
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString5(String s) {
		char[] ch = s.toCharArray();
		int start = 0;
		int end = ch.length - 1;
		while (start < end) {
			ch[start] = (char) (ch[start] ^ ch[end]);
			ch[end] = (char) (ch[start] ^ ch[end]);
			ch[start] = (char) (ch[start] ^ ch[end]);
			start++;
			end--;
		}
		return new String(ch);
	}

	/**
	 * ͨ����ջ�ͳ�ջ��˼������
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString6(String s) {
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		String result = "";
		for (int i = 0; i < ch.length; i++) {
			stack.push(ch[i]);
		}
		for (int i = 0; i < ch.length; i++) {
			result += stack.pop();
		}
		return result;
	}

	/**
	 * ͨ���ݹ�����
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString7(String s) {
		int length = s.length();
		if (length <= 1) {
			return s;
		}
		String leftStr = s.substring(0, length / 2);
		String rightStr = s.substring(length / 2, length);
		return reverseString7(rightStr) + reverseString7(leftStr);
	}
}
