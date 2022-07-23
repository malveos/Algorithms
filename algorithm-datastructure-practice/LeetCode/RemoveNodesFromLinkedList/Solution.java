/***

@Author Omkar Malve

203. Remove Linked List Elements

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode();
        temp.next = head;
        
        ListNode prev = temp;
        while(head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else
                prev = head;
            head = head.next;
        }
        
        return temp.next;
    }
}