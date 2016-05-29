package com.jacksen.java.leetcode;

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

		int[] preorder = new int[] { 1, 2, 4, 3, 5, 6 };
		int[] inorder = new int[] { 4, 2, 1, 5, 3, 6 };

		TreeNode rootNode = build.buildTree(preorder, inorder);
		
	}

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

		TreeNode rootNode = new TreeNode(preorder[0]);

//		build(root, pre, in);
		
		return rootNode;
	}
	
	public void build(TreeNode root, String pre, String in){
		
	}

	public int getIndexInInorder(int[] inorder, int val) {
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i]) {
				return i;
			}
		}
		return -1;
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
