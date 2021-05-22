/****
19. Remove Nth Node From End of List



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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // get to nth node and then start from first node
        int npos = n;
        ListNode forwardPtr = head;
        while (npos> 0) {
            if (forwardPtr == null)
                return head;
            forwardPtr = forwardPtr.next;
            npos--;
        }
        if (null == forwardPtr) {
            return head.next;
        }
        ListNode node = head;
        while (forwardPtr.next != null) {
            forwardPtr = forwardPtr.next;
            node = node.next;
        }
        if (node.next !=null)
            node.next = node.next.next;
        return head;
    }
}