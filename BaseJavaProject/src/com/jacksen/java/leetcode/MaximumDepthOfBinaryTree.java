package com.jacksen.java.leetcode;

/**
 * 104. Maximum Depth of Binary Tree
 * 
 * @author jacksen
 * @date 2016-5-9 下午5:08:21
 */
public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.right = node6;
		// node6.right = node4;

		System.out.println(maxDepth(node1));
	}

	/**
	 * 1ms
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}