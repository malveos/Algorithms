/***

@Author Omkar Malve

Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Can be solved by using positions like binary placements: 000, 001, 010, 011, 100, 101, 110, 111. 

****/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // iterate to the maximum size of power set
        // increment can be 000 001 010...
        for(int bin = 0; bin < 1 << nums.length; bin++) {
            List<Integer> subset = new ArrayList<>();
            for(int t = bin, x = 0; t > 0; x++, t >>= 1)
                if(t % 2 == 1)
                    subset.add(nums[x]);
            ans.add(subset);
        }
        return ans;
    }
}