/***
 Integer to Roman

**/

class Solution {
    public String intToRoman(int num) {
        StringBuilder value = new StringBuilder();
        int[] pv = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] vals = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for(int i = 0; i < 13; i++) {
            int times = 0;
            if (num >= pv[i]) {
                times = num/pv[i];
                num %=pv[i];
            }
            for (int j = 0; j < times; j++) {
                value.append(vals[i]);
            }
        }        
        return value.toString();
    }
}