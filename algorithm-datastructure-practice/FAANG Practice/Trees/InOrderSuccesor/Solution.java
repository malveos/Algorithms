/***

@Author Omkar Malve

Inorder succesor for BST

***/

public class Solution {

	public static found = false;
	public TreeNode getInOrderSuccesor(TreeNode n, int val) {
		if (n == null) return null;
		
		TreeNode left = getInOrderSuccesor(n.left, val);
		if (left != null) return left;
		
		if (n.val == val) {
			found = true;
			return null;
		}
		if (found == true) {
			found = false;
		}
			
		TreeNode right = getInOrderSuccesor(n.right, val);
		if (right != null) return right;
		else return null;
	}
}