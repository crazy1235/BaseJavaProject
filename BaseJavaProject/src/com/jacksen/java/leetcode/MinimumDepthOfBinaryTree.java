package com.jacksen.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 * 
 * @author jacksen
 * @date 2016-5-9 下午6:01:00
 */
public class MinimumDepthOfBinaryTree {
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
		node3.left = node5;
		// node2.right = node5;
		// node5.right = node6;
		// node6.right = node4;

		System.out.println(minDepth2(node1));
	}

	/**
	 * 采用广度遍历
	 * 
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node.left == null && node.right == null) {
				break;
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			depth++;
		}
		return depth;
	}

	/**
	 * 类似于MaximumDepthOfBinaryTree中的maxDepth()方法
	 *  
	 * @param root
	 * @return
	 */
	public static int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth2(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth2(root.left) + 1;
		}
		return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
	}
}
