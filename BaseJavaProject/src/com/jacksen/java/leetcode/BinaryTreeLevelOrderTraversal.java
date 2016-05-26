package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/ <br />
 * 
 * 二叉树层序遍历
 * 
 * @author jacksen
 * @date 2016-5-26 上午9:48:00
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);

		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;

		BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> result = traversal.levelOrder2(node1);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 3ms <br />
	 * beats 14.37% of java submissions
	 * 
	 * @author jacksen
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int i = queue.size(); // 记录每层的结点个数
		TreeNode tempNode = null;
		List<Integer> singleLevel = new ArrayList<>();
		while (!queue.isEmpty()) {
			if (i == 0) {// 一层记录结束
				//
				result.add(singleLevel);

				i = queue.size();
				singleLevel = new ArrayList<>();
			}
			tempNode = queue.poll();
			singleLevel.add(tempNode.val);

			--i;

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}

		}
		result.add(singleLevel);
		return result;
	}

	/**
	 * 递归方式 <br />
	 * 重要的是记录层级<br />
	 * 1ms<br />
	 * eats87.36% of java submissions
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		levelRecursion(root, result, 0);

		return result;
	}

	/**
	 * 递归方法
	 */
	private void levelRecursion(TreeNode node, List<List<Integer>> result,
			int level) {
		if (node == null) {
			return;
		}
		if (result.size() < level + 1) {// 说明还需要添加一行
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(node.val);

		levelRecursion(node.left, result, level + 1);
		levelRecursion(node.right, result, level + 1);
	}

	/**
	 * 
	 * @author jacksen
	 * @date 2016-5-26 上午9:49:16
	 */
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			this.val = x;
		}
	}

}
