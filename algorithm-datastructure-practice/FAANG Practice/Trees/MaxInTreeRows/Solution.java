/**

@Author Omkar Malve

515. Find Largest Value in Each Tree Row

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);// Preventing the level 
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n != null) {
                  max = Math.max(n.val, max);
                  if (n.left != null)  q.add(n.left);
                  if (n.right != null) q.add(n.right);
            } else { //level ends
                ans.add(max);
                max = Integer.MIN_VALUE;
                if (!q.isEmpty()) q.add(null);
            }
        }
        return ans;
    }
}