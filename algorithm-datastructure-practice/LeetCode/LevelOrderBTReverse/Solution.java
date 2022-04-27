/***

@Author Omkar Malve

107. Binary Tree Level Order Traversal II

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> st = new LinkedList<>();
        st.add(root);

        while(!st.isEmpty()) {
            int sz = st.size();
            List<Integer> lvl = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = st.poll();
                lvl.add(cur.val);
                if (cur.left != null) st.add(cur.left);
                if (cur.right != null) st.add(cur.right);
            }
            ans.add(lvl);
        }
        Collections.reverse(ans);
        return ans;
    }
}