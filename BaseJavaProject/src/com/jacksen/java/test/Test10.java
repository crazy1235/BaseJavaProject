package com.jacksen.java.test;

import java.io.File;

public class Test10 {

	public static void main(String[] args) {

		int key = 2;
		System.out.println(getValue(key));
		
		System.out.println(10f/9f);
		
		File file= new File("");
		String path = file.getPath();
		System.out.println(path);
		file = new File(file, "1234");
		path = file.getPath();
		System.out.println(path);
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
