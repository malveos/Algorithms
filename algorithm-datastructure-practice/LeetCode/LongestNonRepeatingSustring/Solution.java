Given a string s, find the length of the longest substring without repeating characters.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding through the string characters
        Map<Character, Integer> cacheMap = new HashMap<>(s.length());
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (null != cacheMap.get(s.charAt(j))) {
                // If character was previous our start we skip it
                i = Math.max(cacheMap.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            cacheMap.put(s.charAt(j), j);
        }
        return ans;
    }
}