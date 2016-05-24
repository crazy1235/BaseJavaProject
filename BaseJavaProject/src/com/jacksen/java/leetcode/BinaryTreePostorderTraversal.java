package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * @author jacksen
 * @date 2016-5-23 下午4:00:06
 */
public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;

		BinaryTreePostorderTraversal traversal = new BinaryTreePostorderTraversal();
		List<Integer> list = traversal.postorderTraversal6(node1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	private List<Integer> resultList = new ArrayList<Integer>();

	/**
	 * 递归方式 <br />
	 * 1ms
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		postOrder(root);
		return resultList;
	}

	private void postOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			postOrder(node.left);
		}
		if (node.right != null) {
			postOrder(node.right);
		}
		resultList.add(node.val);
	}

	/**
	 * 后续遍历非递归方法
	 * 
	 * @author jacksen
	 * @param node
	 */
	public List<Integer> postorderTraversal1(TreeNode node) {
		if (node == null) {
			return resultList;
		}
		Stack<WrapperNode> stack = new Stack<>();
		WrapperNode wrapperNode = new WrapperNode(node, false);
		stack.push(wrapperNode);
		while (!stack.isEmpty()) {
			while ((wrapperNode = stack.peek()).node != null) {
				wrapperNode = new WrapperNode(wrapperNode.node.left, false);
				stack.push(wrapperNode);
			}
			//
			stack.pop();
			//
			wrapperNode = stack.peek();
			while (wrapperNode.node != null) {
				if (wrapperNode.isFinished) {
					resultList.add(stack.pop().node.val);
					if (stack.isEmpty()) {
						return resultList;
					}
					wrapperNode = stack.peek();
				} else {
					wrapperNode.isFinished = true;
					wrapperNode = new WrapperNode(wrapperNode.node.right, false);
					stack.push(wrapperNode);
					break;
				}
			}
		}
		return resultList;
	}

	/**
	 * 非递归方式 <br />
	 * 3ms <br />
	 * http://www.cnblogs.com/Antech/p/3655594.html
	 * 
	 * @param root
	 * @return
	 */
	private List<Integer> postorderTraversal2(TreeNode root) {
		if (root == null) {
			return resultList;
		}
		Stack<WrapperNode> stack = new Stack<>();
		stack.push(new WrapperNode(root, false));
		WrapperNode wrapperNode = null;
		while (!stack.isEmpty()) {
			wrapperNode = stack.peek();
			if (wrapperNode.node == null) {
				stack.pop();
				continue;
			}
			if (wrapperNode.isFinished) {
				resultList.add(stack.pop().node.val);
			} else {
				stack.push(new WrapperNode(wrapperNode.node.right, false));
				stack.push(new WrapperNode(wrapperNode.node.left, false));
				wrapperNode.isFinished = true;
			}
		}
		return resultList;
	}

	/**
	 * 方法二非递归方式的改进 <br />
	 * 3ms <br />
	 * 
	 * @param root
	 * @return
	 */
	private List<Integer> postorderTraversal3(TreeNode root) {
		if (root == null) {
			return resultList;
		}
		Stack<WrapperNode> stack = new Stack<>();
		stack.push(new WrapperNode(root, false));
		WrapperNode wrapperNode = null;
		while (!stack.isEmpty()) {
			wrapperNode = stack.peek();
			if (wrapperNode.isFinished) {
				resultList.add(stack.pop().node.val);
			} else {
				wrapperNode.isFinished = true;
				if (wrapperNode.node.right != null) {
					stack.push(new WrapperNode(wrapperNode.node.right, false));
				}
				if (wrapperNode.node.left != null) {
					stack.push(new WrapperNode(wrapperNode.node.left, false));
				}
			}
		}
		return resultList;
	}

	/**
	 * 使用两个栈 <br />
	 * 2ms <br />
	 * 
	 * https://leetcode.com/discuss/102843/my-ac-java-solution-using-two-stacks
	 * 
	 * @param root
	 * @return
	 */
	private List<Integer> postorderTraversal4(TreeNode root) {
		if (root == null) {
			return resultList;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		stack1.push(root);

		TreeNode tempNode = null;

		while (!stack1.isEmpty()) {
			tempNode = stack1.pop();
			if (tempNode.left != null) {
				stack1.push(tempNode.left);
			}
			if (tempNode.right != null) {
				stack1.push(tempNode.right);
			}
			stack2.push(tempNode);
		}

		while (!stack2.isEmpty()) {
			resultList.add(stack2.pop().val);
		}

		return resultList;
	}

	/**
	 * https://leetcode.com/discuss/71943/preorder-inorder-and-postorder-
	 * iteratively-summarization <br />
	 * 
	 * LinkedList
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal5(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tempNode = root;
		while (!stack.isEmpty() || tempNode != null) {
			if (tempNode != null) {
				stack.push(tempNode);
				list.addFirst(tempNode.val);
				tempNode = tempNode.right;
			} else {
				tempNode = stack.pop().left;
			}
		}

		return list;
	}

	/**
	 * 非递归方式 <br />
	 * 
	 * 参考 Pre order 的preorderTraversal2
	 * 
	 * @author jacksen
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal6(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode tempNode = null;
		while (!stack.isEmpty()) {
			tempNode = stack.pop();
			list.addFirst(tempNode.val);
			if (tempNode.left != null) {
				stack.push(tempNode.left);
			}
			if (tempNode.right != null) {
				stack.push(tempNode.right);
			}
		}
		return list;
	}

	/**
	 * TreeNode包装类
	 * 
	 * @author jacksen
	 * @date 2016-5-23 下午4:25:51
	 */
	private static class WrapperNode {
		TreeNode node;
		boolean isFinished;

		public WrapperNode(TreeNode node, boolean isFinished) {
			this.node = node;
			this.isFinished = isFinished;
		}
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
