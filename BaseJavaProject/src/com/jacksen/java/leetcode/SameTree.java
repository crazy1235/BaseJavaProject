package com.jacksen.java.leetcode;

import com.jacksen.java.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 * 
 * @author jacksen
 * @date 2016-5-30 上午10:09:20
 */
public class SameTree {
	public static void main(String[] args) {
		SameTree sameTree = new SameTree();

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(2);
		TreeNode node7 = new TreeNode(3);
		TreeNode node8 = new TreeNode(4);

		TreeNode p = new TreeNode(0);
		/*
		 * p.left = node1; p.right = node2; node1.left = node3; node2.right =
		 * node4;
		 */

		TreeNode q = new TreeNode(1);
		/*
		 * q.left = node5; q.right = node6; node5.left = node7; node6.right =
		 * node8;
		 */

		boolean flag = sameTree.isSameTree2(p, q);
		System.out.println(flag);
	}

	/**
	 * 0ms
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null & q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

	/**
	 * https://leetcode.com/discuss/69708/one-line-java-solution
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		return (p != null && q != null && p.val == q.val
				&& isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right))
				|| (p == null && q == null);
	}
}
