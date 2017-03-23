package com.jacksen.java.leetcode;

import com.jacksen.java.leetcode.common.ListNode;
import com.jacksen.java.leetcode.common.ListNodeUtils;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * @author Admin
 * 
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		/*
		 * ListNode l1 = new ListNode(5); ListNode l2 = new ListNode(5);
		 */

		ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

		ListNodeUtils.printListNode(result);
	}

	/**
	 * 57ms <br />
	 * 将个数较少的列表后面补上0
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		ListNode temp = new ListNode(0);
		ListNode result = temp;

		int value1 = 0;
		int value2 = 0;
		while (l1 != null && l2 != null) {
			value2 = (l1.val + l2.val + value1) % 10;
			value1 = (l1.val + l2.val + value1) / 10;

			temp.next = new ListNode(value2);
			l1 = l1.next;
			l2 = l2.next;
			temp = temp.next;
			if (l1 == null && l2 == null) {
				break;
			}
			if (l1 == null) {
				l1 = new ListNode(0);
			}
			if (l2 == null) {
				l2 = new ListNode(0);
			}
		}
		if (value1 != 0) {
			temp.next = new ListNode(value1);
		}
		return result.next;
	}

	/**
	 * 递归方式 -- 56ms
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		int value = l1.val + l2.val;
		ListNode result = new ListNode(value % 10);
		result.next = addTwoNumbers2(l1.next, l2.next);
		if (value >= 10) {
			result.next = addTwoNumbers2(new ListNode(value / 10), result.next);
		}
		return result;
	}

	/**
	 * 九章算法答案 <br />
	 * http://www.jiuzhang.com/solutions/add-two-numbers/
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode head = new ListNode(0);
		ListNode point = head;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int sum = carry + l1.val + l2.val;
			point.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
			point = point.next;
		}

		while (l1 != null) {
			int sum = carry + l1.val;
			point.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			point = point.next;
		}

		while (l2 != null) {
			int sum = carry + l2.val;
			point.next = new ListNode(sum % 10);
			carry = sum / 10;
			l2 = l2.next;
			point = point.next;
		}

		if (carry != 0) {
			point.next = new ListNode(carry);
		}
		return head.next;
	}

}
