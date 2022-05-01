/***

@Author Omakr Malve

114. Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


***/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        // Structure will be like Root -> left flatten -> right flatten
         if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        //System.out.println("Setting right of " + root.val + " as " + (left == null ?  null : left.val));
        root.right = left;
        //System.out.println("Setting left of " + root.val + " as NULL");
        root.left = null;
        
        //System.out.println("Setting right of from " + (root == null ? null :root.val) +" to rightmost " + cur.val + " as " + (right == null ?  null : right.val));
        while (root.right != null) root = root.right;
        root.right = right;
    }
}