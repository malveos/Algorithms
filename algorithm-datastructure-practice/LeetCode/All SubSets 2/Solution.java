


Q: options set SL and targets.
Q: Position sizing in options

Can I trade on next week options on expiry day??/***

@Author Omkar Malve

90. Subsets II

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 


***/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums); // duplicates to be in sequence
        findSubSet(ans,  new ArrayList<>(), nums, 0);
        return new ArrayList<>(ans);
    }
    
    public static void findSubSet(Set<List<Integer>> ans, List<Integer> curArray, int[]nums, int n) {
        ans.add(new ArrayList<>(curArray));
        
        for (int i = n; i <nums.length; i++){
            // skipping duplicates
            if (i>n && nums[i]==nums[n])
                continue;
            curArray.add(nums[i]);
            findSubSet(ans, curArray, nums, i + 1);
            curArray.remove(curArray.size() - 1);
        }
    }
    
    
}
