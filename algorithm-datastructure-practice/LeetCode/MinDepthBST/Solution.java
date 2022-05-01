/***

@Author Omkar Malve

111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.


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

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // Can find depth level y level using queue
       
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int sz = q.size();
            depth++;

            for (int i = 0 ; i < sz; i++) {
                TreeNode n = q.poll();
                if (n.left == null && n.right == null) // found min Depth
                    return depth;
                if (n.left != null)
                    q.offer(n.left);
                if (n.right != null)
                    q.offer(n.right);
            }
        }
        return depth;        
    }
/*
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if ((l == 0 && r != 0) || (l != 0 && r == 0))
            return (l == 0 ? r : l ) + 1;
        return Math.min(l, r) + 1;     
    }
*/
}