/***

@Author Omkar Malve

509. Fibonacci Number

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,


***/
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int fib(int n) {
        return useRecursion(n);        
    }

    private int useRecursion(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(map.containsKey(n)) return map.get(n);
        map.put(n - 1, useRecursion(n - 1));
        map.put(n - 2, useRecursion(n - 2));
        return map.get(n - 1)  + map.get(n - 2);
    }
}