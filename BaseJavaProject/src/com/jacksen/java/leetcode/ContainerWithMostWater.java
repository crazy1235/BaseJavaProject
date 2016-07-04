package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * @author jacksen
 * @date 2016-7-4 上午10:39:03
 */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		ContainerWithMostWater water = new ContainerWithMostWater();
		int[] height = { 1, 3, 2, 4, 6, 9, 0, 1 };
		int result = water.maxArea2(height);
		System.out.println(result);
	}

	/**
	 * 时间复杂度o(n²)
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea1(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int result = 0;
		int temp = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				temp = (j - i) * Math.min(height[i], height[j]);
				if (temp > result) {
					result = temp;
				}
			}
		}
		return result;
	}

	/**
	 * o(n)
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int left = 0;
		int right = height.length - 1;
		int result = 0;
		int temp = 0;

		while (left < right) {
			temp = (right - left) * Math.min(height[left], height[right]);
			result = Math.max(result, temp);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return result;
	}
}
