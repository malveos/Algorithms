/**

@Author Omkar Malve

138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 
***/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // add duplicate after each node and the move randome pointer to new duplicate

        if (head == null) return null;

        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        //print(head, "Duplicate Added");
        // Add random ptr to list
       
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // MAke lists seperate
        cur = head;
        Node cpy = cur.next;
        Node nwHead = cpy;
        while (cpy != null) {
            cur.next = cpy.next;
            if (cur.next != null)
                cpy.next = cur.next.next;
            
            cur = cur.next;cpy = cpy.next;
        }
        
       // print(head, "Old List");
       // print(nwHead, "New List");
        return nwHead;
    }

    private void print(Node n, String s) {
        System.out.println("\n" + s);
        while (n != null) {
            System.out.print("->" + n.val + " ");
            n = n.next;
        }
        
    }
}