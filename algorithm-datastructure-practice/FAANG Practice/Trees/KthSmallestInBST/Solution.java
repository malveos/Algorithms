/***

@Author Omkar Malve

230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

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
    static int val = -1;
    public int kthSmallest(TreeNode root, int k) {
         Stack<TreeNode> stack= new Stack();
        TreeNode curr=root;
        while(curr!=null)
        {
            stack.push(curr);
            curr=curr.left;
        }
        
        while(!stack.isEmpty())
        {
            TreeNode top=stack.pop();k--;
            if(k==0) return top.val;
            
            curr=top.right;
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
        }
        return -1;
     //   val = k;
     //   return inorder(root);
    }

    public int inorder(TreeNode root) {
        if (root == null) return -1;
        if (val == 0) return root.val;

        // check if it is at left 
        int l = inorder(root.left);
        if (l != -1) return l;

        val--;
        System.out.println("At = "+ root.val + " with val = " + val);
        if (val == 0) {
            return root.val;
        }
        return inorder(root.right);
    }
}