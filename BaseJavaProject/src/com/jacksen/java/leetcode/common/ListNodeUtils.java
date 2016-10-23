package com.jacksen.java.leetcode.common;

public class ListNodeUtils {

	/**
	 * 打印列表结点的值
	 * 
	 * @param head
	 */
	public static void printListNode(ListNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val + " ");
		while (head.next != null) {
			head = head.next;
			System.out.print(head.val + " ");
		}
	}

}
