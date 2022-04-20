/***

@Author Omkar Malve

133. Clone Graph

Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.


***/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node temp = new Node(node.val);
        
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(node);

        // get old using new
        Map<Node, Node> mp = new HashMap<>();
        mp.put(node, temp);

        while(!bfs.isEmpty()) {
            Node cur = bfs.poll();
            Node tempParent = mp.get(cur);
            for (Node n : cur.neighbors) {
                Node tempN = mp.get(n);
                if (tempN != null) {
                    tempParent.neighbors.add(tempN);
                    continue;
                } else {
                    tempN = new Node(n.val);
                    tempParent.neighbors.add(tempN);
                    mp.put(n, tempN);
                    bfs.add(n);
                }
            }
        }        
        return temp;
    }
}