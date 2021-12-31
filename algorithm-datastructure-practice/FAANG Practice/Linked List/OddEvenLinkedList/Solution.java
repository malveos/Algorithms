/****

@Author Omkar Malve

328. Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next, evenTail = head.next;
        
        while (evenTail != null && evenTail.next != null) {
            odd.next = evenTail.next;
            odd = odd.next;
            
            evenTail.next = odd.next;
            evenTail = evenTail.next;
        }
        
        odd.next = evenHead;
        return  head;
    }
}