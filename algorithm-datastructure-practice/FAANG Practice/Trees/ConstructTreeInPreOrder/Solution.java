/***
@Author Omkar Malve

105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


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
    public int rootI = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {      
        return buildTree(inorder, preorder, 0,  inorder.length - 1);
    }
    private TreeNode buildTree(int[] inOrder, int[] preorder, int st, int ed) {
        if (st > ed) return null;
        int rootData = preorder[rootI];
        TreeNode rt = new TreeNode(rootData);
        rootI++;

        // find that root in inorder to divide that array
        int x = -1;
        for (int i = st; i <= ed; i++) {
            if (rootData == inOrder[i]) {
                x = i;
                break;
            }
        }
        
        rt.left = buildTree(inOrder, preorder, st, x - 1);
        rt.right = buildTree(inOrder, preorder, x + 1, ed);//Need to build right later
        return rt;
    }
}