package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}

	}
	public List<Integer> rightSideView(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashMap<TreeNode, Integer> levelMap = new HashMap<TreeNode, Integer>();
		queue.add(root);
		levelMap.put(root, 0);
		int level = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			int curLevel;
			if ((curLevel = levelMap.get(cur)) == level) {
				result.add(cur.val);
				level++;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				levelMap.put(cur.right, curLevel + 1);
			}
			if (cur.left != null) {
				queue.add(cur.left);
				levelMap.put(cur.left, curLevel + 1);
			}
		}
		return result;
	}
}
