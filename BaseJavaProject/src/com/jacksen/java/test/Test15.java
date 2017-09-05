package com.jacksen.java.test;

public class Test15 {
	public static void main(String[] args) {
		int features = 0;
		features |= 1 << 0;
		System.out.println(features);

		System.out.println(1 << 0);

		System.out.println(1 << 11);

		System.out.println(1 & (1 << 11));

		System.out.println((1 & ((1 << 3) | (1 << 4))));

		System.out.println((1 & ((1 << 2) | (1 << 5))));

		System.out.println(1 & (1 << 7));

		System.out.println(1 & (1 << 1));

		System.out.println(1 & (1 << 10));

		System.out.println(0x01000000);

		System.out.println(Integer.toBinaryString(0x01000000));
		System.out.println(Integer.toBinaryString(16777216));

		System.out.println(0xff000000);

		System.out.println(1 << 2);

		System.out.println(0x3 << 30);

		System.out.println(0xff000000 >> 16);

		System.out.println(0xff000000);

		System.out.println("---------------------");

		long a = 1497433752039L;
		long b = 1497433620738L;
		float c = 10000f;
		System.out.println(b + c);

		String x = new String("123");
		change(x);
		System.out.println(x);
	}

	public static void change(String x) {
		x = "abc";
	}
}
