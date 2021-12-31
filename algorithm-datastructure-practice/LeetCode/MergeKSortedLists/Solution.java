/****

@Author Omkar Malve

Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it

*/
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Need to keep track of min of linkedList heads so maintain meanHean for it
        PriorityQueue<ListNode> minHeap = createHeapUsingLists(lists);
        ListNode head = new ListNode(), tail = head;
        
        while(!minHeap.isEmpty()) {
            ListNode curNode = minHeap.poll();
            tail.next = curNode;
            tail = curNode;
            
            if (tail.next != null)
                minHeap.add(tail.next);
        }
        return head.next;
    }

    public PriorityQueue<ListNode> createHeapUsingLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        
        for(ListNode ln: lists) {
            if (ln != null)
                minHeap.add(ln);
        }
        return minHeap;
    }
}