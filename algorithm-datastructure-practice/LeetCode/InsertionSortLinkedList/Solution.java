/**

@Author Omkar Malve

147. Insertion Sort List

Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode cur = head, dummyHead = new ListNode(0);
        ListNode curPre = dummyHead, nx;
        while (cur != null) {
            nx = cur.next;

            while(curPre.next != null && curPre.next.val < cur.val) {
                curPre = curPre.next;
            }
            // insert between curPre and curPre.next
            cur.next = curPre.next;
            curPre.next = cur;
            curPre = dummyHead;
            cur = nx;
        }
        return dummyHead.next;
    }
}