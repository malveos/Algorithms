/****

@Author Omkar Malve


442. Find All Duplicates in an Array

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.


***/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>(nums.length);
        
        // we can mark array at i negative if occured
        for (int i = 0; i<nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] < 0) { // element was already there
                dups.add(index); // add index means its previous position value
            } else {
                nums[index - 1] *= -1; // make number's index negative for further processing
            }
        }
        return dups;
    }
}