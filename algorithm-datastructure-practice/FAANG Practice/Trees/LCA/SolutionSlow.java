/***
@Author Omkar Malve

236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
***/
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
    private boolean find(TreeNode n, TreeNode target) {
        if (n == null)
            return false;
        return (n.val == target.val) || find(n.left, target) || find(n.right, target);
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        
        if (find(root.left, p)) {
            if (find(root.right, q))
                return root; 
            else
                return lowestCommonAncestor(root.left, p, q);
        } else if (find(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}