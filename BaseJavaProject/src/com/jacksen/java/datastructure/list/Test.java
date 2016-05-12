package com.jacksen.java.datastructure.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		// List<String> list = new LinkedList()<>();

		// ArrayList<E>
		// LinkedList<String> list = new LinkedList<>();
		// list.removeFirst()
		// System.out.println((null).equals(null));

		// testArrayList();

		// testSingleLinkedList();

		testStaticList();

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

		linkedList.addFirst(666);
		linkedList.addLast(999);

		// linkedList.clear();
		// linkedList.set(6, 222);
		linkedList.add(6, 567);

		// int first = linkedList.removeFirst();
		// System.out.println("first item is : " + first);
		//
		// int last = linkedList.removeLast();
		// System.out.println("last item is : " + last);
		//
		// int ele = linkedList.remove(3);
		// System.out.println("the removed node is : " + ele);

		System.out.println(linkedList.remove(new Integer(1203)));

		for (int i = 0; i < linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}

		System.out.println(linkedList.getIndex(111));
	}

	private static void testStaticList() {
		StaticList<String> list = new StaticList<>();
		// System.out.println(list.isEmpty());

		list.add("abc");
		list.add("456");

//		list.add("xxx");
//		list.set(1, "4567");

		list.addFirst("sss");
		
		list.addLast("lll");
		list.addFirst("first");
		
		list.addLast("end");
//		list.removeLast();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
