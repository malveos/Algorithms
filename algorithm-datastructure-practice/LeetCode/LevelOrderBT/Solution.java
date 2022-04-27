/***

@Author Omkar Malve

102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);        

        while(!q.isEmpty()) {
            int lvlSize = q.size();
            List<Integer> lvl = new ArrayList<>();
            for (int i = 0; i < lvlSize; i++) {
                TreeNode cur = q.poll();
                lvl.add(cur.val);

                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);            
            }
            ans.add(lvl); 
        }
        return ans;
    }
}