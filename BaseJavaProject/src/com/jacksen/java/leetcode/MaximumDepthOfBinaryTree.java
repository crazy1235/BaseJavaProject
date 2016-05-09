package com.jacksen.java.leetcode;

import java.util.Stack;

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
		node1.right = node6;
		node2.left = node3;
		node2.right = node5;
		node3.left = node4;
		// node5.right = node6;
		// node6.right = node4;

		System.out.println(maxDepth2(node1));
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

	/**
	 * 深度优先遍历，看栈的最大深度
	 * 
	 * 暂时不对.
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null || node.left != null) {
				depth++;
			}
			if (node.left != null && node.right != null) {
				depth--;
			}
		}
		return ++depth;

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