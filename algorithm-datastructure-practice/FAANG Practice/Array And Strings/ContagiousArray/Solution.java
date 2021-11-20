/**


@Author Omkar Malve


525. Contiguous Array

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

***/
class Solution {
    public int findMaxLength(int[] nums) {
     
        int counter = 0, maxLen = 0;
        Map<Integer, Integer> counterIndexMap = new HashMap<>();
        counterIndexMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                counter++;
            else
                counter--;
            if(counterIndexMap.containsKey(counter)){
                maxLen = Math.max(maxLen, i - counterIndexMap.get(counter));
            } else
                counterIndexMap.put(counter, i);
        }
        return maxLen;
    }
}