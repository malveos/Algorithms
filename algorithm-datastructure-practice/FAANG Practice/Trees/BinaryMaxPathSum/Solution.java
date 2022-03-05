/****

@Author Omkar Malve

124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

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
    private static int ans;
    public int maxPathSum(TreeNode root) {
        // recursilvey find at a node if it can be sued for path or only left /right can be used
        ans = Integer.MIN_VALUE;
        findMax(root);
        return ans;
    }
    
    private int findMax(TreeNode root) {
        if (root == null) return 0;
        
        int l = findMax(root.left);
        int r = findMax(root.right);
        // return max of all, root, root + one child 
        int all = l + r + root.val;
        int linearMax = Math.max(Math.max(l , r) + root.val, root.val);
        int tmp = Math.max(all, linearMax);
        if (ans < tmp) {
            ans = tmp;
        }
        // return as linear path max only
        return linearMax;
        
    }
}
