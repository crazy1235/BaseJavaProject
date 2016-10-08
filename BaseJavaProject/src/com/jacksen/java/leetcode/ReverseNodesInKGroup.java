package com.jacksen.java.leetcode;

import com.jacksen.java.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * @author Admin
 * 
 */
public class ReverseNodesInKGroup {

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

		ListNode result = new ReverseNodesInKGroup().reverseKGroup(node1, 3);
		while (result != null) {
			System.out.print(result.val + "-->");
			result = result.next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		
		
		
		return head;
	}

}
