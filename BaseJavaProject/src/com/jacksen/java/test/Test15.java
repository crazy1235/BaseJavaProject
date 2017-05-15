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
	}
}
