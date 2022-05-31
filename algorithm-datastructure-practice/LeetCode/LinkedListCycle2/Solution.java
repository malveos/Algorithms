/**

@Author Omkar Malve

142. Linked List Cycle II

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.


***/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode n1= head, n2 = head;
        while (n1 != null && n1.next != null) {
            n1 = n1.next.next;
            n2 = n2.next;
            if (n1 == n2) {
                break;   
            }
        }
        if (n1 == null || n1.next == null) return null;
        while(head != n2) {
            head = head.next;
            n2 = n2.next;
        }
        return head;
    }
}