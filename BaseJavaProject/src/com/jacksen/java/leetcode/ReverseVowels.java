package com.jacksen.java.leetcode;

/**
 * ·´×ªÔªÒô×ÖÄ¸
 * 
 * @author jacksen
 * 
 */
public class ReverseVowels {
	public static void main(String[] args) {
		System.out.println(reverseVowels("aA"));
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static boolean checkVowel(char c) {
		if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c
				|| 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseVowels(String s) {
		char[] ch = s.toCharArray();
		int start = 0;
		int end = ch.length - 1;
		char temp;
		while (start < end) {
			if (checkVowel(ch[start]) && checkVowel(ch[end])) {
				temp = ch[end];
				ch[end] = ch[start];
				ch[start] = temp;
				start++;
				end--;
			} else {
				if (!checkVowel(ch[start])) {
					start++;
				}
				if (!checkVowel(ch[end])) {
					end--;
				}
			}
		}
		return new String(ch);
	}

}
