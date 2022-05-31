/*

@Author Omakr Malve

144. Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }

    private void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preOrder(root.left, ans);        
        preOrder(root.right, ans);
    }

    private void postOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        postOrder(root.left, ans);        
        postOrder(root.right, ans);
        ans.add(root.val);
    }
}