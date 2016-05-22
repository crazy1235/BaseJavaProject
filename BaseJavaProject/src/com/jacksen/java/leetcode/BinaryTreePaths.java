package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. Binary Tree Paths <br />
 * 
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * @author jacksen
 * @date 2016-5-20 下午4:00:28
 */
public class BinaryTreePaths {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;

		//
		BinaryTreePaths bTreePaths = new BinaryTreePaths();

		List<String> resultList = bTreePaths.binaryTreePaths3(node1);
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	public List<String> resultList = new ArrayList<String>();

	/**
	 * 递归方式
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return resultList;
		}
		List<String> singleResult = new ArrayList<>();

		getTreePath(root, singleResult);
		return resultList;
	}

	/**
	 * 
	 * @param resultList
	 * @param node
	 * @param singleResult
	 */
	private void getTreePath(TreeNode node, List<String> singleResult) {
		singleResult.add(node.val + "");
		if (node.left == null && node.right == null) {
			resultList.add(getPath(singleResult));
		}
		if (node.left != null) {
			getTreePath(node.left, new ArrayList<>(singleResult));
		}
		if (node.right != null) {
			getTreePath(node.right, new ArrayList<>(singleResult));
		}
	}

	/**
	 * 
	 * @param singleResult
	 * @return
	 */
	private String getPath(List<String> singleResult) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < singleResult.size() - 1; i++) {
			sb.append(singleResult.get(i) + "->");
		}
		sb.append(singleResult.get(singleResult.size() - 1));
		return sb.toString();
	}

	/**
	 * 递归方法二 <br />
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths2(TreeNode root) {
		if (root == null) {
			return resultList;
		}
		findPaths(root, root.val + "");
		return resultList;
	}

	private void findPaths(TreeNode node, String path) {
		if (node.left == null && node.right == null) {
			resultList.add(path);
		}
		if (node.left != null) {
			findPaths(node.left, path + "->" + node.left.val);
		}
		if (node.right != null) {
			findPaths(node.right, path + "->" + node.right.val);
		}
	}

	/**
	 * 递归方法三 <br />
	 * 在方法二的基础上修改，将String改成StringBuilder <br />
	 * 
	 * https://leetcode.com/discuss/92435/java-2ms-solution-using-stringbuilder
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths3(TreeNode root) {
		findPath(root, new StringBuilder());
		return resultList;
	}

	private void findPath(TreeNode node, StringBuilder sb) {
		if (node == null) {
			return;
		}
		int len = sb.length();
		sb.append(node.val);
		if (node.left == null && node.right == null) {
			resultList.add(sb.toString());
		} else {
			sb.append("->");
			findPath(node.left, sb);
			findPath(node.right, sb);
		}
		sb.setLength(len);// 截取 ！！！
	}

	/**
	 * 通过栈来做<br />
	 * 利用后序非递归遍历二叉树的方法变形而来
	 * 
	 * @param root
	 * @return
	 */

	public static List<String> binaryTreePaths4(TreeNode root) {
		List<String> resultList = new ArrayList<String>();

		if (root == null) {
			return resultList;
		}
		Stack<MarkTreeNode> stack = new Stack<>();
		MarkTreeNode markTreeNode = new MarkTreeNode(root);
		stack.push(markTreeNode);
		while (!stack.isEmpty()) {

			while ((markTreeNode = stack.peek()).node != null) {
				markTreeNode = new MarkTreeNode(markTreeNode.node.left, 1);
				stack.push(markTreeNode);
			}
			//
			stack.pop();
			//

			markTreeNode = stack.peek();
			while (markTreeNode.node != null) {
				if (markTreeNode.mark == 2) {
					resultList.add(getOnePath(stack));
					stack.pop();
					if (stack.isEmpty()) {
						break;
					}
					markTreeNode = stack.peek();
				} else {
					markTreeNode.mark = 2;
					markTreeNode = new MarkTreeNode(markTreeNode.node.right, 1);
					stack.push(markTreeNode);
					break;
				}
			}

			// 叶子结点

			//
			stack.pop();
		}

		return resultList;
	}

	/**
	 * 获取一条路径
	 * 
	 * @param stack
	 * @return
	 */
	public static String getOnePath(Stack<MarkTreeNode> stack) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size() - 1; i++) {
			sb.append(stack.get(i).node.val + "->");
		}
		sb.append(stack.get(stack.size() - 1).node.val);
		return sb.toString();
	}

	/**
	 * 
	 * @author Admin
	 * 
	 */
	private static class MarkTreeNode {
		TreeNode node;
		int mark = 0;// mark=1 表示左子树处理返回，mark=2表示右子数处理结束返回。

		public MarkTreeNode() {

		}

		public MarkTreeNode(TreeNode node) {
			this.node = node;
		}

		public MarkTreeNode(TreeNode node, int mark) {
			this.node = node;
			this.mark = mark;
		}
	}

	/**
	 * 
	 * @author jacksen
	 * @date 2016-5-20 下午4:01:14
	 */
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
