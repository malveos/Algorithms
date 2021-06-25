/***
Combination Sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

**/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(null == candidates) return new ArrayList<>();
        Arrays.sort(candidates);
        return combination(candidates, target, 0);
    }

    private List<List<Integer>> combination(int[] candidates, int target, int idx) {
        if(target == 0) {
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<>());
            return temp;
        }
        
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            if (target - candidates[i] >= 0 && i >= idx) {
                List<List<Integer>> subArray = combination(candidates, target - candidates[i], i);
                for (int j = 0; j < subArray.size(); j++ ) {
                    subArray.get(j).add(candidates[i]);
                    temp.add(subArray.get(j));
                }
            }
        }
        return temp;
    }
}