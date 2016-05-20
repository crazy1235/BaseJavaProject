package com.jacksen.java.datastructure.binarytree;

/**
 * 线索二叉树结点
 * 
 * @author jacksen
 * @date 2016-5-20 下午5:11:13
 */
public class ThreadedTreeNode<E> {

	public E data;

	public ThreadedTreeNode<E> leftChild;

	public ThreadedTreeNode<E> rightChild;

	public boolean leftFlag = false;

	public boolean rightFlag = false;

	public ThreadedTreeNode() {

	}

	public ThreadedTreeNode(E data) {
		this.data = data;
	}

	public ThreadedTreeNode(E data, ThreadedTreeNode<E> leftChild,
			ThreadedTreeNode<E> rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

}
