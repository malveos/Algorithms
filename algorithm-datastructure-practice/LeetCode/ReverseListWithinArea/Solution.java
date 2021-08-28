/***
92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.


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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head || left >= right) return head;
        
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode cur = prev;// one node before the head
        int count  = 1;
        
        // iterrate to left
        while (count != left && head.next != null) {
            cur = cur.next;
            head = head.next;
            count++;
        }
        // reverse till the the right pointer/position
        while(count < right) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = cur.next;
            cur.next = tmp;
            
            count += 1;
        }
        return prev.next;
    }
}