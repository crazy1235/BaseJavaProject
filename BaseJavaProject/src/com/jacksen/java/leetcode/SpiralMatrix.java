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
		int topOffset = 0;
		int rightOffset = 0;
		int bottomOffset = 0;
		int leftOffset = 0;
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
}
