/**
@Author Omkar Malve

 Pow(x, n)
 
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

**/
class Solution {
    public double myPow(double x, int n) {
        double answer = 1.0;
        long power = n;
        if (n < 0)
            power = power * -1;

        while (power > 0) {
            if (power % 2 == 1) {
                answer = answer * x;
                power--;
            } else {
                x = x * x;
                power /=2;
            }
        }      
        
        
        if (n < 0)
            answer = (double) (1.0) / (double) answer;

        return answer;
    }
}