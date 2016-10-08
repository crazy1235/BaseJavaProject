package com.jacksen.java.leetcode;

import com.jacksen.java.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author jacksen
 * @date 2016-9-27 下午2:46:35
 */
public class SwapNodesInPairs {

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

		ListNode resultNode = new SwapNodesInPairs().swapPairs(node1);

		while (resultNode != null) {
			System.out.print(resultNode.val + "-->");
			resultNode = resultNode.next;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode result = new ListNode(0);
		result.next = head;

		head = result;

		ListNode node1 = head.next;

		ListNode node2 = head.next.next;

		while (node1 != null && node2 != null) {
			head.next = node2;
			node1.next = node2.next;
			node2.next = node1;

			head = node1;

			if (head.next != null && head.next.next != null) {
				node1 = node1.next;
				node2 = node1.next;
			} else {
				break;
			}
		}

		return result.next;
	}

}
