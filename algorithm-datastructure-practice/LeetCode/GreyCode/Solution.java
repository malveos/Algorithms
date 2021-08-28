/***

@Author Omkar Malve

89. Gray Code
An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.


Sol : calculate for n  -1 , then 0 with all adn 1 with reverse all will form for nth number

***/


class Solution {
    /*public List<Integer> grayCode(int n) {
        List<Integer> ls = new LinkedList<>();
        if (n == 0) {
            ls.add(0);
            return ls;
        }
        
        ls = grayCode(n - 1);
        for (int i = ls.size() - 1; i>=0; i--) {
            // adding it in reverse to maintain order
            //System.out.println("List contains" + ls + " Adding -> [" + ls.get(i) +" + " + (int) Math.pow(2, n - 1) + "] getting ith = " + i +" where n = " + n);
            ls.add(ls.get(i) + (int) Math.pow(2, n - 1));
        }
        //System.out.println("List returning: " + ls );
        return ls;
    }*/
    
    public List<Integer> grayCode(int n) {
        List<Integer> ls = new LinkedList<>();
        if (n == 0) {
            ls.add(0);
            return ls;
        }

        // we maintain 1<<n for next iter finding
        int arr[] = new int[1];
        backtracking(ls, n, arr);
        return ls;
    }
    
    public static void backtracking(List<Integer> ls, int n, int []arr) {
        if (n == 0) {
            ls.add(arr[0]);
            return;
        }
        
        backtracking(ls, n -1, arr);
        arr[0] = arr[0] ^ 1<<n-1;
        backtracking(ls, n -1, arr);
    }
    
    
}