package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix <br />
 * 
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * @author jacksen
 * 
 */
public class SpiralMatrix {
	public static void main(String[] args) {

		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		// int[][] matrix = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 },
		// { 13, 14, 15 } };

		// int[][] matrix = { { 2, 3 } };

		// System.out.println(matrix.length);

		List<Integer> result = spiralOrder2(matrix);

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}

	}

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int m = matrix.length;// rows
		if (m == 0) {
			return result;
		}
		int n = matrix[0].length;// columns
		int topOffset = 0;// 表示从左向右遍历行的次数
		int rightOffset = 0;// 表示从上向下遍历列的次数
		int bottomOffset = 0;// 表示从右向左遍历行的次数
		int leftOffset = 0;// 表示从下向上遍历列的次数
		int i = 0;
		while (true) {
			// top
			for (i = leftOffset; i < n - rightOffset; i++) {
				result.add(matrix[topOffset][i]);
			}
			topOffset++;
			if (topOffset + bottomOffset == m) {
				break;
			}
			// right
			for (i = topOffset; i < m - bottomOffset; i++) {
				result.add(matrix[i][n - 1 - rightOffset]);
			}
			rightOffset++;
			if (leftOffset + rightOffset == n) {
				break;
			}
			// bottom
			for (i = n - 1 - rightOffset; i >= leftOffset; i--) {
				result.add(matrix[m - 1 - bottomOffset][i]);
			}
			bottomOffset++;
			if (topOffset + bottomOffset == m) {
				break;
			}
			// left
			for (i = m - 1 - bottomOffset; i >= topOffset; i--) {
				result.add(matrix[i][leftOffset]);
			}
			leftOffset++;
			if (leftOffset + rightOffset == n) {
				break;
			}
		}
		return result;
	}

	/**
	 * 方二
	 * 
	 * @param matrix
	 * @return
	 */
	public static List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		int i;
		while (true) {
			if (top > bottom) {
				break;
			}
			// top
			for (i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			top++;

			if (left > right) {
				break;
			}

			// right
			for (i = top; i <= bottom; i++) {
				list.add(matrix[i][right]);
			}
			right--;

			if (top > bottom) {
				break;
			}

			// bottom
			for (i = right; i >= left; i--) {
				list.add(matrix[bottom][i]);
			}
			bottom--;

			if (left > right) {
				break;
			}

			// left
			for (i = bottom; i >= top; i--) {
				list.add(matrix[i][left]);
			}
			left++;

		}

		return list;
	}
}
