/**
Divide Two Integers

**/
class Solution {
    public int divide(int dividend, int divisor) {
         if(dividend == 1 << 31 && divisor == -1 ) return Integer.MAX_VALUE;
        
        boolean isPositive = false;
        if ((dividend > 0 && 0 < divisor) || (dividend < 0 && 0 > divisor)) 
            isPositive = true;
        int quo =0;
        
        int numerator = Math.abs(dividend);
        int denominator = Math.abs(divisor);
        while(numerator - denominator >= 0){
            int count = 0;
            while(numerator - (denominator << 1 << count) >=0 ){
                count++;
                
            }
            quo += 1 << count;
            numerator -= denominator << count;
        }
        return isPositive ? quo : -quo;
    }
}