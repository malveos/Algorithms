/***

@Author Omkar Malve

844. Backspace String Compare

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

***/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Simple string compare after process
        StringBuilder s1 = new StringBuilder("");
         for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(s1.length() > 0){
                    s1.deleteCharAt(s1.length() - 1);
                }
            }
            else s1.append(s.charAt(i));
        }
        
        StringBuilder s2 = new StringBuilder("");
         for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(s2.length() > 0){
                    s2.deleteCharAt(s2.length() - 1);
                }
            }
            else s2.append(t.charAt(i));
        }
        
        return s1.toString().equals(s2.toString());
        // if (s == null && t == null) return true;
        // Stack<Character> ss = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if(ss.isEmpty() || c != '#')
        //         ss.add(c);
        //     if (c == '#')
        //         ss.pop();
        // }
        // Stack<Character> tt = new Stack<>();
        // for (int i = 0; i < t.length(); i++) {
        //     char c = t.charAt(i);
        //     if(tt.isEmpty() || c != '#')
        //         tt.add(c);
        //     if (c == '#')
        //         tt.pop();
        // }
        // if (ss.size() != tt.size()) return false;
        // while (!ss.isEmpty()) {
        //     if (ss.peek().equals(tt.peek())) {
        //         ss.pop(); tt.pop();
        //     } else
        //         return false;
        // }
        // return true;
    }
}