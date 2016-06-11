package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * @author jacksen
 * 
 */
public class MaximumSubarray {
	public static void main(String[] args) {

		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		MaximumSubarray mSubarray = new MaximumSubarray();

		System.out.println(mSubarray.maxSubArray4(nums));

	}

	/**
	 * 时间复杂度是O(n²)
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	/**
	 * 动态规划<br />
	 * 2ms <br />
	 * beats 15.95% of java submissions.
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		int length = nums.length;
		int start = nums[length - 1];
		int all = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			start = nums[i] > start + nums[i] ? nums[i] : start + nums[i];
			all = start > all ? start : all;
		}
		return all;
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray3(int[] nums) {
		int length = nums.length;
		int start = nums[0];
		int all = nums[0];
		for (int i = 1; i < length; i++) {
			start = max(nums[i], start + nums[i]);
			all = max(start, all);
		}
		return all;
	}

	private int max(int x, int y) {
		return x > y ? x : y;
	}

	/**
	 * 1ms <br />
	 * beats 68.48% of java submissions.
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray4(int[] nums) {
		int length = nums.length;
		int start = nums[length - 1];
		int all = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			if (start < 0) {
				start = 0;
			}
			start += nums[i];
			if (start > all) {
				all = start;
			}
		}
		return all;
	}

}
