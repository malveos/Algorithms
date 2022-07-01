/**

@Author Omkar Malve

150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
***/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int ans = getAnswer(st.pop(), st.pop(), token);
                st.push(ans);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("/") || s.equals("+") || s.equals("-") || s.equals("*");
    }

    private int getAnswer(int n2, int n1, String op) {
        switch(op) {
            case "+" : return n1 + n2;
            case "-" : return n1 - n2;
            case "*" : return n1 * n2;
            case "/" : return n1 / n2;  
        }
        return 0;
    }
}