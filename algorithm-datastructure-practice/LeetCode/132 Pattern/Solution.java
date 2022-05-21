/***

@Author Omkar Malve

456. 132 Pattern

Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.


***/
class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= max[i-1]){
                max[i] = nums[i];
                min[i] = min[i-1];
            }
            else if(nums[i] <= min[i-1]) {
                min[i] = nums[i];
                max[i] = max[i-1];
            }
            else{ // case where current is less than max and greateer than min [mid of max and min] : check if previous greater and check if there is one minimum existed before that
                // [3 5 0 3 4]
                // [3 3 0 0 0] -< min
                // [3 5 5 5 5] -< max
                // at last 4, 0<4<5 -> got  previous 5 as greter and its previous smaller is 3 As required.
                int j = 0;
                for( j = i-1; j >= 1; j--){
                    if(nums[j] > nums[i])
                        break;
                }
                if(j >=1 && min[j - 1] < nums[i])
                    return true;
                max[i] = max[i-1];
                min[i] = min[i-1];
            }
        }
        return false; 
        
        
    }
     /*   int n = nums.length;
        if (n < 3) {
            return false;
        }

        TreeMap<Integer, Integer> redblackTree = new TreeMap<>();
         for (int i = 1; i < n; i++) {
            redblackTree.put(nums[i], redblackTree.getOrDefault(nums[i], 0) + 1);
        }

        int min_i = Integer.MAX_VALUE;
        for (int j = 1; j < n; j++) {
            min_i = Math.min(min_i, nums[j - 1]);

            redblackTree.put(nums[j], redblackTree.get(nums[j]) - 1);
            if (redblackTree.get(nums[j]) == 0) redblackTree.remove(nums[j]);

            if (min_i > nums[j]) continue;
            
            
            // check if submap exisits i.e. some value is present in betoween
            if (redblackTree.subMap(min_i, false,  nums[j], false).size() > 0)
                return true;
        }
        return false;
    }*/
}