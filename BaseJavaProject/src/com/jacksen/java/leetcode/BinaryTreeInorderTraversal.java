package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author jacksen
 * 
 */
public class BinaryTreeInorderTraversal {

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

		BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
		List<Integer> list = traversal.inorderTraversal2(node1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	public List<Integer> list = new ArrayList<Integer>();

	/**
	 * 递归方式 <br />
	 * 1ms
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		inOrder(root);
		return list;
	}

	/**
	 * 递归方式
	 * 
	 * @param node
	 */
	public void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inOrder(node.left);
		}
		list.add(node.val);
		if (node.right != null) {
			inOrder(node.right);
		}
	}

	/**
	 * 非递归方式<br />
	 * 2ms
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tempNode = root;
		stack.push(tempNode);
		while (!stack.isEmpty()) {
			while ((tempNode = stack.peek()) != null) {
				tempNode = tempNode.left;
				stack.push(tempNode);
			}
			//
			stack.pop();
			//
			if (!stack.isEmpty()) {
				tempNode = stack.pop();
				list.add(tempNode.val);
				stack.push(tempNode.right);
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
