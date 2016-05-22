package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * @author jacksen
 * 
 */
public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;

		BinaryTreePreorderTraversal traversal = new BinaryTreePreorderTraversal();
		List<Integer> list = traversal.preorderTraversal2(node1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	public List<Integer> list = new ArrayList<Integer>();

	/**
	 * 先序遍历二叉树
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		preOrder(root);
		return list;
	}

	/**
	 * 递归方式
	 * 
	 * @param node
	 */
	public void preOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	/**
	 * 非递归方式
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode tempNode = null;
		while (!stack.isEmpty()) {
			tempNode = stack.pop();
			list.add(tempNode.val);
			if (tempNode.right != null) {
				stack.push(tempNode.right);
			}
			if (tempNode.left != null) {
				stack.push(tempNode.left);
			}
		}
		return list;
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
