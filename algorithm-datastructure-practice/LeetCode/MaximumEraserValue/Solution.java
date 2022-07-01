/***

@Author Omkar Malve

1695. Maximum Erasure Value

You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

***/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        return usingPresentArray(nums);
    }

    private int usingPresentArray(int[] nums) {
        boolean[] present = new boolean[10001];
        int l = 0, sum = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!present[nums[i]]) {// Adding uniques and updating sum
                sum += nums[i];
                present[nums[i]] = true;
            } else {// else get max till here and check from left till the index for dups
                max = Math.max(max, sum);
                while(nums[l] != nums[i]) {
                    present[nums[l]] = false;
                    sum -= nums[l++];
                }
                l++;
            }
        }
        return Math.max(max, sum);
    }

    private int usePrefixSum(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();// Sum at a index
        int []prfx = new int[nums.length + 1];
        int maxS = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            prfx[r + 1] = prfx[r] + nums[r];
            if (mp.containsKey(nums[r])) {
                l = Math.max(mp.get(nums[r]) + 1, l);// check if we can skip with same sum to next index
            }
            maxS = Math.max(maxS, prfx[r + 1] - prfx[l]);
            mp.put(nums[r], r);
        }
        return maxS;
    }

    private int useTwoPointerApproach(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] + nums[1];

        int maxS = 0, curS = 0;
        Set<Integer> st = new HashSet<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            // add till not duplicated
            while(!st.add(nums[j])) {
                curS -= nums[i];
                st.remove(nums[i++]);
            }
            curS += nums[j];
            maxS = Math.max(curS, maxS);
        }
        return maxS;
    }
}