package com.jacksen.java.datastructure.list;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// List<String> list = new LinkedList()<>();

		ArrayList<String> list = new ArrayList<>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("000");
		
		String[] arr = new String[6];

		arr = list.toArray(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		// LinkedList<String> list = new LinkedList<>();
		// list.removeFirst()
		// System.out.println((null).equals(null));

		// testArrayList();

		// testSingleLinkedList();

		// testStaticList();

		// testLinkedLinearList();

		// testSingleCyclicLinkedList();
	}

	private static void testSingleCyclicLinkedList() {
		SingleCyclicLinkedList<String> list = new SingleCyclicLinkedList<>();
		list.add("111");
		list.add("222");
		list.addFirst("000");
		list.addLast("999");

		System.out.println("old ele is : " + list.set(3, list.get(3) + "!!"));

		// list.clear();

		// System.out.println(list.getIndex("222"));

		list.add(4, "123");

		// list.removeFirst();

		// list.removeLast();

		list.remove("000");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void testArrayList() {
		LinearList<String> arrayList = new ArrayLinearList<>();
		arrayList.add("123");
		arrayList.add("345");
		arrayList.add("345");
		arrayList.add("345");
		arrayList.add("345");
		arrayList.add("345");
		arrayList.add("345");

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}

	private static void testSingleLinkedList() {
		SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
		linkedList.add(123);
		linkedList.add(555);
		linkedList.add(111);
		linkedList.add(789);
		//
		// linkedList.addFirst(666);
		// linkedList.addLast(999);

		// linkedList.clear();
		// linkedList.set(6, 222);
		linkedList.add(1, 567);

		// int first = linkedList.removeFirst();
		// System.out.println("first item is : " + first);
		//
		// int last = linkedList.removeLast();
		// System.out.println("last item is : " + last);
		//
		// int ele = linkedList.remove(3);
		// System.out.println("the removed node is : " + ele);

		// System.out.println(linkedList.remove(new Integer(1203)));

		for (int i = 0; i < linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}

		// System.out.println(linkedList.getIndex(111));
	}

	private static void testStaticList() {
		StaticList<String> list = new StaticList<>();
		// System.out.println(list.isEmpty());

		list.add("abc");
		list.add("456");
		list.add("999");
		// list.set(1, "4567");
		//
		// list.addFirst("sss");
		//
		// list.addLast("lll");
		// list.addFirst("first");
		//
		// list.addLast("end");
		// list.removeLast();

		// System.out.println("the index of xxx is : " + list.getIndex("xxx"));

		// list.add(1, "10000");

		// list.remove(1);
		// list.removeFirst();
		// list.removeLast();

		System.out.println(list.remove("abc"));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// list.clear();
		// System.out.println("list.isEmpty() : " + list.isEmpty());

	}

	private static void testLinkedLinearList() {
		LinkedLinearList<String> list = new LinkedLinearList<>();
		list.add("111");
		list.add("222");
		list.addFirst("000");
		list.addLast("999");

		list.add(3, "456");

		System.out.println("index : " + list.getIndex("456"));

		list.set(3, list.get(3) + "abc");

		// System.out.println("old first is : " + list.removeFirst());

		// System.out.println("old last is : " + list.removeLast());

		System.out.println("the removed ele is : " + list.remove(2));

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
