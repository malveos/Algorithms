/***

@Author Omkar Malve

205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

***/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return byStaticArray(s, t);
    }

    private boolean byStaticArray(String s, String t) {
        if(s.length() != t.length()) return false;
        boolean [] mapStatus = new boolean[257];
        char [] cArray = new char[257];

        for (int i = 0; i < s.length(); i++) {
            if (mapStatus[t.charAt(i)]) { // if mapped but char used with other
                if (cArray[s.charAt(i)] != t.charAt(i)) return false;
            } else {
                if (cArray[s.charAt(i)] != 0) return false; // no mapping but char used
                cArray[s.charAt(i)] = t.charAt(i);
                mapStatus[t.charAt(i)] = true;
            }
        }
        return true;
    }

    private boolean byMap(String s, String t) {
         if ((s == null) != (t == null)) return false;
        if (s == null && t == null) return true;

        int l1 = s.length(), l2 = t.length();
        if (l1 != l2) return false;

        Map<Character, Character> map = new LinkedHashMap<>();
        for (int i = 0; i < l1; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);

            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            if (map.containsValue(c2) && !map.containsKey(c1)) 
                return false;
            map.put(c1, c2);
        }
        return true;
    }
}