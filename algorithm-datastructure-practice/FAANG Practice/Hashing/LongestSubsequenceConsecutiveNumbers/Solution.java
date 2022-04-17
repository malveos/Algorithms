/***

@Author Omkar Malve

128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.


***/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        else if (nums.length >= ((int) Math.pow(10, 5))) {
		    return (int) Math.pow(10, 5);
        }

        // Idea is to go from every num to all others and mark them visited
        
        HashSet<Integer> arr = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i : nums) arr.add(i);

        //System.out.println("PRocessing on - " + arr);
        int ans = 0;        
        for (int i : arr) {
            if (visited.contains(i)) continue;
            int currentCount = 0;
            int j = i;

            // process forword
            while (arr.contains(j)) {
                currentCount++;
                //System.out.println("Counting and forwarding " + j);
                visited.add(j++);
            }

            // processbackward
            j = i - 1;
            while (arr.contains(j)) {
                currentCount++;
                //System.out.println("Counting and backing " + j);
                visited.add(j--);
            }
            ans = Math.max(ans, currentCount);
        }
        return ans;
    }
}