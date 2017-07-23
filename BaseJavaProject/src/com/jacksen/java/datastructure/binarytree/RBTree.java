package com.jacksen.java.datastructure.binarytree;

/**
 * 红黑树
 * 
 * RBTree的定义如下： 1. 任何一个结点都是有颜色的，黑色或红色 2. 根节点是黑色的 3. 父子节点之间不能出现两个连续的红色节点 4.
 * 任何一个节点向下遍历到其子孙的叶子节点，所经历的黑结点个数必须相等 5. 空节点被认为是黑色的
 * 
 * @author jacksen
 * 
 */
public class RBTree<T extends Comparable<T>> {

	/**
	 * root node
	 */
	private RBTreeNode<T> root;

	/**
	 * tree's size
	 */
	private int size;

	public RBTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * find the value
	 * 
	 * @param value
	 * @return
	 */
	public T find(T value) {
		RBTreeNode<T> rootNode = getRoot();
		while (rootNode != null) {
			int result = rootNode.getValue().compareTo(value);
			if (result > 0) {
				rootNode = rootNode.getLeft();
			} else if (result < 0) {
				rootNode = rootNode.getRight();
			} else {
				return rootNode.getValue();
			}
		}
		return null;
	}

	public T addNode(T value) {
		RBTreeNode<T> node = new RBTreeNode<>(value);
		return addNode(node);
	}

	private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent) {
		if (node != null) {
			node.setParent(parent);
			if (parent == root) {
				node.setParent(null);
			}
		}
	}

	/**
	 * 1. 叔叔节点也为红色。 2. 叔叔节点为空，且祖父节点、父节点和新节点处于一条斜线上。 3.
	 * 叔叔节点为空，且祖父节点、父节点和新节点不处于一条斜线上。
	 * 
	 * @param node
	 * @return
	 */
	public T addNode(RBTreeNode<T> node) {
		node.setLeft(null);
		node.setRight(null);
		node.setRed(true); // 新加入结点初始为红色
		setParent(node, null);
		if (root.getLeft() == null) {
			root.setLeft(node);
			node.setRed(false); // black
			size++;
		} else {
			RBTreeNode<T> x = findParentNode(node);
			int cmp = x.getValue().compareTo(node.getValue());
			if (cmp == 0) {
				T oldNode = x.getValue();
				x.setValue(node.getValue());
				return oldNode;
			}

			// 设置新节点的父节点
			setParent(node, x);

			// 针对父节点设置子节点（新节点node）
			if (cmp > 0) {
				x.setLeft(node);
			} else {
				x.setRight(node);
			}

			fixInsert(node);
			size++;
		}

		return null;
	}

	/**
	 * 遍历查找（准备插入）新节点的父节点
	 * 
	 * @param node
	 * @return
	 */
	private RBTreeNode<T> findParentNode(RBTreeNode<T> node) {
		RBTreeNode<T> root = getRoot();
		RBTreeNode<T> child = root;

		while (child != null) {
			int cmp = child.getValue().compareTo(node.getValue());
			if (cmp == 0) {
				return child;
			}
			if (cmp > 0) {
				root = child;
				child = child.getLeft();
			} else {
				root = child;
				child = child.getRight();
			}
		}
		return root;
	}

	/**
	 * 查找一个节点的叔叔节点 （通过node的父节点和父节点的父节点来进行判断得到叔叔节点）
	 * 
	 * @param node
	 * @return
	 */
	private RBTreeNode<T> findUncleNode(RBTreeNode<T> node) {
		RBTreeNode<T> parent = node.getParent();
		RBTreeNode<T> ancestor = parent.getParent();
		if (ancestor == null) {
			return null;
		}

		if (parent == ancestor.getLeft()) {
			return ancestor.getLeft();
		} else {
			return ancestor.getLeft();
		}
	}

	/**
	 * 判断是否需要平衡数
	 * 
	 * @param x
	 */
	private void fixInsert(RBTreeNode<T> x) {
		RBTreeNode<T> parent = x.getParent();

		while (parent != null && parent.isRed()) {
			RBTreeNode<T> uncleNode = findUncleNode(x);

			// 如果叔叔节点为空， 不管node和父节点，祖先结点在不在一条线上都需要旋转操作
			if (uncleNode == null) {
				RBTreeNode<T> ancestor = parent.getParent(); // ancestor肯定不为空

				if (parent == ancestor.getLeft()) {
					boolean isRight = x == parent.getRight();

					if (isRight) { // 父节点是祖先结点的左节点，当前节点是父节点的右节点
						rotateLeft(parent);
					}

					rotateRight(ancestor);

					if (isRight) {
						x.setRed(false);
						parent = null; // 结束循环
					} else {
						parent.setRed(false);
					}
					ancestor.setRed(true);
				} else {
					boolean isLeft = x == parent.getLeft();
					if (isLeft) { // 父节点是祖先结点的右节点，当前节点是父节点的左节点
						rotateRight(parent);
					}
					rotateLeft(ancestor);

					if (isLeft) {
						x.setRed(false);
						parent = null; // 结束循环
					} else {
						parent.setRed(false);
					}
					ancestor.setRed(true);
				}
			} else { // 叔叔节点是红色
				parent.setRed(false);
				uncleNode.setRed(false);
				parent.getParent().setRed(true);
				x = parent.getParent();
				parent = x.getParent();
			}
		}
		getRoot().makeBlack();
		getRoot().setParent(null);

	}

	private void rotateLeft(RBTreeNode<T> node) {
		RBTreeNode<T> right = node.getRight();
		if (right == null) {
			throw new java.lang.IllegalStateException("right node is null");
		}
		RBTreeNode<T> parent = node.getParent();
		node.setRight(right.getLeft());
		setParent(right.getLeft(), node);

		right.setLeft(node);
		setParent(node, right);

		if (parent == null) {
			root.setLeft(right);
			setParent(right, null);
		} else {
			if (parent.getLeft() == node) {
				parent.setLeft(right);
			} else {
				parent.setRight(right);
			}
			setParent(right, parent);
		}
	}

	private void rotateRight(RBTreeNode<T> node) {
		RBTreeNode<T> left = node.getLeft();
		if (left == null) {
			throw new java.lang.IllegalStateException("left node is null");
		}

		RBTreeNode<T> parent = node.getParent();
		node.setLeft(left.getRight());
		setParent(left.getRight(), node);

		left.setRight(node);
		setParent(node, left);

		if (parent == null) {
			root.setLeft(left);
			setParent(left, null);
		} else {
			if (parent.getLeft() == node) {
				parent.setLeft(left);
			} else {
				parent.setRight(left);
			}
			setParent(left, parent);
		}
	}

}
