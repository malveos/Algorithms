/***

@Author Omkar Malve

113. Path Sum II
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        addSum(root, ans, new ArrayList<>(), targetSum);
        return ans;
    }

    public void addSum(TreeNode root, List<List<Integer>> ans , List<Integer> curPath, int targetSum) {
        if (root == null) return;
        
        curPath.add(root.val);
        targetSum -= root.val;
        // if leaf and path become zero
        if (root.left == null && root.right == null && 0 == targetSum) {
            ans.add(new ArrayList<>(curPath));
        }
        
        addSum(root.left, ans, curPath, targetSum);
        addSum(root.right, ans, curPath, targetSum);
        curPath.remove(curPath.size() - 1);
    }    
}