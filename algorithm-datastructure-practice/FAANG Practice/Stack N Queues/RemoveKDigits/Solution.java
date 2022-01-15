/***
@Author Omkar Malve



402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 ***/

class Solution {
    public String removeKdigits(String num, int k) {
    // use stack to store number smallest to larget while removing then if needed more removal we need to remove rightmost
        
    Stack<Character> st = new Stack<>();
    st.push(num.charAt(0));

    for (int i = 1; i < num.length(); i++) {
        char cur = num.charAt(i);
        if(st.peek() >= cur) {
            while(!st.isEmpty() && k > 0 &&  st.peek() > cur) {
                //char p = 
                    st.pop();
                //System.out.println("Poped from Stack- " + p);
                k--;
            }
        }
        st.push(cur);
    }
    StringBuilder ans = new StringBuilder();
    while(!st.isEmpty()) {
        ans.append(st.pop());
    }
    ans = ans.reverse();
    //System.out.println("From stack-" + ans);

    String str = ans.substring(0, ans.length() - k);

    // remove 0 preceding if any
    int j = 0;
    while (str.length() > j && str.charAt(j) == '0') j++;
    str = str.substring(j);

    return str.equals("") ? "0" : str;
    }
}