/***
@Author Omkar Malve


623. Add One Row to Tree

Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        } else {
            addRow(root, val, 1, depth);
            return root;    
        }
    }

    private void addRow(TreeNode n, int val, int depth, int target) {
        if (n == null) return;
        if (depth == target - 1) {
            TreeNode tl = n.left;
            TreeNode tr = n.right;
            n.left = new TreeNode(val);
            n.right = new TreeNode(val);
            n.left.left = tl;
            n.right.right = tr;
            return;
        } else {
            addRow(n.left, val, depth + 1, target);
            addRow(n.right, val, depth + 1, target);
        }
    }
}