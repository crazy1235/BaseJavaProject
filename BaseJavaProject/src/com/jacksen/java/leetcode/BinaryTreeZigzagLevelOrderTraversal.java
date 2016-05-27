package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * @author jacksen
 * @date 2016-5-27 上午9:46:26
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);

		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;

		BinaryTreeZigzagLevelOrderTraversal traversal = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> result = traversal.zigzagLevelOrder5(node1);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 3ms <br />
	 * 
	 * beats 14.87% of java submissions
	 * 
	 * @author jacksen
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int i = queue.size(); // 记录每层的结点个数
		boolean flag = false;
		TreeNode tempNode = null;
		List<Integer> singleLevel = new ArrayList<>();
		while (!queue.isEmpty()) {
			if (i == 0) {// 一层记录结束
				//
				if (flag) {
					Collections.reverse(singleLevel);
				}
				result.add(singleLevel);
				//
				flag = !flag;

				i = queue.size();
				singleLevel = new ArrayList<>();
			}
			tempNode = queue.poll();
			singleLevel.add(tempNode.val);

			--i;

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}

		}
		if (flag) {
			Collections.reverse(singleLevel);
		}
		result.add(singleLevel);

		return result;
	}

	/**
	 * 递归方式 <br />
	 * 重要的是记录层级, 加上一个标识标识是否集合反向<br />
	 * 
	 * 1ms<br />
	 * eats96.02% of java submissions
	 * 
	 * @author jacksen
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// levelRecursion(root, result, 0, false);
		levelRecursion2(root, result, 0);

		return result;
	}

	/**
	 * 递归方法
	 */
	private void levelRecursion(TreeNode node, List<List<Integer>> result,
			int level, boolean flag) {
		if (node == null) {
			return;
		}
		if (result.size() < level + 1) {// 说明还需要添加一行
			result.add(new LinkedList<Integer>());
		}
		if (flag) {
			((LinkedList<Integer>) result.get(level)).addFirst(node.val);
		} else {
			result.get(level).add(node.val);
		}

		levelRecursion(node.left, result, level + 1, !flag);
		levelRecursion(node.right, result, level + 1, !flag);
	}

	/**
	 * 可以直接通过level层级判断是否需要addFirst，不必要再添加额外的标识
	 * 
	 * @param node
	 * @param result
	 * @param level
	 */
	private void levelRecursion2(TreeNode node, List<List<Integer>> result,
			int level) {
		if (node == null) {
			return;
		}
		if (result.size() < level + 1) {// 说明还需要添加一行
			result.add(new LinkedList<Integer>());
		}
		if (level % 2 != 0) {
			((LinkedList<Integer>) result.get(level)).addFirst(node.val);
		} else {
			result.get(level).add(node.val);
		}

		levelRecursion2(node.left, result, level + 1);
		levelRecursion2(node.right, result, level + 1);
	}

	/**
	 * 用两个栈的方式 <br />
	 * 3ms <br />
	 * beats 14.87% of java submissions
	 * 
	 * @author jacksen
	 * @param node
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> forwardStack = new Stack<>();
		Stack<TreeNode> retrorseStack = new Stack<>();

		forwardStack.push(root);

		TreeNode tempNode = null;
		List<Integer> singleList = new ArrayList<>();
		while (!forwardStack.isEmpty() || !retrorseStack.isEmpty()) {
			while (!forwardStack.isEmpty()) {
				tempNode = forwardStack.pop();
				singleList.add(tempNode.val);
				if (tempNode.left != null) {
					retrorseStack.push(tempNode.left);
				}
				if (tempNode.right != null) {
					retrorseStack.push(tempNode.right);
				}
			}

			if (!singleList.isEmpty()) {
				result.add(singleList);
				singleList = new ArrayList<>();
			}

			while (!retrorseStack.isEmpty()) {
				tempNode = retrorseStack.pop();
				singleList.add(tempNode.val);
				if (tempNode.right != null) {
					forwardStack.push(tempNode.right);
				}
				if (tempNode.left != null) {
					forwardStack.push(tempNode.left);
				}
			}

			if (!singleList.isEmpty()) {
				result.add(singleList);
				singleList = new ArrayList<>();
			}
		}

		return result;
	}

	/**
	 * deque <b>双端队列</b> <br />
	 * 3ms <br/>
	 * beats 14.87% of java submissions
	 * 
	 * @author https://leetcode.com/discuss/89116/java-bfs-with-deque
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder4(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		boolean flag = true;
		TreeNode tempNode = null;
		TreeNode lastNode = root;

		List<Integer> singleLevel = new ArrayList<>();

		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);

		while (!deque.isEmpty()) {
			tempNode = flag ? deque.pollFirst() : deque.pollLast();
			singleLevel.add(tempNode.val);
			if (flag) {// left->right顺序添加到对尾
				if (tempNode.left != null) {
					deque.offerLast(tempNode.left);
				}
				if (tempNode.right != null) {
					deque.offerLast(tempNode.right);
				}
			} else {
				if (tempNode.right != null) {
					deque.offerFirst(tempNode.right);
				}
				if (tempNode.left != null) {
					deque.offerFirst(tempNode.left);
				}
			}
			if (tempNode == lastNode) {
				result.add(singleLevel);// 搞定一层
				singleLevel = new ArrayList<>();
				lastNode = flag ? deque.peekFirst() : deque.peekLast();
				flag = !flag;
			}
		}

		return result;
	}

	/**
	 * 2ms <br />
	 * 
	 * beats 60.36% of java submissions
	 * 
	 * @author jacksen
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder5(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int i = queue.size(); // 记录每层的结点个数
		boolean flag = true;
		TreeNode tempNode = null;
		LinkedList<Integer> singleLevel = new LinkedList<>();
		while (!queue.isEmpty()) {
			if (i == 0) {// 一层记录结束
				//
				result.add(singleLevel);
				//
				i = queue.size();
				singleLevel = new LinkedList<>();
				flag = !flag;
			}
			tempNode = queue.poll();
			if (flag) {
				singleLevel.add(tempNode.val);
			} else {
				singleLevel.addFirst(tempNode.val);
			}

			--i;

			if (tempNode.left != null) {
				queue.offer(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.offer(tempNode.right);
			}

		}
		
		result.add(singleLevel);

		return result;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			this.val = x;
		}
	}
}
