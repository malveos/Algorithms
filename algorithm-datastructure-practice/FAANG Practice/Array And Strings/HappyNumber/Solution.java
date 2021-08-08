/***

@Author Omkar Malve

Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 


***/
class Solution {
    private boolean check(Set<Integer> nums, int n) {
        if (n == 1)
            return true;
        if(!nums.add(n)) {
            return false;
        }
        n = addSquares(n);
        return check(nums, n);
    }

    private int addSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        return check(nums, n);
    }
}