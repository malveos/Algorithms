/***

@Author Omkar Malve

Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new LinkedList<>();
        permute(nums, 0, permutations);
        
        return permutations;
    }

    public void permute(int[] nums, int st, List<List<Integer>> permutations) {
        for (int i = st; i < nums.length; i++) {
            swap(nums, i, st);
            permute(nums, st + 1, permutations);
            swap(nums, st, i);
        }
        if (st == nums.length - 1)
            permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}