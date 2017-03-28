package com.jacksen.java.leetcode;

import java.util.Stack;

import com.jacksen.java.leetcode.common.ListNode;
import com.jacksen.java.leetcode.common.ListNodeUtils;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * <br />
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * <br />
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * <br />
 * return 1->4->3->2->5->NULL. <br />
 * 
 * @author jacksen
 * @date 2017-3-27 下午3:54:44
 */
public class ReverseLinkedListII {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(7);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode result = new ReverseLinkedListII()
				.reverseBetween2(node1, 1, 6);

		ListNodeUtils.printListNode(result);
	}

	/**
	 * 使用stack
	 * 
	 * Runtime : 1ms
	 * 
	 * beats 2.94% of java submissions
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m >= n) {
			return head;
		}

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		head = dummyNode;

		ListNode preNode = head; // pre node

		for (int i = 1; i < m; i++) {
			preNode = preNode.next;
		}

		// ----

		ListNode tempNode = preNode.next;

		Stack<ListNode> stack = new Stack<>();
		int i = 0;
		while (m + i <= n) {
			stack.push(tempNode);
			tempNode = tempNode.next;
			i++;
		}

		ListNode postNode = tempNode; // post node

		ListNode resultNode = stack.pop();
		tempNode = resultNode;

		while (!stack.isEmpty()) {
			tempNode.next = stack.pop();
			tempNode = tempNode.next;
		}

		//
		preNode.next = resultNode;
		tempNode.next = postNode;

		return dummyNode.next;
	}

	/**
	 * 通过迭代方式反转m-n的结点
	 * 
	 * Runtime : 0ms
	 * 
	 * beats 18.23% of java submissions
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if (head == null || head.next == null || m >= n) {
			return head;
		}

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		head = dummyNode;

		ListNode preNode = head; // pre node

		for (int i = 1; i < m; i++) {
			preNode = preNode.next;
		}

		// iteration

		ListNode nodeA = preNode.next;
		ListNode nodeB = preNode.next.next;
		ListNode nodeResult = nodeA;

		int i = 0;
		while (m + i < n) {
			nodeA.next = nodeB.next;
			nodeB.next = nodeResult;
			nodeResult = nodeB;
			nodeB = nodeA.next;
			i++;
		}

		//
		preNode.next = nodeResult;

		return dummyNode.next;
	}
	
	/**
	 * 方法二的优化方式
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween3(ListNode head, int m, int n) {
		if (head == null || head.next == null || m >= n) {
			return head;
		}

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		head = dummyNode;

		ListNode preNode = head; // pre node

		for (int i = 1; i < m; i++) {
			preNode = preNode.next;
		}

		ListNode nodeA = preNode.next;
		ListNode nodeB = preNode.next.next;

		for (int i = 0; i < n - m; i++) {
			nodeA.next = nodeB.next;
			nodeB.next = preNode.next;
			preNode.next = nodeB;
			nodeB = nodeA.next;
		}

		return dummyNode.next;
	}
}
