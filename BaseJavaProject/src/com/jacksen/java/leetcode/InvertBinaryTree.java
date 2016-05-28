package com.jacksen.java.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * @author jacksen
 * 
 */
public class InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(4);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(7);
		TreeNode treeNode4 = new TreeNode(1);
		TreeNode treeNode5 = new TreeNode(3);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(9);

		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		treeNode3.left = treeNode6;
		treeNode3.right = treeNode7;

		InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
		invertBinaryTree.invertTree2(treeNode1);

	}

	/**
	 * 从上往下<br />
	 * 0ms <br />
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	/**
	 * 从下向上对换
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;
		if (root.left != null) {
			leftNode = invertTree2(root.left);
		}
		if (root.right != null) {
			rightNode = invertTree2(root.right);
		}
		root.left = rightNode;
		root.right = leftNode;

		return root;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
