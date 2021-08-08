/**

@Author Omkar Malve

Rotate List

Given the head of a linked list, rotate the list to the right by k places.

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
    public ListNode rotateRight(ListNode head, int k) {
        // go to n-k Node make its next null by keeping a temp
        // attach last of temp a head and temp head is new head.
        
        if (head == null || head.next == null)
            return head;

        int count = 1;
        ListNode originalHead = head;
        while (head.next!=null) {
            head = head.next;
            count++;
        }
        
        if (k == count)
            return originalHead;
        // join last to first
        head.next = originalHead;
        k = k%count;
        
        // n - k nodes
        int smallPart = count - k;
        // count from start
        head = originalHead;
        while(smallPart>1) {
            head = head.next; smallPart--;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}