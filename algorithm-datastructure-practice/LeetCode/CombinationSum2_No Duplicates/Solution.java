/***
. Combination Sum II


Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

****/
class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>  ans = new ArrayList();
        combination(candidates, 0, target, ans, new ArrayList());
        return ans;
    }
    
    private void combination(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> list) {
        if (start == candidates.length) {
            if (target == 0) {
               res.add(new ArrayList(list));
            }
            return;
        }

        if (target >= candidates[start]) {
            list.add(candidates[start]);
            combination(candidates, start + 1, target - candidates[start], res, list);
            list.remove(list.size() - 1);
        }
        
        // check if duplicates
        while(start < candidates.length - 1 && candidates[start] == candidates[start + 1])
            start++;
        combination(candidates, start + 1, target, res, list);
        
    }
    
}