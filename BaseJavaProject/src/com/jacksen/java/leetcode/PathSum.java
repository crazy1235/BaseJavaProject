package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/path-sum/
 * 
 * @author jacksen
 * 
 */
public class PathSum {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node7;
		node4.right = node8;
		node3.left = node5;
		node3.right = node6;
		node6.right = node9;

		PathSum pathSum = new PathSum();
		System.out.println(pathSum.hasPathSum3(node1, 22));
	}

	private boolean flag = false;

	/**
	 * DFS <br />
	 * 
	 * 用BinaryTreePath中方法二变化而来
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		findPath(root, root.val, sum);
		return flag;
	}

	private void findPath(TreeNode node, int value, int sum) {
		if (node.left == null && node.right == null) {
			if (value == sum) {
				flag = true;
			}
		}
		if (node.left != null) {
			findPath(node.left, value + node.left.val, sum);
		}
		if (node.right != null) {
			findPath(node.right, value + node.right.val, sum);
		}
	}

	/**
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		}
		return hasPathSum2(root.left, sum - root.val)
				|| hasPathSum2(root.right, sum - root.val);
	}

	/**
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum3(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				return true;
			} else {
				return false;
			}
		}
		return hasPathSum3(root.left, sum - root.val)
				|| hasPathSum3(root.right, sum - root.val);
	}

	/**
	 * Definition for a binary tree node.
	 * 
	 * @author jacksen
	 * 
	 */
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
