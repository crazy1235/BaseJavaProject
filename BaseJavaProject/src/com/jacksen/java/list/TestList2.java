package com.jacksen.java.list;

import java.util.ArrayList;
import java.util.List;

public class TestList2 {

	private List<String> list = new ArrayList<>();

	public TestList2(List<String> data) {
		System.out.println(list.hashCode() + "---" + data.hashCode());
		this.list = data;
		System.out.println(list.hashCode() + "---" + data.hashCode());
	}
	
	public void putCode(){
		System.out.println("TestList2 --" + list.hashCode() + "---" +  list.toString());
	}

	public void setData(List<String> data) {
		System.out.println("TestList2 --" + list.hashCode() + "---" +  list.toString() + "---" + data.hashCode() + "---" + data.toString());

		list.clear();
		System.out.println("TestList2 --" + list.hashCode() + "---" +  list.toString() + "---" + data.hashCode() + "---" + data.toString());
		list.addAll(data);

		System.out.println("TestList2 --" + list.hashCode() + "---" +  list.toString() + "---" + data.hashCode() + "---" + data.toString());

		System.out.println(list);
	}
}
