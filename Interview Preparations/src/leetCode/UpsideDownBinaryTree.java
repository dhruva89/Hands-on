package leetCode;

public class UpsideDownBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		/*
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		*/

		new UpsideDownBinaryTree().upsideDownBinaryTree(root);
	}

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode val = flipTree(root.left, root, root.right);
		System.out.println();
		return val;
	}

	public TreeNode flipTree(TreeNode cur, TreeNode prev, TreeNode rightSibling) {
		if (cur == null) {
			return prev;
		}
		TreeNode retVal = flipTree(cur.left, cur, cur.right);
		cur.left = rightSibling;
		cur.right = prev;
		return retVal;
	}

}
