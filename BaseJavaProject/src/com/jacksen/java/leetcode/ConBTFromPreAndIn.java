package com.jacksen.java.leetcode;

import com.jacksen.java.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder
 * -traversal/
 * 
 * @author Admin
 * 
 */
public class ConBTFromPreAndIn {
	public static void main(String[] args) {

		ConBTFromPreAndIn build = new ConBTFromPreAndIn();

		int[] preorder = new int[] { 1, 2, 3 };
		int[] inorder = new int[] { 2, 3, 1 };

		TreeNode rootNode = build.buildTree(preorder, inorder);
		System.out.println(rootNode.val);
	}

	/**
	 * 8ms <br />
	 * beats 73.81% of java submissions.
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		if (inorder == null || inorder.length == 0) {
			return null;
		}

		if (preorder.length != inorder.length) {
			return null;
		}

		return build(preorder, inorder, 0, 0, inorder.length - 1);
	}

	public TreeNode build(int[] preorder, int[] inorder, int preIndex,
			int startInIndex, int endInIndex) {
		if (endInIndex < startInIndex) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[preIndex]);

		// the index of current node in inorder
		int index = getIndexInInorder(inorder, preorder[preIndex]);
		int lenL = index - startInIndex;
		int lenR = endInIndex - startInIndex - lenL;

		if (lenL > 0) {
			node.left = build(preorder, inorder, preIndex + 1, startInIndex,
					index - 1);
		}
		if (lenR > 0) {
			node.right = build(preorder, inorder, preIndex + lenL + 1,
					index + 1, endInIndex);
		}

		return node;
	}

	/**
	 * 改进算法<br />
	 * 19ms <br/>
	 * beats 52.29% of java submissions.
	 * 
	 * @param preorder
	 * @param inorder
	 * @param preIndex
	 * @param startInIndex
	 * @param endInIndex
	 * @return
	 */
	public TreeNode build2(int[] preorder, int[] inorder, int preIndex,
			int startInIndex, int endInIndex) {
		if (endInIndex < startInIndex) {
			return null;
		}
		int currentVal = preorder[preIndex];
		TreeNode node = new TreeNode(currentVal);

		// the index of current node in inorder
		int index;
		for (index = startInIndex; index <= endInIndex; index++) {
			if (currentVal == inorder[index]) {
				break;
			}
		}
		// int lenL = index - startInIndex;
		// int lenR = endInIndex - index;

		if (index > startInIndex) {
			node.left = build(preorder, inorder, preIndex + 1, startInIndex,
					index - 1);
		}
		if (endInIndex > index) {
			node.right = build(preorder, inorder, preIndex + index
					- startInIndex + 1, index + 1, endInIndex);
		}

		return node;
	}

	public int getIndexInInorder(int[] inorder, int val) {
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i]) {
				return i;
			}
		}
		return -1;
	}

}
