package com.jacksen.java.leetcode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * @author jacksen
 * @date 2016-5-24 上午10:57:26
 */
public class ValidateBinarySearchTree {
	public static void main(String[] args) {

	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return true;
	}

	/**
	 * 
	 * @author jacksen
	 * @date 2016-5-24 上午11:00:06
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
