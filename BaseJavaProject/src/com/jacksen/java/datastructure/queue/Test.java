package com.jacksen.java.datastructure.queue;

/**
 * 
 * @author jacksen
 * @date 2016-5-13 下午6:48:11
 */
public class Test {
	public static void main(String[] args) {
		// testArrayQueue();

//		testCirularQueue();

		// System.out.println(4>>1);

		testLinkedQueue();
	}

	private static void testLinkedQueue() {
		LinkedQueue<String> queue = new LinkedQueue<>();
		queue.add("123");
		queue.add("234");
		queue.add("456");
		
		
		System.out.println(queue.peek());
		System.out.println(queue.length());
		
		System.out.println(queue.poll());
		System.out.println(queue.length());
	}

	private static void testCirularQueue() {
		CirularQueue<String> queue = new CirularQueue<>();
		queue.add("000");
		queue.add("111");
		queue.add("222");

		System.out.println(queue.poll());
		// System.out.println(queue.length());
		queue.add("333");
		queue.add("444");

		System.out.println(queue.length());
		System.out.println(queue.peek());
	}

	private static void testArrayQueue() {
		ArrayQueue<String> queue = new ArrayQueue<>();
		queue.add("22");
		queue.add("33");
		queue.add("44");

		System.out.println(queue.peek());
		System.out.println(queue.length());

		System.out.println(queue.poll());
		System.out.println(queue.isEmpty());
	}
}
