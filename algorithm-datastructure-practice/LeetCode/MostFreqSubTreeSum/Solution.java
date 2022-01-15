/***
@Author Omkar Malve

508. Most Frequent Subtree Sum

Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).


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
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        // find all and return maximun times SUM   
        Map<Integer, Integer> mp = new HashMap<>();
        findSum(root, mp);
        List<Integer> sums = mp.entrySet().stream().filter(m -> m.getValue().equals(maxFreq)).map(m -> m.getKey()).collect(Collectors.toList());
        
        int[] ans = new int[sums.size()];
        int i = 0;
        for (Integer num :  sums) ans[i++] = num;
        return ans;
    }

    private int findSum(TreeNode rt, Map<Integer, Integer> mp) {
        if (rt == null) return 0;
        int sum = rt.val + findSum(rt.left, mp) + findSum(rt.right, mp);
        mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        
        //update maxFreq
        if (maxFreq < mp.get(sum))
            maxFreq = mp.get(sum);
        return sum;
    }
}