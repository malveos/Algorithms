/***

@Author Omkar Malve

Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
***/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new LinkedList<>();
        Arrays.sort(nums);
        permute(nums, 0, permutations);
        return (permutations);
    }

    public void permute(int[] nums, int st, List<List<Integer>> permutations) {
        if (st == nums.length - 1) {
            permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        
        Set<Integer> used = new HashSet<>();
        for (int i = st; i < nums.length; i++) {
            if(used.add(nums[i])) {
                swap(nums, i, st);
                permute(nums, st + 1, permutations);
                swap(nums, st, i);
            }
        }        
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}