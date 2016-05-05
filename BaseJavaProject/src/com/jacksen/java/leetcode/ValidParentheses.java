package com.jacksen.java.leetcode;

import java.util.Stack;

/**
 * 验证括号匹配
 * 
 * @author jacksen
 * 
 */
public class ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("(("));
	}

	/**
	 * 获取匹配的括号
	 * 
	 * @param c
	 * @return
	 */
	public static char getPartner(char c) {
		if (')' == c) {
			return '(';
		} else if ('}' == c) {
			return '{';
		} else if (']' == c) {
			return '[';
		}
		return c;
	}

	/**
	 * 使用stack来判断
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		char[] ch = s.toCharArray();
		if (ch.length % 2 != 0) {
			return false;
		}
		char c;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < ch.length; i++) {
			if (stack.size() == 0) {
				stack.push(ch[i]);
			} else {
				c = stack.peek();
				if (c == ch[i]) {
					stack.push(ch[i]);
					continue;
				}
				if (c == getPartner(ch[i])) {
					stack.pop();
				} else {
					stack.push(ch[i]);
				}
			}
		}
		return stack.empty();
	}
}
