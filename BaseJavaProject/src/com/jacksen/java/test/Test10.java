package com.jacksen.java.test;

public class Test10 {

	public static void main(String[] args) {

		int key = 2;
		System.out.println(getValue(key));
	}

	public static String getValue(int key) {
		switch (key) {
		case 1:
			return "a";
		case 2:
			return "b";
		case 3:
			return "c";
		default:
			return "";
		}
	}
}
