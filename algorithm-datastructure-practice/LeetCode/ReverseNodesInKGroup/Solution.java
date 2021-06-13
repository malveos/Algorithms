/***
25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



***/

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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        if (len < k)
            return head;
        
        ListNode prev = null, next = null, cur = head;
        int ct = 0;
		// Reverse first k nodes
        while (cur!=null && ct  < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;            
            ct++;
        }
 
		// Recursively reverse next k nodes
        if (next!=null)
            head.next = reverseKGroup(next, k);
        return prev;        
    }
    
    public int getLength(ListNode hd) {
        int ct = 0;
        while (hd!=null) {
            hd = hd.next;
            ct++;
        }
        return ct;
    }
}