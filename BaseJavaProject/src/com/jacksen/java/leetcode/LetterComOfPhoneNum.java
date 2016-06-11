package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author jacksen
 * 
 */
public class LetterComOfPhoneNum {
	public static void main(String[] args) {
		LetterComOfPhoneNum test = new LetterComOfPhoneNum();
		List<String> list = test.letterCombinations("23");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * 1ms <br />
	 * beats 46.92% of java submissions.
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if ("".equals(digits)) {
			return list;
		}
		recursiveSearch(digits, new StringBuilder(), 0, list);
		// recursiveSearch2(digits, "", 0, list);
		return list;
	}

	/**
	 * 递归方法
	 * 
	 * @param digits
	 * @param sb
	 * @param index
	 */
	private void recursiveSearch(String digits, StringBuilder sb, int index,
			List<String> list) {
		if (index == digits.length()) {
			list.add(sb.toString());
		} else {
			String temp = getMapping(digits.charAt(index));
			for (int i = 0; i < temp.length(); i++) {
				recursiveSearch(digits, sb.append(temp.charAt(i)), index + 1,
						list);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private void recursiveSearch2(String digits, String sb, int index,
			List<String> list) {
		if (index == digits.length()) {
			list.add(sb);
		} else {
			String temp = getMapping(digits.charAt(index));
			for (int i = 0; i < temp.length(); i++) {
				recursiveSearch2(digits, sb + temp.charAt(i), index + 1, list);
			}
		}
	}

	/**
	 * 获取数字对应的字符串
	 * 
	 * @param c
	 * @return
	 */
	private String getMapping(char c) {
		switch (c) {
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		default:
			return "";
		}
	}

	/**
	 * 循环方法
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations2(String digits) {

		char[][] c = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
				{ 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
				{ 'w', 'x', 'y', 'z' } };

		List<String> list = new ArrayList<>();
		if ("".equals(digits)) {
			return list;
		}

		int[] answer = new int[digits.length()];
		char[] temp = new char[digits.length()];
		while (true) {
			for (int i = 0; i < digits.length(); i++) {
				temp[i] = c[digits.charAt(i) - '0'][answer[i]];
			}
			list.add(new String(temp));

			int k = digits.length() - 1;

			while (k >= 0) {
				if (answer[k] < c[digits.charAt(k) - '0'].length - 1) {
					answer[k]++;
					break;
				} else {
					answer[k] = 0;
					k--;
				}
			}

			if (k < 0) {// 跳出while条件
				break;
			}
		}

		return list;
	}
}
