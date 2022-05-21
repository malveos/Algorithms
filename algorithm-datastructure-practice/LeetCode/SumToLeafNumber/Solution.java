/**

@author Omkar Malve

129. Sum Root to Leaf Numbers

You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.


***/
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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        calValue(root, 0);
        return ans;
    }

    private void calValue(TreeNode n, int v) {
        if (n == null) return;
        v *= 10;
        v += n.val;
        if (n.left == null && n.right == null) {
            ans += v;
            return;
        }
        calValue(n.left, v);
        calValue(n.right, v);
    }
    /**
    public int sumNumbers(TreeNode root) {
        List<StringBuilder> nums = createNums(root);
        int sum = 0;
        for (StringBuilder s : nums)
            sum+= Integer.parseInt(s.toString());
        return sum;
    }

    private List<StringBuilder> createNums(TreeNode root) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            List<StringBuilder> ls = new ArrayList<>();
            ls.add(sb);
            return ls;
        }
        List<StringBuilder> ln = root.left != null ? createNums(root.left) : new ArrayList<>();
        List<StringBuilder> rn = root.right != null ? createNums(root.right) : new ArrayList<>();
        ln.addAll(rn);
        for (StringBuilder sbb : ln)
            sbb.insert(0, root.val);
        return ln;
    }**/
}