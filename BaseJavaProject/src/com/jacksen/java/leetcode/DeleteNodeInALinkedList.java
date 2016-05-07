package com.jacksen.java.leetcode;

/**
 * 237. Delete Node in a Linked List
 * 
 * @author jacksen
 * @date 2016年5月7日11:39:11
 * 
 */
public class DeleteNodeInALinkedList {
	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		deleteNode(node1);

		while (node1 != null) {
			System.out.print(node1.val + "-->");
			node1 = node1.next;
		}
	}

	/**
	 * 传入的node即是想要删除的节点，注意理解题目
	 * 
	 * @param node
	 */
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
