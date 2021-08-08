/**

@Author Omkar Malve

Permutation Sequence

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

**/
class Solution {
    public String getPermutation(int n, int k) {
    
        ArrayList<Integer> allNums = new ArrayList<>();
        for (int i = 1; i<=n; i++)
            allNums.add(i);
        
        int[] fact = new int[n];
        fact[0] = 1;
        for (int  i = 1; i< n; i++)
            fact[i] = i * fact[i - 1];
        
        
        StringBuilder ans= new StringBuilder();
        //  Logic here: check for n-1 combinations with 1 letter an dcheck if k i in between.
        for (int i = n; i>0; i--) {
            int loc = (int) Math.ceil(k * 1.0/fact[i - 1]);
            
            ans.append(allNums.get(loc - 1));
            allNums.remove(loc - 1);
            k = k - fact[i - 1] * (loc - 1);
        }
        return ans.toString();
    }
}