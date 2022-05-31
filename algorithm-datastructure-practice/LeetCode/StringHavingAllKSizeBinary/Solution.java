/***

@Author Omkar Malve

1461. Check If a String Contains All Binary Codes of Size K

Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

***/
class Solution {
    public boolean hasAllCodes(String s, int k) {
      return getByBitManipulation(s, k);
    }

    private boolean getByBitManipulation(String s, int k) {
        //using k bit, total number of binary number
        // we have to search  in s
        int n = 1 << k;
        boolean[] got = new boolean[n];
        int allOne = n - 1;
        int hashVal = 0;
        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i - k + 1,i + 1)
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');

            // hash only available when i - k + 1 > 0
            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // private boolean getBySet(String s, int k) {
    //       // Collect all strings present in the string and chek if all are there
    //     Set<String> st = new HashSet<>();
    //     for (int i = 0; i <= s.length() - k; i++) {
    //         st.add(s.substring(i, i + k));
    //     }
    //     return st.size() ==  1 << k;//(int) Math.pow(2, k);
    // }
}