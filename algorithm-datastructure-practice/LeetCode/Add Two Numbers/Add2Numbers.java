/**

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newRoot = new ListNode(0) ;
        ListNode curr = newRoot;
        int carry = 0;
        while (null != l1 || null != l2) {
            int sum = (null != l1 ? l1.val : 0) + (null != l2 ? l2.val : 0) + carry;
            carry =  sum / 10;            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if ( null != l1)
                l1 = l1.next;
            if ( null != l2)
                l2 = l2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return newRoot.next;
    }
}