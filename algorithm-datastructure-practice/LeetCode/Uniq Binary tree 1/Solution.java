/***

@Author Omkar Malve

96. Unique Binary Search Trees

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

***/
class Solution {
    public int numTrees(int n) {
        // tHis answer leands to nth catalan number 
        
        //  Summation of Cn Cn-1
        
        int catlan[] = new int [n + 1];
        catlan[0] = catlan[1] = 1;
        for(int i = 2; i <= n; i++){
            catlan[i] = 0;
            for(int j = 0; j < i; j++)
                catlan[i] += catlan[j] * catlan[i-j-1];
        }
        return catlan[n];
    }
}