/***

@Author Omkar Malve

Partition List

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

**/

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
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        // maintain two lists with less and greater than x
        ListNode less = new ListNode(0);
        ListNode newH = less;
        ListNode grt = new ListNode(0);
        ListNode mid = grt;
        
        while(head != null) {
            if (head.val < x) {
                less.next = head;
                less = head;
            } else {
                grt.next = head;
                grt = head;
            }
            head = head.next;
        }
        less.next = mid.next;
        grt.next = null; // preventing Loop
        return newH.next;
    }
}