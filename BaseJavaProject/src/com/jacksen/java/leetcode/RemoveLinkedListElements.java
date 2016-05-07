package com.jacksen.java.leetcode;

/**
 * 203. Remove Linked List Elements
 * 
 * @author jacksen
 * @date 2016年5月6日22:41:03
 * 
 */
public class RemoveLinkedListElements {
	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);

		// node1.next = node2;
		// node2.next = node3;
		// node3.next = node4;
		// node4.next = node5;
		// node5.next = node6;
		// node6.next = node7;

		ListNode resultListNode = removeElements2(node1, 1);
		while (resultListNode != null) {
			System.out.print(resultListNode.val + "-->");
			resultListNode = resultListNode.next;
		}
	}

	/**
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		while (head != null && head.val == val) {
			head = head.next;
		}

		if (head == null) {
			return head;
		}

		ListNode temp = head;

		while (head.next != null) {
			if (head.next.val == val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}

		return temp;
	}

	/**
	 * 通过两个"指针"来做。 <br/>
	 * 1ms
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeElements2(ListNode head, int val) {
		ListNode perHead = new ListNode(0);
		perHead.next = head;
		ListNode perNode = perHead;
		ListNode nextNode = head;
		while (nextNode != null) {
			if (nextNode.val == val) {
				nextNode = nextNode.next;
				perNode.next = nextNode;
			} else {
				perNode = nextNode;
				nextNode = nextNode.next;
			}
		}

		return perHead.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}
}