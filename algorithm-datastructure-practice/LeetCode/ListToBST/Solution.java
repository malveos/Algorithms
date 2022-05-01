/*****

@Author Omkar Malve

109. Convert Sorted List to Binary Search Tree

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
****/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return getTree(head, null);
    }

    private TreeNode getTree(ListNode hd, ListNode ed) {
        if (hd == null || hd == ed) return null;
        ListNode slow = hd, fast = hd;
        while (fast != ed && fast.next != ed) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode n = new TreeNode(slow.val);
        n.left = getTree(hd, slow);
        n.right = getTree(slow.next, ed);
        return n;
    }
}