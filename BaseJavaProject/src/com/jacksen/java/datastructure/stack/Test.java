package com.jacksen.java.datastructure.stack;

import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		/*
		 * Stack<String> stack = new Stack<>(); stack.push("123");
		 * stack.push("456"); stack.push("789");
		 * 
		 * stack.remove(1);
		 * 
		 * System.out.println(stack.size());
		 */

//		testArrayStack();
		
		testLinkedStack();
	}

	private static void testLinkedStack() {
		LinkedStack<String> stack = new LinkedStack<>();
		stack.push("222");
		stack.push("456");
		System.out.println(stack.empty());

		System.out.println(stack.peek());

		System.out.println(stack.size());

		System.out.println(stack.pop() + "---" + stack.size());
		
		stack.clear();
		
		System.out.println(stack.empty());
	}

	private static void testArrayStack() {
		ArrayStack<String> stack = new ArrayStack<>();
		stack.push("222");
		stack.push("456");
		System.out.println(stack.empty());

		System.out.println(stack.peek());

		System.out.println(stack.size());

		System.out.println(stack.pop() + "---" + stack.size());
		
		stack.clear();
		
		System.out.println(stack.empty());
	}
}
