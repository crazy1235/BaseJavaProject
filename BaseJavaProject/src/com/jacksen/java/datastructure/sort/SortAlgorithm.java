package com.jacksen.java.datastructure.sort;

import java.util.Arrays;

/**
 * 各种排序
 * 
 * @author Admin
 * 
 */
public class SortAlgorithm {

	public static void main(String[] args) {

		int[] numbers = new int[] { 23, 34, 12, 3, 5, 56, 10 };

		SortUtil.printArray(numbers);

		// bubblingSort(numbers);
		// quickSort(numbers, 0, numbers.length - 1);

		// mergeSort(numbers, 0, numbers.length - 1);
		selectSort(numbers);

		SortUtil.printArray(numbers);
	}

	// 每一次循环都找出一个最大的或者最小的

	/**
	 * 冒泡排序
	 * 
	 * @param numbers
	 */
	private static void bubblingSort(int[] numbers) {
		int temp = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param numbers
	 */
	private static void quickSort(int[] numbers, int left, int right) {
		if (left < right) {
			int temp = quickSortTemp(numbers, left, right);
			quickSort(numbers, left, temp - 1);
			quickSort(numbers, temp + 1, right);
		}
	}

	private static int quickSortTemp(int[] numbers, int left, int right) {
		int temp = numbers[left];
		while (left < right) {
			while (left < right && numbers[right] > temp) {
				right--;
			}
			numbers[left++] = numbers[right]; // 比中轴小的移动到左边
			while (left < right && numbers[left] < temp) {
				left++;
			}
			numbers[right--] = numbers[left];
		}
		numbers[left] = temp;
		return left;
	}

	/**
	 * 归并排序
	 * 
	 * @param numbers
	 */
	private static void mergeSort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			mergeSort(nums, low, mid);
			// 右边
			mergeSort(nums, mid + 1, high);
			// 左右归并
			mergeTemp(nums, low, mid, high);
		}
	}

	private static void mergeTemp(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = nums[j++];
		}

		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}

	}

	private static void selectSort(int[] nums) {
		int temp = 0;
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			k = i;
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[k]) {
					k = j;
				}
			}
			temp = nums[i];
			nums[i] = nums[k];
			nums[k] = temp;
		}
	}

	private void insertSort(int[] nums) {
		int temp = 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			temp = nums[i];

			for (j = i; j > 0 && temp < nums[j - 1]; j--) {
				nums[j] = nums[j - 1];
			}
			nums[j] = temp;
		}
	}

}
