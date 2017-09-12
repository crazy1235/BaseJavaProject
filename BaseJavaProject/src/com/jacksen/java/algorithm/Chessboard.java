package com.jacksen.java.algorithm;

/**
 * 一个四乘四的表格，一共有4个棋子，每个格子放一个，输出所有的排列
 * 
 * @author Admin
 * 
 */
public class Chessboard {

	public static void main(String[] args) {
		int ori[] = new int[16];

		int count = 0;

		int a = 0, b = 1, c = 2, d = 3;
		while (a <= 12) {
			ori[a] = ori[b] = ori[c] = ori[d] = 1;
			printArr(ori);
			count++;
			ori[a] = ori[b] = ori[c] = ori[d] = 0;

			if (d < 15) {
				d++;
				continue;
			} else if (c < 14) {
				c++;
				d = c + 1;
				continue;
			} else if (b < 13) {
				b++;
				c = b + 1;
				d = c + 1;
			} else if (a < 12) {
				a++;
			} else {
				break;
			}
		}

		System.out.println(count);
	}

	private static void printArr(int[] ori) {
		for (int i : ori) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
