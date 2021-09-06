/***


@Omkar Malve

100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

**/

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
    public boolean isSameTree(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) return true;
        else if ((p1 != null && p2 == null) || (p1 == null && p2 != null) || (p1.val != p2.val))
            return false;
        else     
        return isSameTree(p1.left, p2.left) && isSameTree(p1.right, p2.right);
    }
}