/**

@Author Omkar Malve

20. Valid Parentheses

***/

class Solution {

    public Map<Character, Character> cacheMap = new HashMap<>();
    {
        cacheMap.put(')', '(');
        cacheMap.put('}', '{');
        cacheMap.put(']', '[');
    }    

    public boolean isValid(String s) {
        //'()[]{}'
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c ==')' || c ==']' || c =='}') {
                if (stack.isEmpty() || !stack.pop().equals(cacheMap.get(c)))
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}