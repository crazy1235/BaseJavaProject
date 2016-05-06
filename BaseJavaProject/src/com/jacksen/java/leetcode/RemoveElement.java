package com.jacksen.java.leetcode;

/**
 * 27. Remove Element
 * 
 * @author jacksen
 * 
 */
public class RemoveElement {
	public static void main(String[] args) {
		// System.out.println(removeElement(new int[] { 3, 2, 2, 3 }, 3));

		int[] nums = new int[] { 1, 3, 2, 2, 3 };
		nums = new int[] { 1 };
		int length = removeElement2(nums, 1);
		for (int i = 0; i < length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	/**
	 * two pointers <br/>
	 * 时间复杂度 o(n) <br/>
	 * 空间复杂度o(1)
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}

	/**
	 * 该方法类似于 MoveZero 的moveZeroes3() <br/>
	 * 时间复杂度 o(2n) <br/>
	 * 控件复杂度o(3) <br/>
	 * 
	 * 该方法不好
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement2(int[] nums, int val) {
		int length = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				length++;
			}
		}
		if (length == 0) {
			return 0;
		}
		int first = 0;
		int second = 1;
		while (second < nums.length) {
			if (nums[first] != val) {
				first++;
			} else if (nums[second] != val) {
				nums[second] = nums[second] + nums[first];
				nums[first] = nums[second] - nums[first];
				nums[second] = nums[second] - nums[first];
				first++;
			}
			second++;
		}
		return length;
	}

	/**
	 * o(n)
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement3(int[] nums, int val) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			if (nums[start] == val) {
				if (nums[end] != val) {// swap
					nums[end] = nums[end] + nums[start];
					nums[start] = nums[end] - nums[start];
					nums[end] = nums[end] - nums[start];
					start++;
					end--;
				} else {
					end--;
				}
			} else {
				start++;
			}
		}
		return start;
	}

}
