/**

@Author Omkar Malve

1520. Maximum Number of Non-Overlapping Substrings

Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that meet the following conditions:

The substrings do not overlap, that is for any two substrings s[i..j] and s[x..y], either j < x or i > y is true.
A substring that contains a certain character c must also contain all occurrences of c.
Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the same number of substrings, return the one with minimum total length. It can be shown that there exists a unique solution of minimum total length.

Notice that you can return the substrings in any order.

***/
class Solution {

    private int get(String s, int i) {
        return s.charAt(i) - 'a';
    }

    public List<String> maxNumOfSubstrings(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, s.length());
        
        List<String> ans = new ArrayList<>();
        // Store leftmost and rightmost pos of every chars
        for (int i = 0; i < s.length(); i++) {
            var c = get(s, i);
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }

        //System.out.println("Left:" + Arrays.toString(left));
        //System.out.println("Right:" + Arrays.toString(right));
        int r = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (i == left[get(s, i)]) { // for each char check if validSubString starts from here
                int newRight = getRightLocation(s, i, left, right);
                //System.out.println("Right loc for " + s.charAt(i) + " is =" + (newRight));
                if (newRight != -1) {
                    if (i > r)
                        ans.add("");
                    r = newRight;
                    //System.out.println("Substring " + i + " to " + r);
                    //System.out.println("Before Ans:" + ans);
                    ans.set(ans.size() - 1, s.substring(i, r + 1));
                    //System.out.println("Ans:" + ans);
                }
            }
        }
        return ans;
    }

    //  this return if there is character present that is already present previously
    private int getRightLocation(String s, int i, int[]l, int[] r) {
        int right = r[get(s, i)];
        for (int j = i; j <= right; ++j) {
            if (l[get(s, j)] < i)
                return -1;
            right = Math.max(right, r[get(s, j)]);
        }
        return right;
    }
}