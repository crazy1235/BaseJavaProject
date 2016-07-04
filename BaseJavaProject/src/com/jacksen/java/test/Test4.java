package com.jacksen.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test4 {
	public static void main(String[] args) {
		System.out.println(String.valueOf("24.1%"));

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		/*
		 * for (int i = 0; i < list.size(); i++) { if (i == 4) { list.remove(4);
		 * } System.out.println(list.get(i)); }
		 */

		/*
		 * for (int i = list.size() - 1; i >= 0; i--) { if (i == 4) {
		 * list.remove(4); } System.out.println(list.get(i)); }
		 */

		System.out.println((Set) null);

		int[] arr = new int[] { 4, 0, 1, 3, 6, 8 };
		int[] index = new int[] { 2, 5, 4, 1, 2, 1, 2, 3, 0, 2, 3 };
		String tel = "";
		for (int i : index) {
			tel += arr[i];
		}

		System.out.println(tel);

	}
}
