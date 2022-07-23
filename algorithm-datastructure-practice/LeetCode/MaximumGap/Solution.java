/***

@Author Omkar Malve

164. Maximum Gap

Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.


***/
class Solution {
    public int maximumGap(int[] nums) {
       return getByBucketSorting(nums);
    }

    private int getByBucketSorting(int [] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n < 2) return 0;

        // Logic is to divid all in the bucket averagly and find gaps for bucket
        int max = nums[0], min = nums[0];
        for (int a : nums) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }
        if (max == min) return 0;

        int avgGap = (int)Math.ceil(((double)(max - min)/(n - 1)));
        int[] maxBucket = new int[n];Arrays.fill(maxBucket, Integer.MIN_VALUE);
        int[] minBucket = new int[n];Arrays.fill(minBucket, Integer.MAX_VALUE);
        for (int a: nums) {
            int pos = (a - min)/ avgGap;
            maxBucket[pos] = Math.max(maxBucket[pos], a);
            minBucket[pos] = Math.min(minBucket[pos], a);
        }

        for (int i = 0; i < n; i++) {
            if (minBucket[i] != Integer.MAX_VALUE) {
                avgGap = Math.max(avgGap, minBucket[i] - min);
                min = maxBucket[i]; //cur max is min for next
            }
        }
        return avgGap;
    }

    private int getBySorting(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        Arrays.sort(nums);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n ; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
}