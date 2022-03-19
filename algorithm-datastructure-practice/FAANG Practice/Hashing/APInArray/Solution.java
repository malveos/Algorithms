/****

@Author Omkar Malve

1027. Longest Arithmetic Subsequence

Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ..., nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence seq is arithmetic if seq[i+1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).

***/
class Solution {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length == 1) return 1;
        // need map of num to its index occurances
        // for every pair find if next is present in map till end
        
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> ls = null;
            if (mp.containsKey(nums[i])) {
                ls = mp.get(nums[i]);
            } else {
                ls = new LinkedList<>();
                mp.put(nums[i], ls);
            }
            ls.add(i);
        }
    
        //System.out.println("Map is : " + mp);
        int ans = 2;
        for (int i= 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int count = 2;
                int d = nums[j] - nums[i];
                //System.out.println("Starting as " + nums[i] + " -> " + nums[j]);
                int newN = nums[j] + d;
                int newP = j;
                while (mp.containsKey(newN)) {
                    List<Integer> ls = mp.get(newN);
                    boolean flag = false;
                    // find index just greater than newP
                    for (int n : ls) {
                        if (n > newP) {
                            newP = n;
                            //System.out.println("Start : " + nums[i] +" Found next : " + nums[newP]);
                            count++;
                            newN += d;
                            flag = true;
                            break;
                        }
                            
                    }
                    if (!flag) break; // To prevent infinite loop
                }
                ans = Math.max(ans, count);
                //System.out.println("Cur Max: " + ans);
            }            
        }

        return ans;
    }
}