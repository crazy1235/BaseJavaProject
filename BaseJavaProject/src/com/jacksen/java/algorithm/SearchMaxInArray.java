package com.jacksen.java.algorithm;

/**
 * 一个数组先递增后递减，要求找到最大值
 * 
 * @author Admin
 * 
 */
public class SearchMaxInArray {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 5, 6, 5, 2, 1 };
		int result = findPeak(arr);
		System.out.println(result);
	}

	private static int findPeak(int arr[]) {
		if (arr == null || arr.length == 0) {
			throw new UnsupportedOperationException();
		}

		if (arr.length == 1) {
			return arr[0];
		}

		int left = 0;
		int right = arr.length - 1;
		int mid = (right - left) / 2;

		if (mid == 0) {
			if (arr[mid] <= arr[mid + 1]) {
				return arr[mid + 1];
			} else {
				return arr[mid];
			}
		}

		/*
		 * while(){
		 * 
		 * }
		 */

		return 0;
	}

	/*private static int findPeak2(int arr[], int left, int right) {
		if (left == right) {
			return arr[left];
		}
		int mid = left + (right - left) / 2;
		if ((mid == 0 || arr[mid-1] <= arr[mid] )&& (mid == right) ) {
		}
	}*/
}
