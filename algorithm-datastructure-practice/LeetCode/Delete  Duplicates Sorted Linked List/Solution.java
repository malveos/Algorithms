/***

@Author Omkar Malve

82. Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

*/
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
        if(head == null)
            return head;
        ListNode prev = head, prevprev = null;
        ListNode cur = head.next; // wan to start from second position
    
        while (cur != null) {
            if (cur.val != prev.val) { // non uniq
                prevprev= prev;
                prev = cur;
                cur = cur.next;
            } else { // dulpicate case
                while(cur != null && cur.val == prev.val) {
                    cur = cur.next;
                }

                if (prevprev == null) { // duplicaes at first
                    head = cur;
                } else { // updating prevprev 
                    prevprev.next = cur; // attaching prev non uniq to next non uniq
                }
                prev = cur;
                if(cur != null) // nullpointer if duplicates at last
                    cur = cur.next;
            }
        }
        
        return head;
    }
}