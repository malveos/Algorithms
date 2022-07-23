/***

@Author Omkar Malve

187. Repeated DNA Sequences

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.


***/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() > 10000) return new ArrayList<>();
        Set<String> subS = new HashSet<>(), ans = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ssq = s.substring(i, i + 10);
            if (!subS.add(ssq)) {
                ans.add(ssq);
            }
        }
        return new ArrayList<>(ans);
    }
}