/***

@Author Omkar Malve

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



***/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()) {
            Node n = q.poll();
            if (n != null) {
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                n.next = q.peek();
            } else {
                if (!q.isEmpty())
                    q.add(null);
            }
        }
        
        return root;
    }
}