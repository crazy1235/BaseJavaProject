package com.jacksen.java.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
		int result = solution.lengthOfLongestSubstring("asdbasd");
		System.out.println(result);

	}

	public int lengthOfLongestSubstring(String s) {
		char[] chs = s.toCharArray();
		int length = chs.length;

		int result = 0;
		
		int first = 0;
		int second = 1;

		while (second < length) {
			/*if (chs[]) {
				
			}*/
		}

		return result;
	}

}
