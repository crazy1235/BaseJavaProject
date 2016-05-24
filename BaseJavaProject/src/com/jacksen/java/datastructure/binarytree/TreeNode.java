package com.jacksen.java.datastructure.binarytree;

/**
 * 二叉树结点定义
 * 
 * @author jacksen
 * @date 2016-5-12 上午11:45:09
 * @param <E>
 */
public class TreeNode<E> {
	E data;
	TreeNode<E> leftNode;
	TreeNode<E> rightNode;

	public TreeNode() {

	}

	public TreeNode(E e) {
		this.data = e;
	}

	public TreeNode(E e, TreeNode<E> leftNode, TreeNode<E> rightNode) {
		this.data = e;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}
