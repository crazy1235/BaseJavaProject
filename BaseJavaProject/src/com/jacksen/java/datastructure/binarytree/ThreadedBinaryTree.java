package com.jacksen.java.datastructure.binarytree;

/**
 * 线索二叉树
 * 
 * @author jacksen
 * @date 2016-5-20 下午5:10:15
 */
public class ThreadedBinaryTree {

	/**
	 * 中序线索化
	 * 
	 * @param <E>
	 */
	public static <E> void InOrderThreaded(ThreadedTreeNode<E> node,
			ThreadedTreeNode<E> preNode) {
		if (node != null) {
			// 递归左子树线索化
			InOrderThreaded(node.leftChild, preNode);

			//
			if (node.leftChild == null) {
				node.leftChild = preNode;
				node.leftFlag = true;// true表示前驱或者后序结点
			}

			if (preNode != null && preNode.rightChild ==null) {
				preNode.rightChild = node;
				preNode.rightFlag = true;
			}

			preNode = node;

			// 递归右子树线索化
			InOrderThreaded(node.rightChild, preNode);

		}
	}
}
