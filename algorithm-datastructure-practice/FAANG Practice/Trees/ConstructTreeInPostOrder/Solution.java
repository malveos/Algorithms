/***
@Author Omkar Malve

106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
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
    public static int rootI = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        rootI = inorder.length - 1;
        
        return buildTree(inorder, postorder, 0,  inorder.length -1);
    }

    private TreeNode buildTree(int[] inOrder, int[] postOrder, int st, int ed) {
        if (st > ed) return null;
        int rootData = postOrder[rootI];
        TreeNode rt = new TreeNode(rootData);
        rootI--;

        // find that root in inorder to divide that array
        int x = -1;
        for (int i = st; i <= ed; i++) {
            if (rootData == inOrder[i]) {
                x = i;
                break;
            }
        }
        
        rt.right = buildTree(inOrder, postOrder, x + 1, ed);//Need to build right first
        rt.left = buildTree(inOrder, postOrder, st, x - 1);
        return rt;
    } 
}