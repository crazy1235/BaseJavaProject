package com.jacksen.java.list;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	private List<String> list = new ArrayList<String>();

	public static void main(String[] args) {

		List<String> list = new TestList().list;
		list.add("12");
		list.add("34");

		System.out.println("TestList --- " + list.hashCode());

		TestList2 list2 = new TestList2(list);
		
		list.clear();
		list.add("abc");
		
		System.out.println("TestList --- " + list.hashCode()  +" --- " + list.toString());
		
		list2.putCode();
		
//		list.clear();
		
		list2.setData(list);
	}

}
