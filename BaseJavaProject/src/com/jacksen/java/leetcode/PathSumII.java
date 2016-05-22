package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * @author jacksen
 * 
 */
public class PathSumII {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		TreeNode node10 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node7;
		node4.right = node8;
		node3.left = node5;
		node3.right = node6;
		node6.right = node9;
		node6.left = node10;

		PathSumII pathSumII = new PathSumII();
		List<List<Integer>> resultList = pathSumII.pathSum2(node1, 22);

		for (int i = 0; i < resultList.size(); i++) {
			for (int j = 0; j < resultList.get(i).size(); j++) {
				System.out.print(resultList.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

	public List<List<Integer>> resultList = new ArrayList<>();

	/**
	 * 方法一：
	 * 
	 * 6ms
	 * 
	 * @author jacksen
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return resultList;
		}

		getTreePath(root, new ArrayList<Integer>(), sum);
		return resultList;
	}

	/**
	 * DFS <br />
	 * 仿照BinaryTreePaths的方法
	 * 
	 * @param resultList
	 * @param node
	 * @param singleResult
	 */
	private void getTreePath(TreeNode node, List<Integer> singleResult, int sum) {
		singleResult.add(node.val);
		if (node.left == null && node.right == null) {
			checkSinglePath(singleResult, sum);
		}
		if (node.left != null) {
			getTreePath(node.left, new ArrayList<>(singleResult), sum);
		}
		if (node.right != null) {
			getTreePath(node.right, new ArrayList<>(singleResult), sum);
		}
	}

	/**
	 * 判断单条路径值总和
	 * 
	 * @param list
	 * @param sum
	 */
	private void checkSinglePath(List<Integer> list, int sum) {
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			temp += list.get(i);
		}
		if (sum == temp) {
			resultList.add(list);
		}
	}

	/**
	 * 方法二 <br />
	 * 5ms
	 * 
	 * @author jacksen
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		getPath(root, new ArrayList<Integer>(), sum);
		return resultList;
	}

	private void getPath(TreeNode root, List<Integer> list, int sum) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				resultList.add(list);
			}
			return;
		}
		getPath(root.left, new ArrayList<Integer>(list), (sum - root.val));
		getPath(root.right, new ArrayList<Integer>(list), (sum - root.val));
	}

	/**
	 * Definition for a binary tree node.
	 * 
	 * @author jacksen
	 * 
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
