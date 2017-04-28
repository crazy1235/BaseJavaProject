package com.jacksen.java.test;

import java.util.ArrayList;

public class Test11 {

	public static void main(String[] args) {
		meth("22");
		meth("111");
	}

	public static void meth(String str){
		ArrayList<String> list = new ArrayList<>();
		list.add(str);
		System.out.println(str + "--" + list.size());
	}
	
}
