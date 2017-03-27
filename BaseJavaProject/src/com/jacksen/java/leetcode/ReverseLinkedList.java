package com.jacksen.java.leetcode;

import java.util.Stack;

import com.jacksen.java.leetcode.common.ListNode;
import com.jacksen.java.leetcode.common.ListNodeUtils;

/**
 * https://leetcode.com/problems/reverse-linked-list
 * 
 * @author jacksen
 * @date 2017-3-27 上午9:29:18
 */
public class ReverseLinkedList {

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

		ListNode result = new ReverseLinkedList().reverseList3(node1);

		ListNodeUtils.printListNode(result);
	}

	/**
	 * 通过stack的方式
	 * 
	 * Runtime : 3ms
	 * 
	 * beats 2.24% of java submissions.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		ListNode tempNode = stack.pop();
		ListNode resultNode = tempNode;
		while (!stack.isEmpty()) {
			tempNode.next = stack.pop();
			tempNode = tempNode.next;
		}
		tempNode.next = null;
		return resultNode;
	}

	/**
	 * 迭代方式
	 * 
	 * beats 36.62% of java submissions.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode nodeA = head;
		ListNode nodeB = head.next;
		ListNode nodeResult = nodeA; //

		while (nodeB != null) {
			nodeA.next = nodeB.next;
			nodeB.next = nodeResult;
			nodeResult = nodeB;
			nodeB = nodeA.next;
		}

		return nodeResult;
	}

	/**
	 * 递归方式 1. 从前往后 2. 从后往前
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// return reverseNodes(null, head);
		return reverseNodes2(head);
	}

	/**
	 * 递归方法1 -- 从前往后
	 * 
	 * Runtime : 1ms <br />
	 * 
	 * beats 36.62% of java submissions
	 * 
	 * @param preNode
	 * @param currNode
	 * @return
	 */
	private ListNode reverseNodes(ListNode preNode, ListNode currNode) {
		if (currNode == null) { // 跳出条件
			return preNode;
		}
		ListNode tempNode = currNode.next;

		currNode.next = preNode;

		return reverseNodes(currNode, tempNode);
	}

	/**
	 * 递归方法2 -- 从后往前
	 * 
	 * beats 4.32% of java submissions
	 * 
	 * @param preNode
	 * @param currNode
	 * @return
	 */
	private ListNode reverseNodes2(ListNode node) { // 4
		if (node.next == null) {
			return node;
		}

		ListNode lastNode = node.next; // 1

		ListNode resultNode = reverseNodes2(node.next); // 3->1

		lastNode.next = node;
		node.next = null;

		return resultNode;

	}

}
