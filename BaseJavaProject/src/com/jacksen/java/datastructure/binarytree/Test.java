package com.jacksen.java.datastructure.binarytree;

import java.util.List;

/**
 * 
 * @author jacksen
 * @date 2016-5-20 下午3:47:52
 */
public class Test {

	public static void main(String[] args) {

		// testBinaryTree();

		// testThreadedBinaryTree();

		testBinarySearchTree();

	}

	private static void testBinarySearchTree() {
		TreeNode<Integer> node1 = new TreeNode<>(1);
		TreeNode<Integer> node2 = new TreeNode<>(2);
		TreeNode<Integer> node3 = new TreeNode<>(3);
		TreeNode<Integer> node4 = new TreeNode<>(4);
		TreeNode<Integer> node5 = new TreeNode<>(5);
		TreeNode<Integer> node6 = new TreeNode<>(6);
		TreeNode<Integer> node7 = new TreeNode<>(7);

		node3.leftNode = node1;
		node1.rightNode = node2;
		node3.rightNode = node6;
		node6.leftNode = node4;
		node6.rightNode = node7;
		node4.rightNode = node5;

		TreeNode<Integer> node = BinarySearchTree.searchNode2(node3, 4);
		System.out.println(node == null ? "null" : node.data);

		List<Integer> list = BinarySearchTree.traverseTree(node3);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		System.out.println();

		TreeNode<Integer> minNode = BinarySearchTree.getMinNode(node3);
		System.out.println(minNode == null ? "树为空!" : "minNode's data is "
				+ minNode.data);

		TreeNode<Integer> maxNode = BinarySearchTree.getMaxNode(node3);
		System.out.println(maxNode == null ? "树为空!" : "maxNode's data is "
				+ maxNode.data);

		boolean flag = BinarySearchTree.insertNode(node3, 8);
		System.out.println(flag ? "插入成功" : "插入失败");

		boolean deleteFlag = BinarySearchTree.deleteNode(node3, 3);

		System.out.println(deleteFlag ? "删除成功" : "删除失败");

		list = BinarySearchTree.traverseTree(node3);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		System.out.println();

	}

	private static void testBinaryTree() {
		TreeNode<String> node1 = new TreeNode<>("1");
		TreeNode<String> node2 = new TreeNode<>("2");
		TreeNode<String> node3 = new TreeNode<>("3");
		TreeNode<String> node4 = new TreeNode<>("4");
		TreeNode<String> node5 = new TreeNode<>("5");
		TreeNode<String> node6 = new TreeNode<>("6");
		TreeNode<String> node7 = new TreeNode<>("7");

		node1.leftNode = node2;
		node1.rightNode = node3;
		node2.leftNode = node4;
		node3.leftNode = node5;
		node3.rightNode = node6;
		node5.rightNode = node7;

		// BinaryTree.preOrderTraverse(node1);
		//
		// System.out.println();
		//
		// BinaryTree.preOrderNoRecursion(node1);
		//
		// System.out.println();
		//
		// BinaryTree.preOrderNoRecursion2(node1);

		/*
		 * BinaryTree.InOrderTraverse(node1);
		 * 
		 * System.out.println();
		 * 
		 * BinaryTree.InOrderNoRecursion(node1);
		 */

		// BinaryTree.postOrderTraverse(node1);

		// BinaryTree.layerTraverse(node1);

		BinaryTree.postOrderNoRecursion(node1);

	}

	private static void testThreadedBinaryTree() {
		ThreadedTreeNode<String> node1 = new ThreadedTreeNode<>("A");
		ThreadedTreeNode<String> node2 = new ThreadedTreeNode<>("B");
		ThreadedTreeNode<String> node3 = new ThreadedTreeNode<>("C");
		ThreadedTreeNode<String> node4 = new ThreadedTreeNode<>("D");
		ThreadedTreeNode<String> node5 = new ThreadedTreeNode<>("E");
		ThreadedTreeNode<String> node6 = new ThreadedTreeNode<>("F");
		// ThreadedTreeNode<String> node7 = new ThreadedTreeNode<>("G");

		node1.leftChild = node2;
		node1.rightChild = node3;
		node2.leftChild = node4;
		node3.leftChild = node5;
		node3.rightChild = node6;

		ThreadedBinaryTree.InOrderThreaded(node1, null);

	}

}
