/***

@Auhtor Omkar Malve

167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.


***/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int s = numbers[l] + numbers[h];
            if (s == target) {
                int[] ans = new int[2];
                ans[0] = l + 1;
                ans[1] = h + 1;
                return ans;
            } else if (s < target) {
                l++;
            } else {
                h--;
            }
        }
        return null;
    }
}