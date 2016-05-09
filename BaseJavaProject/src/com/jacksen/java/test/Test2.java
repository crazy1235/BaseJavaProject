package com.jacksen.java.test;

public class Test2 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		printList(node1);

		
		System.out.println();
		node3.next = null;
		printList(node1);

	}

	private static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}
}
