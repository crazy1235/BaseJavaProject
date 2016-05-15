package com.jacksen.java.leetcode;

/**
 * 59. Spiral Matrix II <br />
 * https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * @author jacksen
 * 
 */
public class SpiralMatrixII {
	public static void main(String[] args) {
		int n = 3;
		int[][] result = generateMatrix2(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * 0ms
	 * 
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];

		int top = 0;
		int right = 0;
		int bottom = 0;
		int left = 0;
		int index = 1;
		int i = 0;
		while (true) {
			// top
			for (i = left; i < n - right; i++) {
				result[top][i] = index++;
			}
			top++;
			if (top + bottom == n) {
				break;
			}
			// right
			for (i = top; i < n - bottom; i++) {
				result[i][n - 1 - right] = index++;
			}
			right++;
			if (left + right == n) {
				break;
			}
			// bottom
			for (i = n - 1 - right; i >= left; i--) {
				result[n - 1 - bottom][i] = index++;
			}
			bottom++;
			if (top + bottom == n) {
				break;
			}
			// left
			for (i = n - 1 - bottom; i >= top; i--) {
				result[i][left] = index++;
			}
			left++;
			if (left + right == n) {
				break;
			}
		}
		return result;
	}

	/**
	 * 由于是n * n的数组，所以只需要判断top+bottom 或者left+right即可。
	 * 
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix2(int n) {
		int[][] result = new int[n][n];

		int top = 0;
		int right = 0;
		int bottom = 0;
		int left = 0;
		int index = 1;
		
		while (top + bottom < n) {
			// top
			for (int i = left; i < n - right; i++) {
				result[top][i] = index++;
			}
			top++;
			// right
			for (int i = top; i < n - bottom; i++) {
				result[i][n - 1 - right] = index++;
			}
			right++;
			// bottom
			for (int i = n - 1 - right; i >= left; i--) {
				result[n - 1 - bottom][i] = index++;
			}
			bottom++;
			// left
			for (int i = n - 1 - bottom; i >= top; i--) {
				result[i][left] = index++;
			}
			left++;
		}

		return result;
	}

	/**
	 * 将i变量放到外边，不用每次for循环定义了
	 * 
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix3(int n) {
		int[][] result = new int[n][n];

		int topOffset = 0;
		int rightOffset = 0;
		int bottomOffset = 0;
		int leftOffset = 0;
		int index = 1;

		int i = 0;

		while (topOffset + bottomOffset < n) {
			// top
			for (i = leftOffset; i < n - rightOffset; i++) {
				result[topOffset][i] = index++;
			}
			topOffset++;
			// right
			for (i = topOffset; i < n - bottomOffset; i++) {
				result[i][n - 1 - rightOffset] = index++;
			}
			rightOffset++;
			// bottom
			for (i = n - 1 - rightOffset; i >= leftOffset; i--) {
				result[n - 1 - bottomOffset][i] = index++;
			}
			bottomOffset++;
			// left
			for (i = n - 1 - bottomOffset; i >= topOffset; i--) {
				result[i][leftOffset] = index++;
			}
			leftOffset++;
		}

		return result;
	}
}
