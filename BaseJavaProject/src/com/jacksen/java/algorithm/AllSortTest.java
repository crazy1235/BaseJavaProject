package com.jacksen.java.algorithm;

public class AllSortTest {

	public static void main(String[] args) {
		int[] origin = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
		
		quickSort(origin, 0, origin.length - 1);
	}

	private static void quickSort(int[] origin, int left, int right){
		if (left >= right) {
			return;
		}
		int index = quickSortCore(origin, left, right);
		quickSort(origin, left, index - 1);
		quickSort(origin, index + 1, right);
	}
	
	private static int quickSortCore(int[] origin, int left, int right) {
		int key = origin[left];
		while (left < right) {
			while (origin[right] > key && left < right) {
				right--;
			}
			origin[left] = origin[right];
			while (origin[left] <= key && left < right) {
				left++;
			}
			origin[right] = origin[left];

		}
		origin[right] = key;
		
		printArray(origin);
		
		return right;
	}

	private static void printArray(int[] origin) {
		for (int i = 0; i < origin.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
