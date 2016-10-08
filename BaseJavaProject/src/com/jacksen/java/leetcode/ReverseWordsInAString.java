package com.jacksen.java.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * @author jacksen
 * @date 2016-10-8 下午4:58:52
 */
public class ReverseWordsInAString {

	public static void main(String[] args) {
		ReverseWordsInAString inAString = new ReverseWordsInAString();
		String result = inAString.reverseWords("a  ");
		System.out.println(result);

		System.out.println(inAString.reverseWords4(" a 1"));
	}

	/**
	 * Run Time : 57ms
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if (s.length() == 0) {
			return s;
		}

		String result = "";
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) != ' ') {
				sb.append(s.charAt(i));
			} else if (sb.length() > 0) {
				result = sb.toString() + " " + result;
				sb.setLength(0);
			}
			i++;
		}
		result = sb.toString() + " " + result;
		return result.trim();
	}

	/**
	 * Run Time 73ms
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords2(String s) {
		String result = "";
		String[] strs = s.split("\\s+");
		for (int i = strs.length - 1; i >= 0; i--) {
			result += strs[i] + " ";
		}

		return result.trim();
	}

	/**
	 * https://discuss.leetcode.com/topic/54343/java-99-86-runtime
	 * 
	 * 未完成
	 */
	public String reverseWords3(String s) {
		String result = "";
		String[] strs = s.split("\\s+");
		for (int i = strs.length - 1; i >= 0; i--) {
			result += strs[i] + " ";
		}

		return result.trim();
	}

	/**
	 * RunTime : 12ms
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords4(String s) {
		String[] strs = s.trim().split(" +");
		Collections.reverse(Arrays.asList(strs));
		return String.join(" ", strs);
	}
}
