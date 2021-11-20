/***

@Author Omkar Malve


540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.


***/
class Solution {
     private boolean isSingle(int[] nums, int m) {
        if (m == 0 && nums[m]!=nums[m +1]) return true;
        if (m == nums.length - 1 && nums[m] != nums[m -1]) return true;
        if (nums[m] != nums[m -1] && nums[m]!=nums[m +1]) return true;
        return false;
    }

    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        if (nums.length == 1) return nums[0];
        while(i<=j) {
            int mid = (i + j)/2;
            if (isSingle(nums, mid)) {
                return nums[mid];
            }
            if (mid > 0 &&  nums[mid] == nums[mid - 1]) {
                if (mid %2 == 0) // as we strat from 0
                    j = mid - 1;
                else
                    i = mid + 1;
            }
            if (mid < nums.length - 1 &&  nums[mid] == nums[mid + 1]) {
                if (mid %2 ==0) // we start from 0
                    i = mid + 1;
                else
                    j = mid - 1;
            }
        }
        return nums[i];
    }
}