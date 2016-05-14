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

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		// { 13, 14, 15, 16 } };

		// int[][] matrix = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 },
		// { 13, 14, 15 } };

		// System.out.println(matrix.length);

		List<Integer> result = spiralOrder(matrix);

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
		int top = 0;
		int right = 0;
		int bottom = 0;
		int left = 0;
		while (true) {
			// top
			for (int i = left; i < n - right; i++) {
				result.add(matrix[top][i]);
			}
			top++;
			if (top + bottom == m) {
				break;
			}
			// right
			for (int i = top; i < m - bottom; i++) {
				result.add(matrix[i][n - 1 - right]);
			}
			right++;
			if (left + right == n) {
				break;
			}
			// bottom
			for (int i = n - 1 - right; i >= left; i--) {
				result.add(matrix[m - 1 - bottom][i]);
			}
			bottom++;
			if (top + bottom == m) {
				break;
			}
			// left
			for (int i = m - 1 - bottom; i >= top; i--) {
				result.add(matrix[i][left]);
			}
			left++;
			if (left + right == n) {
				break;
			}
		}
		return result;
	}
}
