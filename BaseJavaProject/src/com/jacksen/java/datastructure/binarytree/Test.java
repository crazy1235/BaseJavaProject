package com.jacksen.java.datastructure.binarytree;

/**
 * 
 * @author jacksen
 * @date 2016-5-20 下午3:47:52
 */
public class Test {

	public static void main(String[] args) {

		// testBinaryTree();

		testThreadedBinaryTree();

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

		// BinaryTree.InOrderTraverse(node1);

		// BinaryTree.postOrderTraverse(node1);
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
