/**

@Author Omkar Malve

1209. Remove All Adjacent Duplicates in String II

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

***/
class Solution {
    class Node {
        char c;
        int sq;
        Node(char c, int sq) {
            this.c = c;
            this.sq = sq;
        }
        public String toString() {
            return "[ Node: " + c + " , " + sq + "]";
        }
    }

    public String removeDuplicates(String s, int k) {
        ArrayDeque<Node> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty() || st.peekLast().c != c) {
                //System.out.println("Adding " + new Node(c, 1));
                st.addLast(new Node(c, 1));
            } else if (st.peekLast().c == c) {
                st.peekLast().sq++;
                //System.out.println("Char  " + c + " count = " + st.peekLast().sq);
            } 
            if (st.peekLast().sq == k) {
                //System.out.println("Removing char as count matched: " + st.peekLast().c);
                st.removeLast();                
            }
        }
        if (st.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            Node d = st.removeFirst();
            sb.append(String.valueOf(d.c).repeat(d.sq));
        }
        return sb.toString();
    }
}