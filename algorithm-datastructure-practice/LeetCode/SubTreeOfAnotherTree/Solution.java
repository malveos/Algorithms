/**

@Author Omkar Malve

572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverseCheck(root, subRoot);
    }

    private boolean traverseCheck(TreeNode rt, TreeNode sr) {
        if (sr == null) return true;
        if (rt == null) return false;
        
        if (isEqual(rt, sr)) {
            return true;
        }
        return traverseCheck(rt.left, sr) || traverseCheck(rt.right, sr);
    }

    private boolean isEqual(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 != null && r2 != null && r1.val == r2.val) {
            return isEqual(r1.left, r2.left) && isEqual(r1.right, r2.right);
        }
        return false;
    }
}