package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

		List<String> resultList = bTreePaths.binaryTreePaths4(node1);
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	public List<String> resultList = new ArrayList<String>();

	/**
	 * 递归方式
	 * 
	 * <br />
	 * 
	 * Run Time : 4ms
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
	 * DFS
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
	 * https://leetcode.com/discuss/85025/sharing-my-recursive-java-solution
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
	 * 
	 * 在方法二的基础上修改，将String改成StringBuilder <br />
	 * 
	 * https://leetcode.com/discuss/92435/java-2ms-solution-using-stringbuilder
	 * 
	 * <br />
	 * 
	 * Run Time : 2ms
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
	 * 
	 * https://leetcode.com/discuss/83013/my-java-non-recursion-solution-using-
	 * stack-and-wrapper
	 * 
	 * <br />
	 * 
	 * Run Time : 5ms
	 * 
	 * @param root
	 * @return
	 */

	public List<String> binaryTreePaths4(TreeNode root) {
		if (root == null) {
			return resultList;
		}

		Stack<Wrapper> stack = new Stack<>();
		stack.add(new Wrapper(root, root.val + ""));
		Wrapper wrapper = null;
		while (!stack.isEmpty()) {
			wrapper = stack.pop();
			if (wrapper.node.left == null && wrapper.node.right == null) {
				resultList.add(wrapper.path);
			}
			if (wrapper.node.left != null) {
				stack.add(new Wrapper(wrapper.node.left, wrapper.path + "->"
						+ wrapper.node.left.val));
			}
			if (wrapper.node.right != null) {
				stack.add(new Wrapper(wrapper.node.right, wrapper.path + "->"
						+ wrapper.node.right.val));
			}
		}

		return resultList;
	}

	/**
	 * 
	 * @author Admin
	 * 
	 */
	private static class Wrapper {
		TreeNode node;
		String path;

		public Wrapper() {

		}

		public Wrapper(TreeNode node) {
			this.node = node;
		}

		public Wrapper(TreeNode node, String path) {
			this.node = node;
			this.path = path;
		}
	}

	/**
	 * BFS <br />
	 * 
	 * with two Queue
	 * 
	 * https://leetcode.com/discuss/67749/bfs-with-two-queue-java-solution
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths5(TreeNode root) {
		if (root == null) {
			return resultList;
		}
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<String> pathQueue = new LinkedList<>();
		nodeQueue.offer(root);
		pathQueue.offer(root.val + "");
		while (!nodeQueue.isEmpty()) {
			TreeNode currNode = nodeQueue.poll();
			String item = pathQueue.poll();
			if (currNode.left == null && currNode.right == null) {
				resultList.add(item);
			}
			if (currNode.left != null) {
				nodeQueue.offer(currNode.left);
				pathQueue.offer(item + "->" + currNode.left.val);
			}
			if (currNode.right != null) {
				nodeQueue.offer(currNode.right);
				pathQueue.offer(item + "->" + currNode.right.val);
			}
		}

		return resultList;
	}

	/**
	 * 不需要多创建一个函数 <br />
	 * 
	 * 3ms
	 * 
	 * https://leetcode.com/discuss/55451/clean-solution-accepted-without-helper
	 * -recursive-function
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths6(TreeNode root) {
		List<String> pathsList = new ArrayList<String>();

		if (root == null) {
			return pathsList;
		}

		if (root.left == null && root.right == null) {
			pathsList.add(root.val + "");
			return pathsList;
		}

		for (String path : binaryTreePaths6(root.left)) {
			pathsList.add(root.val + "->" + path);
		}

		for (String path : binaryTreePaths6(root.right)) {
			pathsList.add(root.val + "->" + path);
		}

		return pathsList;
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
