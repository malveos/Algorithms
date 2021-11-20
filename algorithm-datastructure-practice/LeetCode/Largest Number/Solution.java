/**
@author Omkar Malve

179. Largest Number
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

*/
class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> newN = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(newN, (a, b) -> {
            String a1 = a.toString();
            String a2 = b.toString();
            return (a2+a1).compareTo(a1+a2);
        });
        StringBuilder ans = new StringBuilder();
        for (Integer n : newN)
            ans.append(n);
        System.out.println(newN);
        return (ans.toString().matches("^[0]+$")) ? "0" : ans.toString();
    }
}