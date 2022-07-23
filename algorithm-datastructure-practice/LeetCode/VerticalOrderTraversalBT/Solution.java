/***

@Author Omkar Malve

987. Vertical Order Traversal of a Binary Tree
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

****/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    class Node {
        public Integer col;
        public Integer depth;
        public Integer val;
        Node(int col, int d, int val) {
            this.col = col;
            this.val = val;
            this.depth = d;
        }
        public String toString() {
            return "{ Col = " + col + ", Val = " + val + ", depth = " + depth + "}";
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        // Column, Values Map
        Map<Integer, PriorityQueue<Node>> mp = new TreeMap<>();
        dfs(root, mp, 0, 0);
        
        //System.out.println("Map has : " + mp.values());
        List<List<Integer>> ans = new ArrayList<>();
        for (PriorityQueue<Node> pq : mp.values()) {
            List<Integer> col = new ArrayList<>();
            while(!pq.isEmpty()) {
                col.add(pq.poll().val);
            }
            ans.add(col);
        }
        return ans;
    }

    private void dfs(TreeNode root, Map<Integer, PriorityQueue<Node>> mp, int col, int depth) {
        if (root == null) return;
        if (!mp.containsKey(col)) {
            PriorityQueue<Node> pq = new PriorityQueue<Node>(1005, (n1, n2) -> {
                if (n1.depth == n2.depth) {
                    return n1.val.compareTo(n2.val);
                } else {
                    return n1.depth.compareTo(n2.depth);
                }
            });
            mp.put(col, pq);
        }
        PriorityQueue<Node> pq = mp.get(col);
        pq.add(new Node(col, depth, root.val));

        dfs(root.left, mp, col - 1, depth + 1);
        dfs(root.right, mp, col + 1, depth + 1);
    }
}