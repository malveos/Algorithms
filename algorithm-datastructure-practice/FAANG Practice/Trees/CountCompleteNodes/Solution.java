/***

@Author Omkar Malve

222. Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.




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
    public int countNodes(TreeNode root) {
        
        // Total number of nodes at depth d is 2^d - 1, then we can find nodes in last level by Binary search. Also we can find from the left as all nodes from the left will be comple node.
        
        if (root == null) return 0;
        int depth = getDepth(root);
        if (depth == 0) return 1;// Only root node
        
        int l = 1, r = (int) Math.pow(2, depth);
        int lastNodes = 0;
        while (l <= r) {
            int mid = (l + r)/2;
            if (isAtLeft(root, mid, depth)) {// All lefts are complete
                lastNodes = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return (int)Math.pow(2, depth) - 1 + lastNodes;
    }
    
    private int getDepth(TreeNode n) {
        int ct = 0;
        while(n.left != null){
            n = n.left; 
            ct++;
        }
        return ct;
    }

    private boolean isAtLeft(TreeNode rt, int mid, int d) {
        int l = 1, r = (int) Math.pow(2, d);
        int p = 0;
        for (int i = 0; i < d; i++) {
            p =  (l + r)/2;
            if(p >= mid) {
                rt = rt.left;
                r = p;
            } else {
                rt = rt.right;
                l = p + 1;
            }
        }
        return rt != null;
    }
}