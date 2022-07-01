/**

@Author Omkar Malve

148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.

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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        //System.out.println("Mid is " + slow.val);
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(slow);
        
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
            l1 = l1.next;
        }
        if(l2 != null) {
            cur.next = l2;
            l2 = l2.next;
        }
        return dummyNode.next;
    }

    private ListNode insertionSort(ListNode head) {
       if(head==null || head.next==null){
            return head;
        }
        
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