package com.jacksen.java.leetcode;

import java.util.ArrayList;
import java.util.Stack;

import com.jacksen.java.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-
 * postorder-traversal/
 * 
 * @author jacksen
 * 
 */
public class ConBTFromInAndPost {
	public static void main(String[] args) {

		ConBTFromInAndPost con = new ConBTFromInAndPost();

		int[] postorder = new int[] { 4, 2, 5, 6, 3, 1 };
		int[] inorder = new int[] { 4, 2, 1, 5, 3, 6 };

		TreeNode rootNode = con.buildTree2(inorder, postorder);
	}

	/**
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		if (postorder == null || postorder.length == 0) {
			return null;
		}
		if (inorder.length != postorder.length) {
			return null;
		}

		return doBuildTree(inorder, postorder, postorder.length - 1, 0,
				inorder.length - 1);
	}

	/**
	 * 20ms <br />
	 * beats 31.29% of java submissions.
	 * 
	 * @param inorder
	 * @param postorder
	 * @param postIndex
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public TreeNode doBuildTree(int[] inorder, int[] postorder, int postIndex,
			int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}
		TreeNode node = new TreeNode(postorder[postIndex]);

		int currentIndex;
		// 找到当前结点在inorder中的位置
		for (currentIndex = startIndex; currentIndex <= endIndex; currentIndex++) {
			if (postorder[postIndex] == inorder[currentIndex]) {
				break;
			}
		}

		if (currentIndex < endIndex) {
			node.right = doBuildTree(inorder, postorder, postIndex - 1,
					currentIndex + 1, endIndex);
		}

		// 下次postorder的下标应该是【postIndex - 当前结点右子树的长度(currentIndex + 1 ~ endIndex)
		// - 1】
		if (currentIndex > startIndex) {
			node.left = doBuildTree(inorder, postorder, postIndex
					- (endIndex - (currentIndex + 1) + 1) - 1, startIndex,
					currentIndex - 1);
		}

		return node;
	}

	/**
	 * 22ms <br />
	 * beats 13.33% of java submissions.
	 * 
	 * @param inorder
	 * @param postorder
	 * @param postIndex
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public TreeNode doBuildTree2(int[] inorder, int[] postorder, int postIndex,
			int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}
		TreeNode node = new TreeNode(postorder[postIndex]);

		int currentIndex;
		// 找到当前结点在inorder中的位置
		for (currentIndex = startIndex; currentIndex <= endIndex; currentIndex++) {
			if (postorder[postIndex] == inorder[currentIndex]) {
				break;
			}
		}

		if (currentIndex < endIndex) {
			node.right = doBuildTree(inorder, postorder, postIndex - 1,
					currentIndex + 1, endIndex);
		}

		// 下次postorder的下标应该是
		// 【postIndex - 当前结点右子树的长度(currentIndex + 1 ~ endIndex) - 1】
		if (currentIndex > startIndex) {
			node.left = doBuildTree(inorder, postorder, postIndex - endIndex
					+ currentIndex - 1, startIndex, currentIndex - 1);
		}

		return node;
	}

	/**
	 * 非递归方式<br />
	 * 5ms<br/>
	 * beats 77.06% of java submissions.<br/>
	 * 
	 * https://leetcode.com/discuss/23834/java-iterative-solution-with-
	 * explanation
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree2(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		if (postorder == null || postorder.length == 0) {
			return null;
		}
		if (inorder.length != postorder.length) {
			return null;
		}

		int inIndex = inorder.length - 1;

		int postIndex = postorder.length - 1;

		TreeNode prev = null;
		TreeNode root = new TreeNode(postorder[postIndex]);

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		postIndex--;

		// 此处不能以栈非空为判断条件，以postorder遍历结束为循环结束条件。
		while (postIndex >= 0) {

			while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
				prev = stack.pop();
				inIndex--;
			}
			TreeNode node = new TreeNode(postorder[postIndex]);
			if (prev != null) {
				prev.left = node;
			} else if (!stack.isEmpty()) {
				TreeNode currTop = stack.peek();
				currTop.right = node;
			}
			stack.push(node);
			prev = null;

			postIndex--;
		}

		return root;
	}

}
