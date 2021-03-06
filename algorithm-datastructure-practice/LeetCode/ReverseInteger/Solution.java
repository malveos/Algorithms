/***

Reverse Integer
 Handle Overflow case for Integer

*/
class Solution {
    public int reverse(int x) {
        boolean makeNegative = false;
        if (x<0)
            makeNegative = true;
        
        StringBuilder ans = new StringBuilder();
        x = Math.abs(x);
        int a = 0;
        try {
            while(x > 0) {
                ans.append(x%10);
                x= x/10;
            }
            a = Integer.parseInt(ans.toString());
        } catch (Exception e) {
            return 0;
        }
        return (makeNegative) ? -1 * a : a;
            
    }
}