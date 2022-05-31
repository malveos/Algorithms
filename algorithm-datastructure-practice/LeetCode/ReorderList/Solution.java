/***

@Author Omkar Malve

143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.


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
    public void reorderList(ListNode head) {
        ListNode hd = head;
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode later = mid.next;
        mid.next = null;
        // List<ListNode> rightPart = new ArrayList<>();
        // while(later!= null) {
        //     rightPart.add(later);
        //     later = later.next;
        // }
        later = reverse(later);
        // Collections.reverse(rightPart);
        // Iterator<ListNode> itr = rightPart.iterator();
        // while(hd != null) {
        //     ListNode tmp = hd.next;
        //     ListNode md = later;//itr.hasNext() ? itr.next() : null;
        //     if (md != null) {
        //         hd.next = md;
        //         md.next = tmp;
        //         hd = tmp;
        //         later = later.next;
        //     } else {
        //         break;
        //     }
        // }
        while(later != null) {
            // break off head of second list
            ListNode temp = later;
            later = later.next;
            temp.next = hd.next;
            hd.next = temp;
            hd = temp.next;
        }
    }

    private ListNode reverse(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode first = head;
        ListNode second = first.next;
        ListNode tail = null;
        
        while(second != null) {
            first.next = tail;
            tail = first;
            first = second;
            second = second.next;
        }
        first.next = tail;   
        return first;
    }
}