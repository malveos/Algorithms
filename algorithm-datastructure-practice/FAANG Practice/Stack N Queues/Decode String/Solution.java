/***

@Author Omkar Malve

394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].


***/
class Solution {
    public String decodeString(String s) {     
        Stack<String> st = new Stack();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            //System.out.println("Reading: " + s.charAt(i));
            if (Character.isLetterOrDigit(s.charAt(i)) ) {
                String pushData = "";
                if (Character.isDigit(s.charAt(i))) {
                    StringBuilder num = new StringBuilder();
                    while(Character.isDigit(s.charAt(i)) && i < s.length()) {
                        num.append(s.charAt(i));
                        i++;
                    }
                    i--;
                    //System.out.println("Number:" + num);
                    pushData = Integer.parseInt(num.toString()) + "";
                } else {
                    pushData = s.charAt(i) + "";
                }
                st.push(pushData);
                //System.out.println("Pushing " + pushData);
                //print(st);
            } else if (s.charAt(i) == '[') {
                st.push("[");
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek().charAt(0) )) {
                    temp.insert(0, st.pop());
                }
                //print(st);
                st.pop(); // pop Opening bracket
                int t = Integer.parseInt(st.pop() + "");
                st.push(temp.toString().repeat(t));
                //System.out.println("Repeating " + temp + " " + t + " times.");
            }
            i++;
        }
        while(!st.isEmpty())
            sb.insert(0, st.pop());
        return sb.toString();
    }
    
    private void print(Stack<String> temp) {
        System.out.println("Stack-> " + Arrays.toString(temp.toArray())  );
    }
}