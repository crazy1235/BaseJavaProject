package com.jacksen.java.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import com.jacksen.java.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * @author jacksen
 * @date 2016-5-30 上午10:58:01
 */
public class SymmetricTree {
	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		SymmetricTree symmetricTree = new SymmetricTree();
		boolean flag = symmetricTree.isSysmmetric3(node1);
		System.out.println(flag);
	}

	/**
	 * 双端队列 <br />
	 * DFS <br />
	 * 3ms <br />
	 * beats 6.29% of java submissions
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.addFirst(root.left);
		deque.addLast(root.right);

		TreeNode preNode = null;
		TreeNode postNode = null;

		while (!deque.isEmpty()) {
			preNode = deque.pollFirst();
			postNode = deque.pollLast();
			if (preNode == null && postNode == null) {
				continue;
			}
			if (preNode == null || postNode == null) {
				return false;
			}
			if (preNode.val != postNode.val) {
				return false;
			} else {
				deque.addFirst(preNode.right);
				deque.addFirst(preNode.left);

				deque.addLast(postNode.left);
				deque.addLast(postNode.right);
			}
		}
		return true;
	}

	/**
	 * 递归方式 <br />
	 * 1ms <br />
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSysmmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}

		return checkNodes(root.left, root.right);
	}

	public boolean checkNodes(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		if (node1.val != node2.val) {
			return false;
		} else {
			return checkNodes(node1.left, node2.right)
					&& checkNodes(node1.right, node2.left);
		}
	}

	/**
	 * 拷贝一颗二叉树，reverse。或者拷贝的时候直接反转。 <br />
	 * 然后在使用Same Tree的方法判断这两个树是否一样。 <br />
	 * 1ms
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSysmmetric3(TreeNode root) {
		if (root == null) {
			return true;
		}

		TreeNode newRootNode = copyNode(root);

		SameTree sameTree = new SameTree();
		return sameTree.isSameTree(root, newRootNode);
	}

	/**
	 * 左右对换结点拷贝二叉树
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode copyNode(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode treeNode = new TreeNode(node.val);
		treeNode.left = copyNode(node.right);
		treeNode.right = copyNode(node.left);
		return treeNode;
	}

}
