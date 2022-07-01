/***

@Author Omkar Malve

160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node


**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getBySync(headA, headB);
    }

    private ListNode getBySync(ListNode h1, ListNode h2){
        ListNode a = h1;
        ListNode b = h2;
        
        while(a != b) {
            a = a != null ? a.next : h2;
            b = b != null ? b.next : h1;
        }
        
        return a;
    }

    private ListNode getBYBruteForce(ListNode headA, ListNode headB) {
        ListNode a1 = headA;
        ListNode a2 = headB;
        while(headA != null) {
            a2 = headB;
            while(headB != null) {
                //System.out.println("Comparing " + headA.val + " and " + headB.val);
                if(headA == headB) 
                    return headA;
                headB = headB.next;
            }
            headB = a2;
            headA = headA.next;
        }
        return null;
    }
}