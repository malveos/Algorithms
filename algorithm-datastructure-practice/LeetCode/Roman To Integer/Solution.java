/***
Roman to Integer


***/

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        Map<String, Integer> symbolMap = dataSetup();
        int prev = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int curVal = symbolMap.get(s.charAt(i) + "");
            if (curVal >= prev) {
                sum += curVal;
            } else {
                sum -= curVal;
            }
            prev = curVal;
        }
        
        return sum;
    }
    public Map<String, Integer> dataSetup() {
        Map<String, Integer> symbolMap = new HashMap<>();
        symbolMap.put("M", 1000);
        symbolMap.put("CM", 900);
        symbolMap.put("D", 500);
        symbolMap.put("CD", 400);
        symbolMap.put("C", 100);
        symbolMap.put("XC", 90);
        symbolMap.put("L", 50);
        symbolMap.put("XL", 40);
        symbolMap.put("X", 10);
        symbolMap.put("IX", 9);
        symbolMap.put("V", 5);
        symbolMap.put("IV", 4);
        symbolMap.put("I", 1);        
        return symbolMap;
    }
}