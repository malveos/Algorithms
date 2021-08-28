/****

@Author Omkar Malve

95. Unique Binary Search Trees II

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.




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
    public List<TreeNode> generateTrees(int n) {
        // create all possible left and right subtrees and create a tree
        return generateTree(1, n);
    }
    
    private List<TreeNode> generateTree(int st, int ed) {
        List<TreeNode> res = new ArrayList<>();
        if (st > ed) {
            res.add(null);
            return res;
        }
         if (st == ed) {
             res.add(new TreeNode(st));
             return res;
         }
        
        for (int i = st;i <= ed; i++ ) {
            List<TreeNode> leftSubTree = generateTree(st, i - 1);
            List<TreeNode> rightSubTree = generateTree(i + 1, ed);
            for (TreeNode lSt : leftSubTree) {
                for (TreeNode rSt : rightSubTree) {
                    TreeNode rot = new TreeNode(i);
                    rot.left = lSt;
                    rot.right = rSt;
                    res.add(rot);
                }
            }
        }
        
        return res;
    }
}