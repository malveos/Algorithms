/***

@Author Omkar Malve


228. Summary Ranges

You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 


***/
class Solution {
    public List<String> summaryRanges(int[] nums) {
     
        int n  = nums.length;
        if (n == 0) return new ArrayList<>();
        
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int cur = nums[i];
            int end = cur;
            while (i < n -1 && nums[i] + 1 == nums[i + 1]) {
                end = nums[i + 1];
                i++;
            }
            if (cur != end) {
                sb.append(cur).append("->").append(end);
            } else {
                sb.append(cur);
            }
            i++;
            ans.add(sb.toString());
            sb = new StringBuilder();
        }
        return ans;
    }
}