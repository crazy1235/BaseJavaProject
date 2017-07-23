package com.jacksen.java.datastructure.binarytree;

/**
 * 红黑树结点定义
 * 
 * @author jacksen
 * 
 */
public class RBTreeNode<T extends Comparable<T>> {

	private T value;

	private RBTreeNode<T> left;

	private RBTreeNode<T> right;

	private RBTreeNode<T> parent;

	private boolean red;

	public RBTreeNode() {
		super();
	}

	public RBTreeNode(T value) {
		super();
		this.value = value;
	}

	public RBTreeNode(T value, boolean red) {
		super();
		this.value = value;
		this.red = red;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public RBTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(RBTreeNode<T> left) {
		this.left = left;
	}

	public RBTreeNode<T> getRight() {
		return right;
	}

	public void setRight(RBTreeNode<T> right) {
		this.right = right;
	}

	public RBTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(RBTreeNode<T> parent) {
		this.parent = parent;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	public void makeBlack() {
		this.red = false;
	}

	public void makeRed() {
		this.red = true;
	}

}
