/***

26. Remove Duplicates from Sorted Array


**/


class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return  1;
        
        int left = 0 , right = 0;
        while (right < nums.length) {
            nums[left++] = nums[right];
            while(right != nums.length -1 && nums[right] == nums[right+1] ) {
                right++;
            }
            right++;
            //System.out.println("Next uniq at " + right);
        }
        return left;
    }
}