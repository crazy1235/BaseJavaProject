package com.jacksen.java.leetcode;

/**
 * 283. Move Zeroes
 * 
 * @author jacksen
 * 
 */
public class MoveZeroes {
	public static void main(String[] args) {
		moveZeroes(new int[] { 0, 2, 1, 0, 3, 12 });
	}

	/**
	 * 时间复杂度o(n + n²)
	 * 
	 * @author jacksen
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
		int zeroNum = 0;
		for (int i : nums) {
			if (0 == i) {
				zeroNum++;
			}
		}
		if (zeroNum == 0) {
			return;
		}
		for (int i = 0; i < nums.length;) {
			if (nums[i] == 0) {
				int j = i;
				for (; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[j] = 0;
				zeroNum--;
				if (zeroNum == 0) {
					break;
				}
			} else {
				i++;
			}
		}

		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 变种冒泡做法 --- 时间复杂度o(n²)
	 * 
	 * @author jacksen
	 * @param nums
	 */
	public static void moveZeroes2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] != 0) {
					nums[i] = nums[i] + nums[j];
					nums[j] = nums[i] - nums[j];
					nums[i] = nums[i] - nums[j];
					break;
				}
			}
		}
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	/**
	 * two points
	 * 
	 * 时间复杂度o(n)
	 * 
	 * @author others
	 * 
	 * @param nums
	 */
	public static void moveZeroes3(int[] nums) {
		int first = 0;
		int second = 1;
		int temp;
		while (second < nums.length) {
			if (nums[first] != 0) {
				first++;
			} else if (nums[second] != 0) {
				temp = nums[second];
				nums[second] = nums[first];
				nums[first] = temp;
				first++;
			}
			second++;
		}
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 时间复杂度o(n)
	 * 
	 * @author others
	 * @param nums
	 */
	public static void moveZeroes4(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			}
			if (count != 0 && nums[i] != 0) {
				nums[i - count] = nums[i];
				nums[i] = 0;
			}
		}
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}
