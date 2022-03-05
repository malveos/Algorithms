/***

@Author Omkar Malve

1305. All Elements in Two Binary Search Trees

Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.


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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        
        List<Integer> res = new ArrayList<>();
        
        while(root1 != null || root2 != null || !st1.empty() || !st2.empty()){
            while(root1 != null) { // add all lefts
                st1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null) {
                st2.push(root2);
                root2 = root2.left;
            }

            // starting from left small add till both left parts are in list
            if(st2.empty() || (!st1.empty() && st1.peek().val <= st2.peek().val)){
                root1 = st1.pop();
                //System.out.println("L - " + root1.val);
                res.add(root1.val);
                root1 = root1.right;
            }
            else{
                root2 = st2.pop();
                //System.out.println("R - " + root2.val);
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}