/**

@Author Omkar Malve

94. Binary Tree Inorder Traversal
Given the root of a binary tree, return the inorder traversal of its nodes' values.


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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new LinkedList<>();
        inOrder(root, ls);
        return ls;
    }

    private void inOrder(TreeNode rt, List<Integer> ls) {
        if (rt == null) return;
        inOrder(rt.left, ls);
        ls.add(rt.val);
        inOrder(rt.right, ls);
    }
}