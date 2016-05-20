package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.jacksen.java.datastructure.binarytree.TreeNode;

/**
 * 257. Binary Tree Paths <br />
 * 
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * @author jacksen
 * @date 2016-5-20 下午4:00:28
 */
public class BinaryTreePaths {

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
		node3.right = node6;

		//
		List<String> resultList = binaryTreePaths2(node1);
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	/**
	 * 递归方式
	 * 
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> resultList = new ArrayList<String>();
		if (root == null) {
			return resultList;
		}
		List<String> singleResult = new ArrayList<>();

		getTreePath(resultList, root, singleResult);
		return resultList;
	}

	/**
	 * 
	 * @param resultList
	 * @param node
	 * @param singleResult
	 */
	private static void getTreePath(List<String> resultList, TreeNode node,
			List<String> singleResult) {
		singleResult.add(node.val + "");
		if (node.left == null && node.right == null) {
			resultList.add(getPath(singleResult));
		}
		if (node.left != null) {
			getTreePath(resultList, node.left, new ArrayList<>(singleResult));
		}
		if (node.right != null) {
			getTreePath(resultList, node.right, new ArrayList<>(singleResult));
		}
	}

	/**
	 * 
	 * @param singleResult
	 * @return
	 */
	private static String getPath(List<String> singleResult) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < singleResult.size() - 1; i++) {
			sb.append(singleResult.get(i) + "->");
		}
		sb.append(singleResult.get(singleResult.size() - 1));
		return sb.toString();
	}

	/**
	 * 通过栈来做
	 * 
	 * @param root
	 * @return
	 */

	public static List<String> binaryTreePaths2(TreeNode root) {
		List<String> resultList = new ArrayList<String>();

		if (root == null) {
			return resultList;
		}
		boolean flag = false;
		List<Boolean> temp = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tempNode = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			tempNode = stack.peek();

			if (flag) {// 之前pop出一个
				if (temp.get(temp.size() - 1)) {// 之前pop的是当前结点的右结点
					stack.pop();// 把当前结点pop出
					temp.remove(temp.size() - 1);
				} else {
					if (tempNode.right != null) {
						flag = false;
					} else {// 当前结点没有右结点,pop
						stack.pop();
						temp.remove(temp.size() - 1);
					}
				}
				continue;
			}

			if (temp.size() > 0 && !temp.get(temp.size() - 1)) {
				if (tempNode.right != null) {
					stack.push(tempNode.right);
					temp.add(true);
					continue;
				}
			}
			if (tempNode.left != null) {
				stack.push(tempNode.left);
				temp.add(false);
				continue;
			}
			if (tempNode.right != null) {
				stack.push(tempNode.right);
				temp.add(true);
				continue;
			}

			// 叶子结点
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < stack.size() - 1; i++) {
				sb.append(stack.get(i).val + "->");
			}
			sb.append(stack.get(stack.size() - 1).val);
			resultList.add(sb.toString());

			//
			stack.pop();
			flag = true;
		}

		return resultList;
	}

	/**
	 * 
	 * @author jacksen
	 * @date 2016-5-20 下午4:01:14
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
