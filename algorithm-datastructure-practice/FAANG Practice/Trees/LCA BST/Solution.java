/***

@Author Omkar Malve

235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


**/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val ) {
            //System.out.println(" Moving left to " + root.left.val) ;
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val ) {
           // System.out.println(" Moving right to " + root.right.val) ;
            return lowestCommonAncestor(root.right, p, q);
        }
       // System.out.println(" Returning " + root.val) ;
        return root;
    }
}