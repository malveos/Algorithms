/***

@Author Omkar Malve

654. Maximum Binary Tree

You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.



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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getTree(nums, 0, nums.length);
    }

    private TreeNode getTree(int[] nums, int st, int ed) {
        if (st == ed) return null;
        int mid = getMax(nums, st, ed);
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getTree(nums, st, mid);
        root.right = getTree(nums, mid + 1, ed);
        return root;
    }

    private int getMax(int[] nums, int st, int ed) {
        int mx = st;
        for (int x = st; x < ed; x++) {
            if(nums[mx] < nums[x]) {
                mx = x;
            }
        }
        return mx;
    }
}