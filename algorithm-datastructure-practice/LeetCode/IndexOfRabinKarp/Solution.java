/***

@Author Omkar Malve

 Implement strStr()
 
 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

***/

class Solution {
    // max length
    public final static int d = 256;
    // Some prime number
    public final static int q = 107;
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);   

        // Rabin_carp Algo
        // Calculate hash and move hash next next
        int plen = needle.length();
        int tlen = haystack.length();
        int hash = 1;
        int txtHash = 0;
        int patternHash = 0;
        
        if (plen == 0) return 0;
        if (tlen < plen) return -1;
        //if (needle.equals(haystack.substring(0, plen))) return 0;
        
        // calcualte hash 
        for (int i = 0; i < plen -1; i++)
            hash = (hash * d) % q;
        
        // Processing text starting now....
        for (int i = 0; i < plen; i++) {
            txtHash = (d * txtHash + haystack.charAt(i)) % q;
            patternHash = (d * patternHash + needle.charAt(i)) % q;
        }

        // process tx by windows
        for (int i = 0; i <= tlen - plen; i++) {
            if (txtHash == patternHash) {
                // check for the string compare
                int j = 0;
                for (j = 0; j < plen; j++) {
                    if (haystack.charAt(i + j) !=  needle.charAt(j)) 
                        break;
                }
                if (j == plen)
                    return i;                
            }

            // update textHash
            // remove leading digit and add trailing digit
            if (i < tlen - plen) {
                txtHash = (d * (txtHash - haystack.charAt(i) * hash) + haystack.charAt(i + plen)) % q;

				if (txtHash  < 0) {
                    txtHash = txtHash + q;
                }
            }
            
        }
        return -1;
    } 
}