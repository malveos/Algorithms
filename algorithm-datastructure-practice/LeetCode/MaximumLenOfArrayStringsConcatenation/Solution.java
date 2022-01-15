/***
@Author Omkar Malve

1239. Maximum Length of a Concatenated String with Unique Characters

Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.


***/
class Solution {
    public int maxLength(List<String> arr, int idx, String ans) {
        // base case : check if all chars are uniq characters
        if(idx == arr.size()) {
            if (ans.length() > 26)
                return 0;
            int[] countArray = new int[26];
            for (int i = 0; i < ans.length(); i++) {
                if(countArray[ans.charAt(i) - 'a'] == 1) return 0;
                countArray[ans.charAt(i) - 'a']++;
            }
            return ans.length();
        }
        
        // Recursive include arryelement
        int included = -1;
        int excluded = -1;
        if(ans.length() + arr.get(idx).length() <= 26) {
            included = maxLength(arr, idx + 1, ans + arr.get(idx));
        }
        excluded = maxLength(arr, idx + 1, ans);
        return Math.max(included, excluded);
    }
    
    public int maxLength(List<String> arr) {
        return maxLength(arr, 0, "");
    }
}