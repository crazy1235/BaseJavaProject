package com.jacksen.java.test;

public class Test1 {
	public static void main(String[] args) {
		System.out.println((65659 >> 16) - 1);
		System.out.println((1 << 16) + 123);
		System.out.println(65659 & 0xffff);
		System.out.println(Integer.toHexString(10));

		//
		System.out.println(0xff0085ec);
		System.out.println(0xff000000);
		System.out.println(1 << 24);
		System.out.println(0x00ffffff);
		System.out.println(0x00ffffff & 0xff0085ec);
		System.out.println(0x0085ec);

		int a = (0x00ffffff & 0xff0085ec) + (-16777216);
		System.out.println(Integer.toHexString(a));

		a = (0x00ffffff & 0xff0085ec) + (-402653184);
		System.out.println(Integer.toHexString(a));

		a = (0x00ffffff & 0xff0085ec) + (-620756992);
		System.out.println(Integer.toHexString(a));

		a = (0x00ffffff & 0xff0085ec) + (-2013265920);
		System.out.println(Integer.toHexString(a));

		a = (0x00ffffff & 0xff0085ec) + (2130706432);
		System.out.println(Integer.toHexString(a));
	}

}
