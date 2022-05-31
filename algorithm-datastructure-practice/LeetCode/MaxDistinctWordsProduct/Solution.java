/**

@Author Omkar Malve

318. Maximum Product of Word Lengths

Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

***/
class Solution {
    public int maxProduct(String[] words) {
        // solve at bit manupulation: for a to z if present 1 else 0
        int max = 0;
        int len = words.length;
        int []bits = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if ((bits[i] & bits[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}