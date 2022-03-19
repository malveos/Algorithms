/****

@Author Omkar Malve


BST to Circular Doubly Linked List


**/

public class Solution {

	TreeNode first = null;
	TreeNode last = null;
	public TreeNode getDoublyLinkedList(TreeNode n) {
		if (n == null) return null;
		
		process(n);
		
		// make circular
		last.right = first;
		first.left = last;
		return first;
	}

	private void process(TreeNode n) {
		if (n != null) {
			process(n.left);
			if (last == null) {
				first = n;
			} else {
				n.left = last;
				last.right = n;
			}
			// update for next iteration
			last = n;
			process(n.right);
		}
	}
}