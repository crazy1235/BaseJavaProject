package com.jacksen.java.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * @author jacksen
 * 
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = new int[] { 11, 2, 7, 6, 4, 15 };
		int target = 9;

		int[] result = twoSum3(nums, target);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 嵌套循环 <br />
	 * 注意nums中有可能出现负数 <br />
	 * 
	 * 时间复杂度是O(n²) <br />
	 * 空间复杂度是O(1)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		if (nums == null || nums.length == 0) {
			return result;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * 使用HashMap存储 <br />
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				if (i > map.get(target - nums[i])) {
					result[0] = map.get(target - nums[i]);
					result[1] = i;
				} else {
					result[0] = i;
					result[1] = map.get(target - nums[i]);
				}
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}

	/**
	 * 先排序，然后使用"两个指针"进行判断 <br />
	 * 该方法不适合该题目。适合返回正确数字组合的。该题目返回的是下标，故而不适合排序。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum3(int[] nums, int target) {
		int[] result = new int[2];

		if (nums == null || nums.length == 0) {
			return result;
		}

		//
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {// 从小到大排序
					nums[i] = nums[i] + nums[j];
					nums[j] = nums[i] - nums[j];
					nums[i] = nums[i] - nums[j];
				}
			}
		}

		//
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] < target) {
				start++;
			} else if (nums[start] + nums[end] > target) {
				end--;
			} else {
				result[0] = start;
				result[1] = end;
				break;
			}
		}
		return result;
	}
}
