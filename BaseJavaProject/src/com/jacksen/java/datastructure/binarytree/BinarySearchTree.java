package com.jacksen.java.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树
 * 
 * @author jacksen
 * @date 2016-5-24 上午11:38:39
 */
public class BinarySearchTree {

	/**
	 * 搜索结点
	 * 
	 * @param val
	 * @return
	 */
	public static TreeNode<Integer> searchNode(TreeNode<Integer> root, int val) {
		if (root == null) {
			return null;
		}
		if (val == root.data) {
			return root;
		}
		if (val < root.data) {
			return searchNode(root.leftNode, val);
		}
		if (val > root.data) {
			return searchNode(root.rightNode, val);
		}
		return null;
	}

	/**
	 * 搜索结点
	 * 
	 * @param val
	 * @return
	 */
	public static TreeNode<Integer> searchNode2(TreeNode<Integer> root, int val) {
		while (root != null) {
			if (val < root.data) {
				root = root.leftNode;
			} else if (val > root.data) {
				root = root.rightNode;
			} else
				return root;
		}
		return null;
	}

	/**
	 * 查找值最小的结点<br/>
	 * 最左结点
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode<Integer> getMinNode(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (root.leftNode == null) {
			return root;
		}
		return getMinNode(root.leftNode);
	}

	/**
	 * 查找值最大的结点<br/>
	 * 最右结点
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode<Integer> getMaxNode(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (root.rightNode == null) {
			return root;
		}
		return getMaxNode(root.rightNode);
	}

	/**
	 * 从小到大遍历输出 <br />
	 * 中序遍历
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> traverseTree(TreeNode<Integer> root) {
		List<Integer> result = new ArrayList<Integer>();
		traversal(root, result);
		return result;
	}

	/**
	 * 递归方式遍历
	 * 
	 * @param root
	 * @param list
	 */
	private static void traversal(TreeNode<Integer> root, List<Integer> list) {
		if (root != null) {
			traversal(root.leftNode, list);
			list.add(root.data);
			traversal(root.rightNode, list);
		}
	}

	/**
	 * 插入一个新结点
	 * 
	 * @param root
	 * @param val
	 */
	public static boolean insertNode(TreeNode<Integer> root, int val) {

		TreeNode<Integer> currentNode = root;
		TreeNode<Integer> preNode = null;

		while (currentNode != null) {
			if (val < currentNode.data) {// left
				preNode = currentNode;
				currentNode = currentNode.leftNode;
			} else if (val > currentNode.data) {// right
				preNode = currentNode;
				currentNode = currentNode.rightNode;
			} else {// 不允许有两个结点值相等
				return false;
			}
		}

		currentNode = new TreeNode<Integer>(val);
		if (preNode == null) {// 没有根节点
			root = currentNode;
		} else {
			if (currentNode.data < preNode.data) {
				preNode.leftNode = currentNode;
			} else {
				preNode.rightNode = currentNode;
			}
		}
		return true;
	}

	/**
	 * 删除一个结点
	 * 
	 * @param root
	 * @param val
	 * @return
	 */
	public static boolean deleteNode(TreeNode<Integer> root, int val) {
		TreeNode<Integer> currentNode = root;
		TreeNode<Integer> preNode = null;

		while (currentNode != null) {
			if (val < currentNode.data) {// left
				preNode = currentNode;
				currentNode = currentNode.leftNode;
			} else if (val > currentNode.data) {// right
				preNode = currentNode;
				currentNode = currentNode.rightNode;
			} else {// 找到值相等的结点
				// 判断情况
				if (currentNode.leftNode == null
						&& currentNode.rightNode == null) {// 当前结点没有子结点
					if (preNode == null) {
						root = null;
					} else {
						if (currentNode.data < preNode.data) {
							preNode.leftNode = null;
						} else {
							preNode.rightNode = null;
						}
					}
					currentNode.data = null;// for GC
					currentNode = null;

					return true;
				}
				if (currentNode.leftNode != null
						&& currentNode.rightNode == null) {// 有左子树
					if (preNode == null) {
						root = currentNode.leftNode;
					} else {
						if (currentNode.data < preNode.data) {
							preNode.leftNode = currentNode.leftNode;
						} else {
							preNode.rightNode = currentNode.leftNode;
						}
					}
					currentNode.data = null;
					currentNode = null;

					return true;
				}
				if (currentNode.rightNode != null
						&& currentNode.leftNode == null) {// 有右子树
					if (preNode == null) {
						root = currentNode.rightNode;
					} else {
						if (currentNode.data < preNode.data) {
							preNode.leftNode = currentNode.rightNode;
						} else {
							preNode.rightNode = currentNode.rightNode;
						}
					}
					currentNode.data = null;
					currentNode = null;

					return true;
				}
				if (currentNode.leftNode != null
						&& currentNode.rightNode != null) {// 左右子树都存在
					// TODO 此时应该有两种策略：
					// 一种是用当前结点的左子树中的最大结点替代当前结点;
					// 另一种是用当前结点的右子树中的最小结点替代当前节点

					TreeNode<Integer> tempPre = null;
					TreeNode<Integer> tempNode = currentNode.leftNode;
					while (tempNode.rightNode != null) {// 寻找左子树中最大结点
						tempPre = tempNode;
						tempNode = tempNode.rightNode;
					}
					// TODO 此时也有两种策略：
					// 一种是将pre指向temp，temp然后指向curr的left和right，还要记录temp的pre并使其指向为null
					// 另一种是将curr的值赋为temp的值，然后删除temp即可。
					// 显然第二种方法较简单。
					currentNode.data = tempNode.data;
					if (tempNode.data < tempPre.data) {
						tempPre.leftNode = null;
					} else {
						tempPre.rightNode = null;
					}
					// for GC
					tempNode.data = null;
					tempNode = null;

					return true;
				}

			}
		}

		return false;
	}
}
