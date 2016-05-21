package com.jacksen.java.datastructure.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

	/**
	 * 层序遍历 <br />
	 * 利用队列实现
	 * 
	 * @param <E>
	 * @param node
	 */
	public static <E> void layerTraverse(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.add(node);
		TreeNode<E> tempNode = null;
		while (!queue.isEmpty()) {
			tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			if (tempNode.leftNode != null) {
				queue.add(tempNode.leftNode);
			}
			if (tempNode.rightNode != null) {
				queue.add(tempNode.rightNode);
			}
		}
	}

	/**
	 * 先序遍历非递归方法
	 * 
	 * @param node
	 */
	public static <E> void preOrderNoRecursion(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode<E>> stack = new Stack<>();
		stack.push(node);
		TreeNode<E> tempNode = null;
		while (!stack.isEmpty()) {
			tempNode = stack.pop();
			System.out.print(tempNode.data + " ");
			if (tempNode.rightNode != null) {
				stack.push(tempNode.rightNode);
			}
			if (tempNode.leftNode != null) {
				stack.push(tempNode.leftNode);
			}
		}
	}

	/**
	 * 先序遍历非递归方法2
	 * 
	 * @param node
	 */
	public static <E> void preOrderNoRecursion2(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode<E>> stack = new Stack<>();
		stack.push(node);
		TreeNode<E> tempNode = node;
		while (!stack.isEmpty()) {
			while ((tempNode = stack.peek()) != null) {
				System.out.print(tempNode.data + " ");
				tempNode = tempNode.leftNode;
				stack.push(tempNode);
			}// 向左走到尽头

			stack.pop();// pop出null

			if (!stack.isEmpty()) {
				tempNode = stack.pop();
				stack.push(tempNode.rightNode);
			}
		}
	}

	/**
	 * 中序遍历非递归方法
	 * 
	 * @param node
	 */
	public static <E> void InOrderNoRecursion(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode<E>> stack = new Stack<>();
		TreeNode<E> tempNode = node;
		stack.push(tempNode);
		while (!stack.isEmpty()) {
			while ((tempNode = stack.peek()) != null) {
				tempNode = tempNode.leftNode;
				stack.push(tempNode);
			}
			//
			stack.pop();
			//
			if (!stack.isEmpty()) {
				tempNode = stack.pop();
				System.out.print(tempNode.data + " ");
				stack.push(tempNode.rightNode);
			}
		}
	}

	/**
	 * 后续遍历非递归方法
	 * 
	 * @param node
	 */
	public static <E> void postOrderNoRecursion(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		Stack<MarkTreeNode<E>> stack = new Stack<>();
		MarkTreeNode<E> markTreeNode = new MarkTreeNode<>(node);
		stack.push(markTreeNode);
		while (!stack.isEmpty()) {
			while ((markTreeNode = stack.peek()).node != null) {
				markTreeNode = new MarkTreeNode<E>(markTreeNode.node.leftNode,
						1);
				stack.push(markTreeNode);
			}
			//
			stack.pop();
			//

			markTreeNode = stack.peek();
			while (markTreeNode.node != null) {
				if (markTreeNode.mark == 2) {
					System.out.print(stack.pop().node.data + " ");
					if (stack.isEmpty()) {
						return;
					}
					markTreeNode = stack.peek();
				} else {
					markTreeNode.mark = 2;
					markTreeNode = new MarkTreeNode<>(
							markTreeNode.node.rightNode, 1);
					stack.push(markTreeNode);
					break;
				}
			}
		}
	}

	/**
	 * 
	 * @author Admin
	 * 
	 * @param <E>
	 */
	private static class MarkTreeNode<E> {
		TreeNode<E> node;
		int mark = 0;// mark = 0 表示刚刚访问此结点，mark=1 表示左子树处理返回，mark=2表示右子数处理结束返回。

		public MarkTreeNode() {

		}

		public MarkTreeNode(TreeNode<E> node) {
			this.node = node;
		}

		public MarkTreeNode(TreeNode<E> node, int mark) {
			this.node = node;
			this.mark = mark;
		}
	}
}
