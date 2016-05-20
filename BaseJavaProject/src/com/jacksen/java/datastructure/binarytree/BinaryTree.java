package com.jacksen.java.datastructure.binarytree;

import java.util.List;

/**
 * 二叉树
 * 
 * @author jacksen
 * @date 2016-5-20 下午3:47:04
 */
public class BinaryTree {

	public static void createBinTree(List<String> list) {
		
	}

	/**
	 * 前序遍历
	 * 
	 * @param node
	 */
	public static <E> void preOrderTraverse(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderTraverse(node.leftNode);
		preOrderTraverse(node.rightNode);
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	public static <E> void InOrderTraverse(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		InOrderTraverse(node.leftNode);
		System.out.print(node.data + " ");
		InOrderTraverse(node.rightNode);
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */
	public static <E> void postOrderTraverse(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		postOrderTraverse(node.leftNode);
		postOrderTraverse(node.rightNode);
		System.out.print(node.data + " ");
	}

}
