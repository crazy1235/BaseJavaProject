package com.jacksen.java.leetcode;

import com.jacksen.java.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author Admin
 * 
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(3);
		l2.next.next.next = new ListNode(5);
		
		ListNode node = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode node = result;
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		if (l1 != null) {
			node.next = l1;
		}
		if (l2 != null) {
			node.next = l2;
		}
		return result.next;
	}
}
