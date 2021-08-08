/**

@author Omkar Malve

Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode cur = head.next; // wan to start from second position
    
        while (cur != null) {
            if (cur.val != prev.val) { // non uniq                
                prev.next = cur;
                prev = prev.next;
            }
            cur = cur.next;
        }
        prev.next = null;
        return head;
    }
}