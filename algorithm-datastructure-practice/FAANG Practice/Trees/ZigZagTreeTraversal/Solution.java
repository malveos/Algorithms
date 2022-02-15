/**

@Author Omkar Malve

103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        if (root  == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int lvl = 0;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if(n == null) {
                if (lvl % 2 == 0) {
                    ans.add(level);
                } else {
                    Collections.reverse(level);
                    ans.add(level);
                }
                lvl++;
                if (!q.isEmpty()) {
                    q.add(null);
                }
                level = new ArrayList<>();
            } else {
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                level.add(n.val);
            }
        }
        return ans;
    }
}