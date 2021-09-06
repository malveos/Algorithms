/***

@Author Omkar Malve

99. Recover Binary Search Tree

You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

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
    TreeNode prev, pos1, pos2;
    int count = 0;
    public void recoverTree(TreeNode root) {
        // Do inorder traversal and find positions where root < left
        inOrder(root);
        swapValue(pos1, pos2);
    }

    private void swapValue(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if(prev != null && root.val < prev.val) {
            count++;
            if (count == 1 && pos1 == null)
                pos1 = prev;
            pos2 =root;
        }
        prev = root;
        inOrder(root.right);
    }
}