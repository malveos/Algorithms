/**

@Author Omkar Malve

108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

-**/
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
    public TreeNode sortedArrayToBST(int[] nums) {        
        return getTree(nums, 0, nums.length - 1);
    }

    private TreeNode getTree(int[] nums, int st, int ed) {
        if (st > ed) return null;
        int mid = (st + ed)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = getTree(nums, st, mid - 1);
        n.right = getTree(nums, mid + 1, ed);
        return n;
    }
}