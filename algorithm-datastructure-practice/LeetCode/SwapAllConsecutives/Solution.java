/***
@Author Omkar Malve

 Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        return swap(head);
    }
    
    public ListNode swap(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode newHead = node.next;
        ListNode nNext = node.next.next;
        newHead.next = node;
        node.next = swap(nNext);
        return newHead;
    }
}