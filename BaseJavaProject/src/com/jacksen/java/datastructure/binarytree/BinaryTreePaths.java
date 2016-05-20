package com.jacksen.java.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 遍历二叉树的所有路径 <br />
 * 
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * @author jacksen
 * @date 2016-5-12 上午11:47:40
 */
public class BinaryTreePaths {
	public static void main(String[] args) {
		//
		TreeNode<String> node1 = new TreeNode<String>("111");
		TreeNode<String> node2 = new TreeNode<String>("222");
		TreeNode<String> node3 = new TreeNode<String>("333");
		TreeNode<String> node4 = new TreeNode<String>("444");
		TreeNode<String> node5 = new TreeNode<String>("555");
		TreeNode<String> node6 = new TreeNode<String>("666");

		node1.leftNode = node2;
		node1.rightNode = node3;
		node2.leftNode = node4;
		node2.rightNode = node5;
		node3.rightNode = node6;

		//
		List<String> resultList = binaryTreePaths2(node1);
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	/**
	 * 方法一：递归方式
	 * 
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths(TreeNode<String> root) {
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
	private static void getTreePath(List<String> resultList,
			TreeNode<String> node, List<String> singleResult) {
		singleResult.add(node.data);
		if (node.leftNode == null && node.rightNode == null) {
			resultList.add(getPath(singleResult));
		}
		if (node.leftNode != null) {
			getTreePath(resultList, node.leftNode,
					new ArrayList<>(singleResult));
		}
		if (node.rightNode != null) {
			getTreePath(resultList, node.rightNode, new ArrayList<>(
					singleResult));
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
			sb.append(singleResult.get(i) + "-->");
		}
		sb.append(singleResult.get(singleResult.size() - 1));
		return sb.toString();
	}

	/**
	 * 方法二：入栈出栈的方式
	 * 
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths2(TreeNode<String> root) {
		List<String> resultList = new ArrayList<String>();
		if (root == null) {
			return resultList;
		}

		List<String> singleResult = new ArrayList<>();

		Stack<TreeNode<String>> stack = new Stack<>();
		stack.push(root);
		TreeNode<String> temp = null;
		while (!stack.isEmpty()) {
			temp = stack.peek();

			if (temp.leftNode != null) {
				stack.push(temp.leftNode);
				continue;
			}

			if (temp.rightNode != null) {
				stack.push(temp.rightNode);
				continue;
			}

			if (temp.leftNode == null && temp.rightNode == null) {// 叶子结点
				for (int i = 0; i < stack.size(); i++) {
					singleResult.add(stack.get(i).data);
				}
				resultList.add(getPath(singleResult));
				singleResult.clear();
				stack.pop();
				continue;
			}
		}
		return resultList;
	}
}
